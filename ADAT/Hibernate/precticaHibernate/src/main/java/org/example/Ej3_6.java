package org.example;

import org.example.HibernateUtil;
import org.example.modeloVentas.Clientes;
import org.example.modeloVentas.Productos;
import org.example.modeloVentas.Ventas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Ej3_6 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();


        Clientes c = new Clientes(20,"Antonio","Direccion", "Angola", "+32 234 556 78 98","12345678W");
        insertaCliente(s, c);
        Clientes cl = new Clientes(21,"Ronaldo","Rua dois pedras", "Portugal", "+45 777 77 77 77","98765432R7");
        insertaCliente(s, cl);

        Productos p = new Productos(31, "El libro troll del rubius", 50, 5, 30.99);
        insertaProducto(s, p);
        Productos pr = new Productos(32, "Dark souls IV", 30, 5, 79.99);
        insertaProducto(s, pr);

        Date sqlDate = new Date(System.currentTimeMillis());
        Ventas v = new Ventas((short) 8, sqlDate, 20, cl, p);
        insertaVenta(s, v);

        s.close();
    }

    private static void insertaVenta(Session s, Ventas v) {
        if (existeVenta(s, v)){
            System.err.println("Error al insertar Venta. Venta ya existe");
            return;
        }
        if (!existeClienteId(s,v.getClientesByIdcliente())){
            System.err.println("Error al insertar Venta. Cliente no exite.");
        }
        if(!existeProductoId(s, v.getProductosByIdproducto())){
            System.err.println("Error al insertar Venta. Producto no existe");
        }
        if ((v.getProductosByIdproducto().getStockactual()-v.getCantidad()<v.getProductosByIdproducto().getStockminimo())){
            System.err.println("Error al insertar Venta. No hay stock suficiente.");
            return;
        }
        Transaction t = s.beginTransaction();
        s.save(v);
        t.commit();
        System.out.println("Insertada Venta: "+v);
    }

    private static boolean existeVenta(Session s, Ventas v) {
        Query q = s.createQuery("from Clientes where id = "+v.getIdventa());
        List<Ventas> l = q.list();
        if (l.size() > 0)return true;
        return false;
    }

    private static void insertaCliente(Session s, Clientes c) {
        if (existeClienteId(s,c)){
            System.err.println("Cliente ya existe");
            return;
        }
        Transaction t = s.beginTransaction();
        s.save(c);
        t.commit();
        System.out.println("Insertado cliente: "+c.getNombre()+"-"+c.getNif());
    }
    private static void insertaProducto(Session s, Productos p) {
        if (existeProductoId(s,p)){
            System.err.println("Producto ya existe");
            return;
        }
        Transaction t = s.beginTransaction();
        s.save(p);
        t.commit();
        System.out.println("Insertado productos: "+p.getDescripcion()+" con Stock "+p.getStockactual());
    }
    private static boolean existeClienteId(Session s, Clientes c){
        Query q = s.createQuery("from Clientes where id = "+c.getId());
        List<Clientes> l = q.list();
        if (l.size() > 0)return true;
        return false;
    }
    private static boolean existeProductoId(Session s, Productos p){
        Query q = s.createQuery("from Productos where id = "+p.getId());
        List<Productos> l = q.list();
        if (l.size() > 0)return true;
        return false;
    }
}
