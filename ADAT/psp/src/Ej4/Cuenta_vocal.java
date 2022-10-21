package Ej4;

import java.io.*;
import java.lang.ProcessBuilder.Redirect;

public class Cuenta_vocal {
    static final String CLASE1_EJECUTAR="Cadenas2";
    static final String CLASE2_EJECUTAR="Frecuencia2";

    public static void main(String[] args) {
        try {
            System.out.println("RUTA: " + System.getProperty("user.dir"));//ruta del directorio en el que estamos trabajando
            //Creamos la misma clase en la que estamos
            Cuenta_vocal prog = new Cuenta_vocal();
            //llama al generar cadena con el número introducido por argumento
            System.out.println("----------------------------------------------------------------");
            prog.creaCad(args[1]);
            System.out.println("----------------------------------------------------------------");
            //Ya ha creado la cadena
            System.out.println("Finalizado programa principal");
            leeVocal(args[0].charAt(0));//llama al leer vocal donde coge el primer argumento que es una vocal
        } catch (Exception e) {
            e.printStackTrace();//si da una excepción, da que funciona
        }
    }
    public void creaCad(String ncad) throws IOException,
            InterruptedException {
        String[] command = {
                "java",
                "-classpath",
                "E:\\Repositorio\\Repositorio\\ADAT\\psp\\out\\production\\psp",
                "Ej4." + CLASE1_EJECUTAR, ncad //si hay argumentos porque tiene que ver qué número de cadenas mete el usuario por argumentos.
        };

        File f = new File("Cuenta_vocal.txt");
        f.createNewFile();

        System.out.println("Ejecutando ... \n" + String.join(" ", command));
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectOutput(f); //Redireccionamos la salida estándar al archivo que acabas de crear

        System.out.println("\nDirectorio trabajo: " + "C:\\Users\\Marina\\Documents\\GitHub\\22_23\\AccDatos\\PSP\\T01\\T01\\EjerciciosPractica01\\EjerciciosPractica01\\out\\production\\EjerciciosPractica01");
        pb.directory(new File("E:\\Repositorio\\Repositorio\\ADAT\\psp\\out\\production\\psp"));

        System.out.println("Comando lanzado");
        Process process = pb.start();
        System.out.println("Esperando resultado ...");
        int errCode = process.waitFor();
        System.out.println("Ejecutada aplicación. Código error (valor devuelto) = " + errCode);

    }
    public static void leeVocal(char vocal) throws IOException,
            InterruptedException {
        //generamos el comando para que inicie la clase que se encuentra en la ubicación de la ruta especificada (ejecuta FrecuenciaV_2)
        String[] command = {
                "java",
                "-classpath",
                "E:\\Repositorio\\Repositorio\\ADAT\\psp\\out\\production\\psp",
                "Ej4." + CLASE2_EJECUTAR //no hay argumentos
        };

        System.out.println("Ejecutando ... \n" + String.join(" ", command));
        //crea el proceso con el comando que hemos metido antes
        ProcessBuilder pb = new ProcessBuilder(command);
        //Leer el archivo que se ha creado con anterioridad. (generado por cadenas_v2)
        File arc = new File("Cuenta_vocal.txt");
        pb.redirectInput(Redirect.from(arc));//reedireccionamos la entrada estándar hacia el archivo

        System.out.println("\nDirectorio trabajo: " + "C:\\Users\\Marina\\Documents\\GitHub\\22_23\\AccDatos\\PSP\\T01\\T01\\EjerciciosPractica01\\EjerciciosPractica01\\out\\production\\EjerciciosPractica01");
        //asignamos el directorio de trabajo al proceso
        pb.directory(new File("E:\\Repositorio\\Repositorio\\ADAT\\psp\\out\\production\\psp"));

        System.out.println("Comando lanzado");
        Process process = pb.start(); //empieza el proceso con el .start
        System.out.println("Esperando resultado ...");
        int errCode = process.waitFor(); //espera mientras que termina el proceso ejecutado anteriormente. (Para que no se mezclen los procesos)
        System.out.println("Ejecutada aplicación. Código error (valor devuelto) = " + errCode); //Salta eso si hay algún error.

        String[] parts = output(process.getInputStream()).split("\n"); //En cada posición del array se guarda una cadena hasta que llega al salto de línea
        switch (vocal) {
            case 'a':
                System.out.println("Frecuencia de " + parts[0]);
                break;
            case 'e':
                System.out.println("Frecuencia de " + parts[1]);
                break;
            case 'i':
                System.out.println("Frecuencia de " + parts[2]);
                break;
            case 'o':
                System.out.println("Frecuencia de " + parts[3]);
                break;
            case 'u':
                System.out.println("Frecuencia de " + parts[4]);
                break;
        }
        FileReader fr = new FileReader(arc); //Indicamos la operación de lectura del archivo
        BufferedReader br = new BufferedReader(fr); //lee el archivo
        String linea;
        while ((linea = br.readLine()) != null) //MIentras que línea no sea nula...
            System.out.println(linea);//y lo muestra por pantalla
    }

    private static String output(InputStream inputStream) throws IOException { //coge la salida y lo pone en un String
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + System.getProperty("line.separator"));
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }
}
