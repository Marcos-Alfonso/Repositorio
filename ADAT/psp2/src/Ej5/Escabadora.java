package Ej5;

public class Escabadora extends Thread{
    public Escabadora() {
    }
    public synchronized void Carga(Camion c)  {

        try {
            System.out.println("C_"+c.getNombre()+" - Cargando");
            Thread.sleep(1500);
            System.out.println("C_"+c.getNombre()+" - Cargado");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
