package com.example.reproductor.modelos;

public class Playlist {
    String nombre;
    String imagen;
    int id;

    public Playlist(int id, String nombre,String imagen ) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
