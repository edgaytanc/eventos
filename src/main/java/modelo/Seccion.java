/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author David
 */
public class Seccion {
    private int id;
    private String nombre;
    private int eventoId;
    private BigDecimal precio;
    private List<Asiento> asientos;
    
    // Constructor, getters y setters

    public Seccion(int id, String nombre, int eventoId, BigDecimal precio, List<Asiento> asientos) {
        this.id = id;
        this.nombre = nombre;
        this.eventoId = eventoId;
        this.precio = precio;
        this.asientos = asientos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }

    @Override
    public String toString() {
        return "Seccion{" + "id=" + id + ", nombre=" + nombre + ", eventoId=" + 
                eventoId + ", precio=" + precio + ", asientos=" + asientos + '}';
    }
    
    
}
