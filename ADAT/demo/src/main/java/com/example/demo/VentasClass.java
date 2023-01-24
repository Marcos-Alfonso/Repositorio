package com.example.demo;

import java.sql.Date;

public class VentasClass {
    private short idventa;
    private Date fechaventa;
    private byte idcliente;
    private Object idproducto;
    private byte cantidad;

    public short getIdventa() {
        return idventa;
    }

    public void setIdventa(short idventa) {
        this.idventa = idventa;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public byte getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(byte idcliente) {
        this.idcliente = idcliente;
    }

    public Object getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Object idproducto) {
        this.idproducto = idproducto;
    }

    public byte getCantidad() {
        return cantidad;
    }

    public void setCantidad(byte cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VentasClass that = (VentasClass) o;

        if (idventa != that.idventa) return false;
        if (idcliente != that.idcliente) return false;
        if (cantidad != that.cantidad) return false;
        if (fechaventa != null ? !fechaventa.equals(that.fechaventa) : that.fechaventa != null) return false;
        if (idproducto != null ? !idproducto.equals(that.idproducto) : that.idproducto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idventa;
        result = 31 * result + (fechaventa != null ? fechaventa.hashCode() : 0);
        result = 31 * result + (int) idcliente;
        result = 31 * result + (idproducto != null ? idproducto.hashCode() : 0);
        result = 31 * result + (int) cantidad;
        return result;
    }
}
