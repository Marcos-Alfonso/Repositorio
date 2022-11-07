/*
 
 */
package ej15_prod_cons_semaforo;

import ut2.ej12_prod_cons.*;
import java.util.Queue;

public class Consumidor extends Thread {

    private String id;
    private Almacen buffer;

    public Consumidor(String id, Almacen buffer) {
        super(id);
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                /**
                 * Lanzamos la operación wait() del semaforo para ver si el
                 * buffer tiene dados. Debemos sincronizar el acceso al buffer
                 * debido a que nada nos garantiza que no haya conflictos con
                 * otros hilos El semaforo solo nos garantiza que hay recursos
                 * que consumir
                 */
                Thread.sleep(Main.DEMORA_CONSUMIDOR);

                System.out.print(" --- " + id + "=>");
                int item = buffer.saca();
                System.out.print("\t[" + item + "]");
                System.out.println("\t-Tam:" + buffer.size());
            } catch (InterruptedException ex) {
                System.out.println("\n**** Excepcion CONSUMIDOR**** ");
                ex.printStackTrace();
                break;
            }
        }

    }
}
