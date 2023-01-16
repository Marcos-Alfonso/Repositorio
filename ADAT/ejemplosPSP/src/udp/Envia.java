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
import java.net.InetAddress;

public class Envia {

    // Equipo remoto al que enviamos mensajes
    private static final String RECEIVER_HOST = "127.0.0.1"; // "localhost";
    // Ponemos el número de puerto en el que está escuchando el otro equipo
    private static final int RECEIVER_PORT = 9998;

    /**
     * Mensajes que se enviarán al servidor
     */
    private static final String[] cadenas = new String[]{
        "1. Escribo este mensaje",
        "2. para indicarte que me encuentro",
        "3. estupendamente.",
        "adios"
    };

    public static void main(String args[]) throws InterruptedException {
        int cont=0;
        try {
            InetAddress ipReceiverHost = InetAddress.getByName(RECEIVER_HOST);

            DatagramSocket udpSocket = new DatagramSocket();

            System.out.println("\nINICIAMOS");
            for (String message : cadenas) {
                
                byte[] buffer = message.getBytes();
                
                // Observad como va toda la información en Datagrama, al no haber
                // conexión se precisa indicar
                DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, ipReceiverHost, RECEIVER_PORT);
                System.out.println("Enviado: "+message);
                
                // ¿Que pasa si envíais y no hay nadie escuchando? (Recibe no esta operativo)
                
                udpSocket.send(datagram);

                Thread.sleep(cont*1000);
                cont++;
            }
            udpSocket.close();
        } // end try
        catch (IOException ex) {
            System.out.println("Error en la comunicación");
            ex.printStackTrace();
        }
        System.out.println("\nFIN ENVIO");
    }
}
