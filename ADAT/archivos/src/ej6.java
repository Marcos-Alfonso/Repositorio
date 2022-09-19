import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ej6 {
    public static void main(String[] args) {
        try {
            File f = new File("numNaturales.txt");
            f.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter("numNaturales.txt"));
            for(int i = 0; i<100; i++){
                bw.write("\n"+i);
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
