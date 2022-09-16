import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Inserte ruta de directorio");
        Scanner sc = new Scanner(System.in);
        File f = new File(sc.nextLine());

        if(f.exists()){
            if( f.isDirectory()) {
                File[] array = f.listFiles();
                System.out.println("Total de archivos: "+array.length+"\n----------");
                for (File i : array){
                    System.out.println("Nombre: "+i.getName());
                    if(i.isDirectory()) System.out.println("Directorio");
                    else System.out.println("Archivo");
                    System.out.println("-----------------");
                }
            }else{
                System.out.println("No directorio");
            }
        }else{
            System.out.println("Ruta no encontrada");
        }


    }
}