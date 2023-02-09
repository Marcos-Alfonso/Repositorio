package org.example.modeloVentas;

import org.example.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Ej3_7 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        int id;
        try{
            id = Integer.parseInt(args[0]);
        }catch (Exception eob){
            id = 21;
        }
        Clientes c = s.load(Clientes.class, id);

        System.out.println("Ventas del cliente: "+c.getNombre());
        Query q = s.createQuery("from Ventas v where v.clientesByIdcliente.id = "+c.getId());
        List<Ventas> l = q.list();
        for (Ventas v:l) {
            System.out.println(v);
        }
    }
}
