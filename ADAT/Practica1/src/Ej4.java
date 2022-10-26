import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class Ej4 {
    public static void main(String[] args) throws IOException {

        try {
            URL url = new URL("https://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html");
            URLConnection conexion = url.openConnection();
            conexion.connect();

            InputStream is = conexion.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            char[] buffer = new char[1000];

            //ACA EMPIEZA MI CONDICIÓN DESDE ACÁ PODES CAMBIAR VOS
            String leido;
            String texto = "";
            boolean read = false;
            while ((leido = br.readLine()) != null) {
                    texto+=leido;
                    texto+=System.lineSeparator();
            }
            String [] rows = getRow(texto);
            String [] lines = getLineas(rows);

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

    private static String[] getLineas(String[] rows) {
        for(String s: rows){

            System.out.println("----------------------------");
            String[] lineas = s.split("td");
            for(String st: lineas){
                if(!st.contains("primera")){
                    String x = st.replaceAll(".*\\>|\\<.*", "");
                    //System.out.println(x);
                    st=x;
                }

            }
                /*
                if(!s.contains("primera")){
                    String x = s.replaceAll(".*\\>|\\<.*", "");
                    //System.out.println(x);
                    s=x;
                }
                System.out.println(s);
                */
        }
        return null;
    }

    private static String[] getRow(String texto) {
        String []tablas =texto.split("tbody");
        for(String t:tablas){
            if(t.contains("/mercados/cotizaciones/valores/acciona_M.ANA.html"))
                return t.split("tr");
        }
        return null;
    }
}
