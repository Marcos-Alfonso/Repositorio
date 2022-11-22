/*
    Véase: https://jarroba.com/multitarea-e-hilos-en-java-con-ejemplos-thread-runnable/
    Ejemplo de aplicación que demuestra la utilidad de los hilos

    Modificación del ejercicio de las cajeras para que finalice la Caja2 despues
    se 1 segundos debido a un problema técnico
 */
package ej02;

/**
 *
 * @author Richard
 */
public class Main implements Runnable {

    private Cliente cliente;
    private Cajera cajera;
    private long initialTime;

    public Main(Cliente cliente, Cajera cajera, long initialTime) {
        this.cajera = cajera;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1, 1});

        Cajera cajera1 = new Cajera("Cajera 1");
        Cajera cajera2 = new Cajera("Cajera 2");

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        Runnable proceso1 = new Main(cliente1, cajera1, initialTime);
        Runnable proceso2 = new Main(cliente2, cajera2, initialTime);

        Thread caja1 = new Thread(proceso1);
        Thread caja2 = new Thread(proceso2);
        caja1.start();
        caja2.start();

        try {
            // Esperamos 3 segundos
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        // Se estropea la caja 2
        caja2.interrupt();

        try {
            caja1.join();
            caja2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("\n======\nHILO PRINCIPAL ha completado su tarea\n========");
    }

    @Override
    public void run() {
        this.cajera.procesarCompra(this.cliente, this.initialTime);
    }

}
