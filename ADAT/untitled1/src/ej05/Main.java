package ej05;


/*
    Modificación respecto a ej4. Solo se modifica clase TPV
    
    Véase: https://jarroba.com/multitarea-e-hilos-en-java-con-ejemplos-thread-runnable/
    Ejemplo de aplicación que demuestra la utilidad de los hilos

    Modificación de la propuesta inicial de cajera y clientes añadiendo la 
    restricción que después de completar el proceso de compra hay que pagar
    con TPV. El problema es que solo tenemos uno que se iran pasando las cajeras

    Tendremos tres operaciones
        - coger
        - pagar (tardará 3 seg)
        - soltar
    Estas operaciones se realizarán en un solo método usa();

    Si una cajera tiene el TPV las otras no podrán utilizarlo

    Solucionamos el problema del ejercio anterior utilizando la palabra 
    reservada synchronized

 */
/**
 *
 * @author Richard
 */
public class Main {

    public static void main(String[] args) {

        TPV tpv=new TPV();
        
        Cliente cliente1 = new Cliente("Cliente 1", Cliente.dameCarro(3));
        Cliente cliente2 = new Cliente("Cliente 2", Cliente.dameCarro(3));

        Cajera cajera1 = new Cajera("Cajera 1", tpv);
        Cajera cajera2 = new Cajera("Cajera 2", tpv);

        // Tiempo inicial de referencia
        long initialTime = System.currentTimeMillis();

        Runnable proceso1 = new ProcesoCajera(cliente1, cajera1, initialTime);
        Runnable proceso2 = new ProcesoCajera(cliente2, cajera2, initialTime);

        Thread hilo1, hilo2;
        hilo1 = new Thread(proceso1);
        hilo2 = new Thread(proceso2);
        hilo1.start();
        hilo2.start();

        //
        // El padre espera que los hilos terminen
        // Observad que en los ejemplos anteriores el hilo creador finalizaba antes
        //
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException ex) {
            System.out.println("\n********");
            System.out.println("\n* Algo ha pasado con mis hilos *");
            System.out.println("\n********");
            ex.printStackTrace();
        }

        System.out.println("\n======\nHe completado mi tarea\n========");
    }
}
