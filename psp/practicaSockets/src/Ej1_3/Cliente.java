package Ej1_3;

import java.io.*;
import java.net.Socket;
import java.util.InputMismatchException;

public class Cliente {

     static final int PORT = 4444;
     static String SERVER="127.0.0.1";

    static DataInputStream entrada;
    static DataOutputStream salida;
    static Socket socketCliente;
    static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        try {
            SERVER = args[0];
        }catch (IndexOutOfBoundsException iobe){}
        creaConexion();
            while (true) {
                try{
                    System.out.println("- Cliente Operaciones matemáticas -");
                    // Leo la entrada del usuario
                    System.out.println("Seleccione operador o comando (+,-,*,/, F, A): ");
                    char c  = stdIn.readLine().toCharArray()[0];
                    if(c!='+'&&c!='-'&&c!='*'&&c!='/'&&c!='F'&&c!='A'){
                        throw new InputMismatchException();
                    }
                    salida.writeChar(c);
                    salida.flush();
                    if(c == 'F' || c == 'A'){
                        break;
                    }
                    enviaOperadores();
                    recibeRespuesta();
                }catch (InputMismatchException | NumberFormatException ime){
                    System.err.println("Error en la introducción. ");
                }
            }

        salida.close();
        entrada.close();
        stdIn.close();
        socketCliente.close();
    }

    private static void recibeRespuesta() throws IOException {
        // Envía a la salida estándar la respuesta del servidor
        System.out.println("Respuesta del servidor");
        int nOperacion = entrada.readInt();
        long resu = entrada.readLong();
        String operacion = entrada.readUTF();
        System.out.println("Operación nº "+nOperacion+" | "+operacion+"="+resu);
    }

    private static void enviaOperadores() throws IOException {
        System.out.println("Numero 1: ");
        long n1 = Long.parseLong(stdIn.readLine());

        System.out.println("Número 2: ");
        long n2 = Long.parseLong(stdIn.readLine());

        //Envío los dos después por si da un error en la introducción de datos
        salida.writeLong(n1);
        salida.flush();
        salida.writeLong(n2);
        salida.flush();
    }

    private static void creaConexion() {
        try {
            socketCliente = new Socket(SERVER, PORT);
            System.out.println(socketCliente);
            // Obtenemos el canal de entrada
            entrada = new DataInputStream(new BufferedInputStream(socketCliente.getInputStream()));
            // Establece canal de salida
            salida = new DataOutputStream(new BufferedOutputStream(socketCliente.getOutputStream()));
        } catch (IOException e) {
            System.err.println("No puede establer canales de E/S para la conexión");
            System.exit(-1);
        }
    }

}
