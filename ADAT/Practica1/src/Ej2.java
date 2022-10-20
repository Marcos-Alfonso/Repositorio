import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) throws IOException {
        /*
        Crea un programa que lea los primeros 54 bytes de un fichero BMP (su cabecera) y compruebe si los dos primeros
         bytes de esos 54 corresponden a las letras B y M.
        Si lo son, escribirá el mensaje “Parece un BMP válido”, si no es así, mostrará el mensaje "No es un BMP válido.
         */
        System.out.println("Inserte ruta de fichero.");
        Scanner sc = new Scanner(System.in);
        try{
            File f = new File(sc.nextLine());

            FileInputStream fis = new FileInputStream(f);
            byte[] bt = new byte[54];
            fis.read(bt);
            if(bt[0] == 'B' && bt[1] == 'M') System.out.println("Parece un BMP válido");
            else System.out.println("No es un BMP válido");

            fis.close();
        }catch(IOException ex){
            System.err.println("Ocurrió error durante la ejecución");
        }

    }
}
