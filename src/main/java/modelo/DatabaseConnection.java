package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/eventos";
    private static final String USER = "postgres";
    private static final String PASSWORD = "manager";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("Conexion con exito");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Conexion sin exito");
        }

        return connection;
    }
}

