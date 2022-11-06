import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.File;

public class Ej1 {
    public static void main(String[] args) {

        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("peliculas.xml"));
            document.getDocumentElement().normalize();

            System.out.printf("Elemento raiz: %s %n",
                    document.getDocumentElement().getNodeName());
            //crea una lista con todos los nodos pelicula
            NodeList peliculas = document.getElementsByTagName("Pelicula");
            System.out.printf("Nº Peliculas a recorrer: %d %n", peliculas.getLength());
            NodeList actores = document.getElementsByTagName("Actores");

            for (int i = 0; i < peliculas.getLength(); i ++) {
                //obtener un nodo
                Node peli = peliculas.item(i);
                //tipo de nodo
                if (peli.getNodeType() == Node.ELEMENT_NODE) {
                    //obtener los elementos del nodo
                    Element e = (Element) peli;

                    System.out.printf("Título = %s %n",
                            e.getElementsByTagName("Titulo").item(0).getTextContent());
                    System.out.printf(" * Duración = %s %n",
                            e.getElementsByTagName("Duracion").item(0).getTextContent());
                    System.out.printf(" * Género = %s %n",
                            e.getElementsByTagName("Genero").item(0).getTextContent());
                    System.out.printf(" * Sinopsis = %s %n",
                            e.getElementsByTagName("sinopsis").item(0).getTextContent());
                    System.out.printf(" * Fecha = %s %n",
                            e.getElementsByTagName("Fecha").item(0).getTextContent());
                    System.out.printf(" * Director = %s %n",
                            e.getElementsByTagName("Director").item(0).getTextContent());

                    //Muestro los Actores
                    NodeList n = (NodeList) actores.item(i);
                    for (int j = 0; j < n.getLength(); j++) {
                        Node c = n.item(j);
                        if (c.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.printf("     Actor = %s %n",
                                    n.item(j).getTextContent());
                        }

                    }
                    System.out.println("---");
                }
            }

        } catch (Exception e)
        {e.printStackTrace();}

    }
}
