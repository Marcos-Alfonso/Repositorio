import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ej8 {
    public static void main(String[] args) {
        copyPaste("./NUEVODIR/2.txt", "./");
    }

    private static void copyPaste(String s, String d)  {

        File f1 = new File(s);
        File f2 = new File(d+f1.getName());
        try {
            f2.createNewFile();

            if(f1.exists() && f1.isFile()){
            /*
            try {
                Files.copy(f1.toPath(),
                (new File(f2.getPath() + f1.getName())).toPath(),
                        StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            */
                BufferedReader br = new BufferedReader(new FileReader(f1));
                BufferedWriter bw = new BufferedWriter(new FileWriter(f2));
                String line;
                while((line = br.readLine()) != null){
                    bw.write(line+"\n");
                }
                br.close();
                bw.close();

            }else{
                System.out.println("Ruta de archivo no encontrada");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

}
