package Ej5;

import java.util.ArrayList;

public class Cantera {
    ArrayList<Thread> ladoDerecho = new ArrayList<>();
    ArrayList<Thread> ladoIzquierdo = new ArrayList<>();
    boolean puenteOcupado = false;

    public void addRight(Thread t){
        ladoDerecho.add(t);
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
    public synchronized void  crossLeft(Thread t){
        try {
            ladoDerecho.remove(t);
            puenteOcupado = true;
            Thread.sleep(500);
            ladoIzquierdo.add(t);
            puenteOcupado= false;
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void  crossRight(Thread t){
        try {
            ladoIzquierdo.remove(t);
            puenteOcupado = true;
            Thread.sleep(500);
            ladoDerecho.add(t);
            puenteOcupado= false;
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void carga(Camion c){
        try {

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
