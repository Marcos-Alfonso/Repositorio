package Ej1_2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Recibe {
    private static final int PORT = 10001;
    private static final int MAX_LENGTH = 2048;
    public static void main(String[] args) {
        try{
            String mensaje;
            DatagramSocket ds = new DatagramSocket(PORT);
            byte[] buffer = new byte[MAX_LENGTH];
            DatagramPacket datagram = new DatagramPacket(buffer, MAX_LENGTH);
        }catch (Exception e){

        }
    }
}
