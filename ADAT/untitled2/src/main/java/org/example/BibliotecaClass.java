package org.example;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "biblioteca", schema = "unidad2", catalog = "")
public class BibliotecaClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NUMERO", nullable = false)
    private int numero;
    @Basic
    @Column(name = "TITULO", nullable = true, length = 50)
    private String titulo;
    @Basic
    @Column(name = "AUTOR", nullable = true, length = 50)
    private String autor;
    @Basic
    @Column(name = "FNAC", nullable = true)
    private Date fnac;
    @Basic
    @Column(name = "FECHAPUB", nullable = true)
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
}
