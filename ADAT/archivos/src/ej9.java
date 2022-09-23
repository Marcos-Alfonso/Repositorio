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
            DataOutputStream dos = new DataOutputStream(fos);
            while(true){
                dos.writeInt(sc.nextInt());
            }

        }catch (InputMismatchException e){
            System.out.println("Fin del programa");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileInputStream fis = new FileInputStream(new File("direc/datos.dat"));
            DataInputStream dis =new DataInputStream(fis);
            /*
            int i;
            while ((i = dis.readInt())!=-1) {

                System.out.println(i);
            }
        */
            while (true) {
                System.out.println(dis.readInt());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {

        }


    }
}
