package Ej3_Random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        escibeDep();

        leeDep();
    }
    private boolean existeDep(RandomAccessFile raf, int id) throws IOException {
        //if((id-1)*32 >raf.length())return false;
        raf.seek((id-1)*32);
        int i = raf.readInt();
        if(id == i)return true;
        return false;
    }
    private static void leeDep() {

        try {
            Scanner sc = new Scanner(System.in);
            File f = new File("departamentos.dat");
            if(!f.exists()){
                System.out.println("No existen departamentos");
                return;
            }
            RandomAccessFile raf = new RandomAccessFile(f, "r");

            int id, posicion = 0;
            Double presu;
            char nombre[]=new char[10], aux;

            do{
                raf.seek(posicion);
                id = raf.readInt();
                for (int i=0;i<10;i++) {
                    aux=raf.readChar();
                    nombre[i]=aux;
                }
                String n=new String(nombre);

                presu = raf.readDouble();
                if(id >0)
                    System.out.printf("ID: %s, Nombre: %s, Presupuesto: %.2f %n",id,n,presu);
                posicion= posicion + 32; //me posiciono para el sig empleado, cada empleado ocupa 36 bytes
            } while(raf.getFilePointer() != raf.length());
            raf.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void escibeDep(){
        try {
            Scanner sc = new Scanner(System.in);
            File f = new File("departamentos.dat");
            if(!f.exists()){
                f.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(f, "rw");

            System.out.println("Inserte id del departamento: ");
            int id = sc.nextInt();
            System.out.println("Inserte nombre del departamento: ");
            sc.nextLine();
            StringBuilder nombre =new StringBuilder(sc.nextLine()) ;
            nombre.setLength(10);
            System.out.println("Inserte presupuesto del departamento: ");
            Double presu = sc.nextDouble();

            raf.seek((id-1)*32);
            raf.writeInt(id);
            raf.writeChars(nombre.toString());
            raf.writeDouble(presu);

            raf.close();
            System.out.println("Departamento Guardado" );
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
