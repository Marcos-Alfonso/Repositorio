import java.io.File;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        /*
        Crea un programa que lea los primeros 54 bytes de un fichero BMP (su cabecera) y compruebe si los dos primeros
         bytes de esos 54 corresponden a las letras B y M.
        Si lo son, escribirá el mensaje “Parece un BMP válido”, si no es así, mostrará el mensaje "No es un BMP válido.
         */
        System.out.println("Inserte ruta de fichero.");
        Scanner sc = new Scanner(System.in);
        File f = new File(sc.nextLine());

    }
}
