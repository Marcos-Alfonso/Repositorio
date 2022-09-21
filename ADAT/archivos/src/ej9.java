import javax.imageio.stream.FileImageInputStream;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ej9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte numeros enteros, escriba un caracter para finalizar");
        try {
            File f = new File("direc/datos.dat");
            FileOutputStream fos = new FileOutputStream(f);

            while(true){
                fos.write(sc.nextInt());
            }
        }catch (InputMismatchException e){
            System.out.println("Fin del programa");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        try {
            FileInputStream fis = new FileInputStream(new File("direc/datos.dat"));
            int i;
            while ((i = fis.read())!=-1) {
                System.out.println(i);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {

        }
         */

    }
}
