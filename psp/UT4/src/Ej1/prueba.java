/**
 * Aplicaci�n que descarga un archivo de un servidor FTP gratuito del servidor ftp.rediris.es.
 *
 * El programa funciona de la siguiente manera:
 *  1. Se conectar� al servidor y mostrar� la lista de carpetas y archivos que tiene en su directorio ra�z (diferenciando archivos y carpetas).
 *  2. Preguntar� si deseamos entrar en una carpeta o descargar el archivo.
 */

package Ej1;

import java.io.*;
import java.net.SocketException;
import java.nio.file.*;
import java.util.*;

import org.apache.commons.net.ftp.*;

public class prueba {

    // Constantes
    private static final String SERVIDOR = "ftp.rediris.es";
    private static final String USUARIO = "usuario";
    private static final String CLAVE = "clave";

    // FTP
    private static FTPClient ftp = new FTPClient();

    // Entrada por teclado
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // Conectar
            boolean conectado = iniciarConexion();

            // Comprobar conexi�n
            if (conectado) {
                // Configurar opciones
                configurar();

                // Ver archivos de /
                listarArchivos();

                // Pedir y realizar operaciones
                int accion = -1;
                while (accion != 0) {
                    // Pedir operaci�n por teclado
                    accion = pedirAccion();

                    if (accion == 1) {
                        // Entrar en carpeta
                        accionCarpeta();
                    } else if (accion == 2) {
                        // Descargar archivo
                        accionDercarga();
                    }
                }
            }
        } catch (SocketException e) {
            System.out.println("\nFallo de conexi�n.");
        } catch (IOException e) {
            System.out.println("\nFallo de conexi�n.");
        }
    }

    /**
     * Trata de acceder a una carpeta del servidor, si existe.
     */
    private static void accionDercarga() {
        boolean copiado = descargarArchivo();

        if (copiado) {
            System.out.println("\nFichero descargado correctamente.");
        } else {
            System.out.println("\nEl fichero no ha podido ser descargado.");
        }
    }

    /**
     * Trata de descargar un fichero del servidor, si existe y la ruta es correcta.
     *
     * @throws IOException
     */
    private static void accionCarpeta() throws IOException {
        boolean cambiada = cambiarCarpeta();

        if (cambiada) {
            // Mostrar contenidos
            listarArchivos();
        } else {
            System.out.println("\nLa carpeta no es correcta.");
        }
    }

    /**
     * Descarga el fichedo indicado a la carpeta indicada.
     *
     * @return Si el fichero ha sido descargado correctamente.
     */
    private static boolean descargarArchivo() {
        // Pedir nombre y ruta
        String nombre = pedirFichero("\nNombre del archivo: ");
        String ruta = pedirFichero("Carpeta de destino: ");

        // Fichero
        Path ubicacion = Paths.get(ruta + "/" + nombre);
        File fichero = ubicacion.toFile();

        try (DataOutputStream escritor = new DataOutputStream(new FileOutputStream(fichero, true))) {
            // Crear fichero
            fichero.createNewFile();

            // Copiar contenido
            return ftp.retrieveFile(nombre, escritor);
        } catch (IOException e) {
        }

        return false;
    }

    /**
     * Pide el nombre de la carpeta a entrar y entra en ella.
     *
     * @return Si la operaci�n ha tenido �xito.
     * @throws IOException
     */
    private static boolean cambiarCarpeta() throws IOException {
        // Pedir carpeta
        String carpeta = pedirFichero("\nNombre de la carpeta: ");

        // Cambiar carpeta
        return ftp.changeWorkingDirectory(ftp.printWorkingDirectory() + "/" + carpeta);
    }

    /**
     * Pide por teclado el nombre de un fichero.
     *
     * @param frase Texto a mostrar al usuario.
     * @return El nombre introducido por teclado.
     */
    private static String pedirFichero(String frase) {
        // Pedir
        System.out.print(frase);

        // Leer
        String fichero = teclado.nextLine();
        return fichero;
    }

    /**
     * Se conecta con el servidor e inicia sesi�n.
     *
     * @return El �xito o fracaso de la operaci�n.
     * @throws SocketException
     * @throws IOException
     */
    private static boolean iniciarConexion() throws SocketException, IOException {
        ftp.connect(SERVIDOR);
        System.out.println("Conectando a " + SERVIDOR);

        // Verificar
        boolean conectado = FTPReply.isPositiveCompletion(ftp.getReplyCode());

        if (!conectado) {
            ftp.disconnect();
            System.err.println(SERVIDOR + " rechaz� la conexi�n.");
            return false;
        }

        // Iniciar sesion
        boolean sesion = ftp.login(USUARIO, CLAVE);

        return sesion;
    }

    /**
     * Establece el tipo de fichero, el tipo de transferencia y el modo pasivo.
     *
     * @throws IOException
     */
    private static void configurar() throws IOException {
        ftp.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
        ftp.setFileTransferMode(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();
    }

    /**
     * Pide la acci�n a realizar por teclado.
     *
     * @return La acci�n a realizar.
     */
    private static int pedirAccion() {
        // Opciones
        mostrarOpciones();

        // Pedir por teclado
        int accion = -1;
        boolean invalida = true;
        while (invalida) {
            accion = leerAccion();

            // Comprobar opci�n
            invalida = accion != 0 && accion != 1 && accion != 2;

            if (invalida) {
                // Si no se inserta un n�mero o no es correcto
                System.out.println("La opci�n no es v�lida.");
            }
        }

        return accion;
    }

    /**
     * Lee la acci�n escogida por teclado.
     *
     * @return La acci�n introducida por el usuario, o -1 si no introduce un n�mero.
     */
    private static int leerAccion() {
        int accion = -1;
        try {
            // Pedir
            System.out.print("Seleccione una opci�n: ");

            // Leer
            accion = teclado.nextInt();
        } catch (InputMismatchException e) {
        }
        teclado.nextLine();
        return accion;
    }

    /**
     * Muestra todas las acciones disponibles.
     */
    private static void mostrarOpciones() {
        System.out.println("\nOperar:");
        System.out.println("1 - Entrar en carpeta.");
        System.out.println("2 - Descargar archivo.");
        System.out.println("0 - Salir.");
    }

    /**
     * Muestra el directorio actual y sus ficheros.
     *
     * @throws IOException
     */
    private static void listarArchivos() throws IOException {
        // Mostrar directorio actual
        System.out.println("\nLista de archivos y carpetas de " + ftp.printWorkingDirectory());

        // Obtener lista de ficheros
        FTPFile[] lista = ftp.listFiles();

        // Imprimir cada miembro
        for (FTPFile fichero : lista) {
            if (fichero.isFile()) {
                // Si es fichero
                System.out.println(fichero.getName());
            } else {
                // Si es carpeta
                System.out.println(fichero.getName() + " [carpeta]");
            }
        }
    }

}
