package org.example.Modelo;

import java.util.Objects;

public class TViajes {
    private int codViaje;
    private String nombre;
    private Integer estacionorigen;
    private Integer estaciondestino;
    private TEstaciones tEstacionesByEstacionorigen;
    private TEstaciones tEstacionesByEstaciondestino;

    public int getCodViaje() {
        return codViaje;
    }

    public void setCodViaje(int codViaje) {
        this.codViaje = codViaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEstacionorigen() {
        return estacionorigen;
    }

    public void setEstacionorigen(Integer estacionorigen) {
        this.estacionorigen = estacionorigen;
    }

    public Integer getEstaciondestino() {
        return estaciondestino;
    }

    public void setEstaciondestino(Integer estaciondestino) {
        this.estaciondestino = estaciondestino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TViajes tViajes = (TViajes) o;
        return codViaje == tViajes.codViaje && Objects.equals(nombre, tViajes.nombre) && Objects.equals(estacionorigen, tViajes.estacionorigen) && Objects.equals(estaciondestino, tViajes.estaciondestino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codViaje, nombre, estacionorigen, estaciondestino);
    }

    public TEstaciones gettEstacionesByEstacionorigen() {
        return tEstacionesByEstacionorigen;
    }

    public void settEstacionesByEstacionorigen(TEstaciones tEstacionesByEstacionorigen) {
        this.tEstacionesByEstacionorigen = tEstacionesByEstacionorigen;
    }

    public TEstaciones gettEstacionesByEstaciondestino() {
        return tEstacionesByEstaciondestino;
    }

    public void settEstacionesByEstaciondestino(TEstaciones tEstacionesByEstaciondestino) {
        this.tEstacionesByEstaciondestino = tEstacionesByEstaciondestino;
    }
}
