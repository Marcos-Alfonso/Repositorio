/*
Ejemplo productor-consumidor con la posibilidad de almacenar
más de un elemento. Tendremos una cola de n-elementos en la que el productor
introducirá datos, y el consumidor los sacará. Habrá que controlar que
el productor no introduzca cuando la cola está llena, y que el consumidor no
saque cuando la cola está vacia.

http://comojava.blogspot.com/2015/07/como-usar-wait-notify-y-notifyall.html


Cómo usar wait, notify y notifyAll - Ejemplo de Productor Consumidor
Puede usar los métodos wait, notify y notifyAll para la comunicación entre hilos en Java. Por ejemplo, si tiene dos hilos que se ejecutan en su programa Productor y Consumidor, teniendo un hilo para el Productor este se puede comunicar con los consumidores para que puede comenzar a consumir una vez que haya elementos para ser consumidos en la cola. Del mismo modo un hilo consumidor puede decirle a un productor que también puede empezar a poner artículos ahora porque hay algo de espacio en la cola, que fue creada como resultado del consumo. Un hilo puede utilizar el método wait() para hacer una pausa y no hacer nada, dependiendo de alguna condición. Por ejemplo, en el problema del productor/consumidor, el hilo productor debe esperar si la cola está llena y el hilo consumidor debe esperar si la cola está vacía. Si algún hilo está esperando alguna condición para convertirse en verdad, puede utilizar los métodos notify y notifyAll para informarles de que la condición cambió y se puede despertar. Tanto notify() y el método notifyAll() notifican, pero notify() envía una sola notificación sin garantizar que hilo será notificado y notifyAll() envía notificaciones a todos los hilos. Así que si sólo un hilo está esperando en un objeto bloqueado, también conocido como monitor, entonces tanto notify como notifyAll notificarán a dicho hilo. Si varios hilos están esperando en un monitor entonces notify solo informará a uno de los hilos con suerte, y el resto no recibirá ninguna notificación, pero notifyAll si notificará a todos los hilos. En este tutorial de multihilos con Java aprenderás a usar los métodos wait, notify y notifyAll en Java implementando el problema del Productor-Consumidor. Si estás buscando una revisión más profunda sobre concurrencia y multihilos, te recomiendo que leas el libro Java Concurrency in Practice de Brian Goetz, sino lees dicho libro tu recorrido hacia el manejo de multihilos con Java no estará completo. Quizás, este es uno de los principales libros que debe leer todo desarrollador Java.
 */
package ej12_prod_cons;

import java.util.LinkedList;
import java.util.Queue;

public class MainMultiple {

    public static void main(String args[]) throws InterruptedException  {
        System.out.println("Como usar el metodo wait y notify en Java");
        System.out.println("Resolviendo el problema del Productor-Consumidor");
        Queue buffer = new LinkedList<>();
        int maxSize = 10;
        
        Productor producer[] = new Productor[5];
        for(int i=0; i<producer.length; i++) {
            producer[i]=new Productor("P-"+i, buffer, maxSize);
        }

        Consumidor consumer[] = new Consumidor[8];
        for(int i=0; i<consumer.length; i++) {
            consumer[i]=new Consumidor("P-"+i, buffer, maxSize);
        }
        
        arranca(consumer);
        arranca(producer);
                
        // ejecutamos los hilos x segundos y finalizamos
        Thread.sleep(2000);
        
        para(producer);
        para(consumer);
    }
    
    public static void arranca(Consumidor hilo[]) {
        for(int i=0; i<hilo.length; i++) {
            hilo[i].start();
        }  
    }
    
    public static void arranca(Productor hilo[]) {
        for(int i=0; i<hilo.length; i++) {
            hilo[i].start();
        }  
    }

    public static void para(Consumidor hilo[]) {
        for(int i=0; i<hilo.length; i++) {
            hilo[i].marcaFinalizado();
            hilo[i].interrupt();
        }  
    }    
    
    public static void para(Productor hilo[]) {
        for(int i=0; i<hilo.length; i++) {
            hilo[i].marcaFinalizado();
            hilo[i].interrupt();
        }  
    }    
}
