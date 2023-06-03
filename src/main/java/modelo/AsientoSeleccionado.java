
package modelo;


public class AsientoSeleccionado {
    private String asiento;
    private String seccion;

    public AsientoSeleccionado(String asiento, String seccion) {
        this.asiento = asiento;
        this.seccion = seccion;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    
    
}
