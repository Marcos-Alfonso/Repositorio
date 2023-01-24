package com.example.demo;

public class ClientesClass {
    private byte id;
    private String nombre;
    private String direccion;
    private String poblacion;
    private String telef;
    private String nif;

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientesClass that = (ClientesClass) o;

        if (id != that.id) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (poblacion != null ? !poblacion.equals(that.poblacion) : that.poblacion != null) return false;
        if (telef != null ? !telef.equals(that.telef) : that.telef != null) return false;
        if (nif != null ? !nif.equals(that.nif) : that.nif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (poblacion != null ? poblacion.hashCode() : 0);
        result = 31 * result + (telef != null ? telef.hashCode() : 0);
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        return result;
    }
}
