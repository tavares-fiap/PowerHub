package Model;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class FieldFuncs_DAO {

    public static void cleanSignUpFields() {
        View.SignUp_GUI.cpf_txt.setText("");
        View.SignUp_GUI.name_txt.setText("");
        View.SignUp_GUI.phoneNumber_txt.setText("");
        View.SignUp_GUI.email_txt.setText("");
        View.SignUp_GUI.password_txt.setText("");
    }

    public static void cleanAddResidenceFields() {
        View.MainMenu_GUI.cep_txt.setText("");
        View.MainMenu_GUI.uf_txt.setText("");
        View.MainMenu_GUI.city_txt.setText("");
        View.MainMenu_GUI.neighborhood_txt.setText("");
        View.MainMenu_GUI.street_txt.setText("");
        View.MainMenu_GUI.number_txt.setText("");
        View.MainMenu_GUI.country_txt.setText("");
        View.MainMenu_GUI.additional_txt.setText("");
        View.MainMenu_GUI.energyFee_txt.setText("");
    }

    public static void autoCompleteAddress(String cep) {
        FindAddress_DAO search = new FindAddress_DAO();
        HashMap<String, String> addressInfo = search.findAddressByCEP(cep);
        try {
            View.MainMenu_GUI.uf_txt.setText(addressInfo.get("uf"));
            View.MainMenu_GUI.city_txt.setText(addressInfo.get("localidade"));
            View.MainMenu_GUI.neighborhood_txt.setText(addressInfo.get("bairro"));
            View.MainMenu_GUI.street_txt.setText(addressInfo.get("logradouro"));
            View.MainMenu_GUI.country_txt.setText("Brasil"); //API Via Cep so funciona em territorio brasileiro
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar preencher os campos.\nCodigo do erro: " + e);
        }
    }
}
