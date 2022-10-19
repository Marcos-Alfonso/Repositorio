package Ej3;

import java.util.Random;
import java.util.Scanner;

public class Cadenas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCadenas = sc.nextInt();
        for (int i = 0; i < nCadenas; i++) {
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
