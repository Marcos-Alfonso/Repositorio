import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ej5 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("NUEVODIR/file1.txt"));
        String line;
        while((line = reader.readLine()) != null)
            System.out.println(line);
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra fiechero");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
