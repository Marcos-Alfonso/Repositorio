package Test_1_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class Servidor {
    public static final int PORT = 4444;
    public static final String ADDRESS = "127.0.0.1";

    public static void main(String[] args) {


        try {
            DatagramSocket ds = new DatagramSocket();
            InetAddress ip = InetAddress.getByName(ADDRESS);
            //socketServidor.connect(ip, PORT);

            char c = recibir(ds);
            System.out.println("Recibe: "+c);
            enviar(ds,"Soria del ano");
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static char recibir(DatagramSocket socket) throws IOException {
        DatagramPacket paquete = new DatagramPacket(new byte[Character.BYTES], Character.BYTES);
        socket.receive(paquete);
        char caracter = ByteBuffer.wrap(paquete.getData()).getChar();
        return caracter;
    }
    private static void enviar(DatagramSocket socket, String cadena) throws IOException {
        byte[] cadenaBytes = cadena.getBytes();

        InetAddress ip = InetAddress.getByName(ADDRESS);
        DatagramPacket paquete = new DatagramPacket(cadenaBytes, cadenaBytes.length, ip, PORT);
        socket.send(paquete);
    }
}
