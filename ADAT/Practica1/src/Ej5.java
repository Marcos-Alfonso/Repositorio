import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Ej5 {
    static HashMap<String, String> cotizaciones = new HashMap<String, String>();
    public static void main(String[] args) throws IOException {

        try {
            URL url = new URL("https://www.expansion.com/mercados/cotizaciones/indices/ibex35_I.IB.html");
            URLConnection conexion = url.openConnection();
            conexion.connect();

            InputStream is = conexion.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            char[] buffer = new char[1000];

            String leido;
            String texto = "";
            boolean read = false;
            while ((leido = br.readLine()) != null) {
                texto+=leido;
                texto+=System.lineSeparator();
            }
            String [] rows = getRow(texto);
            rellenaHash( rows);

            for(String key : cotizaciones.keySet()) {
                String[]values = cotizaciones.get(key).split("-");
                Cotizacion c = new Cotizacion(key, values[0], values[1], values[2]);
                c.GrabarCotizacion();
            }
            Cotizacion.LeerCotizacion();
        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
    private static String[] rellenaHash(String[] rows) {
        for(String s: rows){
            String[] lineas = s.split("td");
            try{
                //obtengo de forma limpia el nombre

                String nombre = lineas[1].substring(lineas[1].indexOf("title")+7);
                nombre = nombre.substring(0, nombre.indexOf("\""));

                //obtengo la fecha de hoy con un formato específico
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDateTime now = LocalDateTime.now();
                String fecha = dtf.format(now);

                //obtengo tanto el valor de cotización como la hora de esta misma.
                String valor = lineas[3].replaceAll(".*\\>|\\<.*", "");
                String hora = lineas[19].replaceAll(".*\\>|\\<.*", "");

                cotizaciones.put(nombre, fecha+"-"+hora+"-"+valor);
            }catch(Exception e){// por tema de html había rows que estaban vacías, al intentar acceder a un idex de la mismada error y no introduce nada en el HashMap

            }
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
