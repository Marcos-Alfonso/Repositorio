package Ej5;

import java.io.*;
import java.net.Socket;

public class Jugador {
     DataInputStream entrada;
     DataOutputStream salida;

     Socket socket;
    public Jugador(Socket socketJugador) {
        try {
            socket = socketJugador;
            entrada = new DataInputStream(new BufferedInputStream(socketJugador.getInputStream()));
            salida = new DataOutputStream(new BufferedOutputStream(socketJugador.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
