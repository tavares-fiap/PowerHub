
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ResidenceFuncs_DAO {
    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    
    public static boolean addResidence(String cep, String country, String state, String city, String neighborhood, String street, String number, String additional, String energyFee){
        if (ValidationFuncs_DAO.isCepValid(cep) &&
            !ValidationFuncs_DAO.containsNumber(country) &&
            !ValidationFuncs_DAO.containsNumber(state) &&
            !ValidationFuncs_DAO.containsNumber(city) &&
            !ValidationFuncs_DAO.containsNumber(neighborhood) &&
            !ValidationFuncs_DAO.containsNumber(street) &&
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
                Model.FieldFuncs_DAO.refreshResidenceCombobox();
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro na inserção!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Algum campo nao foi preenchido corretamente!");
        }
        return false;
    }
    
    public static Residence getResidenceById(int residenceId){
        String query = "SELECT * FROM RESIDENCE WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, residenceId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String cep = rs.getString("cep");
                String country = rs.getString("country");
                String state = rs.getString("state");
                String city = rs.getString("city");
                String neighborhood = rs.getString("neighborhood");
                String street = rs.getString("street");
                String number = rs.getString("number");
                String additional = rs.getString("additional");
                double energyFee = rs.getDouble("energy_fee");
                return new Residence(residenceId, cep, country, state, city, neighborhood, street, number, additional, energyFee);
            }
            return null;        
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
