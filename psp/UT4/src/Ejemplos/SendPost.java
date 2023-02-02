/*
 * Uso de la clase URLConnetion para realizar una petición post a un servidor
   web y enviar datos en el cuerpo de la petición

   http://www.java2s.com/Code/Java/Network-Protocol/SendingaPOSTRequestUsingaURL.htm

    Para probar el programa copie el fichero "procesapost.php" en la ruta
    raiz del servidor web.


Ayuda:
https://docs.oracle.com/javase/7/docs/api/java/net/URLConnection.html

 */
package Ejemplos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *
 * @author santiago
 */
public class SendPost {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        /*
        El formato de los campos enviados en el cuerpo será
        campo1=valor1&campo2=valor2&....
        Las cadenas iran codificadas acorde a como esté definida la página/servicio
        que procese la petición
        */
        String data = "";
        data += URLEncoder.encode("Campo1", "UTF-8") + "=" + URLEncoder.encode("value1", "UTF-8");
        data += "&" + URLEncoder.encode("Campo2", "UTF-8") + "=" + URLEncoder.encode("value2", "UTF-8");

        // Se debería copiar el fichero "procesapost.php" en la ruta raiz de 
        // vuestro servidor
        URL url = new URL("http://localhost/procesapost.php");
        
        // Usamos la clase HttpURLConnection que hereda de la clase abstracta
        // URLConnection para poder usar el método "setRequestMethod". Aunque no 
        // es necesario, queda más claro
        HttpURLConnection  conn = (HttpURLConnection)  url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");

        // Introducimos los campos en el cuerpo de la petición
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
        wr.close();
        rd.close();
    }

}
