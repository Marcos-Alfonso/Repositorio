package Ej5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteJugador {
    public static final int PORT = 4444;
    public static String SERVER="127.0.0.1";
    static DataInputStream entrada;
    static DataOutputStream salida;
    static boolean continuar = true;
    static String name;
    public static void main(String[] args) throws IOException {
        try{
            SERVER = args[0];
        }catch(IndexOutOfBoundsException e){       }

        Socket socketCliente = null;
        try {
            System.out.println("Conectando a dirección "+SERVER+":"+PORT);
            socketCliente = new Socket(SERVER, PORT);
            // Obtenemos el canal de entrada
            entrada = new DataInputStream(new BufferedInputStream(socketCliente.getInputStream()));
            // Establece canal de salida
            salida = new DataOutputStream(new BufferedOutputStream(socketCliente.getOutputStream()));
        } catch (IOException e) {
            System.err.println("No puede establer canales de E/S para la conexión");
            System.exit(-1);
        }

        System.out.println("Conectado a socket. Esperando confirmación de inicio de partida");
        String linea = entrada.readUTF();
        name = linea;
        System.out.println("Eres el "+linea);
        //imprimo el tablero
        System.out.println(entrada.readUTF());
        if (linea.equals("J1") ){
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

    private static void valida() throws IOException {
        System.out.println("Esperando respuesta del servidor...");
        //recibo e imprimo el tablero
        System.out.println(entrada.readUTF());
        String l = entrada.readUTF();
        if (l.equals("J1") || l.equals("J2")){
            continuar = false;
            if (l.equals(name)){
                System.out.println("Has ganado!");
            }else {
                System.out.println("Perdiste!");
            }
        }
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
