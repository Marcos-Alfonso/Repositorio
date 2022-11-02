package ej11;

import java.util.Random;
 
public class Productor implements Runnable {
    private Almacen almacen;
 
    public Productor(Almacen almacen) {
        this.almacen = almacen;
    }
 
    public void run() {
        String info[] = {
            "1. Era un día lluvioso",
            "2. de octubre",
            "3. del año 2018",
            "4. probando procesos"
        };
        Random random = new Random();
 
        for (int i = 0;
             i < info.length;
             i++) {
            almacen.pon(info[i]);
            /*
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
            */
        }
        almacen.pon("HECHO");
    }
}               