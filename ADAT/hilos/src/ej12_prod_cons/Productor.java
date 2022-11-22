/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej12_prod_cons;

import java.util.Queue;
import java.util.Random;

class Productor extends Thread {

    private String id;
    private Queue queue;
    private int maxSize;
    private Secuenciador secuenciador = new Secuenciador();

    /**
     * Flag que controla el bucle de repetición
     */
    private boolean finalizado = false;

    public Productor(String id, Queue queue, int maxSize) {
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
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Cola LLENA, el hilo productor [" + id + "] esta esperando que el consumidor tome algo de la cola");
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                Random random = new Random();
                int item = secuenciador.siguiente();
                System.out.println("+++ " + id + "=> \t[" + item + "]");
                queue.add(item);
                queue.notifyAll();
            }
        }
    }
}
