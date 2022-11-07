/**
 * Clase que implementa la funcionalidad que hace la Cajera
 * 
 * Cuando los hilos los creamos heredando de Thread entonces
 * la clase debe implementar el método "run()" y la funcionalidad
 * que desarrolla. Normalmente esto crea código de más dificil comprensión.
 * 
 * En los otros ejemplos la funcionalidad de run es implementada por la clase
 * que lleva el método main()
 */
package ej01;

/**
 *
 * @author Richard
 */
public class CajeraThread extends Thread {

    private String nombre;

    private Cliente cliente;

    private long initialTime;

    public CajeraThread() {
    }

    public CajeraThread(String nombre, Cliente cliente, long initialTime) {
        this.nombre = nombre;
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {

        System.out.println("La cajera " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000
                + "seg");

        for (int i = 0; i < this.cliente.getCarroCompra().length; i++) {
            // Se procesa el pedido en X segundos
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1)
                    + " del cliente " + this.cliente.getNombre() + "->Tiempo: "
                    + (System.currentTimeMillis() - this.initialTime) / 1000
                    + "seg");
        }

        System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR "
                + this.cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - this.initialTime) / 1000
                + "seg");
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
