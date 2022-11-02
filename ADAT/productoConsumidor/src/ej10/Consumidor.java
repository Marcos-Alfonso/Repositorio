
package ej10;

/*
    Consumidor - Consume información que está guardada en Almacen
*/
import java.util.Random;
 
public class Consumidor implements Runnable {
    private Almacen almacen;
    String id;
 
    public Consumidor(Almacen almacen, String id) {
        this.almacen = almacen;
        this.id=id;
    }
 
    /**
     * Hilo del consumidor
     */
    public void run() {
        Random random = new Random();
        for (String message = almacen.toma(id);
             ! message.equals("HECHO");
             message = almacen.toma(id)) {
            System.out.format("Recibido mensaje: %s%n", message);
            /*
            // Esperamos aleatoriamente un tiempo
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {}
            */
        }
    }
}        