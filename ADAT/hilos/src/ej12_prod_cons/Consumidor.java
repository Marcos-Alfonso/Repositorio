/*
 
 */
package ej12_prod_cons;

import java.util.Queue;

class Consumidor extends Thread {

    private String id;
    private Queue queue;
    private int maxSize;

    /**
     * Flag que controla el bucle de repetición
     */
    private boolean finalizado = false;

    public Consumidor(String id, Queue queue, int maxSize) {
        super(id);
        this.id = id;
        this.queue = queue;
        this.maxSize = maxSize;
    }

    public void marcaFinalizado() {
        finalizado = true;
    }

    @Override
    public void run() {
        while (!finalizado) {
            /**
             * Observad como sincronizamos sobre el objeto cola, que es el que
             * deberá evitar accesos simultaneo desde los diferentes hilos Todos
             * los objetos java pueden ser sincronizados, cuando ponemos las
             * palabra synchronizez en un método estamos realizando
             * synchronized(this).
             */
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("Cola VACIA." + "El hilo consumidor [" + id + "] esta esperando que el hilo productor que ponga algo en la cola");
                    try {
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("-- Consumiendo : " + queue.remove());
                queue.notifyAll();
            }
        }
    }
}
