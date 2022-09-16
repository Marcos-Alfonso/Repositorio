import java.io.File;
import java.util.Scanner;

public class ej2 {
    public static void main(String[] args)
    {
        System.out.println("Inserte ruta de directorio");
        Scanner sc = new Scanner(System.in);
        File f = new File(sc.nextLine());

        if(f.exists()){

        }else{
            System.out.println("Ruta no encontrada");
        }


    }
}