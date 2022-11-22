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
public class Main {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1, 1});

        Cajera cajera1 = new Cajera("Cajera 1");
        Cajera cajera2 = new Cajera("Cajera 2");

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        cajera1.procesarCompra(cliente1, initialTime);
        cajera2.procesarCompra(cliente2, initialTime);
        
        System.out.println("\n======\nHe completado mi tarea\n========");
    }
}
