package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrecioManager {

    public static boolean guardarPrecio(Precio precio) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO precios (evento_id, seccion_id, precio) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, precio.getEventoId());
            preparedStatement.setInt(2, precio.getSeccionId());
            preparedStatement.setDouble(3, precio.getPrecio());
            preparedStatement.executeUpdate();

            return true; // Devolver true si la inserción es exitosa
        } catch (SQLException e) {
            // Aquí debes manejar cualquier error que ocurra durante la inserción.
            e.printStackTrace();

            return false; // Devolver false si ocurre una excepción
        }
    }
}
