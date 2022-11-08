import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.*;
import java.util.ArrayList;

public class Ej4 {
    public static void main(String[] args){
        ArrayList<Cotizacion> lista= new ArrayList<Cotizacion>();
        try{
            File f =new File("cotizaciones.dat");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            while(true){
                Cotizacion c =(Cotizacion) ois.readObject();
                lista.add(c);
            }
        }catch (Exception ex){
        }
        //teniendo una lista de los objetos, los pasamos a xml con DOM
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document dom = builder.newDocument();
            dom.setXmlVersion("1.0");

            Element rootEle = dom.createElement("cotizaciones");

            for (Cotizacion c: lista) {
                Element ep = dom.createElement("cotizacion");

                Element nombre = dom.createElement("nombre");
                nombre.appendChild(dom.createTextNode(c.nombre));
                ep.appendChild(nombre);

                Element valor = dom.createElement("valor");
                valor.appendChild(dom.createTextNode(c.valor));
                ep.appendChild(valor);

                Element hora = dom.createElement("hora");
                hora.appendChild(dom.createTextNode(c.hora));
                ep.appendChild(hora);

                Element fecha = dom.createElement("fecha");
                fecha.appendChild(dom.createTextNode(c.fecha));
                ep.appendChild(fecha);

                rootEle.appendChild(ep);
            }
            dom.appendChild(rootEle);

            Source source = new DOMSource(dom);
            Result result =
                    new StreamResult(new java.io.File("Cotizaciones.xml"));
            Transformer transformer =
                    TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        }catch (ParserConfigurationException pce){
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
