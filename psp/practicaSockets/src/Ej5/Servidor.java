package Ej5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static final int PORT = 4444;


    public static void main(String[] args) throws IOException {
        // Establece el puerto en el que escucha peticiones
        try {
            ServerSocket socketServidor = new ServerSocket(PORT);
            System.out.println("Escuchando peticiones en puerto: "+socketServidor.getLocalPort());
            while (true){
                Socket socketJugador1 = socketServidor.accept();
                System.out.println("Jugador 1 conectado: "+socketJugador1.getPort());
                Socket socketJugador2 = socketServidor.accept();
                System.out.println("Jugador 2 conectado: "+socketJugador2.getPort());
                Partida p = new Partida(socketJugador1, socketJugador2);
                System.out.println("Iniciando Partida entra jugadores "+socketJugador1.getPort()+" : "+socketJugador2.getPort());
                // Lanzar Thread
                p.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
