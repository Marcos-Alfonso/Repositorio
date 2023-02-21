package Ej1;

import org.apache.commons.net.ftp.*;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ClienteFTP {
    private static FTPClient ftp = new FTPClient();
    private static final String SERVER = "ftp.rediris.es";
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            boolean conexion = iniciarConexion();

            if(conexion){

                ftp.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
                ftp.setFileTransferMode(FTP.BINARY_FILE_TYPE);
                ftp.enterLocalPassiveMode();

                System.out.println("\nArchivos y Carptetas de " + ftp.printWorkingDirectory());
                printArchivos( ftp.listFiles(), ftp.printWorkingDirectory(), 0);
                controlMenu();
            }else {
                System.err.println("No se puede acceder a conexión. Codigo de Error: "+ftp.getReplyCode());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void controlMenu() throws IOException {
        int c;
        do {
            printMenu();
            c = sc.nextInt();
            sc.nextLine();
            if (c == 1){
                cambiaCarpeta();
            }else if (c == 2){
                descargaArchivo();
            }
        }while (c != 0);
    }

    private static void descargaArchivo() throws IOException {
        System.out.println("Inserte nombre del archivo");
        String nombre = sc.nextLine();
        System.out.println("Inserte carpeta destino de su dispositivo");
        String ruta = sc.nextLine();

        Path ubicacion = Paths.get(ruta + "/" + nombre);
        File fichero = ubicacion.toFile();
        boolean b = false;
        try{
            DataOutputStream writer = new DataOutputStream(new FileOutputStream(fichero, true));
            fichero.createNewFile();
            b= ftp.retrieveFile(nombre, writer);
            if (!b)fichero.delete();
        }catch(IOException ex){
            ex.printStackTrace();
        }
        if (b){
            System.out.println("Fichero descargado");
        }else {
            System.out.println("No se pudo descargar el fichero");
        }
    }

    private static void cambiaCarpeta() throws IOException {
        System.out.println("Inserte nombre de carpeta a cambiar");
        String carpeta = sc.nextLine();

       boolean b = ftp.changeWorkingDirectory(ftp.printWorkingDirectory() + "/" + carpeta);

        if (b) {
            printArchivos( ftp.listFiles(), ftp.printWorkingDirectory(), 0);
        } else {
            System.out.println("\nLa carpeta no es correcta.");
        }
    }

    private static void printMenu() {
        System.out.println("Opciones: " +
                "\n\t1-Cambiar carpeta" +
                "\n\t2-Descargar archivo");
    }

    private static boolean iniciarConexion()throws IOException {
        System.out.println("Conectando a " + SERVER);
        ftp.connect(SERVER);

        boolean b = FTPReply.isPositiveCompletion(ftp.getReplyCode());
        if (!b) {
            ftp.disconnect();
            return false;
        }

        boolean sesion = ftp.login("username", "password");;
        return sesion;
    }
    //metodo imprime todos los archivos y y directorios del servidor. Si es un directorio mostrará su archivos internos de forma recursiva conn la tabulación adecuada.
    private static void printArchivos(FTPFile[] ftpFiles, String d, int index) throws IOException {

        for (FTPFile fichero : ftpFiles) {
            if (!fichero.getName().equals(".")  && !fichero.getName().equals("..")){

                System.out.print(tabByIndex(index)+fichero.getName());
                if (!fichero.isFile()) {
                    System.out.print("[carpeta]\n");
                    printArchivos(ftp.listFiles(d+fichero.getName()), d+fichero.getName(), index+1);
                }else {
                    System.out.print("\n");
                }
            }
        }
    }

    private static String tabByIndex(int i){
        String s = "";
        for (int j = 0; j < i; j++) {
            s+="\t";
        }
        return s;
    }
}
