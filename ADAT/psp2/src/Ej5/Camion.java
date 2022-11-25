package Ej5;

import java.util.ArrayList;

public class Camion extends Thread{
    private String nombre;
    private Puente puente;
    private  Escabadora escabadora;
    private boolean cargado;

    public Camion(String nombre, Puente puente, Escabadora escabadora) {
        super();
        this.nombre = nombre;
        this.puente = puente;
        this.escabadora = escabadora;
    }
    public String getNombre(){
        return nombre;
    }
    public void run(){

        synchronized (puente){
            puente.crossLeft(this);
        }
        synchronized (escabadora){
            escabadora.Carga(this);
        }
        synchronized (puente){
            puente.crossRight(this);
        }



    }
}
