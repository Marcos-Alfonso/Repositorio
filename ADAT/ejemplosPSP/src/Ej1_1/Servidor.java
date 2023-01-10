package Ej1_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;

public class Servidor {
    public static final int PORT = 10000;

    public static void main(String[] args) throws IOException {

        ServerSocket socketServidor = null;
        try {
            socketServidor = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("No puede escuchar en el puerto: " + PORT);
            System.exit(-1);
        }

        while (true) {
            Socket socketCliente = null;
            BufferedReader entrada = null;
            PrintWriter salida = null;

            System.out.println("Escuchando: " + socketServidor);
            try {
                // Espero a recibir petición
                socketCliente = socketServidor.accept();
                System.out.println("Connexión acceptada: " + socketCliente);
                // Establece canal de entrada
                entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                // Establece canal de salida
                salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true);

                char c = ' ';

                while (true) {
                    try{
                        System.out.println("Seleccione operador o comando (+,-,*,/, F, A):");
                        c = entrada.readLine().toCharArray()[0];
                        System.out.println("Número 1: ");
                        long n1 = Integer.parseInt(entrada.readLine());
                        System.out.println("Número 2: ");
                        long n2 = Integer.parseInt(entrada.readLine());
                        salida.println(opera(c,n1,n2));
                        if (c=='F' || c=='A') {
                            break;
                        }
                    }catch (InputMismatchException ime){
                        System.out.println("Datos incorrectos");
                    }
                }
                if(c=='A'){
                    salida.close();
                    entrada.close();
                    socketCliente.close();
                    break;
                }
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }
            salida.close();
            entrada.close();
            socketCliente.close();
        }

        socketServidor.close();
    }

    private static long opera(char c, long n1, long n2) throws InputMismatchException {
        long resu = 0;
        switch(c){
            case '+': resu = n1+n2;break;
            case '-': resu = n1-n2;break;
            case '*': resu = n1*n2;break;
            case '/': resu = n1/n2;break;
            default:
                throw new InputMismatchException();
        }

        return resu;
    }
}
