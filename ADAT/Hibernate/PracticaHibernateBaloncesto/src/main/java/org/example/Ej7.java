package org.example;

import antlr.MismatchedCharException;
import org.example.Modelo.Estadisticas;
import org.example.Modelo.Jugadores;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;

public class Ej7 {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        try {
            if (!jugadorExisteById(s, Integer.parseInt(args[1]))) {
                System.err.println("Jugador no existe.");
                System.exit(-1);
            }

            Estadisticas e = new Estadisticas();
            e.setTemporada(args[0]);
            e.setJugador(Integer.parseInt(args[1]));
            e.setPuntosPorPartido(Double.parseDouble(args[2]));
            e.setAsistenciasPorPartido(Double.parseDouble(args[3]));
            e.setTaponesPorPartido(Double.parseDouble(args[4]));
            e.setRebotesPorPartido(Double.parseDouble(args[5]));
            e.setJugadoresByJugador(s.load(Jugadores.class, Integer.parseInt(args[1])));
            insertaEstadistica(s, e);

        } catch (IndexOutOfBoundsException | InputMismatchException iob) {
            System.err.println("Error en los argumentos. ");
        }
        s.close();
    }

    private static void insertaEstadistica(Session s, Estadisticas e) {
        if (existeEstadistica(s,e)){
            System.err.println("Error. Ya existe Estadística. ");
            return;
        }
        Transaction t = s.beginTransaction();
        s.save(e);
        t.commit();
        System.out.println("Estadística insertada: "+e.getTemporada()+"-"+e.getJugador());
    }

    private static boolean existeEstadistica(Session s, Estadisticas e) {
        Query q = s.createQuery("from Estadisticas e where e.jugador = "+e.getJugador()+" and e.temporada like '"+e.getTemporada()+"'");
        List<Estadisticas> l = q.list();
        if(l.size() == 0)
        return false;
        return true;
    }

    public static boolean jugadorExisteById(Session s, int id) {
        Jugadores j = s.load(Jugadores.class, id);
        try{
            j.getNombre();
        }catch (ObjectNotFoundException onf){
            return false;
        }
        return true;
    }

    public static boolean estadisticaExiste(Session s, Estadisticas e) {

        return false;
    }
}
