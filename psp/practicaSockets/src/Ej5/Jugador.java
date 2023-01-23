package Ej5;

import java.io.*;
import java.net.Socket;

public class Jugador {
     DataInputStream entrada;
     DataOutputStream salida;

    public Jugador(Socket socketJugador) {
        try {
            entrada = new DataInputStream(new BufferedInputStream(socketJugador.getInputStream()));

            salida = new DataOutputStream(new BufferedOutputStream(socketJugador.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
