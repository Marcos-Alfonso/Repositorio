/*
  Comunicación con sockets y TCP
* http://www.it.uc3m.es/celeste/docencia/cr/2003/PracticaSocketsTCP/
 */
package consola2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author santiago
 */
public class Servidor implements Runnable {

    public static final int PORT = 4444;
    private ServerSocket socketServidor;
    private ServerFrame ventana;
    Socket socketCliente;
    BufferedReader entrada;
    PrintWriter salida;

    public Servidor(ServerFrame ventana) throws IOException {
        this.ventana = ventana;
        // Establece el puerto en el que escucha peticiones
        socketServidor = new ServerSocket(PORT);
        ventana.showMessage("Escuchando: " + socketServidor.toString());
    }

    public void run() {
        try {
            // Se bloquea hasta que recibe alguna petición de un cliente
            // abriendo un socket para el cliente
            socketCliente = socketServidor.accept();
            ventana.showMessage("Connexión acceptada: " + socketCliente.toString());
            // Establece canal de entrada
            entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            // Establece canal de salida
            salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true);

            // Hace eco de lo que le proporciona el cliente, hasta que recibe "Adios"
            while (true) {
                String str = entrada.readLine();
                ventana.showMessage("Cliente: " + str);
                // Hacemos echo de lo recibido para que lo lea el cliente
                salida.println("[Servidor]" + str);
                if (str.equals("Adios")) {
                    break;
                }
            }

            liberaRecursos();
            
            ventana.showMessage("** CONEXIÓN CERRADA **");
        } catch (IOException e) {
            ventana.showMessage("IOException: " + e.getMessage());
        }
    }

    public void liberaRecursos() throws IOException {
        salida.close();
        entrada.close();
        socketCliente.close();
        socketServidor.close();
    }

}
