package Ej3;

import java.util.Random;
import java.util.Scanner;

public class Cadenas {
    public static void main(String[] args) {
        for (int i = 0; i < Integer.parseInt(args[0]); i++){

            System.out.println(generaCadena());

        }
    }

    private static String generaCadena() {
        String s = "";
        for (int i = 0; i < (new Random().nextInt(1,20)); i++) {
            s += rndChar();
        }
        return s;
    }
    private static char rndChar () {
        int rnd = (int) (Math.random() * 52);
        //determino si el carácter va a ser mayúscula o minúscula
        char base = (rnd < 26) ? 'A' : 'a';
        return (char) (base + rnd % 26);

    }
}
