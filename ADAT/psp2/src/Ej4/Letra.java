package Ej4;

public class Letra extends Thread{
    private char caracterInicial;
    private SistemaDeRed sistema;
    public Letra(char a, SistemaDeRed s){
        caracterInicial = a;
        sistema = s;
    }

    public void run(){
        while(sistema.getPeticionesActuales()>= sistema.N_PETICIONES_MAX){
            synchronized (sistema){
                try {
                    sistema.wait();
                    if(sistema.claveAcertada){
                        this.stop();
                    }

                    System.out.println("deja esperar "+caracterInicial);
                } catch (InterruptedException e) {
                }
            }
        }

        sistema.iniciaPeticion(this);
        for (int i = 0; i < 26; i++) {
            char c1 = (char)('a'+i);
            for (int j = 0; j < 26; j++) {
                char c2 = (char)('a'+j);
                for (int k = 0; k < 26; k++) {
                    char c3 = (char)('a'+k);
                    String prueba = ""+caracterInicial+c1+c2+c3;
                    if(sistema.claveAcertada){
                        synchronized (sistema){
                            sistema.notifyAll();
                        }
                        this.stop();
                    }
                    if(sistema.checkClave(prueba)){
                        sistema.claveAcertada = true;
                        System.out.println("N.º"+sistema.nIntentos+" - H-"+caracterInicial+", prueba "+prueba+" - Acierto");
                    }else{
                        //System.out.println("N.º - H-"+caracterInicial+", prueba "+prueba+" - Fallo");
                    }

                }
            }
        }
        System.out.println("Finaliza "+caracterInicial);
        sistema.finalizaPeticion(this);
        synchronized (sistema){
            sistema.notify();
        }

    }
}
