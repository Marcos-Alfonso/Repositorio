package org.example;

import org.example.HibernateUtil;
import org.example.modeloVentas.Clientes;
import org.example.modeloVentas.Productos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Ej3_6 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();


        Clientes c = new Clientes();
        c.setId(20);
        c.setNombre("Antonio");
        c.setNif("12345678W");
        c.setDireccion("Dirección");
        c.setPoblacion("Angola");
        c.setTelef("+32 234 556 78 98");
        insertaCliente(s, c);
        c = new Clientes();
        c.setId(21);
        c.setNombre("Ronaldo");
        c.setNif("98765432R7");
        c.setDireccion("Rua dois pedras");
        c.setPoblacion("Portugal");
        c.setTelef("+45 777 77 77 77");
        insertaCliente(s, c);





        s.close();
    }

    private static void insertaCliente(Session s, Clientes c) {
        if (existeClienteId(s,c.getId())){
            System.err.println("Cliente ya existe");
            return;
        }
        Transaction t = s.beginTransaction();
        s.save(c);
        t.commit();
        System.out.println("Insertado cliente: "+c.getNombre()+"-"+c.getNif());
    }
    private static boolean existeClienteId(Session s, int id){
        Query q = s.createQuery("from Clientes where id = "+id);
        List<Clientes> l = q.list();
        if (l.size() > 0)return true;
        return false;
    }
    private static boolean existeProductoId(Session s, int id){
        Query q = s.createQuery("from Productos where id = "+id);
        List<Productos> l = q.list();
        if (l.size() > 0)return true;
        return false;
    }
}
