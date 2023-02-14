package org.example;

import org.example.Modelos.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        Query q = s.createQuery("from Artistas");
        List<Artistas> l = q.list();

        //a. Mostrar una lista de peliculas que realiza un director, asi como su nombre
        Artistas a = new Artistas();
        a.setArtistaId(18);
        muestraPeliculasDeDirector(s, a);

        //b. modifica un estudio de una pelicula por otro, si no existe el estudio se dará alta del mismo. Mostrar los datos del nuevo estudio y del antiguo
        Peliculas p = s.load(Peliculas.class, 3);
        Estudios e  =new Estudios();
        e.setNombre("20th Century Fox");
        e.setEmail("info@century.com");
        e.setEstudioId(4);
        modificaEstudioDePelicula(s, p, e);

        //c. Elimina un estudio si existe y los datos relacionados
        Estudios estudio = new Estudios();
        estudio.setEstudioId(3);
        eliminaEstudio(s, estudio);
        s.close();
    }

    private static void modificaEstudioDePelicula(Session s, Peliculas p, Estudios e) {
        Transaction t = s.beginTransaction();
        if (!existeEstudio(s, e)){
            System.out.println("No existe estudio. Se va a dar de alta estudio.");
            s.save(e);
        }
        p.setEstudioId(e.getEstudioId());
        s.update(p);
        t.commit();
        System.out.println("Modificación efectuada.");
    }

    private static void eliminaEstudio(Session s, Estudios e) {
        if (!existeEstudio(s, e)){
            System.err.println("No existe estudio.");
            return;
        }
        Estudios estudio = s.load(Estudios.class, e.getEstudioId());

        // Funciona porque en los xml he añadido cascade="delete" en Estudios y Peliculas
        // si no daría error al interntar hacerlo.
        Transaction t = s.beginTransaction();
        s.delete(estudio);
        t.commit();

        /*
        //voy una por una eliminando las peliculas que tiene el estudio
        for (Peliculas p:estudio.getPeliculasByEstudioId()) {
            //antes de eliminar la pelicula, elimino las relaciones que tiene con artistas
            eliminaRelaciones(s, p);
            Transaction t = s.beginTransaction();
            s.delete(p);
            t.commit();
        }
        Transaction t = s.beginTransaction();
        s.delete(estudio);
        t.commit();
        */
        System.out.println("Eliminado estudio: "+estudio.getNombre());
    }

    private static void eliminaRelaciones(Session s, Peliculas p) {
        Transaction t = s.beginTransaction();
        for (PelArt pa:p.getPelArtsByPeliculaId()) {
            s.delete(pa);
        }
        t.commit();
    }

    private static boolean existeEstudio(Session s, Estudios e) {
        Query q = s.createQuery("from Estudios where estudioId = "+e.getEstudioId());
        List<Estudios> l = q.list();
        if (l.size() > 0)return true;
        return false;
    }

    private static void muestraPeliculasDeDirector(Session s, Artistas a) {
        if (!existeArtista(s, a)){
            System.err.println("No existe artista.");
            return;
        }
        Artistas director = s.load(Artistas.class, a.getArtistaId());
        System.out.println("Director: "+director.getNombre());
        Query q = s.createQuery("from Peliculas where directorId = "+director.getArtistaId());
        List<Peliculas> l = q.list();
        for (Peliculas p :l) {
            System.out.println("\t-"+p.getTitulo());
        }
    }

    private static boolean existeArtista(Session s, Artistas a) {
        Query q = s.createQuery("from Artistas where artistaId = "+a.getArtistaId());
        List<Artistas> l = q.list();
        if (l.size() > 0)return true;
        return false;
    }

}