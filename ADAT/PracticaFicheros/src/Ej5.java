import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej5 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int in = 1;
        while (in != 0){
            try{
                System.out.println("1-Grabar Cotizaciones Actuales." +
                        "\n2-Ver Fichero." +
                        "\n3-Ver cotizaciones (fecha/hora)." +
                        "\n0-Salir");
                in = sc.nextInt();
                switch (in){
                    case 1:
                        Cotizacion.GrabarCotizacion();
                        System.out.println("Grabación realizada");
                        break;
                    case 2:
                        Cotizacion.LeerCotizacion();
                        break;
                    case 3:
                        System.out.println("Introduce fecha: (dd/MM/yyyy)");
                        sc.nextLine();
                        String f = sc.nextLine();
                        System.out.println("Introduce hora: (mm/hh)");
                        Cotizacion.VerCotizacion(f,sc.nextLine());
                        break;
                    default:

                }
            }catch (InputMismatchException ime){
                sc.nextLine();
            }

        }


    }

}
