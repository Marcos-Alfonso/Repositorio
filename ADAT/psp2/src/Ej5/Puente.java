package Ej5;

import java.util.ArrayList;

public class Puente {
    ArrayList<Thread> ladoDerecho = new ArrayList<>();
    ArrayList<Thread> ladoIzquierdo = new ArrayList<>();
    boolean puenteOcupado = false;

    public void addRight(Camion c){
        ladoDerecho.add(c);
    }
    /*
    public void addLeft(Thread t){
        ladoIzquierdo.add(t);
    }
    public void removeRight(Thread t){
        ladoDerecho.remove(t);
    }
    public void removeLeft(Thread t){
        ladoIzquierdo.remove(t);
    }
    */
    public synchronized void  crossLeft(Camion c){
        try {
            System.out.println("C_"+c.getNombre()+" - Pasando puente <--");
            ladoDerecho.remove(c);
            puenteOcupado = true;
            Thread.sleep(500);
            ladoIzquierdo.add(c);
            puenteOcupado= false;
            System.out.println("C_"+c.getNombre()+" - Puente Cruzado <--");
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void  crossRight(Camion c){
        try {
            System.out.println("C_"+c.getNombre()+" - Pasando puente -->");
            ladoIzquierdo.remove(c);
            puenteOcupado = true;
            Thread.sleep(500);
            ladoDerecho.add(c);
            puenteOcupado= false;
            System.out.println("C_"+c.getNombre()+" - Puente Cruzado -->");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    public synchronized void carga(Camion c){
        try {

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
     */


}
