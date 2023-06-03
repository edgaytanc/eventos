package modelo;

import modelo.DatabaseConnection;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class BoletoManager {

    public static boolean verificarDisponibilidadAsiento(int eventoId, int seccionId, String asiento) {
        String sql = "SELECT * FROM boletos WHERE eventoId = ? AND seccionId = ? AND asiento = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, eventoId);
            statement.setInt(2, seccionId);
            statement.setString(3, asiento);

            try (ResultSet resultSet = statement.executeQuery()) {
                return !resultSet.next();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public static boolean reservarAsiento(int eventoId, int usuarioId, int seccionId, String asiento, LocalDateTime fechaHoraEvento, String direccionVenue, BigDecimal precio) {
        String sql = "INSERT INTO boletos (eventoId, usuarioId, seccionId, asiento, fechaHoraEvento, direccionVenue, precio) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, eventoId);
            statement.setInt(2, usuarioId);
            statement.setInt(3, seccionId);
            statement.setString(4, asiento);
            statement.setTimestamp(5, java.sql.Timestamp.valueOf(fechaHoraEvento));
            statement.setString(6, direccionVenue);
            statement.setBigDecimal(7, precio);

            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public static Boleto obtenerBoleto(int id) {
        String sql = "SELECT * FROM boletos WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Boleto(
                            resultSet.getInt("id"),
                            resultSet.getInt("eventoId"),
                            resultSet.getInt("usuarioId"),
                            resultSet.getInt("seccionId"),
                            resultSet.getString("asiento"),
                            resultSet.getTimestamp("fechaHoraEvento").toLocalDateTime(),
                            resultSet.getString("direccionVenue"),
                            resultSet.getBigDecimal("precio")
                    );
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
