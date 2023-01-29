/*
 * Programa servidor que nos permite operar con ficheros.
 * Las operaciones disponibles son:
 *  G: Traer el fichero (GET)
 *  D: Borrar el fichero (DELETE)
 *  R: Renombrar el fichero (RENAME)
 *  L: Obtener lista de ficheros
 */

package Ej2;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public class Servidor {

	private static final byte[] FICH_RENOMBRADO = new String("Fichero renombrado con éxito.").getBytes();
	private static final byte[] FICH_BORRADO = new String("Fichero borrado con éxito.").getBytes();
	private static final byte[] ERR_1 = new String("El fichero no existe.").getBytes();
	private static final byte[] ERR_2 = new String("El nuevo nombre no es correcto.").getBytes();
	private static final byte[] ERR_3 = new String("Error desconocido.").getBytes();


	static final int PUERTO = 4444;


	static DataInputStream entrada;
	static DataOutputStream salida;

	static byte resultado;
	static long longitud;
	static byte[] informacion;

	public static void main(String[] args) {
		try {
			while (true){
				atenderCliente();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static void atenderCliente() throws IOException {
		try  {
			ServerSocket socketServidor = new ServerSocket(PUERTO);
			Socket socketCliente = socketServidor.accept();
			obtenerStreams(socketCliente);

			char operacion = ' ';
			do {
				operacion = operar();
			} while (operacion != 'F');
			entrada.close();
			salida.close();
			socketCliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static char operar() throws IOException {
		char operacion = entrada.readChar();
		System.out.println("Cliente: " + operacion);

		if (operacion == 'G' || operacion == 'D' || operacion == 'R') {
			opercaFichero(operacion);
		} else if (operacion == 'L') {
			listarFicheros();
		}
		if (operacion != 'F') {
			enviarResultados();
		}
		return operacion;
	}


	private static void enviarResultados() throws IOException {
		salida.writeByte(resultado);
		salida.writeLong(longitud);
		salida.write(informacion);
		salida.flush();
		
		System.out.println("Enviado: " + resultado);
	}


	private static void opercaFichero(char operacion) throws IOException {

		String nombre = entrada.readUTF();
		System.out.println("Cliente: " + nombre);

		Path ubicacion = Paths.get(nombre);
		File fichero = ubicacion.toFile();

		try {
			if (!fichero.exists()) {
				setDatos((byte) 1, ERR_1);
			} else {

				operarConFichero(fichero, operacion);
			}
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			setDatos((byte) 3, ERR_3);
		}
	}

	private static void listarFicheros() {
		File carpeta = new File(".");
		File[] todo = carpeta.listFiles();

		String ficheros = "";
		for (File fichero : todo) {
			if (fichero.isFile()) {
				ficheros += fichero.getName() + "\n";
			}
		}
		setDatos((byte) 0, ficheros.getBytes());
	}


	private static void setDatos(byte res, byte[] flujo) {
		resultado = res;
		longitud = flujo.length;
		informacion = flujo;
	}

	private static void operarConFichero(File fichero, char operacion) throws Exception {
		switch (operacion) {
		case 'G':
			enviarFichero(fichero);
			break;
		case 'R':
			renombrarFichero(fichero);
			break;
		case 'D':
			borrarfichero(fichero);
			break;
		}
	}

	private static void enviarFichero(File fichero) throws Exception {

		try {
			InputStream lector = new FileInputStream(fichero);
			byte[] contenido = leerNBytes(lector, Integer.MAX_VALUE);

			setDatos((byte) 0, contenido);
		} catch (IOException e) {

			throw new Exception();
		}
	}
	
	/**
	 * Lee una cantidad de bytes de reader. Copiado de la librer�a de java 9.
	 * 
	 * @param lector  
	 * @param len
	 * @return
	 * @throws IOException
	 */
	public static byte[] leerNBytes(InputStream lector, int len) throws IOException {
        if (len < 0) {
            throw new IllegalArgumentException("len < 0");
        }

        List<byte[]> bufs = null;
        byte[] result = null;
        int total = 0;
        int remaining = len;
        int n;
        do {
            byte[] buf = new byte[Math.min(remaining, 8192)];
            int nread = 0;

            // read to EOF which may read more or less than buffer size
            while ((n = lector.read(buf, nread,
                    Math.min(buf.length - nread, remaining))) > 0) {
                nread += n;
                remaining -= n;
            }

            if (nread > 0) {
                if (Integer.MAX_VALUE - 8 - total < nread) {
                    throw new OutOfMemoryError("Required array size too large");
                }
                total += nread;
                if (result == null) {
                    result = buf;
                } else {
                    if (bufs == null) {
                        bufs = new ArrayList<>();
                        bufs.add(result);
                    }
                    bufs.add(buf);
                }
            }
            // if the last call to read returned -1 or the number of bytes
            // requested have been read then break
        } while (n >= 0 && remaining > 0);

        if (bufs == null) {
            if (result == null) {
                return new byte[0];
            }
            return result.length == total ?
                result : Arrays.copyOf(result, total);
        }

        result = new byte[total];
        int offset = 0;
        remaining = total;
        for (byte[] b : bufs) {
            int count = Math.min(b.length, remaining);
            System.arraycopy(b, 0, result, offset, count);
            offset += count;
            remaining -= count;
        }

        return result;
    }


	private static void renombrarFichero(File fichero) throws IOException {
		String nombre = entrada.readUTF();
		System.out.println("Cliente: " + nombre);
		File nuevo = new File(nombre);
		boolean renombrado = fichero.renameTo(nuevo);
		if (renombrado) {
			setDatos((byte) 0, FICH_RENOMBRADO);
		} else {
			setDatos((byte) 2, ERR_2);
		}
	}


	private static void borrarfichero(File fichero) {
		fichero.delete();
		setDatos((byte) 0, FICH_BORRADO);
	}

	private static void obtenerStreams(Socket socket) throws IOException {
		entrada = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		salida = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
	}

}
