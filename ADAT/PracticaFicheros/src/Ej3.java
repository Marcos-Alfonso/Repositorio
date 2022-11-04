import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej3 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int check = 0;
        do{
            System.out.println("M E N U\n" +
                    "---------------------\n" +
                    "   1- Introducir datos \n" +
                    "   2- Borrar un departamento \n" +
                    "   3- Consultar un departamento  \n" +
                    "   4- Ver fichero\n" +
                    "   5- Salir");

            try{
                check = sc.nextInt();

            switch (check){
                case 1://Introducir datos (se comprobará que no exista el id que se introduce).

                    nuevoDepartamento();
                    break;
                case 2://Borrar un departamento (se pedirá el id del departamento)
                    borraDep();
                    break;
                case 3://Consultar un departamento (se pedirá el id del departamento)
                    consultaDep();
                    break;
                case 4://Ver fichero (se mostrará el fichero)
                    printAll();
                    break;
                default:
            }
            }catch (InputMismatchException e){
                //si no añado este string entra en bucle infinito, por simple funcionamiento de Java al recibir salida estándar
                String s = sc.nextLine();
            }catch (IOException e){
                String s = sc.nextLine();
            }
        }while(check!=5);
    }

    private static void printAll() throws IOException{
        File f = new File("departamentos.dat");
        RandomAccessFile raf = new RandomAccessFile(f, "r");
        int id, posicion = 0;
        Double presu;
        char nombre[]=new char[10];

        do{
            raf.seek(posicion);
            id = raf.readInt();
            for (int i=0;i<10;i++) {
                nombre[i]=raf.readChar();
            }
            String nom=new String(nombre);

            presu = raf.readDouble(); //obtengo salario
            if(id >0)
                System.out.printf("Departamento ID: %s, Nombre: %s, Presupuesto: %.2f %n",id,nom,presu);
            posicion= posicion + 32; //me posiciono para el sig empleado, cada empleado ocupa 36 bytes
        } while(raf.getFilePointer() != raf.length());
        raf.close();
    }

    private static void consultaDep() throws IOException, InputMismatchException{
        System.out.println("Inserte id del departamento a eliminar: ");
        int id =sc.nextInt();
        File f = new File("departamentos.dat");
        //lo abro en read, no preciso escribir nada
        RandomAccessFile raf = new RandomAccessFile(f, "r");

        if(!checkExist(raf, id)){
            System.err.println("No existe el departamento");
            //si existe cierro el fichero y salgo del método para que no siga ejecutándolo
            raf.close();
            return;
        }

        raf.seek((id-1)*32);
        id= raf.readInt();
        Double resu;
        char nombre[]=new char[10];
        for (int i=0;i<10;i++) {
            nombre[i]=raf.readChar();
        }
        String nom=new String(nombre);

        resu = raf.readDouble(); //obtengo salario
        if(id >0)
            System.out.printf("Departamento ID: %s, Nombre: %s, Presupuesto: %.2f %n",id,nom,resu);
        raf.close();
    }

    private static void borraDep() throws IOException, InputMismatchException {
        System.out.println("Inserte id del departamento a eliminar: ");
        int id =sc.nextInt();
        // (int = 4b, double = 8b, String(10l)= 20b)=32b
        File f = new File("departamentos.dat");
        //lo abro en read/write, ya que necesito comprobar si el departamento existe, si no solo lo abriría en write
        RandomAccessFile raf = new RandomAccessFile(f, "rw");

        if(!checkExist(raf, id)){
            System.err.println("No existe el departamento");
            //si existe cierro el fichero y salgo del método para que no siga ejecutándolo
            raf.close();
            return;
        }
        raf.seek((id-1)*32);
        raf.writeInt(0);
        raf.writeChars("DELETED***");
        raf.writeDouble(0.0);
    }

    private static void nuevoDepartamento() throws InputMismatchException{
        try{
            // (int = 4b, double = 8b, String(10l)= 20b)=32b
            File f = new File("departamentos.dat");
            //lo abro en read/write, ya que necesito comprobar si el departamento existe, si no solo lo abriría en write
            RandomAccessFile raf = new RandomAccessFile(f, "rw");

            System.out.println("Inserte id del nuevo departamento: ");
            int id =sc.nextInt();
            //compruebo si existe el departemento
            if(checkExist(raf, id)){
                System.err.println("Ya existe el departamento");
                //si existe cierro el fichero y salgo del método para que no siga ejecutándolo
                raf.close();
                return;
            }
            System.out.println("Inserte nombre del nuevo departamento: ");
            sc.nextLine();
            StringBuffer nombre  =new StringBuffer(sc.nextLine());
            System.out.println("Inserte presupuesto del nuevo departamento: ");
            Double presupuesto  =sc.nextDouble();

            raf.seek((id-1)*32);
            raf.writeInt(id);
            nombre.setLength(10);
            raf.writeChars(nombre.toString());
            raf.writeDouble(presupuesto);
            System.out.println("Departamento creado!");
            raf.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //metodo que comprueba si existe el id de un departamento. Me será util a lo largo de la ejecución.
    private static boolean checkExist(RandomAccessFile raf, int id) {
        //me interesa que si da error al intentar leer me devuelva false
        try{
            raf.seek((id-1)*32);
            if( raf.readInt()== id){
                return true;
            }
        }catch (IOException ex){
        }
        return false;
    }
}
