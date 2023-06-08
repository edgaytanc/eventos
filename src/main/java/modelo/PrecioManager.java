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

    public static void eliminaPrecio(int id_evento) {
        String sql = "DELETE FROM precios WHERE evento_id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id_evento);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Los precios asociados al evento han sido eliminados exitosamente");
            } else {
                System.out.println("No se encontraron precios para eliminar asociados a este evento");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Eliminación fallida");
        }
    }

}
