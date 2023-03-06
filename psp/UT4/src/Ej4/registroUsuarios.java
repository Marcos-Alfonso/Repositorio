package Ej4;

import org.jsoup.helper.HttpConnection;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.net.http.HttpResponse;

public class registroUsuarios {

    private static final String NOMBRE = "Marcos";
    private static final String APELLIDO = "Alfonso";
    public static void main(String[] args) {
        char c = 'A';
        for (int i = 0; i < 20; i++) {
            try {
                resgistraUsuario((char) (c+i));
            } catch (IOException e) {
                System.err.println("Error al registrar usuario: "+NOMBRE+APELLIDO+" "+c);
            }
        }
    }

    private static void resgistraUsuario(char c) throws IOException {

        System.out.println("Registrando usuario: "+NOMBRE+APELLIDO+" "+c);
        URL url = new URL("https://ieslamarisma.net/prof/santi/psput4_login/register.php");
        HttpURLConnection conn = (HttpURLConnection)  url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(cadenaPost(c));
        wr.flush();
        System.out.println("Respuesta del servidor: "+conn.getResponseMessage()+" "+conn.getResponseCode());

    }

    private static String cadenaPost(char letra) {

        StringBuilder sb = new StringBuilder(APELLIDO);
        sb.setLength(3);
        String usuario = NOMBRE + " " + sb.toString() + " " + letra;
        String correo = NOMBRE + "_" + letra + "@dam2.ieslamarisma.net";
        String clave = NOMBRE + letra;
        //nos aseguramos de que la clave tiene mas de 6 caracteres, en caso de que tenga menos de 6
        while (clave.length() < 6) {
            clave += "_";
        }

        String cadenaPost = "";
        try {
            cadenaPost += URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(usuario, "UTF-8");
            cadenaPost += "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(correo, "UTF-8");
            cadenaPost += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(clave, "UTF-8");
            cadenaPost += "&" + URLEncoder.encode("cpassword", "UTF-8") + "=" + URLEncoder.encode(clave, "UTF-8");
            cadenaPost += "&" + URLEncoder.encode("terminosycond", "UTF-8") + "=" + URLEncoder.encode("on", "UTF-8");
            cadenaPost += "&" + URLEncoder.encode("signup", "UTF-8") + "=" + URLEncoder.encode("Registrar", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return cadenaPost;
    }
}
