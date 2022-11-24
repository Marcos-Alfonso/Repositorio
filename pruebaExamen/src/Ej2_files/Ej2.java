package Ej2_files;

import java.io.*;

public class Ej2 {
    public static void main(String[] args) {
        File f=new File("bitmap.bmp");     //Creation of File Descriptor for input file
        FileReader fr= null;   //Creation of File Reader object
        try {
            fr = new FileReader(f);
            BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
            int c = br.read();
            System.out.println((char) c);
            c = br.read();
            System.out.println((char) c);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
