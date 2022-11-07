/*
 * Implementa la clase Almacen que se utilizará para almacenar los elementos
   generados por el Productor y que luego sacará el Consumidor.

   Utilizaremos la herencia para aprovechar el código del ejemplo anterior, 
   solo mostraremos lo que cambia

   Para que funcione correctamente el programa anterior tenemos que garantizar
   que los métodos guarda() y saca() sean atómicos y no hay modificaciones por
   parte de otro Thread mientras están realizando operaciones.

   Esto lo conseguiremos utilizando un monitor, marcandolos como synchronized
 */
package ej16_prod_cons_semaforo_synchronized;

import ut2.ej15_prod_cons_semaforo.*;

/**
 *
 * @author santiago
 */
public class Almacen extends ut2.ej15_prod_cons_semaforo.Almacen {
   
    
    /**
     * Constructor
     * @param bufferSize    Tamaño
     * @param frame         Ventana que muestra la evolución
     */
    public Almacen(int bufferSize, Frame frame) {
        super(bufferSize, frame);
    }
    
    /**
     * Introduce un elemento en el buffer si hay espacio para meterlo. Si no 
     * espera ha que haya un hueco
     * 
     * @param item
     * @throws InterruptedException 
     */
    @Override
    synchronized public void guarda(int item) throws InterruptedException {
        
        // Esperamos que haya un hueco donde meter el elemento antes de guardar
        semHuecos.acquire(1);
        cola.add(item);
        frame.setNElemAlmacen(cola.size());
        if (isFull()) {
            System.out.println("\n ^^^ Buffer LLENO");
        }
        // Una vez introducido el elemento soltamos el semaforo Lleno para 
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
    @Override
    synchronized public int saca() throws InterruptedException {
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
}
