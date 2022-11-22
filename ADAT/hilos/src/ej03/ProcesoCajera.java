package ej03;

/*
    Véase: https://jarroba.com/multitarea-e-hilos-en-java-con-ejemplos-thread-runnable/
    Ejemplo de aplicación que demuestra la utilidad de los hilos

    Main.java           - Enfoque secuencial
    MainThead.java      - Enfoque con hilos heredando de Thread
    MainRunnable.java   - Enfoque con hilos implementando la interfaz Runnable
 */
/**
 *
 * @author Richard
 */
public class ProcesoCajera implements Runnable {

    private Cliente cliente;
    private Cajera cajera;
    private long initialTime;

    public ProcesoCajera(Cliente cliente, Cajera cajera, long initialTime) {
        this.cajera = cajera;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        try {
            this.cajera.procesarCompra(this.cliente, this.initialTime);
        }
        catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
