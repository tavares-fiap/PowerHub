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
    
    public static void refreshDeviceCombobox(int residenceId) {
        String query = "SELECT id, name FROM DEVICE WHERE residence_id = ?";
        View.MainMenu_GUI.devices_cbx.removeAllItems();
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, residenceId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                View.MainMenu_GUI.devices_cbx.addItem(id + " || " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void refreshMyDevicesFields(int deviceId) {
        Device device = Model.DeviceFuncs_DAO.getDeviceById(deviceId);
        if (device != null) {
            View.MainMenu_GUI.deviceNameMyDevices_txt.setText(device.getDeviceName());
            View.MainMenu_GUI.powerInWattsMyDevices_txt.setText(String.valueOf(device.getPowerInWatts()));
            if (device.getStatus()){
                View.MainMenu_GUI.status_togglebtn.setSelected(true);
                View.MainMenu_GUI.status_togglebtn.setText("ON");
            } else {
                View.MainMenu_GUI.status_togglebtn.setSelected(false);
                View.MainMenu_GUI.status_togglebtn.setText("OFF");
            }
        }
    }

    public static void refreshMyResidencesFields(int residenceId) {
        Residence residence = Model.ResidenceFuncs_DAO.getResidenceById(residenceId);
        if (residence != null) {
            View.MainMenu_GUI.cep_txt1.setText(residence.getCep());
            View.MainMenu_GUI.country_txt1.setText(residence.getCountry());
            View.MainMenu_GUI.uf_txt1.setText(residence.getState());
            View.MainMenu_GUI.city_txt1.setText(residence.getCity());
            View.MainMenu_GUI.neighborhood_txt1.setText(residence.getNeighborhood());
            View.MainMenu_GUI.street_txt1.setText(residence.getStreet());
            View.MainMenu_GUI.number_txt1.setText(residence.getNumber());
            View.MainMenu_GUI.additional_txt1.setText(residence.getAdditional());
            View.MainMenu_GUI.energyFee_txt1.setText(String.valueOf(residence.getEnergyFee()));
        }
    }
}
