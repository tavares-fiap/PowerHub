package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class MeasurementFuncs_DAO {

    private static String dbUrl = Controller.DataBaseConfig_DB.getUrl();
    private static String dbUsername = Controller.DataBaseConfig_DB.getUsername();
    private static String dbPassword = Controller.DataBaseConfig_DB.getPassword();

    public static boolean newMeasurement(Device device) {
        int deviceId = device.getId();
        LocalDateTime started = LocalDateTime.now();

        String sql = "INSERT INTO MEASUREMENT (device_id, started) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement insert = con.prepareStatement(sql)) {
            // Configurando os parâmetros do PreparedStatement
            insert.setInt(1, deviceId);
            insert.setObject(2, Timestamp.valueOf(started));
            //insert.setBoolean(3, true); (por default ja esta true no banco de dados)
            // Executando a inserção
            insert.executeUpdate();
            System.out.println("Novo MEASUREMENT iniciado!");

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro ao tentar iniciar nova medicao!\nCodigo do erro: " + ex.getMessage(), "ERRO!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean endMeasurement(Device device, double energyFee) {
        int deviceId = device.getId();
        String stringStarted = getMeasurementStart(deviceId);
        LocalDateTime started = convertToDateTime(stringStarted);
        LocalDateTime ended = LocalDateTime.now();
        Duration duration = Duration.between(started, ended);
        int durationInMinutes = (int) duration.toMinutes();
        double consumption = calculateConsumption(device.getPowerInWatts(), durationInMinutes);
        double finalFee = calculateFinalFee(consumption, durationInMinutes, energyFee);
        try (java.sql.Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                PreparedStatement pstmt = con.prepareStatement("UPDATE MEASUREMENT SET ended=?, consumption=?, status=?, energy_fee=?, usage_time_in_minutes=?, final_fee=? WHERE status=? AND device_id=?")) {
            pstmt.setObject(1, Timestamp.valueOf(ended));
            pstmt.setDouble(2, consumption);
            pstmt.setBoolean(3, false);
            pstmt.setDouble(4, energyFee);
            pstmt.setInt(5, durationInMinutes);
            pstmt.setDouble(6, finalFee);
            pstmt.setBoolean(7, true); //So pode existir uma medicao ativa por vez no banco, por isso bisca pela que esta ativa
            pstmt.setInt(8, deviceId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Medicao finalizada com sucesso!");
                return true;
            } else {
                System.out.println("Nenhuma medicao encontrada");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar atualizar/finalizar medicao!\nCodigo do erro: " + e.getMessage());
            return false;
        }
    }

    public static double calculateConsumption(double devicePower, double usageTimeInMinutes) {
        return (devicePower * (usageTimeInMinutes / 60)) / 1000;
    }
    
    public static double calculateFinalFee(double consumption, double usageTimeInMinutes, double energy_fee) {
        return (consumption * (usageTimeInMinutes/60)) * energy_fee;
    }

    public static String getMeasurementStart(int deviceId) {
        String query = "SELECT started FROM MEASUREMENT WHERE status=? AND device_id = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setBoolean(1, true);
            stmt.setInt(2, deviceId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String started = rs.getString("started");
                return started;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static LocalDateTime convertToDateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[.S]");
        return LocalDateTime.parse(dateTime, formatter);
    }
}
