package Ej1_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;

public class Servidor {

    public static final int PORT = 4444;

    static ServerSocket socketServidor = null;
    static Socket socketCliente = null;
    static DataInputStream entrada;
    static DataOutputStream salida;
    static char operador;

    public static void main(String[] args) throws IOException {


        // Establece el puerto en el que escucha peticiones

        try {
            socketServidor = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("No puede escuchar en el puerto: " + PORT);
            System.exit(-1);
        }

        System.out.println("Escuchando: " + socketServidor);
        do{
            conexionClientes();
        }while (operador !='A');

        salida.close();
        entrada.close();
        socketCliente.close();
        socketServidor.close();
    }

    private static void conexionClientes() {
        try {
            socketCliente = socketServidor.accept();
            System.out.println("Connexión acceptada: " + socketCliente);
            // Establece canal de entrada
            entrada = new DataInputStream(new BufferedInputStream(socketCliente.getInputStream()));
            // Establece canal de salida
            salida = new DataOutputStream(new BufferedOutputStream(socketCliente.getOutputStream()));

            while (true) {
                operador = entrada.readChar();
                if(operador == 'A'){
                    System.err.println("Instrucción abortar recibida.");
                    break;
                }
                long n1 = entrada.readLong();
                long n2 = entrada.readLong();

                salida.writeUTF(n1+""+operador+n2+" = "+opera(operador,n1,n2));
            }

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    private static long opera(char c, long n1, long n2) {
        long resu = 0;
        switch (c){
            case '+':
                resu = n1+n2;
                break;
            case '-':
                resu = n1-n2;
                break;
            case '*':
                resu = n1*n2;
                break;
            case '/':
                resu = n1/n2;
                break;
        }
        return resu;
    }

}
