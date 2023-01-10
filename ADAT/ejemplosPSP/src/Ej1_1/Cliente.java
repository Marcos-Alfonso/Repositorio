package Ej1_1;

import java.io.*;
import java.net.Socket;

public class Cliente {
    public static final int PORT = 10000;
    public static final String SERVER="127.0.0.1";

    public static void main(String[] args)  throws IOException {
        Socket socketCliente = null;
        BufferedReader recibe = null;
        PrintWriter envia = null;

        try {
            socketCliente = new Socket(SERVER, PORT);
            // Obtenemos el canal de entrada
            recibe = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            // Obtenemos el canal de salida
            envia = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true);
        } catch (IOException e) {
            System.err.println("No puede establer canales de E/S para la conexión");
            System.exit(-1);
        }
        BufferedReader stdIn;
        stdIn = new BufferedReader(new InputStreamReader(System.in));

        String linea;
        try {
            while (true) {
                // Leo la entrada del usuario
                System.out.println("Seleccione operador o comando (+,-,*,/, F, A):");
                linea = stdIn.readLine();
                // La envia al servidor
                envia.println(linea);

                System.out.println("Numero 1:");
                linea = stdIn.readLine();
                // La envia al servidor
                envia.println(linea);

                System.out.println("Numero 2:");
                linea = stdIn.readLine();
                // La envia al servidor
                envia.println(linea);

                // Envía a la salida estándar la respuesta del servidor
                linea = recibe.readLine();
                System.out.println("Respuesta servidor: " + linea);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // Libera recursos
        envia.close();
        recibe.close();
        stdIn.close();
        // Cierro socket
        socketCliente.close();
    }
}
