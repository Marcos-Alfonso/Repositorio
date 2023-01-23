package Ej5;

import java.util.Scanner;

public class chess {
    static String[][] tablero = new String[8][8];
    public static void main(String[] args) {
        initTablero();
        System.out.println(getTableroString(tablero));
    }

    private static void initTablero(){
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
    private static String getTableroString(String[][] t){
        String cadena = "   0  1  2  3  4  5  6  7\n  ┌──┬──┬──┬──┬──┬──┬──┬──┐\n";
        for (int i = 0; i < tablero.length; i++) {
            cadena+= i+"-├"+t[i][0]+"┼"+t[i][1]+"┼"+t[i][2]+"┼"+t[i][3]+"┼"+t[i][4]+"┼"+t[i][5]+"┼"+t[i][6]+"┼"+t[i][7]+"┤\n";
            if (i< tablero.length-1){
                cadena+="  ├──┼──┼──┼──┼──┼──┼──┼──┤\n";
            }
        }
        cadena += "  └──┴──┴──┴──┴──┴──┴──┴──┘";
        return cadena;
    }
}
