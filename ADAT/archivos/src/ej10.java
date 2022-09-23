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

            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(array.length);
            dos.writeInt(array[0].length);
            System.out.println("Inserta los valores del array: ");
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
            DataInputStream dis = new DataInputStream(fis);
            Double[][] array = new Double[dis.readInt()][dis.readInt()];
            for(int i=0; i< array.length; i++) {
                for(int j=0; j< array[i].length; j++) {
                    array[i][j] = dis.readDouble();
                    System.out.print(array[i][j]+"\t");
                }
                System.out.println(" ");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {

        }
    }
}
