/*
Ejemplo productor-consumidor con la posibilidad de almacenar
más de un elemento. 
Tendremos una cola de n-elementos en la que el productor
introducirá datos, y el consumidor los sacará. Habrá que controlar que
el productor no introduzca cuando la cola está llena, y que el consumidor no
saque cuando la cola está vacia.



 */
package ej16_prod_cons_semaforo_mutex;

import ut2.ej15_prod_cons_semaforo.*;

/**
 * Problema del productor-consumidor con un buffer intermedio de N elementos
 * El productor/es podrá meter en el buffer N elementos. Cuando se llene los
 * productores esperarán para meter nuevos elementos.
 * 
 * El consumidor podrá sacar elementos del buffer si hay alguno. Si está vacio
 * esperará por ellos.
 * 
 * Propueta implementada con Semaforos. Java implementa una clase semaforo
 * 
 * Utilizaremos un semaforo para sincronizar los procesos
 * https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Semaphore.html * 
 * 
 * Esta propuesta tal como está es imcompleta y no funciona como se verá al
 * ejecutarlo.
 * 
 * Clases utilizadas:
 *    - Secuenciador: clase que implementa un contador. En el almacen 
 *      introduciremos una secuencia de enterios, así veremos si hay 
 *      inconsistencias
 *    - Cola: implementa una cola con un array que será utilizada por la clase 
 *            Almacen. Se hace de esta forma para forzar excepciones si se
 *            introducen más elementos de los permitidos
 *    - Almacen: Lugar en el que se meterán o sacarán los items
 *    - Productor: Hilo que genera elementos y los guarda en el almacen si es 
 *          posible, si no espera a que haya hueco
 *    - Consumidor: Hilo que saca elementos del almacen si hay alguno, si no 
 *          espera que haya elementos.
 * 
 * @author santiago
 */

public class Main  extends ut2.ej15_prod_cons_semaforo.Main {

    public static void main(String args[]) throws InterruptedException {
        new Main().runProgram();
    }
}
