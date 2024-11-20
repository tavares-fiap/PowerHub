package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class FieldFuncs_DAO {
    
    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();
    
    public static void cleanSignUpFields() {
        View.SignUp_GUI.cpf_txt.setText("");
        View.SignUp_GUI.name_txt.setText("");
        View.SignUp_GUI.phoneNumber_txt.setText("");
        View.SignUp_GUI.email_txt.setText("");
        View.SignUp_GUI.password_txt.setText("");
    }

    public static void cleanNewDeviceFields(){
        View.MainMenu_GUI.deviceNameNewDevice_txt.setText("");
        View.MainMenu_GUI.powerInWattsNewDevice_txt.setText("");
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

    public static void refreshResidenceCombobox() {
        String userCpf = Controller.LoggedUser_Controller.getLoggedUser().getCpf();
        String query = "SELECT id, cep, street, number FROM RESIDENCE WHERE user_cpf = ?";
        View.MainMenu_GUI.residencesNewDevice_cbx.removeAllItems();
        View.MainMenu_GUI.residencesMyDevices_cbx.removeAllItems();
        View.MainMenu_GUI.residencesMyResidences_cbx.removeAllItems();
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, userCpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String cep = rs.getString("cep");
                String street = rs.getString("street");
                String number = rs.getString("number");
                View.MainMenu_GUI.residencesNewDevice_cbx.addItem(id + " || " + cep + " || " + street + " || " + number);
                View.MainMenu_GUI.residencesMyDevices_cbx.addItem(id + " || " + cep + " || " + street + " || " + number);
                View.MainMenu_GUI.residencesMyResidences_cbx.addItem(id + " || " + cep + " || " + street + " || " + number);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
