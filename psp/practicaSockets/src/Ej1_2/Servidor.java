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
	static char operacion = '+';
	public static void main(String[] args) throws SocketException {
			socket = new DatagramSocket(PUERTO_SERVIDOR);
			while (operacion != 'A') {
				operaCliente();
			}
	}
	static DatagramSocket socket ;
	private static void operaCliente()  {
		try{
			InetAddress ip = InetAddress.getByName(IP);
			socket.connect(ip, PUERTO_CLIENTE);
			do {
				operar();
			} while (operacion != 'F' && operacion != 'A');
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void operar() throws IOException {

		operacion = recibirChar();
		System.out.println("Recibe: " + operacion);

		if (operacion == '+' || operacion == '-' || operacion == '*' || operacion == '/') {
			long numero1 = recibirLong();
			long numero2 = recibirLong();
			
			System.out.println("Recibe: " + numero1);
			System.out.println("Recibe: " + numero2);

			long resultado = calcularOperacion(operacion, numero1, numero2);

			String cadena = numero1 + " " + operacion + " " + numero2 + " = " + resultado;

			enviar( contador);
			enviar( resultado);
			enviar( cadena);
			contador++;
		}

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


	private static char recibirChar() throws IOException {
		DatagramPacket paquete = new DatagramPacket(new byte[Character.BYTES], Character.BYTES);
		socket.receive(paquete);
		char caracter = ByteBuffer.wrap(paquete.getData()).getChar();
		return caracter;
	}

	private static long recibirLong() throws IOException {
		DatagramPacket paquete = new DatagramPacket(new byte[Long.BYTES], Long.BYTES);
		socket.receive(paquete);
		long numero = ByteBuffer.wrap(paquete.getData()).getLong();
		return numero;
	}

	private static void enviar( long n) throws IOException {
		byte[] nBytes = ByteBuffer.allocate(Long.BYTES).putLong(n).array();
		DatagramPacket paquete = new DatagramPacket(nBytes, nBytes.length);
		socket.send(paquete);
	}
	private static void enviar( int n) throws IOException {
		byte[] nBytes = ByteBuffer.allocate(Integer.BYTES).putInt(n).array();
		DatagramPacket paquete = new DatagramPacket(nBytes, nBytes.length);
		socket.send(paquete);
	}
	private static void enviar(String c) throws IOException {
		byte[]cBytes = c.getBytes();
		DatagramPacket paquete = new DatagramPacket(cBytes, cBytes.length);
		socket.send(paquete);
	}

}