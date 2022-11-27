package Ej4_2;

import java.util.concurrent.Semaphore;

public class Letra extends Thread{
    private char caracterInicial;
    private SistemaDeRed sistema;
    private Semaphore semaphore;
    public Letra(char a, SistemaDeRed s, Semaphore se){
        caracterInicial = a;
        sistema = s;
        semaphore = se;
    }

    public void run(){
        try {
            semaphore.acquire();

            if(!sistema.claveAcertada){
                //System.out.println("Inicia "+caracterInicial);
                iniciaServicio();
                //System.out.println("Finaliza "+caracterInicial);
            }

            semaphore.release();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void iniciaServicio() {
        for (int i = 0; i < 26; i++) {
            char c1 = (char)('a'+i);
            for (int j = 0; j < 26; j++) {
                char c2 = (char)('a'+j);
                for (int k = 0; k < 26; k++){

                    if (sistema.claveAcertada){
                        return;
                    }

                    char c3 = (char)('a'+k);
                    String prueba = ""+caracterInicial+c1+c2+c3;

                    if(sistema.checkClave(prueba)){
                        sistema.claveAcertada = true;
                        System.out.println(sistema.nIntentos+" - H-"+caracterInicial+", prueba "+prueba+" - Acierto");
                        return;
                    }else{
                        System.out.println(sistema.nIntentos+" - H-"+caracterInicial+", prueba "+prueba+" - Fallo");
                    }

                }
            }
        }

    }

}
