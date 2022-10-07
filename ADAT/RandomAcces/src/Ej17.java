import java.io.*;

public class Ej17 {
    public static void main(String[] args) {
        try{
            File f = new File("productos.dat");
            f.mkdirs();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(new Producto(123, "desc1", 134, 24.78));
            oos.writeObject(new Producto(31, "desc2", 5, 4.478));
            oos.writeObject(new Producto(14423, "desc2", 45, 44.78));
            oos.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        try{
            File f = new File("productos.dat");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            System.out.println(ois.readObject().toString());
            System.out.println(ois.readObject().toString());
            System.out.println(ois.readObject().toString());

        }catch (IOException e){

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
