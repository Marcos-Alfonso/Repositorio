package org.example.Modelos;

import java.util.Collection;
import java.util.Objects;

public class Peliculas {
    private int peliculaId;
    private String titulo;
    private int peliAnno;
    private int estudioId;
    private int directorId;
    private Collection<PelArt> pelArtsByPeliculaId;
    private Estudios estudiosByEstudioId;
    private Artistas artistasByDirectorId;

    public int getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(int peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPeliAnno() {
        return peliAnno;
    }

    public void setPeliAnno(int peliAnno) {
        this.peliAnno = peliAnno;
    }

    public int getEstudioId() {
        return estudioId;
    }

    public void setEstudioId(int estudioId) {
        this.estudioId = estudioId;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peliculas peliculas = (Peliculas) o;
        return peliculaId == peliculas.peliculaId && peliAnno == peliculas.peliAnno && estudioId == peliculas.estudioId && directorId == peliculas.directorId && Objects.equals(titulo, peliculas.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peliculaId, titulo, peliAnno, estudioId, directorId);
    }

    public Collection<PelArt> getPelArtsByPeliculaId() {
        return pelArtsByPeliculaId;
    }

    public void setPelArtsByPeliculaId(Collection<PelArt> pelArtsByPeliculaId) {
        this.pelArtsByPeliculaId = pelArtsByPeliculaId;
    }

    public Estudios getEstudiosByEstudioId() {
        return estudiosByEstudioId;
    }

    public void setEstudiosByEstudioId(Estudios estudiosByEstudioId) {
        this.estudiosByEstudioId = estudiosByEstudioId;
    }

    public Artistas getArtistasByDirectorId() {
        return artistasByDirectorId;
    }

    public void setArtistasByDirectorId(Artistas artistasByDirectorId) {
        this.artistasByDirectorId = artistasByDirectorId;
    }
}
