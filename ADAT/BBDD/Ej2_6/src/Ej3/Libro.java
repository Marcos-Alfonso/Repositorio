package Ej3;

import java.sql.Date;

public class Libro {
private String titulo;
private String autor;
private Date fechaNacimiento;
private int fechaPublicacion;

    public Libro(String titulo, String autor, Date fechaNacimiento, int fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaPublicacion = fechaPublicacion;
    }
    public Libro(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(int fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
