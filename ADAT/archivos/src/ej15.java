import java.io.*;

public class ej15 {
    public static void main(String[] args) {
        Pedido n1 = new Pedido("Pedido n1", 3, 4.67);
        Pedido n2 = new Pedido("Pedido n2", 5, 4.44);
        Pedido n3 = new Pedido("Pedido n3", 34, 10.45);

        File f = new File("NUEVODIR/pedidos.obj");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(n1);
            oos.writeObject(n2);
            oos.writeObject(n3);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error");
            throw new RuntimeException(e);
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            while (true){
                Pedido p = (Pedido) ois.readObject();
                System.out.println(p.toString());
            }
        } catch (IOException e) {
            System.out.println("Lectura finalizada");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
