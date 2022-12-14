/**
 * Clase que implementa la funcionalidad que hace el cliente
 * 
 * 
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
 * su compra '9 segundos'.
 */
package ej02;

/**
 *
 * @author Richard
 */
public class Cliente {

	private String nombre;
	private int[] carroCompra;

	public Cliente() {
	}

	public Cliente(String nombre, int[] carroCompra) {
		this.nombre = nombre;
		this.carroCompra = carroCompra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[] getCarroCompra() {
		return carroCompra;
	}

	public void setCarroCompra(int[] carroCompra) {
		this.carroCompra = carroCompra;
	}

}
