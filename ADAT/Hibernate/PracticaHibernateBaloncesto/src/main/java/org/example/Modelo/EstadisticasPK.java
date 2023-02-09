package org.example.Modelo;

import java.io.Serializable;
import java.util.Objects;

public class EstadisticasPK implements Serializable {
    private String temporada;
    private int jugador;

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public int getJugador() {
        return jugador;
    }

    public void setJugador(int jugador) {
        this.jugador = jugador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadisticasPK that = (EstadisticasPK) o;
        return jugador == that.jugador && Objects.equals(temporada, that.temporada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temporada, jugador);
    }
}
