import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ej10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte valores de  fila y columnas: ");
        try{
            Double[][] array = new Double[sc.nextInt()][sc.nextInt()];
            File f = new File("direc/array.dat");
            FileOutputStream fos = new FileOutputStream(f);
             fos.write(array.length);
             fos.write(array[0].length);
            DataOutputStream dos = new DataOutputStream(fos);

            for(int i=0; i< array.length; i++) {
                for(int j=0; j< array[i].length; j++) {
                    array[i][j] = sc.nextDouble();
                }
            }
            for(int i=0; i< array.length; i++) {
                for(int j=0; j< array[i].length; j++) {
                    dos.writeDouble(array[i][j]);
                }
            }
        fos.close();
        dos.close();
        printArray();
        } catch (InputMismatchException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void printArray() {
        try {
            FileInputStream fis = new FileInputStream(new File("direc/array.dat"));
            int i;
            while ((i = fis.read())!=-1) {
                System.out.println(i);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {

        }
    }
}
