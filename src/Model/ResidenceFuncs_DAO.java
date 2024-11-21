package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ResidenceFuncs_DAO {

    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();

    public static boolean addResidence(String cep, String country, String state, String city, String neighborhood, String street, String number, String additional, String energyFee) {
        if (ValidationFuncs_DAO.isCepValid(cep)
                && !ValidationFuncs_DAO.containsNumber(country)
                && !ValidationFuncs_DAO.containsNumber(state)
                && !ValidationFuncs_DAO.containsNumber(city)
                && !ValidationFuncs_DAO.containsNumber(neighborhood)
                && !ValidationFuncs_DAO.containsNumber(street)
                && ValidationFuncs_DAO.canBeConvertedToInteger(number)
                && ValidationFuncs_DAO.canBeConvertedToDouble(energyFee)) {

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

    public static Residence getResidenceById(int residenceId) {
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

    private static void generateReport(int residenceId, String cep, String country,
            String state, String city, String neighborhood, String street, String number,
            String additional, double avgEnergyFee, int totalDevices, double totalPower, double totalConsumption,
            double avgConsumptionPerDevice, double finalFee, int totalMeasurements) {

        String filePath = "REPORT/residence-report.txt";

        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Cria diretórios se não existirem

            FileWriter writer = new FileWriter(file);
            writer.write("=-=-=-=- RALATORIO DE RESIDENCIA =-=-=-=-\n\n");
            writer.write("CEP: " + cep + "\n");
            writer.write("ID: " + residenceId + "\n");
            writer.write("Pais: " + country + "\n\n");
            writer.write("UF: " + state + "\n\n");
            writer.write("Cidade: " + city + "\n\n");
            writer.write("Bairro: " + neighborhood + "\n\n");
            writer.write("Rua: " + street + "\n\n");
            writer.write("Numero: " + number + "\n\n");
            writer.write("Complemento: " + additional + "\n\n");

            writer.write("---- MEASUREMENTS INFO ----\n\n");
            writer.write("Total de aparelhos: " + totalDevices + "\n");
            writer.write("Soma das potencias dos aparelhos: " + totalPower + "\n");
            writer.write("Consumo total de energia da residencia: " + totalConsumption + "\n");
            writer.write("Media de kWH por aparelho: " + avgConsumptionPerDevice + "\n");
            writer.write("Tarifa de energia media: " + avgEnergyFee + "\n");
            writer.write("Total gasto estimado (R$): " + finalFee + "\n");
            writer.write("Total de medicoes: " + totalMeasurements + "\n");
            writer.close();

            Runtime.getRuntime().exec("cmd.exe /c start notepad.exe " + file.getAbsolutePath());

        } catch (IOException ex) {
            Logger.getLogger(View.MainMenu_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public static void fetchDataAndGenerateReport(int residenceId) {
        String residenceQuery = "SELECT r.cep, r.country, r.state, r.city, r.neighborhood, r.street, r.number, r.additional, r.energy_fee"
                + " FROM RESIDENCE r"
                + " WHERE r.id = ?";

        String deviceSummaryQuery = "SELECT COUNT(*) AS totalDevices, SUM(d.power) AS totalPower"
                + " FROM DEVICE d"
                + " WHERE d.residence_id = ?";

        String measurementSummaryQuery = "SELECT SUM(m.consumption) AS totalConsumption, COUNT(*) AS totalMeasurements,"
                + " AVG(m.energy_fee) AS avgEnergyFee"
                + " FROM MEASUREMENT m"
                + " INNER JOIN DEVICE d ON m.device_id = d.id"
                + " WHERE d.residence_id = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            // Informações da residência
            String cep = "";
            String country = "";
            String state = "";
            String city = "";
            String neighborhood = "";
            String street = "";
            String number = "";
            String additional = "";
            double energyFee = 0.0;

            try (PreparedStatement stmt = conn.prepareStatement(residenceQuery)) {
                stmt.setInt(1, residenceId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        cep = rs.getString("cep");
                        country = rs.getString("country");
                        state = rs.getString("state");
                        city = rs.getString("city");
                        neighborhood = rs.getString("neighborhood");
                        street = rs.getString("street");
                        number = rs.getString("number");
                        additional = rs.getString("additional");
                        energyFee = rs.getDouble("energy_fee");
                    }
                }
            }

            // Resumo de dispositivos
            int totalDevices = 0;
            double totalPower = 0.0;

            try (PreparedStatement stmt = conn.prepareStatement(deviceSummaryQuery)) {
                stmt.setInt(1, residenceId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        totalDevices = rs.getInt("totalDevices");
                        totalPower = rs.getDouble("totalPower");
                    }
                }
            }

            // Resumo de medições
            double totalConsumption = 0.0;
            int totalMeasurements = 0;
            double avgEnergyFee = 0.0;

            try (PreparedStatement stmt = conn.prepareStatement(measurementSummaryQuery)) {
                stmt.setInt(1, residenceId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        totalConsumption = rs.getDouble("totalConsumption");
                        totalMeasurements = rs.getInt("totalMeasurements");
                        avgEnergyFee = rs.getDouble("avgEnergyFee");
                    }
                }
            }

            // Calcular valores derivados
            double avgConsumptionPerDevice = totalDevices > 0 ? totalConsumption / totalDevices : 0.0;
            double finalFee = totalConsumption * avgEnergyFee;

            // Gerar o relatório
            generateReport(residenceId, cep, country, state, city, neighborhood, street, number, additional, avgEnergyFee, totalDevices, totalPower, totalConsumption, avgConsumptionPerDevice, finalFee, totalMeasurements);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
