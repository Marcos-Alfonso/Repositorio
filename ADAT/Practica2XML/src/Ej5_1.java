import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;


public class Ej5_1 {
    static JComboBox<String> combo = new JComboBox<>();
    static ArrayList<ArrayList<String>> lista = new ArrayList<>();
    static JTextArea area = new JTextArea();
    public static void main(String[] args) {
        JFrame frame = new JFrame("Carga xml");
        combo.addActionListener(e -> {
            cargaTX();
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout bl = new BorderLayout();
        frame.setLayout(bl);
        frame.setSize(500, 500);

        JButton b = new JButton("Importar");
        frame.getContentPane().add(area, BorderLayout.CENTER);
        frame.getContentPane().add(b, BorderLayout.SOUTH);
        frame.getContentPane().add(combo, BorderLayout.NORTH);

        b.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File f = chooser.getSelectedFile();
                cargaXML(f);
            }
        });
        frame.setVisible(true);
    }
    private static void cargaTX(){
        int i = combo.getSelectedIndex();
        ArrayList<String> pelicula=lista.get(i);
        String tx = "";
        for (String s:pelicula) {
            tx +=s+"\n";
        }
        area.setText(tx);
    }

    private static void cargaXML(File f) {{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(f);
            document.getDocumentElement().normalize();

            //crea una lista con todos los nodos pelicula
            NodeList peliculas = document.getElementsByTagName("Pelicula");
            NodeList actores = document.getElementsByTagName("Actores");

            for (int i = 0; i < peliculas.getLength(); i ++) {
                ArrayList<String> array = new ArrayList<>();
                //obtener un nodo
                Node peli = peliculas.item(i);
                //tipo de nodo
                if (peli.getNodeType() == Node.ELEMENT_NODE) {
                    //obtener los elementos del nodo
                    Element e = (Element) peli;
                    array.add("Titulo: "+e.getElementsByTagName("Titulo").item(0).getTextContent());
                    array.add("Duración: "+e.getElementsByTagName("Duracion").item(0).getTextContent());
                    array.add("Género: "+e.getElementsByTagName("Genero").item(0).getTextContent());
                    array.add("Sinopsis: "+e.getElementsByTagName("sinopsis").item(0).getTextContent());
                    array.add("Título: "+e.getElementsByTagName("Fecha").item(0).getTextContent());
                    array.add("Director: "+e.getElementsByTagName("Director").item(0).getTextContent());

                    String ac = "Actores: \n";
                    NodeList n = (NodeList) actores.item(i);
                    for (int j = 0; j < n.getLength(); j++) {
                        Node c = n.item(j);
                        if (c.getNodeType() == Node.ELEMENT_NODE) {
                            ac += "\t"+n.item(j).getTextContent()+"\n";
                        }
                    }
                    array.add(ac);
                    lista.add(array);
                    combo.addItem(array.get(0));
                }
            }
            cargaTX();
        } catch (Exception e)
        {e.printStackTrace();}
    }

    }
/*
    public void selectFile() {
        JFileChooser chooser = new JFileChooser();
        // optionally set chooser options ...
        if (chooser.showOpenDialog() == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            // read  and/or display the file somehow. ....
        } else {
            // user changed their mind
        }
    }
    */
}
