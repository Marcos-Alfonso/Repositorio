package ej11;/*
    
 */


public class Almacen {

    // Mesnaje que envía productor a consumidor
    protected String message;
    
    /* True si el consumidor debe esparar a que el productor introduzca el 
       elemento (envíe mensaje),
       False si el productor debe esperar a que el consumidor saque el elemento
       (envie mensaje) */
    protected boolean vacio = true;

    public synchronized String toma() {
        // Wait until message is available.
        while (vacio) {
            try {
                System.out.println("toma() vacio="+vacio);
                System.out.println("\t\ttoma() vacio=" + vacio + " " + System.currentTimeMillis());
                wait();
            } catch (InterruptedException e) {
 
            }
        }
        // Toggle status.
        vacio = true;
        // Notify producer that status has changed.
        notifyAll();
        return message;
    }

    public synchronized void pon(String message) {
        // Wait until message has been retrieved.
        while (!vacio) {
            try {
                System.out.println("\t\tpon() vacio=" + vacio + " " + System.currentTimeMillis());
                wait();
            } catch (InterruptedException e) {
            }
        }
        // Toggle status.
        vacio = false;
        // Store message.
        this.message = message;
        // Notify consumer that status has changed.
        notifyAll();
    }
}
