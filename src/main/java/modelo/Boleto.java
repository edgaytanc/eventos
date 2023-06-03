package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Boleto {
    private int id;
    private int eventoId;
    private int usuarioId;
    private int seccionId;
    private String asiento;
    private LocalDateTime fechaHoraEvento;
    private String direccionVenue;
    private BigDecimal precio;
    
    // Constructor, getters y setters
    
    public Boleto(){
        
    }

    public Boleto(int id, int eventoId, int usuarioId, int seccionId, String asiento, LocalDateTime fechaHoraEvento, String direccionVenue, BigDecimal precio) {
        this.id = id;
        this.eventoId = eventoId;
        this.usuarioId = usuarioId;
        this.seccionId = seccionId;
        this.asiento = asiento;
        this.fechaHoraEvento = fechaHoraEvento;
        this.direccionVenue = direccionVenue;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(int seccionId) {
        this.seccionId = seccionId;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public LocalDateTime getFechaHoraEvento() {
        return fechaHoraEvento;
    }

    public void setFechaHoraEvento(LocalDateTime fechaHoraEvento) {
        this.fechaHoraEvento = fechaHoraEvento;
    }

    public String getDireccionVenue() {
        return direccionVenue;
    }

    public void setDireccionVenue(String direccionVenue) {
        this.direccionVenue = direccionVenue;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
}
