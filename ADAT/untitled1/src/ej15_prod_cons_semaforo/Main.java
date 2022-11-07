/*
Ejemplo productor-consumidor con la posibilidad de almacenar
más de un elemento. 
Tendremos una cola de n-elementos en la que el productor
introducirá datos, y el consumidor los sacará. Habrá que controlar que
el productor no introduzca cuando la cola está llena, y que el consumidor no
saque cuando la cola está vacia.



 */
package ej15_prod_cons_semaforo;

/**
 * Problema del productor-consumidor con un buffer intermedio de N elementos
 * El productor/es podrá meter en el buffer N elementos. Cuando se llene los
 * productores esperarán para meter nuevos elementos.
 * 
 * El consumidor podrá sacar elementos del buffer si hay alguno. Si está vacio
 * esperará por ellos.
 * 
 * Propueta implementada con Semaforos. Java implementa una clase semaforo
 * 
 * Utilizaremos un semaforo para sincronizar los procesos
 * https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Semaphore.html * 
 * 
 * Esta propuesta tal como está es imcompleta y no funciona como se verá al
 * ejecutarlo.
 * 
 * Clases utilizadas:
 *    - Secuenciador: clase que implementa un contador. En el almacen 
 *      introduciremos una secuencia de enterios, así veremos si hay 
 *      inconsistencias
 *    - Cola: implementa una cola con un array que será utilizada por la clase 
 *            Almacen. Se hace de esta forma para forzar excepciones si se
 *            introducen más elementos de los permitidos
 *    - Almacen: Lugar en el que se meterán o sacarán los items
 *    - Productor: Hilo que genera elementos y los guarda en el almacen si es 
 *          posible, si no espera a que haya hueco
 *    - Consumidor: Hilo que saca elementos del almacen si hay alguno, si no 
 *          espera que haya elementos.
 * 
 * @author santiago
 */

public class Main {

    static final int DEMORA_PRODUCTOR=10;
    static final int DEMORA_CONSUMIDOR=10;
    static final int BUFFER_SIZE = 10;
    Frame frame;

    public static void main(String args[]) throws InterruptedException {
        new Main().runProgram();
    }
    
    /**
     * Ejecutaremos así el programa para aprovechar la herencia en el paquete
     * siguiente y  no tener que modificar más que los cambios
     * 
     * @throws InterruptedException 
     */
    public void runProgram()  throws InterruptedException {
        System.out.println("Resolviendo el problema del Productor-Consumidor con semaforos");

        lanzaVentana();
        Almacen buffer = new Almacen(BUFFER_SIZE, frame);

        Productor producer = new Productor("P-1", buffer);
        Consumidor consumer = new Consumidor("C-1", buffer);


        consumer.start();
        producer.start();
        
        // Prueba a cambiar las prioridades de los hilos, para ver si
        // afecta
        // ¿Afecta?
        //producer.setPriority(Thread.MIN_PRIORITY);
        //consumer.setPriority(Thread.MAX_PRIORITY);

        
        // Dejamos que se llene el almacen
        //Thread.sleep(DEMORA_PRODUCTOR*BUFFER_SIZE);
        
        /*
        // ejecutamos los hilos X segundos y finalizamos
        Thread.sleep(3000);

        producer.interrupt();
        
        Thread.sleep(1000);
        consumer.interrupt();
        */

        System.out.println("\n\nFINALIZADO main(..)");
    }

    /**
     * Abre una ventana en la que se mostrará el estado del buffer
     */
    public void lanzaVentana() {
        frame = new Frame();
        frame.setVisible(true);
        frame.setMaxSize(BUFFER_SIZE);
    }

}
