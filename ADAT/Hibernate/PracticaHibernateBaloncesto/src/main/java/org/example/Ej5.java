package org.example;

import org.example.Modelo.Estadisticas;
import org.example.Modelo.Jugadores;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Ej5 {
    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        int id = 0;
        try{
            id = Integer.parseInt(args[0]);
        }catch (Exception eob){
            System.err.println("Error al recibir id.");
            System.exit(-1);
        }
        Jugadores j = null;
        try{
            j = s.load(Jugadores.class, id);
            System.out.println("Datos del Jugador "+j.getCodigo()
                    +"\nNombre: "+j.getNombre()
                    +"\nEquipo: "+j.getNombreEquipo());
        }catch (ObjectNotFoundException onf){
            System.err.println("Jugador no existe.");
            System.exit(-1);
        }
        Query q = s.createQuery("from Estadisticas e where e.jugador = "+j.getCodigo());
        System.out.println("Temporada   Ptos    Asis    Tap Reb" +
                "\n======================================");
        List<Estadisticas> l = q.list();
        int count = 0;
        for (Estadisticas e:l) {
            System.out.println(e.getTemporada()+"\t\t"+e.getPuntosPorPartido()+"\t\t"+e.getAsistenciasPorPartido()+"\t\t"+e.getTaponesPorPartido()+"\t"+e.getRebotesPorPartido());
            count++;
        }
        System.out.println("======================================");
        System.out.println("Número de registros: "+count);
        System.out.println("======================================");
    }
}