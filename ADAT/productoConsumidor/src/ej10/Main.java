/*
  Ejemplo de productor/consumidor basado en ejemplo de la página
  http://www.jtech.ua.es/dadm/restringido/java/sesion05-apuntes.html

  En el que se han eliminado todas las condiciones de sincronización
  por lo que no funcionará correctamente

  La lógica de sincronización estará en la clase Almacen. En este ejemplo
  tratamos de sincronizar mediante variables (Espera activa), parece que el programa funciona
  pero no tenemos garantía de que no existan interbloqueos 

  Si se ejecta varías vece con distintos tiempos de demora se observará como
  el programa se bloquea

  El productor indicará el final con la cadena HECHO, el consumidor finalizará
  cuando la encuentre

  Se han cambiado los nombres de las variables
 */
package ej10;

import java.util.ArrayList;

public class Main {

    /**
     * Probad ejecuciones cambiando la demora (milisegundos)
     * Observad como la espera activa ejecuta continuamente instrucciones
     */
    public static final int DEMORA = 5;

    final static int N_PRODUCTORES = 1;
    final static int N_CONSUMIDORES = 1;

    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        ArrayList<Thread> hilos = new ArrayList<Thread>();

        for (int i = 0; i < N_PRODUCTORES; i++) {
            Thread hilo = new Thread(new Productor(almacen, "P" + i));
            hilos.add(hilo);
            hilo.start();
        }

        for (int i = 0; i < N_CONSUMIDORES; i++) {
            Thread hilo = new Thread(new Consumidor(almacen, "C" + i));
            hilos.add(hilo);
            hilo.start();
        }

        /*
        // Que pasa si añadimos más hilos ...
        // Hay más lugares problematicos
         */
        
        // Esperamos que todos acaben
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException ex) {
            }
        }

        System.out.println("---- FIN MAIN ----");
    }
}
