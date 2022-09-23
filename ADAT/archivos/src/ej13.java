import java.io.*;

public class ej13 {
    public static void main(String[] args) {

        InputStream is = null;
        OutputStream os = null;
        try {
                is = new FileInputStream(new File("img/foto.png"));

            os = new FileOutputStream(new File("NUEVODIR/copy.png"));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
