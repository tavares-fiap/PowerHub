
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ResidenceFuncs_DAO {
    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    
    public static boolean addResidence(String cep, String country, String state, String city, String neighborhood, String street, String number, String additional, String energyFee){
        if (ValidationFuncs_DAO.isCepValid(cep) &&
            ValidationFuncs_DAO.containsOnlyLettersAndSpaces(country) &&
            ValidationFuncs_DAO.containsOnlyLettersAndSpaces(state) &&
            ValidationFuncs_DAO.containsOnlyLettersAndSpaces(city) &&
            ValidationFuncs_DAO.containsOnlyLettersAndSpaces(neighborhood) &&
            ValidationFuncs_DAO.containsOnlyLettersAndSpaces(street) &&
            ValidationFuncs_DAO.canBeConvertedToInteger(number) &&
            ValidationFuncs_DAO.canBeConvertedToDouble(energyFee)) {
            
            String sql = "INSERT INTO RESIDENCE (cep, country, state, city, neighborhood, street, number, additional, energy_fee, user_cpf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement insert = con.prepareStatement(sql)) {
                
                // Configurando os parâmetros do PreparedStatement
                insert.setString(1, cep);
                insert.setString(2, country);
                insert.setString(3, state);
                insert.setString(4, city);
                insert.setString(5, neighborhood);
                insert.setString(6, street);
                insert.setString(7, number);
                insert.setString(8, additional);
                insert.setString(9, energyFee);
                insert.setString(10, Controller.LoggedUser_Controller.getLoggedUser().getCpf());
                
                // Executando a inserção
                insert.executeUpdate();
                JOptionPane.showMessageDialog(null, "Residencia adicionada com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);

                Model.FieldFuncs_DAO.cleanAddResidenceFields();
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro na inserção!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Algum campo nao foi preenchido corretamente!");
        }
        return false;
    }
}
