import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombre;
    private int edad;
    private String ciudad;
    private double descuento;

    public Cliente(String nombre, int edad, String ciudad, double descuento) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ciudad='" + ciudad + '\'' +
                ", descuento=" + descuento +
                '}';
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
