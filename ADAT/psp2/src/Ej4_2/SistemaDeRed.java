package Ej4_2;

import java.util.ArrayList;
import java.util.Random;

public class SistemaDeRed {
    private String clave;

    //el numero total de intentos posibles es 26^4 = 456.976, por lo que no hay necesidad de utilizar long, con int nos sirve
    public int nIntentos = 0;
    public boolean claveAcertada;

    private ArrayList<Letra> listaPeticiones = new ArrayList<>();
    public SistemaDeRed(){
        Random rnd = new Random();
        String password = "";

        for (int i = 0; i < 4; i++) {
            char c = (char) ('a' + rnd.nextInt(26));
            password += c;
        }
        clave = password;
    }

    public synchronized boolean checkClave(String s){
        nIntentos++;
        if(s.equals(clave)){
            System.out.println(nIntentos+" - H-"+s.charAt(0)+", prueba "+s+" - Acierto");
            claveAcertada = true;
            return true;
        }else if(!claveAcertada){
            System.out.println(nIntentos+" - H-"+s.charAt(0)+", prueba "+s+" - Fallo");
        }
        return false;
    }
}
