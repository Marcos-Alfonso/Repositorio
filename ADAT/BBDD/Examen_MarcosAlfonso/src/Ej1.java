import java.io.*;
import java.util.ArrayList;

public class Ej1 {
    public static void main(String[] args) {
        //apartado a) lee fichero csv y guarda los datos en un fichero de objetos
        ArrayList<Cliente> lista = getListaClientes();
        guardaClientes(lista);

        try {
            // apartado b) lee el fichero de objetos, me guardo todos los clientes en un arraylist, y muestra los datos
            ArrayList<Cliente> listaObj =getClientesFichero();
            for(Cliente c : listaObj){
                System.out.println(c.toString());
            }
            //apartado c) lee fichero de objetos y muestralo en formato csv
            for (Cliente c :listaObj) {
                System.out.println(clienteToCSV(c));
            }

            //apartado d) funcion que crea un csv con los clientes del fichero de objetos que tengan un descuento de mas del 10%
            generaCSVclientes();
        } catch (IOException e) {    }


    }

    private static void generaCSVclientes() throws IOException {
        ArrayList<Cliente> listaObj =getClientesFichero();
        File f = new File("Clientes10.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for (Cliente c :listaObj) {
            if(c.getDescuento()>10){
                bw.write(clienteToCSV(c)+"\n");
            }
        }
        bw.close();
    }

    private static String clienteToCSV(Cliente c) throws IOException {
        return c.getNombre()+","+c.getEdad()+","+c.getCiudad()+","+c.getDescuento();
    }

    private static ArrayList<Cliente> getClientesFichero() throws IOException {
        File f = new File("clientes.dat");
        ArrayList<Cliente> lista = new ArrayList<>();
        if(!f.exists()){
            System.err.println("Fichero no encontrado");
            return null;
        }
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            while (true) {
                Cliente c= (Cliente) ois.readObject();
                lista.add(c);
            }
        }catch (EOFException | ClassNotFoundException eo) {
            System.out.println("FIN DE LECTURA.");
        }
        ois.close();
        return lista;
    }

    private static void guardaClientes(ArrayList<Cliente> lista)  {
        File f = new File("clientes.dat");
        ObjectOutputStream oos;
        try{
            if(!f.exists()){
                FileOutputStream fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }else {
                oos = new MiObjectOutputStream(new FileOutputStream(f,true));
            }
            for (Cliente c:lista) {
                oos.writeObject(c);
            }
            oos.close();
        }catch (IOException ex){

        }

    }

    private static ArrayList<Cliente> getListaClientes() {
        File f = new File("clientes.csv");
        try {
            ArrayList<Cliente> listaCliente= new ArrayList<Cliente>();
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = "";
            while((line = br.readLine())!=null){
                String []datos = line.split(",");
                Cliente c = new Cliente(datos[0],Integer.parseInt(datos[1]) , datos[2], Double.parseDouble(datos[3]));
                listaCliente.add(c);
            }
            return listaCliente;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
