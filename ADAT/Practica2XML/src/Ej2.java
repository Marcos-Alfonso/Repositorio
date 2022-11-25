import java.io.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ej2 {
    public static void main(String[] args) throws SAXException, IOException {
        XMLReader  procesadorXML = XMLReaderFactory.createXMLReader();
        GestionContenido gestor= new GestionContenido();
        procesadorXML.setContentHandler(gestor);
        InputSource fileXML = new InputSource("https://www.aemet.es/documentos_d/eltiempo/prediccion/avisos/rss/CAP_AFAE_wah_RSS.xml");
        procesadorXML.parse(fileXML);

    }
}
class GestionContenido extends DefaultHandler {
    public GestionContenido() {
        super();
    }
    public void startDocument() {
        System.out.println("Comienzo del Documento XML");
    }
    public void endDocument() {
        System.out.println("Final del Documento XML");
    }
    public void startElement(String uri, String nombre,
                             String nombreC, Attributes atts) {

        if(nombre.contains("title") || nombre.contains("pubDate")){
            System.out.printf("\t Principio Elemento: %s %n",nombre);
            b = true;
        }
        if(nombre.contains("item")) System.out.println("---------------");


    }

    private boolean b = false;

    public void endElement(String uri, String nombre,
                           String nombreC) {
        if(nombre.contains("title")|| nombre.contains("pubDate"))
        System.out.printf("\tFin Elemento: %s %n", nombre);
        if(nombre.contains("item")) System.out.println("---------------");
    }
    public void characters(char[] ch, int inicio, int longitud)
            throws SAXException {
        if (!b)return;
        String car=new String(ch, inicio, longitud);
        //quitar saltos
        car = car.replaceAll("[\t\n]","");
        System.out.printf ("\t Caracteres: %s %n", car);
        b = false;
    }
}
