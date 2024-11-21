package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DeviceFuncs_DAO {

    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();

    public static boolean addDevice(String deviceName, String powerInWatts, int residenceId) {
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
                Model.FieldFuncs_DAO.refreshDeviceCombobox(residenceId);
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro na inserção!", "ERRO!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo de potencia nao foi preenchido corretamente!");
        }
        return false;
    }

    public static Device getDeviceById(int deviceId) {
        String query = "SELECT * FROM DEVICE WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, deviceId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                double power = rs.getDouble("power");
                boolean status = rs.getBoolean("status");
                return new Device(deviceId, name, power, status);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean changeDeviceStatus(Device device, boolean status) {
        int deviceId = device.getId();
        try (java.sql.Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                PreparedStatement pstmt = con.prepareStatement("UPDATE DEVICE SET status=? WHERE id=?")) {
            pstmt.setBoolean(1, status);
            pstmt.setInt(2, deviceId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Status do dispositivo alterado com sucesso!");
                return true;
            } else {
                System.out.println("Dispositivo nao encontrado");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar mudar status do dispositivo!");
            return false;
        }
    }

    public static boolean updateDeviceInfo(int deviceId, String newName, String newPower) {
        if (ValidationFuncs_DAO.canBeConvertedToDouble(newPower)) {
            try (java.sql.Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                    PreparedStatement pstmt = con.prepareStatement("UPDATE DEVICE SET name=?, power=? WHERE id=?")) {
                pstmt.setString(1, newName);
                pstmt.setString(2, newPower);
                pstmt.setInt(3, deviceId);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Informacoes do dispositivo alteradas com sucesso!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Dispositivo nao encontrado");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Erro ao tentar atualizar informacoes do dispositivo!");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo de potencia nao foi preenchido corretamente!");
        }
        return false;
    }

    public static boolean deleteDevice(int deviceId) {
        if (Model.ConfirmationFuncs_DAO.deleteDeviceConfirmation()) {
            try (java.sql.Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                    PreparedStatement pstmtDelete = con.prepareStatement("DELETE FROM DEVICE WHERE id=?")) {
                pstmtDelete.setInt(1, deviceId);
                int rowsAffected = pstmtDelete.executeUpdate(); //executeUpdate para saber se houveram linhas afetadas pelo comando.
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Dispositivo deletado com sucesso!");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Dispositivo nao encontrado!");
                    return false;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir dados! Por favor, tente novamente.");
            }
            return false;
        }
        return false;
    }

    private static void generateReport(int deviceId, String deviceName, double power, double consumption, double usageTimeInHours, double finalFee, int totalMeasurements, double avgEnergyFee) {
        //LocalDateTime dateTime = LocalDateTime.now();
        String filePath = "REPORT/device-report.txt";
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Cria diretórios se não existirem

            FileWriter writer = new FileWriter(file);
            writer.write("=-=-=-=- RALATORIO DE DISPOSITIVO =-=-=-=-\n\n");
            writer.write("Nome: " + deviceName + "\n");
            writer.write("ID: " + deviceId + "\n");
            writer.write("Potencia em WATTS: " + power + "\n\n");
            writer.write("---- MEASUREMENTS INFO ----\n\n");
            writer.write("Total kWH: " + consumption + "\n");
            writer.write("Tarifa de energia media: " + avgEnergyFee + "\n");
            writer.write("Tempo total de uso: " + usageTimeInHours + "\n");
            writer.write("Total gasto estimado (R$): " + finalFee + "\n");
            writer.write("Quantidade total de medicoes:" + totalMeasurements + "\n");
            writer.close();

            Runtime.getRuntime().exec("cmd.exe /c start notepad.exe " + file.getAbsolutePath());

        } catch (IOException ex) {
            Logger.getLogger(View.MainMenu_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fetchDataAndGenerateReport(int deviceId) {
        String deviceQuery = "SELECT d.name, d.power FROM DEVICE d WHERE d.id = ?";
        String measurementQuery = "SELECT SUM(m.consumption) AS totalConsumption, SUM(m.usage_time_in_minutes) AS totalUsageTime, COUNT(*) AS totalMeasurements, "
                + " AVG(m.energy_fee) AS avgEnergyFee"
                + " FROM MEASUREMENT m"
                + " WHERE m.device_id = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            // Obtendo informações do dispositivo
            String deviceName = null;
            double power = 0.0;

            try (PreparedStatement stmt = conn.prepareStatement(deviceQuery)) {
                stmt.setInt(1, deviceId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        deviceName = rs.getString("name");
                        power = rs.getDouble("power");
                    } else {
                        System.out.println("Dispositivo não encontrado!");
                        return;
                    }
                }
            }

            // Obtendo informações de medições
            double totalConsumption = 0.0;
            double totalUsageTime = 0.0;
            int totalMeasurements = 0;
            double avgEnergyFee = 0.0;

            try (PreparedStatement stmt = conn.prepareStatement(measurementQuery)) {
                stmt.setInt(1, deviceId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        totalConsumption = rs.getDouble("totalConsumption");
                        totalUsageTime = rs.getDouble("totalUsageTime") / 60.0; // Converter minutos para horas
                        totalMeasurements = rs.getInt("totalMeasurements");
                        avgEnergyFee = rs.getDouble("avgEnergyFee");
                    }
                }
            }

            // Calculando a taxa final
            double finalFee = totalConsumption * avgEnergyFee;

            // Chamando a função generateReport
            generateReport(deviceId, deviceName, power, totalConsumption, totalUsageTime, finalFee, totalMeasurements, avgEnergyFee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
