package Ej5_1;

public class Main {
    public static void main(String[] args) {
        new Main().runProgram();
    }
    public void runProgram() {
        Puente p = new Puente();
        Escabadora e = new Escabadora();
        for (int i = 0; i < 7; i++) {
            Camion camion = new Camion("Camion"+(i+1), p, e);
            p.addRight(camion);
            camion.start();
        }

    }
}
