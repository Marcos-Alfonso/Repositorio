package ej11;/*
  Ejemplo de productor/consumidor basado en ejemplo de la página
  http://www.jtech.ua.es/dadm/restringido/java/sesion05-apuntes.html

  Ejemplo clásico del ej11.Productor/ej11.Consumidor. En este problema hay dos hilos
  que producen y consumen simultáneamente datos de un mismo buffer o misma 
  variable. 
  problema es que no se interbloqueen, al tiempo que si el buffer está vacío, 
  el consumidor se quede en espera, y si el buffer está lleno, el productor quede 
  en espera.

  Se han cambiado los nombres de las variables

   Tan solo tenemos un productor y un consumidor, y el almacen solo
   permite guardar un elemento

  En este ejemplo se utiliza el monitor generado por synchronized para evitar
  conflictos

  La logica de la sincronización está en la clase ej11.Almacen.
  Se bloquean los hilos con wait() cuando tienen que esperar, y se depiertan
  con notify() o notifyAll()

 */

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        (new Thread(new Productor(almacen))).start();
        (new Thread(new Consumidor(almacen))).start();
    }
}
