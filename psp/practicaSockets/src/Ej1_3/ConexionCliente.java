package Ej1_3;

import java.io.*;
import java.net.Socket;

public class ConexionCliente extends Thread{


     Socket socketCliente = null;
     DataInputStream entrada;
     DataOutputStream salida;
     char operador;

     static private int nOperacion = 0;
    ConexionCliente(Socket socketCliente){
        this.socketCliente = socketCliente;
    }

    public void run(){
            conexionClientes();
        try {
            salida.close();
            entrada.close();
            socketCliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private  void conexionClientes() {
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

    private  boolean operaCliente() throws IOException {
        operador = entrada.readChar();
        System.out.println("Recibe: "+operador);
        if(operador == 'A'){
            System.err.println("Instrucción abortar recibida.");
            Servidor.finaliza();
            return true;
        }

        long n1 = entrada.readLong();
        System.out.println("Recibe: "+n1);
        long n2 = entrada.readLong();
        System.out.println("Recibe: "+n2);

        envíaRespuesta(n1, n2);
        return false;
    }

    private  void envíaRespuesta(long n1, long n2) throws IOException {
        salida.writeInt(++nOperacion);
        salida.writeLong(opera(operador, n1, n2));
        salida.writeUTF(n1 +""+operador+ n2);
        salida.flush();
    }

    private  void estableceConexión() throws IOException {

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
