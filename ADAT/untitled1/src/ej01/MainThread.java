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
public class MainThread {

    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Cliente 1", new int[]{2, 2, 1, 5, 2, 3});
        Cliente cliente2 = new Cliente("Cliente 2", new int[]{1, 3, 5, 1, 1});

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();
        CajeraThread cajera1 = new CajeraThread("Cajera 1", cliente1, initialTime);
        CajeraThread cajera2 = new CajeraThread("Cajera 2", cliente2, initialTime);

        cajera1.start();
        cajera2.start();
        
        System.out.println("\n======\nHILO PRINCIPAL ha completado su tarea\n========");
    }
}
