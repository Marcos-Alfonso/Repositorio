package Ej5_2;

public class Escabadora extends Thread{
    public Escabadora() {
    }
    public synchronized void Carga(Camion c)  {
        try {
            System.out.println("C_"+c.getNombre()+" (5) – Escabadora - cargando");
            Thread.sleep(1500);
            System.out.println("C_"+c.getNombre()+" (6) – Escabadora - Fin carga");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
