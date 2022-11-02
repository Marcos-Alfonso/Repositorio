package ej11;/*
    ej11.Consumidor - Consume información que está guardada en ej11.Almacen
*/
import java.util.Random;
 
public class Consumidor implements Runnable {
    private Almacen almacen;
 
    public Consumidor(Almacen almacen) {
        this.almacen = almacen;
    }
 
    public void run() {
        Random random = new Random();
        for (String message = almacen.toma();
             ! message.equals("HECHO");
             message = almacen.toma()) {
            System.out.format("Recibido mensaje: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}        