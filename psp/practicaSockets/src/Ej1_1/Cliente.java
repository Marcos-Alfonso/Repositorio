package Ej1_1;

import java.io.*;
import java.net.Socket;
import java.util.InputMismatchException;

public class Cliente {

    public static final int PORT = 4444;
    public static final String SERVER="127.0.0.1";

    static DataInputStream entrada;
    static DataOutputStream salida;

    public static void main(String[] args) throws IOException {

        Socket socketCliente = null;
        entrada = new DataInputStream(new BufferedInputStream(socketCliente.getInputStream()));
        // Establece canal de salida
        salida = new DataOutputStream(new BufferedOutputStream(socketCliente.getOutputStream()));


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

        String linea;
        try {
            while (true) {
                try{
                    System.out.println("- Cliente Operaciones matemáticas -");
                    // Leo la entrada del usuario
                    System.out.println("Seleccione operador o comando (+,-,*,/, F, A): ");
                    char c  = stdIn.readLine().toCharArray()[0];
                    if(c!='+'&&c!='-'&&c!='*'&&c!='/'&&c!='F'&&c!='A'){
                        throw new InputMismatchException();
                    }
                    envia.println(c);
                    if(c == 'F' || c == 'A'){
                        break;
                    }

                    System.out.println("Numero 1: ");
                    long n1 = Long.parseLong(stdIn.readLine());

                    System.out.println("Número 2: ");
                    long n2 = Long.parseLong(stdIn.readLine());
                    //Envío los dos después por si da un error en la introducción de datos
                    envia.println(n1);
                    envia.println(n2);

                    // Envía a la salida estándar la respuesta del servidor
                    linea = recibe.readLine();
                    System.out.println(linea);
                }catch (InputMismatchException | NumberFormatException ime){
                    System.err.println("Error en la introducción. ");
                }
            }
        } catch (IOException  e) {
            System.out.println("IOException: " + e.getMessage());
        }

        envia.close();
        recibe.close();
        stdIn.close();
        socketCliente.close();
    }

}
