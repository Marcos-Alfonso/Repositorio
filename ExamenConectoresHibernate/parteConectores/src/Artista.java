import java.sql.Date;

public class Artista {
    int id;
    String nombre;
    Date fechaNac;
    Date fechaDef;

    public Artista(int id, String nombre, Date fechaNac, Date fechaDef) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.fechaDef = fechaDef;
    }

    public Artista() {
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

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Date getFechaDef() {
        return fechaDef;
    }

    public void setFechaDef(Date fechaDef) {
        this.fechaDef = fechaDef;
    }
}
