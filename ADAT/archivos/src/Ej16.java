import java.io.*;
import java.util.ArrayList;

public class Ej16 {
    public static void main(String[] args) {
        ArrayList<Agenda> array= getOldData();
        Agenda a1 = new Agenda("PEPE", "Rodi", 345);
        Agenda a2 = new Agenda("defa", "Roddasfawi", 343453465);
        Agenda a3 = new Agenda("PEssPwaaE", "Rodafawei", 56567);
        array.add(a1);
        array.add(a2);
        array.add(a3);

        File f = new File("NUEVODIR/agenda.dat");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            for (int i = 0; i < array.size(); i++) {
                oos.writeObject(array.get(i));
            }
            oos.close();
        } catch (IOException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            while (true){
                Agenda a = (Agenda) ois.readObject();
                System.out.println(a.toString());
            }
        } catch (IOException e) {
            System.out.println("Datos Cargados");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }




    }

    private static ArrayList getOldData() {
        File f = new File("NUEVODIR/agenda.dat");
        ArrayList<Agenda> array= new ArrayList<Agenda>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            while (true){
                Agenda a = (Agenda) ois.readObject();
                array.add(a);
            }
        } catch (IOException e) {
            System.out.println("Datos Cargados");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return array;
    }
}
