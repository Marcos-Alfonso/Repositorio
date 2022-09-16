import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ej3 {
    public static void main(String[] args) {
        new File("NUEVODIR").mkdirs();

        try {
            File f1 =new File("NUEVODIR/1.txt");
            f1.createNewFile();
            File f2 =new File("NUEVODIR/2.txt");
            f2.createNewFile();

            f1.renameTo(new File("NUEVODIR/file1.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
