package Ej1;

import java.io.*;

public class Ej1 {
    public static void main(String[] args) {
        for (String s:args) {
            File f = new File(s);
            try {

                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = "", total = "";
                while((line = br.readLine())!= null){
                    total += line;
                }
                System.out.println(f.getName()+"\nNº total de vocales: "+cuentaVocales(total));
                br.close();
            } catch (IOException e) {
                System.err.println("No se encuentra el archivo "+f.getName());
            }
        }
    }

    private static int cuentaVocales(String total) {
        int count = 0;
        for (char c :total.toLowerCase().toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' )count++;
        }
        return count;
    }
}
