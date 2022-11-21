package Ej5;

import Ej1.IncDec;

import java.util.ArrayList;

public class aguasClaras {
    public static void main(String[] args) {
        new aguasClaras().runProgram();
    }
    ArrayList<Thread> ladoDerecho = new ArrayList<>();
    ArrayList<Thread> ladoIzquierdo = new ArrayList<>();
    boolean puenteOcupado = false;
    public void runProgram() {
        for (int i = 0; i < 5; i++) {
            Thread camion = new Camion("Camion"+(i+1));
            ladoDerecho.add(camion);
        }
        for (Thread t:ladoDerecho) {
            t.start();
        }
    }
    class Camion extends Thread {
        private String nombre;

        public Camion(String nombre) {
            super();
            this.nombre = nombre;
        }

        public synchronized void run() {
                try {
                    while(puenteOcupado){

                        System.out.print("");
                    }
                    puenteOcupado = true;
                    System.out.println("C_"+nombre+" - Pasando puente");
                    sleep(500);
                    System.out.println("C_"+nombre+" - Puente Cruzado");
                    puenteOcupado = false;
                    notifyAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Hilo Interrumpido");
                }
        }

    }
}
