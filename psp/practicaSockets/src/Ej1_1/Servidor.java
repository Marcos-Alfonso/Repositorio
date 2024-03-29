package Ej1_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static final int PORT = 4444;

    static ServerSocket socketServidor = null;
    static Socket socketCliente = null;
    static DataInputStream entrada;
    static DataOutputStream salida;
    static char operador;

    static int nOperacion;
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
            estableceConexión();
            while (true) {
                if (operaCliente()) break;
            }

        } catch (IOException e) {
            //caso en el que el cliente se desconecta
            System.err.println("Conexión Finalizada");
        }
    }

    private static boolean operaCliente() throws IOException {
        operador = entrada.readChar();
        System.out.println("Recibe: "+operador);
        if(operador == 'A'){
            System.err.println("Instrucción abortar recibida.");
            return true;
        }

        long n1 = entrada.readLong();
        System.out.println("Recibe: "+n1);
        long n2 = entrada.readLong();
        System.out.println("Recibe: "+n2);

        envíaRespuesta(n1, n2);
        return false;
    }

    private static void envíaRespuesta(long n1, long n2) throws IOException {
        salida.writeInt(++nOperacion);
        salida.writeLong(opera(operador, n1, n2));
        salida.writeUTF(n1 +""+operador+ n2);
        salida.flush();
    }

    private static void estableceConexión() throws IOException {
        socketCliente = socketServidor.accept();
        nOperacion = 0;
        System.out.println("Connexión acceptada: " + socketCliente);
        // Establece canal de entrada
        entrada = new DataInputStream(new BufferedInputStream(socketCliente.getInputStream()));
        // Establece canal de salida
        salida = new DataOutputStream(new BufferedOutputStream(socketCliente.getOutputStream()));
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
