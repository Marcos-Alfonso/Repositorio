package com.example.agendacontactos;

import java.io.Serializable;

public class contacto implements Serializable {
    private String codigo;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String grupo;

    public contacto(String codigo, String nombre,String apellido,String telefono, String email, String grupo){
        this.codigo = codigo;
        this.nombre=nombre;
        this.apellido=apellido;
        this.telefono=telefono;
        this.email=email;
        this.grupo=grupo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getGrupo() {
        return grupo;
    }

}
