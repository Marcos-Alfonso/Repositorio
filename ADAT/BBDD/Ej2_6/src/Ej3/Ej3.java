package Ej3;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) throws SAXException, IOException {
        //b) leo y cargo los datos del xml a la base d datos
        //Utilizo una esctructura SAX para persear los datos en un array de objetos Libro y lo obtengo de mi custom Handler
        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        GestionContenido gestor= new GestionContenido();
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("biblioteca.xml");
        procesadorXML.parse(fileXML);
        ArrayList<Libro> listaLibros = gestor.getArray();

        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/unidad2", "root", "root");
            System.out.println("Iniciando inserción de libros en DB");
            Statement stmt=c.createStatement();

            //primero obtengo el mayor numero del id
            ResultSet rs=stmt.executeQuery("select MAX(NUMERO) from biblioteca");
            rs.next();
            int i = rs.getInt("MAX(NUMERO)");

            for (Libro l:listaLibros) {
                PreparedStatement ps = c.prepareStatement("INSERT INTO `biblioteca` (`TITULO`, `AUTOR`, `FNAC`, `FECHAPUB`,`NUMERO`) VALUES (?,?,?,?,?);");
                ps.setString(1, l.getTitulo());
                ps.setString(2, l.getTitulo());
                ps.setDate(3, l.getFechaNacimiento());
                ps.setInt(4, l.getFechaPublicacion());
                ps.setInt(5, ++i);
                ps.executeUpdate();
                ps.close();
            }
            System.out.println("Finalizando inserción en la DB");

            //c) Ahora leo los datos de la Base de Datos

             stmt=c.createStatement();
             rs=stmt.executeQuery("select * from biblioteca");
            System.out.println("\nDatos de la Base de Datos");
            while (rs.next()){
                System.out.printf("Fila %d: %s, %s, %tc, %d\n",
                        rs.getRow(),
                        rs.getString("TITULO"),
                        rs.getString("AUTOR"),
                        rs.getDate("FNAC"),
                        rs.getInt("FECHAPUB"));
            }

            // d)	Mostrar los libros publicados en un determinado año que se pasa como parámetro.
            System.out.println("Inserta año de publicación a buscar en la base de datos:");
            int input = (new Scanner(System.in)).nextInt();
            stmt=c.createStatement();
            rs=stmt.executeQuery("select * from biblioteca where FECHAPUB = '"+input+"'");
            // Si no hay dato alguno lo digo
            if (!rs.isBeforeFirst() ) {
                System.out.println("No hay datos");
            }
            //si no muestra los que hay
            while (rs.next()){
                System.out.printf("Fila %d: %s, %s, %tc, %d\n",
                        rs.getRow(),
                        rs.getString("TITULO"),
                        rs.getString("AUTOR"),
                        rs.getDate("FNAC"),
                        rs.getInt("FECHAPUB"));
            }
            stmt.close();
            rs.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}

class GestionContenido extends DefaultHandler {
    public ArrayList getArray(){

        return libros;
    }
    public GestionContenido() {
        super();
    }
    public void startDocument() {
        System.out.println("Comienzo del Documento XML");
    }
    public void endDocument() {
        System.out.println("Final del Documento XML");
    }
    ArrayList<Libro> libros = new ArrayList<>();
    Libro currentLibro ;

    boolean titulo;
    boolean autor;

    boolean fechaPublicacion;
    public void startElement(String uri, String nombre,
                             String nombreC, Attributes atts) {

        if(nombre.equalsIgnoreCase("libro")){
            this.currentLibro = new Libro();
        }
        if(nombre.equalsIgnoreCase("titulo")){
            titulo = true;
        }
        if(nombre.equalsIgnoreCase("autor")){
            autor = true;
            Date date1 = null;
            try {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate ld = LocalDate.parse(atts.getValue("fechaNacimiento"),formatter);
                date1=Date.valueOf(ld);
            } catch (IllegalArgumentException |NullPointerException e) {

            }
            currentLibro.setFechaNacimiento(date1);
        }
        if (nombre.equalsIgnoreCase("fechaPublicacion")){
            fechaPublicacion = true;
        }
    }


    public void endElement(String uri, String nombre,
                           String nombreC) {
        if(nombre.equalsIgnoreCase("libro")){
            libros.add(currentLibro);
        }
        if(nombre.equalsIgnoreCase("titulo")){
            titulo = false;
        }
        if(nombre.equalsIgnoreCase("autor")){
            autor = false;
        }
        if (nombre.equalsIgnoreCase("fechaPublicacion")){
            fechaPublicacion = false;
        }
    }
    public void characters(char[] ch, int inicio, int longitud)
            throws SAXException {

        String car=new String(ch, inicio, longitud);
        //quitar saltos
        car = car.replaceAll("[\t\n]","");
        if(titulo){
            currentLibro.setTitulo(car);
        }if(fechaPublicacion){
            currentLibro.setFechaPublicacion(Integer.parseInt(car));
        }if(autor){
            currentLibro.setAutor(car);
        }
    }
}