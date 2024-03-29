package org.example.modeloVentas;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

public class Productos {
    private Integer id;
    private String descripcion;
    private Integer stockactual;
    private Integer stockminimo;
    private Double pvp;
    private Collection<Ventas> ventasById;

    public Productos(){

    }

    public Productos(Integer id, String descripcion, Integer stockactual, Integer stockminimo, Double pvp) {
        this.id = id;
        this.descripcion = descripcion;
        this.stockactual = stockactual;
        this.stockminimo = stockminimo;
        this.pvp = pvp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStockactual() {
        return stockactual;
    }

    public void setStockactual(Integer stockactual) {
        this.stockactual = stockactual;
    }

    public Integer getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(Integer stockminimo) {
        this.stockminimo = stockminimo;
    }

    public Double getPvp() {
        return pvp;
    }

    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productos productos = (Productos) o;
        return Objects.equals(id, productos.id) && Objects.equals(descripcion, productos.descripcion) && Objects.equals(stockactual, productos.stockactual) && Objects.equals(stockminimo, productos.stockminimo) && Objects.equals(pvp, productos.pvp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, stockactual, stockminimo, pvp);
    }

    public Collection<Ventas> getVentasById() {
        return ventasById;
    }

    public void setVentasById(Collection<Ventas> ventasById) {
        this.ventasById = ventasById;
    }
}
