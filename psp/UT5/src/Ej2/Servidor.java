/*
 * Programa servidor que nos permite operar con ficheros.
 * Las operaciones disponibles son:
 *  G: Traer el fichero (GET)
 *  D: Borrar el fichero (DELETE)
 *  R: Renombrar el fichero (RENAME)
 *  L: Obtener lista de ficheros
 */

package Ej2;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class Servidor {

	private static final byte[] FICH_RENOMBRADO = new String("Fichero renombrado con éxito.").getBytes();
	private static final byte[] FICH_BORRADO = new String("Fichero borrado con éxito.").getBytes();
	private static final byte[] ERR_1 = new String("El fichero no existe.").getBytes();
	private static final byte[] ERR_2 = new String("El nuevo nombre no es correcto.").getBytes();
	private static final byte[] ERR_3 = new String("Error desconocido.").getBytes();


	static final int PUERTO = 4444;


	static DataInputStream entrada;
	static DataOutputStream salida;

	static byte resultado;
	static long longitud;
	static byte[] informacion;

	public static void main(String[] args) {
		try {
			while (true){
				atenderCliente();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static void atenderCliente() throws IOException {
		try  {
			/*mod
			SSLServerSocketFactory sslServerSocketFactory =
					(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			SSLServerSocket sslServerSocket =
					(SSLServerSocket) sslServerSocketFactory.createServerSocket(PUERTO);

			Socket socketCliente = sslServerSocket.accept();
			*/
			ServerSocket socket = new ServerSocket(PUERTO);
			Socket socketCliente = socket.accept();

			obtenerStreams(socketCliente);

			char operacion = ' ';
			do {
				operacion = operar();
			} while (operacion != 'F');
			entrada.close();
			salida.close();
			socketCliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static char operar() throws IOException {
		char operacion = entrada.readChar();
		System.out.println("Cliente: " + operacion);

		if (operacion == 'G' || operacion == 'D' || operacion == 'R') {
			opercaFichero(operacion);
		} else if (operacion == 'L') {
			listarFicheros();
		}
		if (operacion != 'F') {
			enviarResultados();
		}
		return operacion;
	}


	private static void enviarResultados() throws IOException {
		salida.writeByte(resultado);
		salida.writeLong(longitud);
		salida.write(informacion);
		salida.flush();
		
		System.out.println("Enviado: " + resultado);
	}


	private static void opercaFichero(char operacion) throws IOException {

		String nombre = entrada.readUTF();
		System.out.println("Cliente: " + nombre);

		Path ubicacion = Paths.get(nombre);
		File fichero = ubicacion.toFile();

		try {
			if (!fichero.exists()) {
				setDatos((byte) 1, ERR_1);
			} else {

				operarConFichero(fichero, operacion);
			}
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			setDatos((byte) 3, ERR_3);
		}
	}

	private static void listarFicheros() {
		File carpeta = new File(".");
		File[] todo = carpeta.listFiles();

		String ficheros = "";
		for (File fichero : todo) {
			if (fichero.isFile()) {
				ficheros += fichero.getName() + "\n";
			}
		}
		setDatos((byte) 0, ficheros.getBytes());
	}


	private static void setDatos(byte res, byte[] flujo) {
		resultado = res;
		longitud = flujo.length;
		informacion = flujo;
	}

	private static void operarConFichero(File fichero, char operacion) throws Exception {
		switch (operacion) {
		case 'G':
			enviarFichero(fichero);
			break;
		case 'R':
			renombrarFichero(fichero);
			break;
		case 'D':
			borrarfichero(fichero);
			break;
		}
	}

	private static void enviarFichero(File fichero) throws Exception {

		try {
			salida.writeUTF(HashTool.getHash(fichero));
			System.out.println("Enviando fichero: "+HashTool.getHash(fichero));
			InputStream lector = new FileInputStream(fichero);
			//byte[] contenido = leerNBytes(lector, Integer.MAX_VALUE);
			byte[] contenido = lector.readAllBytes();
			setDatos((byte) 0, contenido);
		} catch (IOException e) {
			throw new Exception();
		}
	}


	private static void renombrarFichero(File fichero) throws IOException {
		String nombre = entrada.readUTF();
		System.out.println("Cliente: " + nombre);
		File nuevo = new File(nombre);
		boolean renombrado = fichero.renameTo(nuevo);
		if (renombrado) {
			setDatos((byte) 0, FICH_RENOMBRADO);
		} else {
			setDatos((byte) 2, ERR_2);
		}
	}


	private static void borrarfichero(File fichero) {
		fichero.delete();
		setDatos((byte) 0, FICH_BORRADO);
	}

	private static void obtenerStreams(Socket socket) throws IOException {
		entrada = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		salida = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
	}

}
