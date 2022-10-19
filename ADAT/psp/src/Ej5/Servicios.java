package Ej5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Servicios {
    public static void main(String[] args) {
        try {
            String line;
            //Primero ejecuto el comando tasklist
            Process p = Runtime.getRuntime().exec("tasklist");
            //Y ahora lo leo con un Buffered reader, parecido a como leeriamos un fichero de texto pero con el InptStream del proceso
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line); //Obtengo una línea del comando con readLine y la imprimo
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
