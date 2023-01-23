package Ej1_3;

import java.io.*;
import java.net.Socket;

public class ConexionClientes extends Thread{

     Socket socketCliente = null;
     DataInputStream entrada;
     DataOutputStream salida;
     char operador;

    ConexionClientes (Socket socketCliente){
        this.socketCliente = socketCliente;
    }

    public void run(){
        do{
            conexionClientes();
        }while ( operador != 'F');

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

            System.out.println("Connexión acceptada: " + socketCliente);
            // Establece canal de entrada
            entrada = new DataInputStream(new BufferedInputStream(socketCliente.getInputStream()));
            // Establece canal de salida
            salida = new DataOutputStream(new BufferedOutputStream(socketCliente.getOutputStream()));

            while (true) {
                operador = entrada.readChar();

                if( operador == 'F'){
                    System.err.println("Finalizada una conexión: " + socketCliente.getPort());
                    break;
                }
                if(operador == 'A' ){
                    System.err.println("Recibida operación Abortar en socket" + socketCliente.getPort());
                    System.exit(-1);
                }

                long n1 = entrada.readLong();

                long n2 = entrada.readLong();
                String operacion = n1+""+operador+n2+" = "+opera(operador,n1,n2);
                System.out.println("Se ha realizado una operación: "+operacion);
                salida.writeUTF(operacion);

                salida.flush();
            }

        } catch (IOException e) {
            System.out.println("Finalizada una conexión: " + socketCliente.getPort());
        }
    }

    private long opera(char c, long n1, long n2) {
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
