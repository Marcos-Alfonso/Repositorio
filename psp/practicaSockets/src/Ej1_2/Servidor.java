/*
 * Programa servidor que recibir� dos n�meros y un operador y devolver� el resultado.
 * La conexi�n se realizar� usando UDP.
 */

package Ej1_2;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class Servidor {


	static final String IP = "127.0.0.1";
	static final int PUERTO_SERVIDOR = 4444;
	static final int PUERTO_CLIENTE = 4445;
	static int contador = 1;

	public static void main(String[] args) {
		try {
			char operacion = '+';
			while (operacion != 'A') {
				operacion = atenderCliente(operacion);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static char atenderCliente(char operacion) throws IOException {
		try (DatagramSocket socket = new DatagramSocket(PUERTO_SERVIDOR)) {
			InetAddress ip = InetAddress.getByName(IP);
			socket.connect(ip, PUERTO_CLIENTE);

			do {
				operacion = operar(socket);
			} while (operacion != 'F' && operacion != 'A');
		} catch (IOException e) {
			e.printStackTrace();
		}

		return operacion;
	}

	private static char operar(DatagramSocket socket) throws IOException {

		char operacion = recibirChar(socket);
		System.out.println("Cliente: " + operacion);

		if (operacion == '+' || operacion == '-' || operacion == '*' || operacion == '/') {
			long numero1 = recibirLong(socket);
			long numero2 = recibirLong(socket);
			
			System.out.println("Cliente: " + numero1);
			System.out.println("Cliente: " + numero2);

			long resultado = calcularOperacion(operacion, numero1, numero2);

			String cadena = numero1 + " " + operacion + " " + numero2 + " = " + resultado;

			enviar(socket, contador);
			enviar(socket, resultado);
			enviar(socket, cadena);
			
			System.out.println("Enviado: " + cadena);

			contador++;
		}
		return operacion;
	}

	private static long calcularOperacion(char operacion, long numero1, long numero2) {
		long resultado = 0;
		switch (operacion) {
		case '+':
			resultado = numero1 + numero2;
			break;
		case '-':
			resultado = numero1 - numero2;
			break;
		case '*':
			resultado = numero1 * numero2;
			break;
		case '/':
			resultado = numero1 / numero2;
			break;
		}
		return resultado;
	}


	private static char recibirChar(DatagramSocket socket) throws IOException {
		DatagramPacket paquete = new DatagramPacket(new byte[Character.BYTES], Character.BYTES);
		socket.receive(paquete);
		char caracter = ByteBuffer.wrap(paquete.getData()).getChar();
		return caracter;
	}

	private static long recibirLong(DatagramSocket socket) throws IOException {
		DatagramPacket paquete = new DatagramPacket(new byte[Long.BYTES], Long.BYTES);
		socket.receive(paquete);
		long numero = ByteBuffer.wrap(paquete.getData()).getLong();
		return numero;
	}

	private static void enviar(DatagramSocket socket, long numero) throws IOException {
		byte[] numeroBytes = ByteBuffer.allocate(Long.BYTES).putLong(numero).array();
		DatagramPacket paquete = new DatagramPacket(numeroBytes, numeroBytes.length);
		socket.send(paquete);
	}


	private static void enviar(DatagramSocket socket, int numero) throws IOException {
		byte[] numeroBytes = ByteBuffer.allocate(Integer.BYTES).putInt(numero).array();
		DatagramPacket paquete = new DatagramPacket(numeroBytes, numeroBytes.length);
		socket.send(paquete);
	}


	private static void enviar(DatagramSocket socket, String cadena) throws IOException {
		byte[] cadenaBytes = cadena.getBytes();
		DatagramPacket paquete = new DatagramPacket(cadenaBytes, cadenaBytes.length);
		socket.send(paquete);
	}

}