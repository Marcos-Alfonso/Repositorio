/*
 * Implementa la clase Almacen que se utilizará para almacenar los elementos
   generados por el Productor y que luego sacará el Consumidor.

   Se utilizarán dos semaforos para evitar que metamos en el almacen más 
   elementos de los permitidos o saquemos del almacen cuando está vacio.

   El semaforo semLLeno si inciazializará a 0, para indicar que hay 0 elementos
   cada vez que se meta un elemento se realizará una operación release(1), lo que 
   hara que se incremente en 1.

   El semaforo semHuecos si incializará al tamaño del almacen, y nos indicará
   el número de huecos que tenemos para meter cosas en el almacen
 */
package ej15_prod_cons_semaforo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author santiago
 */
public class Almacen {

    protected final Cola cola;
    /**
     * Semaforo que impedirá que se introduzcan elementos si el buffer está 
     * lleno
     */
    protected final Semaphore semItems;
    
    /** Semaforo que impedirá que se saquen elementos si el buffer está 
     * vacio
     */
    protected final Semaphore semHuecos;
    
    protected final Frame frame;
    
    /**
     * Constructor
     * @param bufferSize    Tamaño
     * @param frame         Ventana que muestra la evolución
     */
    public Almacen(int bufferSize, Frame frame) {
        this.frame=frame;
        cola=new Cola(bufferSize);
        
        // La primera vez no hay nada en el buffer
        semItems = new Semaphore(0, true);
        
        // La primera vez hay muchos huecos para meter
        semHuecos = new Semaphore(bufferSize, true);
    }
    
    /**
     * Introduce un elemento en el buffer si hay espacio para meterlo. Si no 
     * espera ha que haya un hueco
     * 
     * @param item
     * @throws InterruptedException 
     */
    public void guarda(int item) throws InterruptedException {
        // Esperamos que haya un hueco donde meter el elemento antes de guardar
        semHuecos.acquire(1);
        
        cola.add(item);
        frame.setNElemAlmacen(cola.size());
        if (isFull()) {
            System.out.println("\n ^^^ Buffer LLENO");
        }
        // Una vez introducido el elemento añadimos al semaforo para 
        // indicar que tenemos un elemento nuevo
        semItems.release(1);
    }

    /**
     * Saca un elemento del buffer si hay alguno. Si no espera a que un 
     * productor genere un nuevo elemento
     * 
     * @return
     * @throws InterruptedException 
     */
    public int saca() throws InterruptedException {
        int item;
        // Esperamos que haya un elemento para sacar
        semItems.acquire(1);
        item = (int) cola.remove();
        frame.setNElemAlmacen(cola.size());       
        if (isEmpty()) {
            System.out.println("\n \\/\\/ Buffer VACÍO");
        }
        // Hemos sacado un elemento, hemos dejado un hueco libre
        semHuecos.release(1);

        return item;
    }

    public boolean isEmpty() {
        return cola.isEmpty();
    }

    public boolean isFull() {
        return cola.isFull();
    }

    public int size() {
        return cola.size();
    }
}
