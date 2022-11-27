package Ej4;


import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main().runProgram();
    }
    public void runProgram() {
        SistemaDeRed sr = new SistemaDeRed();


        for (int i = 0; i < 26; i++) {
            Letra l = new Letra((char)('a'+i), sr);
            l.start();
        }

    }
}
