package org.example;

import org.example.modeloVentas.Clientes;
import org.example.modeloVentas.Ventas;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Iterator;
import java.util.Set;

public class Ej3_5 {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        int id;
        try{
            id = Integer.parseInt(args[0]);
        }catch (Exception eob){
            id = 1;
        }
        Clientes c = s.load(Clientes.class, id);

        System.out.println("Ventas del cliente: "+c.getNombre());
        Set<Ventas> lista = (Set<Ventas>) c.getVentasById();
        Iterator<Ventas> i = lista.iterator();

        double d = 0;
        int count = 0;
        while (i.hasNext()){
            Ventas v = i.next();
            d+= v.getImporte();
            System.out.println(v);
            count++;
        }
        System.out.println("Importe total: "+d+"\nTotal de ventas: "+count);
        s.close();
    }
}