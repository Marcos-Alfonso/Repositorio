/**
 *
 * Ejemplo de DatagramPacket y DatagramSocket
 * http://java-net-by-fabriccio.blogspot.com/2011/07/ejemplo-de-datagrampacket-y.html
 *
 * El siguiente código utiliza sockets datagrama para intercambiar una única cadena
 * de datos. La lógica del programa es lo más sencilla posible para subrayar la
 * sintáxis básica de las comunicaciones entre procesos. El emisor crea un paquete
 * datagrama que contiene una dirección de destino, mientras que el paquete
 * datagrama del receptor no incluye una dirección de destino.
 *
 * ejemplo de envio de mensaje entre un cliente y un servidor utilizando
 * el protocolo de transporte UDP
 *
 * Recordad: no se establece una "conexión" entre el cliente y el servidor
 */
package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Recibe {

    private static final int RECEIVER_PORT = 9998;

    // Tamaño máximo que tendrá el paquete que recibamos
    private static final int MAX_LEN = 2048;

    public static void main(String args[]) {
        System.out.println("\nINICIO ESCUCHA\n");

        try {
            String message;
            DatagramSocket mySocket = new DatagramSocket(RECEIVER_PORT);
            byte[] buffer = new byte[MAX_LEN];
            DatagramPacket datagram = new DatagramPacket(buffer, MAX_LEN);
            do {
                // Esperamos la recepción de algún mensaje
                mySocket.receive(datagram);
                message = new String(buffer);
                System.out.println("Recibido: " + message);
            } while (!message.equals("adios"));
            mySocket.close();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.\r\n" + e.getMessage());
        }
        System.out.println("\nFIN ESCUCHA\n");
    }
}
