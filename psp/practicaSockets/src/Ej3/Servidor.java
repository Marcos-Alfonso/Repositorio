package Ej3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static final int PORT = 4444;

    public static void main(String[] args) throws IOException {


        // Establece el puerto en el que escucha peticiones
        try {
            ServerSocket socketServidor = new ServerSocket(PORT);
            while (true){
                Socket socketCliente = socketServidor.accept();
                ConexionCliente conexion = new ConexionCliente(socketCliente);
                // Lanzar Thread
                conexion.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void finaliza(){
        System.exit(-1);

    }

}
