

package Ej2;

import java.io.*;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

public class Cliente {

	static final String IP = "127.0.0.1";
	static final int PUERTO = 4444;


	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	static DataInputStream entrada;
	static DataOutputStream salida;
	

	private static String nuevoNombre;

	public static void main(String[] args) {

		try {
			Socket socket = new Socket(IP, PUERTO);
			/* mod
			SSLContext sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, null, null);

			SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

			SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket(IP, PUERTO);
			*/

			System.out.println("- Cliente de descarga de ficheros -");
			System.out.println("Introduce:" +
					"   -G: Trae el fichero" +
					"   -D: Borra el fichero" +
					"   -R: Renombrar un fichero");
			obtenerStreams(socket);

			boolean operar = true;
			while (operar) {
				operar = operacion();
			}

			salida.writeChar('F');
			salida.flush();

			entrada.close();
			salida.close();
			teclado.close();
		} catch (IOException e) {
			System.out.println("No se ha podido establecer la conexión.");
		}
	}

	private static void obtenerStreams(Socket socket) throws IOException {
		entrada = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		salida = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
	}

	private static boolean operacion() throws IOException {

		System.out.print("(Deje en blanco para finalizar) Operación: ");
		String entrada = teclado.readLine();
		System.out.println();
		if (entrada.isEmpty()) {
			return false;
		}

		char operador = entrada.toUpperCase().charAt(0);

		if (operador == 'G' || operador == 'R' || operador == 'D' || operador == 'L') {
			salida.writeChar(operador);
			salida.flush();

			enviarDatos(operador);

			resultados(operador);
		} else {
			System.out.println("El operador no es correcto.");
			System.out.println();
		}

		return true;
	}

	private static void enviarDatos(char operador) throws IOException {
		switch (operador) {
		case 'G':
			String nombre = pedirNombre("Ruta del fichero en el servidor: ");
			nuevoNombre = pedirNombre("Ruta del nuevo fichero en el cliente: ");

			salida.writeUTF(nombre);
			salida.flush();

			break;
		case 'R':
			nombre = pedirNombre("Ruta del fichero en el servidor: ");
			nuevoNombre = pedirNombre("Nuevo nombre: ");

			salida.writeUTF(nombre);
			salida.writeUTF(nuevoNombre);
			salida.flush();

			break;
		case 'D':
			nombre = pedirNombre("Ruta del fichero en el servidor: ");
			salida.writeUTF(nombre);
			salida.flush();

			break;
		}
	}

	private static String pedirNombre(String string) {
		String nombre = "";
		do {
			System.out.print(string);
			try {
				nombre = teclado.readLine();
			} catch (IOException e) {}

		} while (nombre.isEmpty());
		System.out.println();

		return nombre;
	}


	private static void resultados(char operador) throws IOException {
		String hash = "";
		if (operador == 'G') {
			hash = entrada.readUTF();
		}
		byte resultado = entrada.readByte();
		long longitud = entrada.readLong();

		//byte[] informacion = leerNBytes((int) longitud);
		byte[] informacion = entrada.readNBytes((int) longitud);

		if (resultado != 0) {

			System.out.println("Error " + resultado + ": " + new String(informacion));
		} else if (operador == 'G') {
			copiarArchivo(informacion, hash);
		} else {
			System.out.println(new String(informacion));
		}

	}

	private static void copiarArchivo(byte[] informacion, String hash) throws IOException {

		File fichero = new File(nuevoNombre);
		boolean creado = false;
		boolean correcto = true;
		try {
			creado = fichero.createNewFile();
		} catch (IOException e) {
			System.out.println("Error 4: El nombre del fichero de destino no es correcto.");
			correcto = false;
		}

		if (creado) {
			try (OutputStream escritor = new FileOutputStream(fichero)) {
				escritor.write(informacion);
			}
			System.out.println("Fichero copiado con éxito.");
			try {
				System.out.println("Hash del fichero creado:\t\t"+HashTool.getHash(fichero) +"\nHash del fichero del servidor:\t"+hash);
				if (HashTool.getHash(fichero).equals(hash)) System.out.println("El fichero es identico al del servidor.");
				else System.out.println("Códigos Hash no coinciden. Error en descarga");
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}
		} else if (correcto) {
			System.out.println("Error 4: El fichero de destino ya existe.");
		}
	}


}
