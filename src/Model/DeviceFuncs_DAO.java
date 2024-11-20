package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DeviceFuncs_DAO {
    
    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    
    public static boolean addDevice(String deviceName, String powerInWatts, int residenceId){
        if (ValidationFuncs_DAO.canBeConvertedToDouble(powerInWatts)) {
            String sql = "INSERT INTO DEVICE (name, power, residence_id) VALUES (?, ?, ?)";
            try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement insert = con.prepareStatement(sql)) {
                // Configurando os parâmetros do PreparedStatement
                insert.setString(1, deviceName);
                insert.setString(2, powerInWatts);
                insert.setInt(3, residenceId);
                // Executando a inserção
                insert.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dispositivo adicionado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);

                Model.FieldFuncs_DAO.cleanNewDeviceFields();
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro na inserção!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo de potencia nao foi preenchido corretamente!");
        }
        return false;
    }
}
