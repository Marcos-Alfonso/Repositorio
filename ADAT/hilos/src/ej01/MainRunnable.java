/*
    Véase: https://jarroba.com/multitarea-e-hilos-en-java-con-ejemplos-thread-runnable/
    Ejemplo de aplicación que demuestra la utilidad de los hilos

    Main.java           - Enfoque secuencial
    MainThead.java      - Enfoque con hilos heredando de Thread
    MainRunnable.java   - Enfoque con hilos implementando la interfaz Runnable
 */
package ej01;

/**
 *
 * @author Richard
 */
public class MainRunnable implements Runnable {

    private Cliente cliente;
    private Cajera cajera;
    private long initialTime;

    public MainRunnable(Cliente cliente, Cajera cajera, long initialTime) {
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

        Runnable proceso1 = new MainRunnable(cliente1, cajera1, initialTime);
        Runnable proceso2 = new MainRunnable(cliente2, cajera2, initialTime);

        new Thread(proceso1).start();
        new Thread(proceso2).start();

        System.out.println("\n======\nHILO PRINCIPAL ha completado su tarea\n========");
    }

    @Override
    public void run() {
        this.cajera.procesarCompra(this.cliente, this.initialTime);
    }

}
