package Model;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login_DAO {

    public static boolean login(String cpf, String insertedPassword) {
        if (!ValidationFuncs_DAO.isCpfValid(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF Invalido!\nESPERADO: Somente numeros/ 11 digitos");
            View.Login_GUI.cpf_txt.setText("");
            return false;
        }
        try {
            User user = UserFuncs_DAO.getUserByCpf(cpf);
            if (user != null) {
                if (user.getPassword().equals(insertedPassword)) {
                    JOptionPane.showMessageDialog(null, "Seja bem-vindo " + user.getName().split(" ")[0]);
                    Controller.LoggedUser_Controller.setLoggedUser(user);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Senha incorreta!");
                    View.Login_GUI.password_txt.setText("");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario nao encontrado!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o Tutor no banco de dados", "ERRO!", 0);
            return false;
        }
        return false;
    }
}
