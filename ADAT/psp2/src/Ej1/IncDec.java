
package Ej1;
public class IncDec {

    final int N_OPERACIONES = 1000;
    
    final int VALOR_INICIAL = 99;

    /**
     * Variable compartida por los hilos sin control de exclusión
     */
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

    // HILO QUE INCREMENTA
    class Incrementa extends Thread {

        public synchronized void run() {
            for (int n = 0; n < N_OPERACIONES; n++) {
                contador++;
            }
        }
    }

    // HILO QUE DECREMENTA
    class Decrementa extends Thread {

        public synchronized void run() {
            for (int n = 0; n < N_OPERACIONES; n++) {
                contador--;

            }
        }
    }
    private void printCount(){
        String s = "";
        for (int i = 0; i < contador; i++) {
            s+=" ";
        }
        System.out.println(s+"o");
    }


}
