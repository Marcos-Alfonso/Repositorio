import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class Ej4 {
    public static void main(String[] args) {

        try {
            URL url = new URL("http://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html?ci%d=SEM23201");
            URLConnection conexion = url.openConnection();
            conexion.connect();

            //Lectura
            InputStream is = conexion.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            char[] buffer = new char[1000];

            //ACA EMPIEZA MI CONDICIÓN DESDE ACÁ PODES CAMBIAR VOS
            int leido;
            String texto = "";
            while ((leido = br.read(buffer)) > 0) {
                String datos = new String(buffer, 0, leido);
                texto += datos;
            }
            System.out.println(texto);

        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
