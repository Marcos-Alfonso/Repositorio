package ej15_prod_cons_semaforo;

/**
 * Implementación de una clase básica Cola. 
 * No sería preciso realizarla
   se implementa para tratar de buscar problemas en trabajos concurrentes

   Para realizar la cola se crea un array en el que se añade al final,  y 
   se elimina del principio. Cuando sacamos el primer elemento se desplazan
   todos los otros elementos al principio.
   
   Existen muchos metodos más eficientes para realizar esta tarea, se ha utilizado
   * este por su simplicidad y además es el que produce más problemas de
   * concurrencia que es lo que nos interesa.
 * @author santiago
 */
public class Cola {
    private int items[];
    private int idxUltimo;
    
    public Cola(int size) {
        items=new int[size];
        idxUltimo=0;
    }
    
    public void add(int item) {
        items[idxUltimo]=item;
        idxUltimo++;
    }
    
    public int remove() {
        int item=items[0];
        borraPrimero();
        idxUltimo--;
        return item;
    }
    
    /**
     * Desplaza los elementos una posición a la izquierda
     */
    private void borraPrimero() {
        for(int i=0; i<idxUltimo-1; i++) {
            // Desplazamos hacia el comienzo
            items[i]=items[i+1];
        }
    }
    
    public int size() {
        return idxUltimo;
    }
    
    public int maxSize() {
        return items.length;
    }
    
    public boolean isEmpty() {
        return idxUltimo==0;
    }
    
    public boolean isFull() {
        return idxUltimo==items.length;
    }
}
