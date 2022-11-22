package ej03;

/**
 *
 * @author Richard
 */
public class Cajera {

    private String nombre;
    private TPV tpv;

    public Cajera(String nombre, TPV tpv) {
        this.nombre = nombre;
        this.tpv=tpv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void procesarCompra(Cliente cliente, long timeStamp)  throws InterruptedException {

        System.out.println("La cajera " + this.nombre
                + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre()
                + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000
                + "seg");

        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("[" + this.nombre + "] Procesado el producto " + (i + 1)
                    + " ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000
                    + "seg");
        }

        tpv.coje(this);
        tpv.verificaQueTengoTPV(this);
        tpv.paga();
        tpv.verificaQueTengoTPV(this);
        tpv.suelta();
        System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR "
                + cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
