import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ej8 {
    public static void main(String[] args) {
        copyPaste("NUEVODIR/2.txt", ".");
    }

    private static void copyPaste(String s, String d)  {
        File f1 = new File(s);
        File f2 = new File(d);
        if(f1.exists() && f1.isFile() && f2.isDirectory()){
            try {
                Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
