import java.io.*;
import java.nio.Buffer;

public class ej13 {
    public static void main(String[] args) {
/*
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
      */
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("img/foto.png")));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("NUEVODIR/copy.png")));

            String line;
            while((line = br.readLine()) != null){
                bw.write(line+"\n");
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
