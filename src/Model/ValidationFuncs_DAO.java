
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
    
    public static boolean isCepValid(String cep) {
        if (cep == null || cep.length() != 8) {
            return false;
        }
        for (char c : cep.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean containsOnlyLettersAndSpaces(String inputString) {
        if (inputString == null || inputString.length() < 1) {
            return false;
        }
        for (char c : inputString.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') { // Verifica se o caractere não é uma letra nem um espaço
                return false;
            }
        }
        return true;
    }
    
    public static boolean containsNumber(String inputString) {
        if (inputString == null || inputString.length() < 1) {
            return false;
        }
        for (char c : inputString.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean canBeConvertedToInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean canBeConvertedToDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
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
