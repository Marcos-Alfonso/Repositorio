package ej12_prod_cons;

import ut2.ej15_prod_cons_semaforo.*;

/**
 * Clase que genera una secuencia de números
 * 
 * @author santiago
 */
public class Secuenciador {
    
    int cont=0;
    
    public Secuenciador() { }
    
    public Secuenciador(int inicio) {
        cont=inicio;
    }
    
    synchronized public int siguiente() {
        return cont++;
    }
}
