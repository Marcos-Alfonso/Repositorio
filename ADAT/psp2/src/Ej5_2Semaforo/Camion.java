package Ej5_2Semaforo;

import java.util.concurrent.Semaphore;

public class Camion extends Thread{
    private static final int N_CAMIONES_MAX = 2;
    private String nombre;
    private Puente puente;
    private Escabadora escabadora;
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
    private static Semaphore semaforo = new Semaphore(N_CAMIONES_MAX);

    public void run(){
        System.out.println("C_"+nombre+" (1) - Esperando derecha para cruzar puente");
        try {
            semaforo.acquire();
            synchronized (puente){
                puente.crossLeft(this);
            }
            System.out.println("C_"+nombre+" (4) – Esperando izquierda para cargar");
            synchronized (escabadora){
                escabadora.Carga(this);
            }
            System.out.println("C_"+nombre+" (7) – Esperando izquierda para cruzar puente");
            synchronized (puente){
                puente.crossRight(this);
            }
            semaforo.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
