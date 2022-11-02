/*
  Ejemplo de productor/consumidor basado en ejemplo de la página
  http://www.jtech.ua.es/dadm/restringido/java/sesion05-apuntes.html

  Se ha tratado de sincronizar ambos hilos utilando mecanismos de espera
  activa. Desafortunadamente al no ser las operaciones atomicas pueden
  producirse interbloqueos

  ¿Qué pasa si estaVacio y tieneAlgo toman ambos el valor true?

  No tenemos garantía de que el proceso finalice correctamente

  Se han cambiado los nombres de las variables
 */
package ej10;

public class Almacen {
    
    int n = 0;

    // Message sent from producer to consumer.
    private String mensaje;
    /* 
        Se utilizaran las variables 'estaVacio' y 'tieneAlgo' para indicar
        si el almacen tiene elementos.
        Se podría realizar con una sola variable, pero lo que tratamos es 
        de buscar interbloqueos
     */
    /**
     * estaVacio valdrá True si el almacen está vacio
     */
    private boolean estaVacio = true;

    /**
     * tieneAlgo valdrá True si hay un elemento en el almacen que se pueda sacar
     */
    private boolean tieneAlgo = false;

    public String toma(String id) {
        while (estaVacio) {
            // Espera activa a que pon() deje vacio a False
            System.out.println("\t\t\t"+id+" toma() vacio=" + estaVacio + " algo=" + tieneAlgo + " " + System.currentTimeMillis());
        }
        // Vamos a sacar el elemento
        estaVacio = true;
        // Que pasa si se corta la tarea aquí y pasa a ejecutar el hilo
        // que espera en pon()
        paraUnPoco();
        tieneAlgo = false;
        return mensaje;
    }

    public void pon(String message, String id) {
        while (tieneAlgo) {
            // Espera activa a que toma() deje vacio a True
            System.out.println("\t\t\t"+id+" pon() vacio=" + estaVacio + " algo=" + tieneAlgo + " " + System.currentTimeMillis());
        }
        estaVacio = false;
        paraUnPoco();
        this.mensaje = message;
        // Hemos metido un elemento

        // Que pasa si se corta la tarea aquí y pasa a ejecutar el hilo
        // que espera en toma()        
        tieneAlgo = true;
    }

    /**
     * Relentiza la ejecución dependiendo del valor introducido
     * en la variable final DEMORA
     */
    private void paraUnPoco() {
        if (Main.DEMORA == 0) {
            return;
        }
        try {
            Thread.sleep(Main.DEMORA);
        } catch (Exception e) {
        }
    }
}
