package org.example;

import org.example.HibernateUtil;
import org.example.Modelo.Equipos;
import org.example.Modelo.Estadisticas;
import org.example.Modelo.Jugadores;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Ej6 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        Query q = s.createQuery("from Equipos");
        List<Equipos> l = q.list();
        System.out.println("Número de equipos: "+l.size());
        System.out.println("===================================");
        for (Equipos e:l) {
            System.out.println("Equipo: "+e.getNombre());
            Collection<Jugadores> jg = e.getJugadoresByNombre();
            System.out.println("Nº Jugadores: "+jg.size());
            for (Jugadores j:jg) {
                printStats(s, j);
            }
            System.out.println("...................................");
            System.out.println("===================================");
        }
        s.close();
    }

    private static void printStats(Session s, Jugadores j) {
        Query q = s.createQuery("from Estadisticas e where e.jugador = "+j.getCodigo());

        List<Estadisticas> l = q.list();
        double suma = 0;
        for (Estadisticas e:l) {
            suma+=e.getPuntosPorPartido();
        }
        suma = suma/l.size();
        String result = String.format("%.2f", suma);
        System.out.println(j.getCodigo()+", "+j.getNombre()+": "+result);
    }
}
