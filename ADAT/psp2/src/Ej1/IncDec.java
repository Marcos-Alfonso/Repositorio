/*
    Programa que intenta demostrar los problemas de la condición de carrera
    si no utilizamos mecanismos de sincronización.
 */
package Ej1;

/**
 * Ejemplo de aplicación que demuestra el problema de la condición de carrera
 * 
 * El programa no da resultados acorde a lo esperado y dependerá del orden en
 * el que se han ejecutado los hilos.
 * 
 * 
 */
public class IncDec {

    final int N_OPERACIONES = 10000;
    final  int VALOR_INICIAL = 100;
     int contador = VALOR_INICIAL;

    public static void main(String[] args) {
        new IncDec().runProgram();
    }

    public void runProgram() {
        System.out.println("\nValor incial: "+contador);
        Thread hiloInc = new Incrementa();
        Thread hiloDec = new Decrementa();
        hiloInc.start();
        hiloDec.start();
        try {
            hiloInc.join();
            hiloDec.join();
        } catch (InterruptedException ex) {
        }
        System.out.println("\nValor FINAL: "+contador);
    }


    class Incrementa extends Thread {
        public void run() {
            for (int n = 0; n < N_OPERACIONES; n++) {
                contador++;
            }
        }
    }
    class Decrementa extends Thread {
        public void run() {
            for (int n = 0; n < N_OPERACIONES; n++) {
                contador--;
            }
        }
    }

}
