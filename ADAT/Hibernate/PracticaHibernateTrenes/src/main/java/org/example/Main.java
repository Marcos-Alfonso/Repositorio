package org.example;

import org.example.Modelo.TEstaciones;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        System.out.println("Hello world!");
        Query q = s.createQuery("from TEstaciones e ");
        List<TEstaciones> estaciones = q.list();
        for (TEstaciones e:estaciones) {
            actualizaNLineas(s, e);
        }
    }

    private static void actualizaNLineas(Session s, TEstaciones e) {
        Query q = s.createQuery("from TLineaEstacion l where l.id.codEstacion = "+e.getCodEstacion());
        List<TEstaciones> TLineaEstacion = q.list();
        
    }
}