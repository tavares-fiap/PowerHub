package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserFuncs_DAO {

    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();

    public static boolean signUp(String cpf, String name, String phoneNumber, String email, String password) {
        Controller.Connect_DB.loadDriver();
        if (ValidationFuncs_DAO.isCpfValid(cpf) && ValidationFuncs_DAO.containsOnlyLettersAndSpaces(name) && !ValidationFuncs_DAO.isCpfRegistered(cpf)) {
            try {
                Connection con = null;
                try {
                    con = (Connection) DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                } catch (SQLException ex) {
                    Logger.getLogger(View.SignUp_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                String sql = "INSERT INTO USER (cpf, name, phone_number, email, password) VALUES ('" + cpf + "','" + name + "','" + phoneNumber + "','" + email + "','" + password + "')";

                try {
                    PreparedStatement insert = (PreparedStatement) con.prepareStatement(sql);
                    insert.execute(); // Executando a inserção 
                    JOptionPane.showMessageDialog(null, "\nCadastro realizado com sucesso!\n", "", -1);
                    Controller.LoggedUser_Controller.setLoggedUser(new User(cpf, name, phoneNumber, email, password));
                    Model.FieldFuncs_DAO.cleanSignUpFields();
                    return true;
                } catch (SQLException ex) {
                    if (ex.getSQLState().equals("23000")) {  // Verifica se o código SQL é de violação de chave primária
                        JOptionPane.showMessageDialog(null, "\nErro: CPF já cadastrado no sistema!", "ERRO!", 0);
                    } else {
                        JOptionPane.showMessageDialog(null, "\nOcorreu algum erro na inserção!", "ERRO!", 0);
                    }
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "\nOcorreu algum erro durante conexao!!", "ERRO", 0);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nome ou CPF Invalido!\nCPF ESPERADO: Somente numeros/ 11 digitos\nNOME ESPERADO: Somente letras e espaços");
            View.SignUp_GUI.cpf_txt.setText("");
            return false;
        }
    }

    public static User getUserByCpf(String insertedCpf) throws SQLException {
        try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM USER WHERE cpf = ?")) {
            pstmt.setString(1, insertedCpf);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String cpf = rs.getString("cpf");
                    String name = rs.getString("name");
                    String phoneNumber = rs.getString("phone_number");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    return new User(cpf, name, phoneNumber, email, password);
                }
            }
        }
        return null; // Retorna null se o usuario não for encontrado
    }
}
