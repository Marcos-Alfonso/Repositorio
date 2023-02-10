package org.example.Modelo;

import java.util.Objects;

public class TAccesos {
    private int codAcceso;
    private String descripcion;
    private int codEstacion;
    private TEstaciones tEstacionesByCodEstacion;

    public int getCodAcceso() {
        return codAcceso;
    }

    public void setCodAcceso(int codAcceso) {
        this.codAcceso = codAcceso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodEstacion() {
        return codEstacion;
    }

    public void setCodEstacion(int codEstacion) {
        this.codEstacion = codEstacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TAccesos tAccesos = (TAccesos) o;
        return codAcceso == tAccesos.codAcceso && codEstacion == tAccesos.codEstacion && Objects.equals(descripcion, tAccesos.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAcceso, descripcion, codEstacion);
    }

    public TEstaciones gettEstacionesByCodEstacion() {
        return tEstacionesByCodEstacion;
    }

    public void settEstacionesByCodEstacion(TEstaciones tEstacionesByCodEstacion) {
        this.tEstacionesByCodEstacion = tEstacionesByCodEstacion;
    }
}
