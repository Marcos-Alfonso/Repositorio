import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ej7 {
    public static void main(String[] args) {
        try {
            File f = new File("primos.txt");
            f.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter("primos.txt"));
            int i = 0;
            int g = 0;
            while(i<20){
                if(esPrimo(g)) {
                    bw.write("\n"+g);
                    i++;
                }
                g++;
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean esPrimo(int numero) {

        if (numero == 0 || numero == 1 || numero == 4) {
            return false;
        }
        for (int x = 2; x < numero / 2; x++) {
            if (numero % x == 0)
                return false;
        }
        return true;
    }
}
