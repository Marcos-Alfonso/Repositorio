import java.io.*;

public class Cotizacion implements Serializable{
    private static final long serialVersionUID = 1L;
    String nombre;
    String fecha;
    String hora;
    String valor;

    public Cotizacion(String nombre, String fecha, String hora, String valor) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
    }
    public Cotizacion(){

    }

    @Override
    public String toString() {
        return
                 nombre + ":\n\t" +
                "fecha='" + fecha + '\'' +
                " - hora='" + hora + '\'' +
                " - valor='" + valor + '\'';
    }

    public void GrabarCotizacion() throws IOException {
        File f = new File("cotizaciones.obj");
        ObjectOutputStream oos;
        if(!f.exists()){
            FileOutputStream fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
        }else {
            oos = new MiObjectOutputStream(new FileOutputStream(f,true));
        }
        oos.writeObject(this);
        oos.close();
    }
    public static void LeerCotizacion() throws IOException {
        File f = new File("cotizaciones.obj");
        FileInputStream fis = new FileInputStream(f);//conecta el flujo de bytes al flujo de datos
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
        while (true) { //lectura del fichero
            Cotizacion c= (Cotizacion) ois.readObject();
            System.out.println(c.toString());}
        }catch (EOFException | ClassNotFoundException eo) {
            System.out.println("FIN DE LECTURA.");
        }
        ois.close();
    }
}
