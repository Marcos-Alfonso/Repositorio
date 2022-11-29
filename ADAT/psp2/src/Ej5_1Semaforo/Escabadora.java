package Ej5_1Semaforo;

public class Escabadora extends Thread{
    public Escabadora() {
    }
    public void Carga(Camion c)  {
        try {
            System.out.println("C_"+c.getNombre()+" (5) – Escabadora - cargando");
            Thread.sleep(1500);
            System.out.println("C_"+c.getNombre()+" (6) – Escabadora - Fin carga");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
