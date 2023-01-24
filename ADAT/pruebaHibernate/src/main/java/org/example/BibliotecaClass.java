package org.example;

import java.sql.Date;
import java.util.Objects;

public class BibliotecaClass {
    private int numero;
    private String titulo;
    private String autor;
    private Date fnac;
    private Integer fechapub;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public Date getFnac() {
        return fnac;
    }

    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }

    public Integer getFechapub() {
        return fechapub;
    }

    public void setFechapub(Integer fechapub) {
        this.fechapub = fechapub;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BibliotecaClass that = (BibliotecaClass) o;
        return numero == that.numero && Objects.equals(titulo, that.titulo) && Objects.equals(autor, that.autor) && Objects.equals(fnac, that.fnac) && Objects.equals(fechapub, that.fechapub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, titulo, autor, fnac, fechapub);
    }
}
