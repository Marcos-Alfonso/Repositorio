import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int tablero[][] = {
                {0,6,0, 1,0,4, 0,5,0},
                {0,0,8, 3,0,5, 6,0,0},
                {2,0,0, 0,0,0, 0,0,1},

                {8,0,0, 4,0,7, 0,0,6},
                {0,0,6, 0,0,0, 3,0,0},
                {7,0,0, 9,0,1, 0,0,4},

                {5,0,0, 0,0,0, 0,0,2},
                {0,0,7, 2,0,6, 9,0,0},
                {0,4,0, 5,0,8, 0,7,0}};
        /*
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.print("\n");
        }
        */

    solve(tablero);
    }

    private static void solve(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if(tablero[i][j] == 0){
                    trySolve(tablero, i, j);
                }
            }
        }
    }

    private static void trySolve(int[][] tablero, int i, int j) {
        int [] row = tablero[i];
        int [] col = tablero[i];
        for (int k = 0; k < col.length; k++) {
            col[k] = tablero[k][j];
            System.out.println(col[k]);
        }

    }
}