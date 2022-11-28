package Ej4_2;


import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        new Main().runProgram();
    }
    public void runProgram() {
        SistemaDeRed sr = new SistemaDeRed();
        Semaphore s = new Semaphore(4);

        for (int i = 0; i < 26; i++) {
            Letra l = new Letra((char)('a'+i), sr, s);
            l.start();
        }
    }
}
