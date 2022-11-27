package Ej5_1;

import java.util.ArrayList;

public class Puente {
    ArrayList<Thread> ladoDerecho = new ArrayList<>();
    ArrayList<Thread> ladoIzquierdo = new ArrayList<>();
    boolean puenteOcupado = false;

    public void addRight(Camion c){
        ladoDerecho.add(c);
    }

    public synchronized void  crossLeft(Camion c){
        try {
            puenteOcupado = true;
            ladoDerecho.remove(c);
            System.out.println("C_"+c.getNombre()+" (2) - PUENTE - Comienzo cruzar");

            Thread.sleep(500);
            ladoIzquierdo.add(c);
            puenteOcupado= false;
            System.out.println("C_"+c.getNombre()+" (3) - PUENTE - Fin cruzar");
            //notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void  crossRight(Camion c){
        try {
            puenteOcupado = true;
            ladoIzquierdo.remove(c);
            System.out.println("C_"+c.getNombre()+" (8) - PUENTE - Comienzo cruzar");
            Thread.sleep(500);
            ladoDerecho.add(c);
            puenteOcupado= false;

            System.out.println("C_"+c.getNombre()+" (9) - PUENTE - Fin cruzar");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public int cuantosLadoIzq(){
        return ladoIzquierdo.size();
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
