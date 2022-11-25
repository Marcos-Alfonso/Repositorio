import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ej2 {
    public static void main(String[] args) {
        ArrayList<Cliente> listaCliente= new ArrayList<Cliente>();
        try{
            File f =new File("clientes.dat");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            while(true){
                Cliente c =(Cliente) ois.readObject();
                listaCliente.add(c);
            }
        }catch (Exception ex){
        }

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document dom = builder.newDocument();
            dom.setXmlVersion("1.0");

            Element rootEle = dom.createElement("cliente");

            for (Cliente c: listaCliente) {
                Element ep = dom.createElement("cliente");

                Element nombre = dom.createElement("nombre");
                nombre.appendChild(dom.createTextNode(c.getNombre()));
                ep.appendChild(nombre);

                Element edad = dom.createElement("edad");
                edad.appendChild(dom.createTextNode(c.getEdad()+""));
                ep.appendChild(edad);

                Element ciudad = dom.createElement("ciudad");
                ciudad.appendChild(dom.createTextNode(c.getCiudad()));
                ep.appendChild(ciudad);

                Element descuento = dom.createElement("descuento");
                descuento.appendChild(dom.createTextNode(c.getDescuento()+""));
                ep.appendChild(descuento);

                rootEle.appendChild(ep);
            }
            dom.appendChild(rootEle);

            Source source = new DOMSource(dom);
            Result result =
                    new StreamResult(new java.io.File("clientes.xml"));
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
