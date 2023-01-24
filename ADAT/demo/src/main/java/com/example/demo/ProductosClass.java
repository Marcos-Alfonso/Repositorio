package com.example.demo;

import java.math.BigDecimal;

public class ProductosClass {
    private Object id;
    private String descripcion;
    private Object stockactual;
    private Object stockminimo;
    private BigDecimal pvp;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Object getStockactual() {
        return stockactual;
    }

    public void setStockactual(Object stockactual) {
        this.stockactual = stockactual;
    }

    public Object getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(Object stockminimo) {
        this.stockminimo = stockminimo;
    }

    public BigDecimal getPvp() {
        return pvp;
    }

    public void setPvp(BigDecimal pvp) {
        this.pvp = pvp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductosClass that = (ProductosClass) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (stockactual != null ? !stockactual.equals(that.stockactual) : that.stockactual != null) return false;
        if (stockminimo != null ? !stockminimo.equals(that.stockminimo) : that.stockminimo != null) return false;
        if (pvp != null ? !pvp.equals(that.pvp) : that.pvp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (stockactual != null ? stockactual.hashCode() : 0);
        result = 31 * result + (stockminimo != null ? stockminimo.hashCode() : 0);
        result = 31 * result + (pvp != null ? pvp.hashCode() : 0);
        return result;
    }
}
