/*
  Comunicación con sockets y TCP
  http://www.it.uc3m.es/celeste/docencia/cr/2003/PracticaSocketsTCP/
 */
package consola2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santiago
 */
public class Cliente {

    public static final int PORT = 4444;
    public static final String SERVER = "127.0.0.1";

    Socket socketCliente;
    BufferedReader recibe;
    PrintWriter envia;

    public Cliente() throws IOException {
        // Creamos un socket en el lado cliente, enlazado con un
        // servidor que está en la misma máquina que el cliente
        // y que escucha en el puerto 4444
        socketCliente = new Socket(SERVER, PORT);
        // Obtenemos el canal de entrada
        recibe = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
        // Obtenemos el canal de salida
        envia = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true);
    }

    public String send(String msg) throws IOException {
        // La envia al servidor
        envia.println(msg);
        // Envía a la salida estándar la respuesta del servidor
        msg = recibe.readLine();
        return msg;
    }

    public void liberaRecursos() {
        envia.close();
        try {
            recibe.close();
            // Cierro socket
            socketCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
