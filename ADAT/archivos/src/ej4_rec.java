import java.io.File;
import java.util.Scanner;

public class ej4_rec {
    public static void main(String[] args) {

        System.out.println("Inserte ruta de directorio");
        Scanner sc = new Scanner(System.in);
        File f = new File(sc.nextLine());

        if(f.exists()){
            if( f.isDirectory()) {
                unfold(f, 0);
            }else{
                System.out.println("No directorio");
            }
        }else{
            System.out.println("Ruta no encontrada");
        }


    }
    private static void unfold(File f, int x){
        File[] array = f.listFiles();
        System.out.println(tab(x)+"----------\n"+tab(x)+"Directorio: "+f.getName()+" - Total de archivos: "+array.length);
        for (File i : array){
            if(i.isDirectory()) unfold(i, x+1);
            else System.out.println(tab(x)+"Nombre: "+i.getName());
        }
        System.out.println(tab(x)+"-------------");
    }
    private static String tab(int i){
        String s = "";
        for(int f = 0; f<i; f++){
            s+="\t";
        }
        return s;
    }
}
