import org.json.*;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class Ej3 {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://www.aemet.es/documentos_d/eltiempo/prediccion/avisos/rss/CAP_AFAE_wah_RSS.xml");
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

        try {
            System.out.println(xmlStringToJSONString(texto, 4));
        } catch (JSONException je) {
            System.out.println(je.toString());
        }

    }
    public static String xmlStringToJSONString(String xmlString, int indentFactor) {
        JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
        String string = xmlJSONObj.toString(indentFactor);
        return string;
    }
}
