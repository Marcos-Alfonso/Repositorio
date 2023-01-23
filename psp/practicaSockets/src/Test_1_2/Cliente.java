package Test_1_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {
    public static final int PORT = 4444;
    public static final String ADDRESS = "127.0.0.1";

    private static void enviar(DatagramSocket socket, char caracter) throws IOException {
        byte[] caracterBytes = ByteBuffer.allocate(Character.BYTES).putChar(caracter).array();

        InetAddress ia = InetAddress.getByName(ADDRESS);

        DatagramPacket paquete = new DatagramPacket(caracterBytes, caracterBytes.length, ia, PORT);
        socket.send(paquete);
    }
    private static void enviar(DatagramSocket socket, long numero) throws IOException {
        byte[] numeroBytes = ByteBuffer.allocate(Long.BYTES).putLong(numero).array();
        DatagramPacket paquete = new DatagramPacket(numeroBytes, numeroBytes.length);
        socket.send(paquete);
    }
    private static String recibir(DatagramSocket socket) throws IOException {
        DatagramPacket paqueteOperacion = new DatagramPacket(new byte[64], 64);

        socket.receive(paqueteOperacion);
        System.out.println("e");
        String operacion = new String(paqueteOperacion.getData(), 0, paqueteOperacion.getLength());
        return operacion;
    }

    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getByName(ADDRESS);
            DatagramSocket ds = new DatagramSocket();
            //ds.connect(ia, PORT);

            Scanner sc = new Scanner(System.in);

            System.out.println("- Cliente Operaciones matemáticas -");
            while (true) {

                // Leo la entrada del usuario
                System.out.println("Seleccione operador o comando (+,-,*,/, F, A): ");
                char c  = sc.nextLine().charAt(0);
                if(c!='+'&&c!='-'&&c!='*'&&c!='/'&&c!='F'&&c!='A'){
                    throw new InputMismatchException();
                }
                enviar(ds, c);
                String respuesta = recibir(ds);
                System.out.println("recibo"+respuesta);

            }
        } // end try
        catch (IOException ex) {
            System.out.println("Error en la comunicación");
            ex.printStackTrace();
        }
    }
}
