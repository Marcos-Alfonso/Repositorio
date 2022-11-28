package Ej1;

import java.util.concurrent.Semaphore;

public class carreraSemaforo {


        final int N_OPERACIONES = 10000;
        final  int VALOR_INICIAL = 100;
        int contador = VALOR_INICIAL;
        Semaphore s = new Semaphore(1);

        public static void main(String[] args) {
        new carreraSync().runProgram();
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
                    try {
                        s.acquire();
                        contador++;
                        s.release();
                    } catch (InterruptedException e) {}
                }
            }
        }

        class Decrementa extends Thread {
            public void run() {
                for (int n = 0; n < N_OPERACIONES; n++) {
                    try {
                        s.acquire();
                        contador--;
                        s.release();
                    } catch (InterruptedException e) {}
                }
            }
        }

    }

