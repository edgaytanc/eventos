
package modelo;

import modelo.DatabaseConnection;
import java.sql.*;

public class UserManager {

    public static boolean registerUser(String username, String password) {
        String hashedPassword = hashPassword(password);

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, hashedPassword);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // manejar excepción
            e.printStackTrace();
        }

        return false;
    }

    public static boolean loginUser(String email, String password) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT \"contraseña\" FROM usuarios WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("contraseña");
                //temporal
                System.out.println(storedPassword);
                //temporal
                //return storedPassword.equals(hashPassword(password));
                return true;
            }
        } catch (SQLException e) {
            // manejar excepción
            e.printStackTrace();
        }

        return false;
    }

    private static String hashPassword(String password) {
        // Aquí se debe implementar la lógica de hashing de la contraseña.
        // En un caso real, nunca se debe utilizar un método de hashing tan simple.
        // Se debe usar un algoritmo seguro de hashing de contraseñas, como bcrypt.
        return String.valueOf(password.hashCode());
    }
}
