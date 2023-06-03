package modelo;

import modelo.Boleto;
import modelo.Asiento;
import modelo.Cliente;
import modelo.DatabaseConnection;
import modelo.EstadoAsiento;
import modelo.Seccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    
    List<Evento> eventos= new ArrayList<>();
    
    public static void addEvent(Evento event) {
        String query = "INSERT INTO eventos (nombre, sinopsis, fechaInicio, fechaFin, imagenPublicitaria, responsable, fechaHoraPublicacion, fechaHoraOcultar) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, event.getNombre());
            stmt.setString(2, event.getSinopsis());
            stmt.setObject(3, event.getFechaInicio());
            stmt.setObject(4, event.getFechaFin());
            stmt.setString(5, event.getImagenPublicitaria());
            stmt.setString(6, event.getResponsable());
            stmt.setObject(7, event.getFechaHoraPublicacion());
            stmt.setObject(8, event.getFechaHoraOcultar());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Evento> getAllEvents() {
        List<Evento> events = new ArrayList<>();
        String query = "SELECT * FROM eventos";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Evento event = new Evento(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("sinopsis"),
                        rs.getObject("fechaInicio", LocalDateTime.class),
                        rs.getObject("fechaFin", LocalDateTime.class),
                        rs.getString("imagenPublicitaria"),
                        rs.getString("responsable"),
                        rs.getObject("fechaHoraPublicacion", LocalDateTime.class),
                        rs.getObject("fechaHoraOcultar", LocalDateTime.class)
                );
                
                events.add(event);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return events;
    }

    public static Evento getEvent(int id) {
        String query = "SELECT * FROM eventos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Evento(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("sinopsis"),
                            rs.getObject("fechaInicio", LocalDateTime.class),
                            rs.getObject("fechaFin", LocalDateTime.class),
                            rs.getString("imagenPublicitaria"),
                            rs.getString("responsable"),
                            rs.getObject("fechaHoraPublicacion", LocalDateTime.class),
                            rs.getObject("fechaHoraOcultar", LocalDateTime.class)
                    );
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
    public void modificarEvento(Evento evento) {
        String sql = "UPDATE eventos SET nombre = ?, sinopsis = ?, fechaInicio = ?, fechaFin = ?, imagenPublicitaria = ?, responsable = ?, fechaHoraPublicacion = ?, fechaHoraOcultar = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, evento.getNombre());
            statement.setString(2, evento.getSinopsis());
            statement.setObject(3, evento.getFechaInicio());
            statement.setObject(4, evento.getFechaFin());
            statement.setString(5, evento.getImagenPublicitaria());
            statement.setString(6, evento.getResponsable());
            statement.setObject(7, evento.getFechaHoraPublicacion());
            statement.setObject(8, evento.getFechaHoraOcultar());
            statement.setInt(9, evento.getId());

            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void gestionarVisibilidadEvento(int idEvento, boolean visible) {
        String sql = "UPDATE eventos SET visible = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setBoolean(1, visible);
            statement.setInt(2, idEvento);

            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Boleto seleccionarBoleto(int idEvento, int idSeccion, String asiento) {
        // Buscar el evento
        for (Evento evento : eventos) {
            if (evento.getId() == idEvento) {
                // Encontramos el evento, ahora buscamos la sección
                for (Seccion seccion : evento.getSecciones()) {
                    if (seccion.getId() == idSeccion) {
                        // Encontramos la sección, ahora buscamos el asiento
                        for (Asiento a : seccion.getAsientos()) {
                            if (a.getFila().equals(asiento) && a.getEstado() == EstadoAsiento.DISPONIBLE) {
                                // Encontramos el asiento y está disponible, ahora lo seleccionamos
                                a.setEstado(EstadoAsiento.OCUPADO);
                                // Creamos y retornamos el boleto
                                return new Boleto(1,evento.getId(), 1, seccion.getId(),asiento,LocalDateTime.now(),"hola", seccion.getPrecio());
                            }
                        }
                    }
                }
            }
        }
        // No encontramos el asiento, o no estaba disponible
        return null;
    }

    public boolean comprarBoleto(Boleto boleto, Cliente cliente) {
        // Aquí iría tu código para realizar la transacción de la compra.
        // Esto podría implicar crear un nuevo registro en la base de datos para la compra,
        // y actualizar el registro del boleto para marcarlo como vendido.
        // Deberías devolver true si la compra es exitosa, y false en caso contrario.
        return false;
    }
}
