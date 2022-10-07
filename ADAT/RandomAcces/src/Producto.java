import java.io.Serializable;

public class Producto implements Serializable {
    private int codigo;
    private String descripcion;
    private int unidades;
    private double precio;

    public Producto(int codigo, String descripcion, int unidades, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getUnidades() {
        return unidades;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", unidades=" + unidades +
                ", precio=" + precio +
                '}';
    }
}
