import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ej18 {
    public static void main(String[] args)  {

        try { File fichero = new File("AleatorioEmple.dat");
            RandomAccessFile file = null; // r read
            file = new RandomAccessFile(fichero, "r");
            int seek = (new Scanner(System.in)).nextInt();
            int id, dep, posicion = (seek-1)*36;

            Double salario;
            char apellido[]=new char[10], aux;

            file.seek(posicion); //nos posicionamos en posicion
            id = file.readInt(); // obtengo id de empleado
            for (int i=0;i<10;i++) {
                aux=file.readChar();
                apellido[i]=aux;
            }
            String apellidos=new String(apellido);
            dep = file.readInt(); //obtengo dep
            salario = file.readDouble(); //obtengo salario
            System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n",id,apellidos.trim(),dep,salario);
            file.close(); //cerrar fichero
        } catch (IOException e) {
            System.err.println("No se encontró  empleado");
        }

    }
}
