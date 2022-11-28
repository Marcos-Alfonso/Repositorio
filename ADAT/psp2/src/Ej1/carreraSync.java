
package Ej1;
public class carreraSync {

    final int N_OPERACIONES = 10000;
    
    final  int  VALOR_INICIAL = 100;
    Contador contador = new Contador();

    public static void main(String[] args) {
        new carreraSync().runProgram();
    }

    public void runProgram() {
        System.out.println("\nValor incial: "+contador.count);
        Thread hiloInc = new Incrementa();
        Thread hiloDec = new Decrementa();

        hiloInc.start();
        hiloDec.start();
        try {
            hiloInc.join();
            hiloDec.join();
        } catch (InterruptedException ex) {
        }
        System.out.println("\nValor FINAL: "+contador.count);
    }

    class Incrementa extends Thread {

        public void run() {
            for (int n = 0; n < N_OPERACIONES; n++) {
                synchronized (contador){
                contador.count++;
                }
            }
        }
    }

    class Decrementa extends Thread {

        public void run() {
            for (int n = 0; n < N_OPERACIONES; n++) {
                synchronized (contador){
                    contador.count--;
                }
            }
        }
    }
    class Contador {
        public int count = VALOR_INICIAL;
    }


}
