package ej10;

import java.util.Random;

public class Productor implements Runnable {

    private Almacen almacen;
    String id;

    String[] palabras = {
        "1. uno",
        "2. dos",
        "3. tres",
        "4. cuatro"
    };
    int idx=0;

    public Productor(Almacen almacen, String id) {
        this.almacen = almacen;
        this.id=id;
    }

    /**
     * Hilo del productor
     */
    public void run() {
        Random random = new Random();

        for(;idx<palabras.length; idx++ ) {
            almacen.pon(palabras[idx], id);
            /*
            try {
                // Esperamos aleatoriamente hasta 5 segs
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {  }
            */
        }
        // Notificamos finalización
        almacen.pon("HECHO", id);
    }
}
