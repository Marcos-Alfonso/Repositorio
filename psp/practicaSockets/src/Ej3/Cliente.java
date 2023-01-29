

package Ej3;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente {

	static final String IP = "127.0.0.1";
	static final int PUERTO = 4444;


	static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

	static DataInputStream entrada;
	static DataOutputStream salida;
	

	private static String nuevoNombre;

	public static void main(String[] args) {

		try {
			Socket socket = new Socket(IP, PUERTO);
			System.out.println("- Cliente de descarga de ficheros -");
			System.out.println("Introduce:" +
					"   -G: Trae el fichero" +
					"   -D: Borra el fichero" +
					"   -R: Renombrar un fichero");
			obtenerStreams(socket);

			boolean operar = true;
			while (operar) {
				operar = operacion();
			}

			salida.writeChar('F');
			salida.flush();

			entrada.close();
			salida.close();
			teclado.close();
		} catch (IOException e) {
			System.out.println("No se ha podido establecer la conexión.");
		}
	}

	private static void obtenerStreams(Socket socket) throws IOException {
		entrada = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
		salida = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
	}

	private static boolean operacion() throws IOException {

		System.out.print("(Deje en blanco para finalizar) Operación: ");
		String entrada = teclado.readLine();
		System.out.println();
		if (entrada.isEmpty()) {
			return false;
		}

		char operador = entrada.toUpperCase().charAt(0);

		if (operador == 'G' || operador == 'R' || operador == 'D' || operador == 'L') {
			salida.writeChar(operador);
			salida.flush();

			enviarDatos(operador);

			resultados(operador);
		} else {
			System.out.println("El operador no es correcto.");
			System.out.println();
		}

		return true;
	}

	private static void enviarDatos(char operador) throws IOException {
		switch (operador) {
		case 'G':
			String nombre = pedirNombre("Ruta del fichero en el servidor: ");
			nuevoNombre = pedirNombre("Ruta del nuevo fichero en el cliente: ");

			salida.writeUTF(nombre);
			salida.flush();

			break;
		case 'R':
			nombre = pedirNombre("Ruta del fichero en el servidor: ");
			nuevoNombre = pedirNombre("Nuevo nombre: ");

			salida.writeUTF(nombre);
			salida.writeUTF(nuevoNombre);
			salida.flush();

			break;
		case 'D':
			nombre = pedirNombre("Ruta del fichero en el servidor: ");
			salida.writeUTF(nombre);
			salida.flush();

			break;
		}
	}

	private static String pedirNombre(String string) {
		String nombre = "";
		do {
			System.out.print(string);
			try {
				nombre = teclado.readLine();
			} catch (IOException e) {}

		} while (nombre.isEmpty());
		System.out.println();

		return nombre;
	}


	private static void resultados(char operador) throws IOException {

		byte resultado = entrada.readByte();
		long longitud = entrada.readLong();
		byte[] informacion = leerNBytes((int) longitud);

		if (resultado != 0) {

			System.out.println("Error " + resultado + ": " + new String(informacion));
		} else if (operador == 'G') {
			copiarArchivo(informacion);
		} else {
			System.out.println(new String(informacion));
		}

		System.out.println();

	}
	
	/**
	 * Lee una cantidad de bytes de reader. Copiado de la librer�a de java 9.
	 * 
	 * @param len
	 * @return
	 * @throws IOException
	 */
	public static byte[] leerNBytes(int len) throws IOException {
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
            while ((n = entrada.read(buf, nread,
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

	private static void copiarArchivo(byte[] informacion) throws IOException {

		File fichero = new File(nuevoNombre);
		boolean creado = false;
		boolean correcto = true;
		try {
			creado = fichero.createNewFile();
		} catch (IOException e) {
			System.out.println("Error 4: El nombre del fichero de destino no es correcto.");
			correcto = false;
		}

		if (creado) {
			try (OutputStream escritor = new FileOutputStream(fichero)) {
				escritor.write(informacion);
			}
			System.out.println("Fichero copiado con éxito.");
		} else if (correcto) {
			System.out.println("Error 4: El fichero de destino ya existe.");
		}
	}


}
