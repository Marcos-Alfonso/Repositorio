package org.example;

import org.example.Modelo.TEstaciones;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Ej3 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        Query q = s.createQuery("from TEstaciones e ");
        List<TEstaciones> estaciones = q.list();
        for (TEstaciones e:estaciones) {
            actualizaNLineas(s, e);
            actualizaNAccesos(s, e);
            actualizaNViajesDestino(s, e);
            actualizaNViajesProcedencia(s, e);
        }
    }

    private static void actualizaNLineas(Session s, TEstaciones e) {
        Query q = s.createQuery("from TLineaEstacion l where l.id.codEstacion = "+e.getCodEstacion());
        List<TEstaciones> le = q.list();
        Transaction t = s.beginTransaction();
        e.setNumlineas(le.size());
        s.update(e);
        t.commit();
        System.out.println("Nº de líneas actualizadas: "+e.getCodEstacion());
    }
    private static void actualizaNAccesos(Session s, TEstaciones e) {
        Query q = s.createQuery("from TAccesos l where l.codEstacion = "+e.getCodEstacion());
        List<TEstaciones> le = q.list();
        Transaction t = s.beginTransaction();
        e.setNumaccesos(le.size());
        s.update(e);
        t.commit();
        System.out.println("Nº de accesos actualizados: "+e.getCodEstacion());
    }
    private static void actualizaNViajesDestino(Session s, TEstaciones e) {
        Query q = s.createQuery("from TViajes l where l.estaciondestino = "+e.getCodEstacion());
        List<TEstaciones> le = q.list();
        Transaction t = s.beginTransaction();
        e.setNumviajesdestino(le.size());
        s.update(e);
        t.commit();
        System.out.println("Nº de Viajes de Destino actualizados: "+e.getCodEstacion());
    }
    private static void actualizaNViajesProcedencia(Session s, TEstaciones e) {
        Query q = s.createQuery("from TViajes l where l.estacionorigen = "+e.getCodEstacion());
        List<TEstaciones> le = q.list();
        Transaction t = s.beginTransaction();
        e.setNumviajesprocedencia(le.size());
        s.update(e);
        t.commit();
        System.out.println("Nº de Viajes de Procedencia actualizados: "+e.getCodEstacion());
    }
}