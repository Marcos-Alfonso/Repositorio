package Ej5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteJugador {
    public static final int PORT = 4444;
    public static final String SERVER="127.0.0.1";
    static DataInputStream entrada;
    static DataOutputStream salida;
    static boolean continuar = true;
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
        BufferedReader stdIn =new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Conectado a socket. Esperando confirmación de inicio de partida");
        String linea = entrada.readUTF();
        System.out.println("Eres el "+linea);
        //imprimo el tablero
        System.out.println(entrada.readUTF());
        if (linea == "J1"){
            while(continuar){
                realizaMovimiento();
                valida();
                if(!continuar)break;
                valida();
            }
        }else {
            while(continuar){
                valida();
                if(!continuar)break;
                realizaMovimiento();
                valida();
            }
        }
    }

    private static void valida() {

    }

    private static void realizaMovimiento() throws IOException {
        //pido 4 ints por teclado: y los valido primero
        int oldX, oldY, newX, newY;
        System.out.println("Inserta X e Y de la pieza a mover:");
        oldX = pideInt();
        oldY = pideInt();
        System.out.println("Inserta X e Y del sitio al que mover la pieza en "+oldX+"-"+oldY+":");
        newX = pideInt();
        newY = pideInt();
        salida.writeInt(oldX);
        salida.writeInt(oldY);
        salida.writeInt(newX);
        salida.writeInt(newY);
        salida.flush();
    }

    private static int pideInt() {
        Scanner sc = new Scanner(System.in);
        while (true){
            int i = sc.nextInt();
            if (i>=0 && i<=7) return i;
            System.out.println("Valor incorrecto, debe ser un valor entre 0-7");
        }
    }
}
