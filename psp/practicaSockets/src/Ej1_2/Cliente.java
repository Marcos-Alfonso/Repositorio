/*
 * Programa cliente que leer� operadores y n�meros por teclado solicitar� 
 * a un servidor que realice la operaci�n. La conexi�n se realizar� usando UDP.
 */

package Ej1_2;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.*;

public class Cliente {

	// Servidor y puerto
	static final String IP = "127.0.0.1";
	static final int PUERTO_SERVIDOR = 4444;
	static final int PUERTO_CLIENTE = 4445;

	private static final int SIZE = 64;

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		try (DatagramSocket socket = new DatagramSocket(PUERTO_CLIENTE)) {
			System.out.println("- Cliente de operaciones matemáticas -");

			InetAddress ip = InetAddress.getByName(IP);
			socket.connect(ip, PUERTO_SERVIDOR);


			boolean operar = true;
			while (operar) {
				operar = operacion(socket);
			}

		} catch (IOException e) {
			System.out.println("No se ha podido establecer la conexión.");
		}

	}
	static char operador;
	private static boolean operacion(DatagramSocket socket) throws IOException {
		// Pido operador
		System.out.print("Seleccione operador o comando (+, -, *, /, F, A): ");
		 operador = sc.nextLine().toUpperCase().charAt(0);


		if (operador == 'A' || operador == 'F' || operador == '+' || operador == '-' || operador == '*' || operador == '/') {
			// Envio operador
			enviar(socket, operador);
			return procesarOperador(socket, operador);
		} else {
			System.out.println("El operador no es correcto.");
			return true;
		}
	}

	private static boolean procesarOperador(DatagramSocket socket, char operador) throws IOException {
		switch (operador) {
		case 'A':
			System.out.println("Servidor detenido");
			socket.close();

			return false;

		case 'F':
			System.out.println("Finaliza conexión");
			socket.close();

			return false;

		default:
			operaNum(socket);
			String resultados = recibirResultados(socket);
			System.out.println("Respuesta del servidor:");
			System.out.println(resultados);

			return true;
		}
	}

	private static String recibirResultados(DatagramSocket socket) throws IOException {
		int numero = recibirInt(socket);

		long total = recibirLong(socket);

		String operacion = recibirString(socket);

		String resultado = "Operación "+numero+": "+operacion;

		return resultado;
	}

	private static String recibirString(DatagramSocket socket) throws IOException {
		DatagramPacket paqueteOperacion = new DatagramPacket(new byte[SIZE], SIZE);
		socket.receive(paqueteOperacion);
		String operacion = new String(paqueteOperacion.getData(), 0, paqueteOperacion.getLength());
		return operacion;
	}

	private static long recibirLong(DatagramSocket socket) throws IOException {
		DatagramPacket paquete = new DatagramPacket(new byte[Long.BYTES], Long.BYTES);
		socket.receive(paquete);
		long numero = ByteBuffer.wrap(paquete.getData()).getLong();
		return numero;
	}

	private static int recibirInt(DatagramSocket socket) throws IOException {
		DatagramPacket paquete = new DatagramPacket(new byte[Integer.BYTES], Integer.BYTES);
		socket.receive(paquete);
		int numero = ByteBuffer.wrap(paquete.getData()).getInt();
		return numero;
	}

	private static void operaNum(DatagramSocket socket) throws IOException {
		System.out.print("Número 1: ");
		long numero1 = getNumero();
		System.out.print("Número 2: ");
		long numero2 = getNumero();

		enviar(socket, numero1);
		enviar(socket, numero2);
	}
	//leo un número por teclado, comprobando que es correcto
	private static long getNumero() {
		boolean cont;
		long n = 0;
		do {
			try {
				n = sc.nextLong();
				cont = false;
			} catch (InputMismatchException e) {
				System.out.println("Formato incorrecto. Prueba otra vez");
				cont = true;
			}
			sc.nextLine();
		} while (cont);
		return n;
	}

	private static void enviar(DatagramSocket socket, long numero) throws IOException {
		byte[] numeroBytes = ByteBuffer.allocate(Long.BYTES).putLong(numero).array();
		DatagramPacket paquete = new DatagramPacket(numeroBytes, numeroBytes.length);
		socket.send(paquete);
	}

	private static void enviar(DatagramSocket socket, char caracter) throws IOException {
		byte[] caracterBytes = ByteBuffer.allocate(Character.BYTES).putChar(caracter).array();
		DatagramPacket paquete = new DatagramPacket(caracterBytes, caracterBytes.length);
		socket.send(paquete);
	}

}
