package Ej5;


import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class Partida extends Thread{
    //sockets jugadores
    Jugador j1 ;
    Jugador j2;
    String[][] tablero = new String[8][8];
    public Partida(Socket socketJugador1, Socket socketJugador2) {
         j1 = new Jugador(socketJugador1);
         j2 = new Jugador(socketJugador2);
         initTablero();
    }
    boolean continua = true;
    public void run(){
        try {
            j1.salida.writeUTF("J1");
            j1.salida.flush();
            j2.salida.writeUTF("J2");
            j2.salida.flush();
            enviaAmbos(getTableroString(tablero));

            while(continua){
                movimiento(j1);
                valida();
                if(!continua)break;
                movimiento(j2);
                valida();
            }
        } catch (IOException e) {
            System.err.println("Error en la partida: "+j1.socket.getPort()+":"+j2.socket.getPort());
            //nuevo
            try{
                j1.salida.writeUTF("J1");
                j1.salida.writeUTF("J1");
                j1.salida.flush();
            }catch (IOException ex){}
            try{
                j2.salida.writeUTF("J2");
                j2.salida.writeUTF("J2");
                j2.salida.flush();
            }catch (IOException ex){}
        }
    }

    private void valida() throws IOException {
        enviaAmbos(getTableroString(tablero));
        if(!tableroTiene("1K")){
            enviaAmbos("J2");
            System.out.println("Partida Finalizada, Ganador: "+j2.socket.getPort());
            finaliza();
        } else if (!tableroTiene("2K")) {
            enviaAmbos("J1");
            System.out.println("Partida Finalizada, Ganador: "+j1.socket.getPort());
            finaliza();
        }else{
            enviaAmbos("cont");
        }
    }

    private void finaliza() throws IOException {
        //enviaAmbos(getTableroString(tablero));
        continua = false;
    }

    private boolean tableroTiene(String s) {
        List<String[]> list = Arrays.asList(tablero);
        for(String[] arr: list){
            if(Arrays.asList(arr).contains(s))
                return true;
        }
        return false;
    }

    private void movimiento(Jugador j) throws IOException {
        int oldX = j.entrada.readInt();
        int oldY = j.entrada.readInt();
        int newX = j.entrada.readInt();
        int newY = j.entrada.readInt();
        mueve(oldX, oldY, newX, newY);

    }

    private void enviaAmbos(String mensaje) throws IOException {
        j1.salida.writeUTF(mensaje);
        j1.salida.flush();
        j2.salida.writeUTF(mensaje);
        j2.salida.flush();
    }

    private void mueve(int oldX, int oldY, int newX, int newY){
        tablero[newY][newX] = tablero[oldY][oldX];
        tablero[oldY][oldX] = "  ";
    }
    private  void initTablero(){
        for (int i = 0; i <tablero.length ; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = "  ";
            }
        }
        tablero[0][0] = tablero[0][7]  = "1T";
        tablero[7][0] = tablero[7][7] = "2T";

        tablero[0][1] = tablero[0][6]  = "1C";
        tablero[7][1] = tablero[7][6] = "2C";

        tablero[0][2] = tablero[0][5]  = "1A";
        tablero[7][2] = tablero[7][5] = "2A";

        tablero[0][3] = "1Q";
        tablero[0][4] = "1K";

        tablero[7][3] = "2Q";
        tablero[7][4] = "2K";

        tablero[1][0] = tablero[1][1] = tablero[1][2] = tablero[1][3] = tablero[1][4] = tablero[1][5] = tablero[1][6] = tablero[1][7] = "1P";
        tablero[6][0] = tablero[6][1] = tablero[6][2] = tablero[6][3] = tablero[6][4] = tablero[6][5] = tablero[6][6] = tablero[6][7] = "2P";
    }
    private String getTableroString(String[][] t){
        String cadena = "    0    1    2    3    4    5    6    7\n  ┌────┬────┬────┬────┬────┬────┬────┬────┐\n";
        for (int i = 0; i < t.length; i++) {
            cadena+= i+"-│ "+t[i][0]+" │ "+t[i][1]+" │ "+t[i][2]+" │ "+t[i][3]+" │ "+t[i][4]+" │ "+t[i][5]+" │ "+t[i][6]+" │ "+t[i][7]+" │\n";
            if (i< t.length-1){
                cadena+="  ├────┼────┼────┼────┼────┼────┼────┼────┤\n";
            }
        }
        cadena += "  └────┴────┴────┴────┴────┴────┴────┴────┘";
        return cadena;
    }

}

