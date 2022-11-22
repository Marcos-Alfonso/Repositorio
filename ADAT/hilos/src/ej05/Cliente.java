package ej05;




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
        
        /**
         * Devuelve un carro de nItems lleno de enteros
         * @param nItems
         * @return 
         */
        public static int[] dameCarro(int nItems) {
            int unCarro[]=new int[nItems];
            
            // Llenamos el carro
            for(int i=0; i<nItems; i++) {
                unCarro[i]=(int)Math.floor(Math.random()*10+1);
            }
            return unCarro;
            
        }

}
