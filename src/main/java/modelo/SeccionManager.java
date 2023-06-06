package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeccionManager {

    public static boolean addSeccion(Seccion seccion) {
        String query = "INSERT INTO secciones (nombre, evento_id) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, seccion.getNombre());
            stmt.setInt(2, seccion.getEventoId());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static int countEvents() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT COUNT(*) AS count FROM secciones";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("count");
            }
        } catch (SQLException e) {
            // manejar excepción
            e.printStackTrace();
        }

        // Devolver -1 para indicar que ocurrió un error
        return -1;
    }

}
