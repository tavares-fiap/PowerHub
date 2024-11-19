
package Model;


public class CleanFields_DAO {
    public static void cleanSignUpFields(){
        View.SignUp_GUI.cpf_txt.setText("");
        View.SignUp_GUI.name_txt.setText("");
        View.SignUp_GUI.phoneNumber_txt.setText("");
        View.SignUp_GUI.email_txt.setText("");
        View.SignUp_GUI.password_txt.setText("");
    }
}
