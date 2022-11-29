package Ej5_1Semaforo;

import java.util.concurrent.Semaphore;

public class Camion extends Thread{
    private String nombre;
    private Puente puente;
    private Escabadora escabadora;

    private static Semaphore semaforo = new Semaphore(1);

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
        try {
            System.out.println("C_"+nombre+" (1) - Esperando derecha para cruzar puente");
            semaforo.acquire();

            puente.crossLeft(this);

            System.out.println("C_"+nombre+" (4) – Esperando izquierda para cargar");
            escabadora.Carga(this);

            System.out.println("C_"+nombre+" (7) – Esperando izquierda para cruzar puente");
            puente.crossRight(this);

            semaforo.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
