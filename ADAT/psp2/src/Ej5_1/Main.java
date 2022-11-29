package Ej5_1;

public class Main {
    public static final int N_CAMIONES = 7;
    public static void main(String[] args) {
        new Main().runProgram();
    }
    public void runProgram() {
        Puente p = new Puente();
        Escabadora e = new Escabadora();
        for (int i = 0; i < N_CAMIONES; i++) {
            Camion camion = new Camion("Camion"+(i+1), p, e);
            p.addRight(camion);
            camion.start();
        }

    }
}
