package org.example.Modelos;

import java.util.Objects;

public class PelArt {
    /*
    private int peliculaId;
    private int artistaId;

     */
    private PelArtPK pk;
    private Peliculas peliculasByPeliculaId;
    private Artistas artistasByArtistaId;

    public PelArtPK getPk() {
        return pk;
    }

    public void setPk(PelArtPK pk) {
        this.pk = pk;
    }
/*
    public int getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(int peliculaId) {
        this.peliculaId = peliculaId;
    }

    public int getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(int artistaId) {
        this.artistaId = artistaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PelArt pelArt = (PelArt) o;
        return peliculaId == pelArt.peliculaId && artistaId == pelArt.artistaId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(peliculaId, artistaId);
    }
*/
    public Peliculas getPeliculasByPeliculaId() {
        return peliculasByPeliculaId;
    }

    public void setPeliculasByPeliculaId(Peliculas peliculasByPeliculaId) {
        this.peliculasByPeliculaId = peliculasByPeliculaId;
    }

    public Artistas getArtistasByArtistaId() {
        return artistasByArtistaId;
    }

    public void setArtistasByArtistaId(Artistas artistasByArtistaId) {
        this.artistasByArtistaId = artistasByArtistaId;
    }
}
