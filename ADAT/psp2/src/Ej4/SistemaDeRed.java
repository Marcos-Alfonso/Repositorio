package Ej4;

import java.util.ArrayList;
import java.util.Random;

public class SistemaDeRed {
    private String clave;

    //el numero total de intentos posibles es 26^4 = 456.976, por lo que no hay necesidad de utilizar long, con int nos sirve
    public int nIntentos = 0;
    public boolean claveAcertada;
    public final int N_PETICIONES_MAX = 4;
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
        return s.equals(clave);
    }

    public void iniciaPeticion(Letra l){
        listaPeticiones.add(l);
    }
    public void finalizaPeticion(Letra l){
        listaPeticiones.remove(l);
    }
    public int getPeticionesActuales(){
        return listaPeticiones.size();
    }

}
