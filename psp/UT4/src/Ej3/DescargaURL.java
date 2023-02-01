package Ej3;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class DescargaURL {
    public static void main(String[] args) {
        String contenido;
        try {
            contenido = getHTML(args[0]);
            crearFichero(contenido, args[1]);
        } catch (IOException | IndexOutOfBoundsException e) {
            System.err.println("Error en la creación del fichero.");
        }
    }

    private static void crearFichero(String contenido, String fichero) throws IOException {
        File f = new File(fichero);
        f.createNewFile();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fichero, true)));
        out.println(contenido);
        out.close();
        System.out.println("Fichero "+fichero+" creado.");
    }

    private static String getHTML(String arg) throws IOException {
            URL url = new URL(arg);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            conexion.connect();
            System.out.println("Código HTTP de respuesta: "+conexion.getResponseCode());

            InputStream is = conexion.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String leido;
            String texto = "";
            while ((leido = br.readLine()) != null) {
                texto += leido;
                texto += System.lineSeparator();
            }
            return texto;
    }
}