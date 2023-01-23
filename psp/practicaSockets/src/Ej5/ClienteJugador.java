package Ej5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteJugador {
    public static final int PORT = 4444;
    public static final String SERVER="127.0.0.1";
    static DataInputStream entrada;
    static DataOutputStream salida;

    public static void main(String[] args) throws IOException {
        Socket socketCliente = null;
        try {
            socketCliente = new Socket(SERVER, PORT);

            // Obtenemos el canal de entrada
            entrada = new DataInputStream(new BufferedInputStream(socketCliente.getInputStream()));
            // Establece canal de salida
            salida = new DataOutputStream(new BufferedOutputStream(socketCliente.getOutputStream()));
        } catch (IOException e) {
            System.err.println("No puede establer canales de E/S para la conexión");
            System.exit(-1);
        }
        BufferedReader stdIn;
        stdIn = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Conectado a socket. Esperando confirmación de inicio de partida");
        String linea = entrada.readUTF();
        System.out.println(linea);

    }
}
