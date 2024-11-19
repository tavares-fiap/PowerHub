
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ValidationFuncs_DAO {
    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    
    public static boolean isCpfValid(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        for (char c : cpf.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNameValid(String name) {
        if (name == null || name.length() < 1) {
            return false;
        }
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') { // Verifica se o caractere não é uma letra nem um espaço
                return false;
            }
        }
        return true;
    }
    
    public static boolean isCpfRegistered(String validCpf) {
        String sql = "SELECT * FROM USER WHERE CPF = ?";
        try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.setString(1, validCpf);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                JOptionPane.showMessageDialog(null, "CPF: " + validCpf + " ja cadastrado no nome de " + name + " !");
                return true;
            }
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro durante a busca do CPF no sistema!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
