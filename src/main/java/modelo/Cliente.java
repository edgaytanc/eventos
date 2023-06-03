
package modelo;

import modelo.Rol;
import modelo.Usuario;


public class Cliente{
    
    private int id;
    private String nombre;
    private String correo;
    private String direccion;
    private String numeroTarjeta;

    public Cliente(int id, String nombre, String correo, String direccion, String numeroTarjeta) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.numeroTarjeta = numeroTarjeta;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo +
               ", direccion=" + direccion + ", numeroTarjeta=" + numeroTarjeta + '}';
    }
    
    
}
