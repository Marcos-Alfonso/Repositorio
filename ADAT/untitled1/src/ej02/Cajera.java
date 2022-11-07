/**
 * Clase que implementa la funcionalidad que hace la Cajera
 *
 * En este ejemplo vamos a simular el proceso de cobro de un supermercado;
 * es decir, unos clientes van con un carro lleno de productos y una cajera
 * les cobra los productos, pasándolos uno a uno por el escaner de la caja
 * registradora. En este caso la cajera debe de procesar la compra cliente
 * a cliente, es decir que primero le cobra al cliente 1, luego al cliente 2
 * y así sucesivamente. Para ello vamos a definir una clase "Cajera" y una
 * clase "Cliente" el cual tendrá un "array de enteros" que representaran
 * los productos que ha comprado y el tiempo que la cajera tardará en pasar
 * el producto por el escaner; es decir, que si tenemos un array con [1,3,5]
 * significará que el cliente ha comprado 3 productos y que la cajera tardara
 * en procesar el producto 1 '1 segundo', el producto 2 '3 segundos' y el
 * producto 3 en '5 segundos', con lo cual tardara en cobrar al cliente toda
 * su compra '9 segundos'*
 */
package ej02;

/**
 *
 * @author Richard
 */
public class Cajera {

    private String nombre;
    private boolean averiadaCaja = false;

    public Cajera() {
    }

    public Cajera(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void procesarCompra(Cliente cliente, long timeStamp) {

        System.out.println("La cajera " + this.nombre
                + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre()
                + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000
                + "seg");

        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXsegundos(cliente.getCarroCompra()[i]);
            if (averiadaCaja) {
                System.out.println("\n## Se acabo ... caja averiada "+getNombre());
                return;
            }
            System.out.println("[" + this.nombre + "] Procesado el producto " + (i + 1)
                    + " ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000
                    + "seg");
        }

        System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR "
                + cliente.getNombre() + " EN EL TIEMPO: "
                + (System.currentTimeMillis() - timeStamp) / 1000 + "seg");

    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            this.averiadaCaja = true;
            Thread.currentThread().interrupt();
        }
    }

}
