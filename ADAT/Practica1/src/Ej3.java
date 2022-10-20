import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej3 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int check = 0;
        do{
            System.out.println("M E N U\n" +
                    "---------------------\n" +
                    "   1- Introducir datos \n" +
                    "   2- Borrar un departamento \n" +
                    "   3- Consultar un departamento  \n" +
                    "   4- Ver fichero\n" +
                    "   5- Salir");
            try{
                check = sc.nextInt();
            }catch (InputMismatchException ex){

            }
            switch (check){
                case 1:
                    nuevoDepartamento();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
            }

        }while(check!=5);
    }

    private static void nuevoDepartamento() {
        try{
            System.out.println("Inserte id del nuevo departamento: ");
            int id =sc.nextInt();
            System.out.println("Inserte nombre del nuevo departamento: ");
            String nombre  =sc.nextLine();
            System.out.println("Inserte nombre del nuevo departamento: ");
            Double presupuesto  =sc.nextDouble();
        }catch (InputMismatchException ex){

        }

    }
}
