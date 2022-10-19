package Ej3;

import java.io.*;

public class Lanzador {

    final String CLASE_EJECUTAR="Cadenas";

    public static void main(String[] args) {
        try {
            System.out.println("RUTA: " + System.getProperty("user.dir"));
            Lanzador prog = new Lanzador();
            for(int i = 0; i < Integer.parseInt(args[0]); i++){
                prog.creaCad(args[1]); //
            }
            System.out.println("Finalizado programa principal");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void creaCad(String cad) throws IOException, InterruptedException {
        String[] command = {
                "java",
                "-classpath",
                ".\\out\\production\\psp",
                "Ejer3."+CLASE_EJECUTAR, cad};

        System.out.println("Ejecutando ... \n" + String.join(" ", command));
        ProcessBuilder pb = new ProcessBuilder(command);

        System.out.println("\nDirectorio trabajo: " + ".\\out\\production\\psp");
        pb.directory(new File(".\\out\\production\\psp"));

        System.out.println("Comando lanzado");
        Process process = pb.start();
        System.out.println("Esperando resultado ...");
        //quitando el waitFor se intercala la salida de los procesos

        //int errCode = process.waitFor();
        //System.out.println("Ejecutada aplicación. Código error (valor devuelto) = " + errCode);

        System.out.println("SALIDA:\n" + output(process.getInputStream()));
    }

    private static String output(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + System.getProperty("line.separator"));
            }
        } finally{
            br.close();
        }
        return sb.toString();
    }
}
