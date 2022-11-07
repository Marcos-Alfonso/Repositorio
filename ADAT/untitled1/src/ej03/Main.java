package ej03;

/*
    Véase: https://jarroba.com/multitarea-e-hilos-en-java-con-ejemplos-thread-runnable/
    Ejemplo de aplicación que demuestra la utilidad de los hilos

    Modificación de la propuesta inicial de cajera y clientes añadiendo la 
    restricción que después de completar el proceso de compra hay que pagar
    con TPV. El problema es que solo tenemos uno que se iran pasando las cajeras

    Tendremos tres operaciones
        - coger
        - pagar (tardará 3 seg)
        - soltar

    Si una cajera tiene el TPV las otras no podrán utilizarlo


    Esta implementación dará problemas dependiendo del número de elementos
    que lleve en cada carro el cliente.
   
    Prueba las combinaciones, y observa el resultado
                Nº Items
    Cliente 1       4   4   4
    Cliente 2       6   5   4

    Observa que el programa no es determinista. No podemos garantizar si
    acabará y como acabará

    Cuando trabajamos en multitarea a veces necesitamos garantizar el acceso
    exclusivo a determinados elementos mientras estamos operando.
    Este ejemplo es muy burdo, y no contempla todas las posibles combinaciones
    que se pueden dar, pero sirve como referencia.

    Esto se solucionará muy facil con un semaforo
 */
/**
 *
 * @author Richard
 */
public class Main {

    public static void main(String[] args) {

        TPV tpv=new TPV();
        
        Cliente cliente1 = new Cliente("Cliente 1", Cliente.dameCarro(4));
        Cliente cliente2 = new Cliente("Cliente 2", Cliente.dameCarro(6));

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
