package org.example.modeloVentas;

import java.sql.Date;
import java.util.Objects;

public class Ventas {
    private short idventa;
    private Date fechaventa;
    private byte cantidad;
    private Clientes clientesByIdcliente;
    private Productos productosByIdproducto;

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
        Ventas ventas = (Ventas) o;
        return idventa == ventas.idventa && cantidad == ventas.cantidad && Objects.equals(fechaventa, ventas.fechaventa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idventa, fechaventa, cantidad);
    }

    public Clientes getClientesByIdcliente() {
        return clientesByIdcliente;
    }

    public void setClientesByIdcliente(Clientes clientesByIdcliente) {
        this.clientesByIdcliente = clientesByIdcliente;
    }

    public Productos getProductosByIdproducto() {
        return productosByIdproducto;
    }

    public void setProductosByIdproducto(Productos productosByIdproducto) {
        this.productosByIdproducto = productosByIdproducto;
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "ID Venta=" + idventa +
                ", Fecha=" + fechaventa +
                ", Cantidad=" + cantidad +
                ", PVP =" + productosByIdproducto.getPvp() +
                ", Producto =" + productosByIdproducto.getDescripcion() +
                ", Importe =" + (productosByIdproducto.getPvp()*(double)cantidad) +
                '}';
    }
    public double getImporte(){
        return productosByIdproducto.getPvp()*(double)cantidad;
    }
}
