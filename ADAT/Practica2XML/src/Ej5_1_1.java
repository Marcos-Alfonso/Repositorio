
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Ej5_1_1 {
    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new MyPanel());
        frame.pack();
        frame.setVisible (true);
    }
    public static class MyPanel extends JPanel {
        private JLabel jcomp1;
        private JTextField txTitulo;
        private JTextField txFecha;
        private JTextField txGenero;
        private JLabel jcomp5;
        private JLabel jcomp6;
        private JTextArea txSinopsis;
        private JLabel jcomp8;
        private static JComboBox combo;
        private JButton inserta;

        public MyPanel() {
            //construct preComponents
            String[] comboItems = {};

            //construct components
            jcomp1 = new JLabel ("Título");
            txTitulo = new JTextField (5);
            txFecha = new JTextField (5);
            txGenero = new JTextField (5);
            jcomp5 = new JLabel ("Fecha");
            jcomp6 = new JLabel ("Genero");
            txSinopsis = new JTextArea (5, 5);
            jcomp8 = new JLabel ("Sinopsis");
            combo = new JComboBox (comboItems);
            inserta = new JButton ("Insertar");
            txTitulo.setEditable(false);
            txFecha.setEditable(false);
            txGenero.setEditable(false);
            txSinopsis.setEditable(false);

            inserta.addActionListener(e -> {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    File f = chooser.getSelectedFile();
                    cargaXML(f);
                }
            });
            combo.addActionListener(e -> {
                cargaTX();
            });

            //adjust size and set layout
            setPreferredSize (new Dimension (412, 281));
            setLayout (null);
            txSinopsis.setLineWrap(true);
            JScrollPane sp = new JScrollPane(txSinopsis);
            //add components
            add (jcomp1);
            add (txTitulo);
            add (txFecha);
            add (txGenero);
            add (jcomp5);
            add (jcomp6);
            add (sp);
            add (jcomp8);
            add (combo);
            add (inserta);

            //set component bounds (only needed by Absolute Positioning)
            jcomp1.setBounds (15, 45, 100, 25);
            txTitulo.setBounds (70, 45, 200, 25);
            txFecha.setBounds (70, 75, 200, 25);
            txGenero.setBounds (70, 105, 200, 25);
            jcomp5.setBounds (15, 75, 100, 25);
            jcomp6.setBounds (15, 105, 100, 25);
            txSinopsis.setBounds (70, 135, 200, 105);
            jcomp8.setBounds (15, 135, 100, 25);
            combo.setBounds (70, 15, 200, 25);
            inserta.setBounds (275, 190, 125, 50);
            sp.setBounds (70, 135, 200, 105);
        }

        private void cargaTX() {
            Element e = lista.get(combo.getSelectedIndex());
            txTitulo.setText(e.getElementsByTagName("Titulo").item(0).getTextContent());
            txGenero.setText(e.getElementsByTagName("Genero").item(0).getTextContent());
            txFecha.setText(e.getElementsByTagName("Fecha").item(0).getTextContent());
            txSinopsis.setText(e.getElementsByTagName("sinopsis").item(0).getTextContent());
        }

        static ArrayList<Element> lista= new ArrayList<>();
        private static void cargaXML(File f) {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try{
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(f);
                document.getDocumentElement().normalize();

                //crea una lista con todos los nodos pelicula
                NodeList peliculas = document.getElementsByTagName("Pelicula");
                lista.clear();
                for (int i = 0; i < peliculas.getLength(); i ++) {
                    Node peli = peliculas.item(i);
                    //tipo de nodo
                    if (peli.getNodeType() == Node.ELEMENT_NODE) {
                        //obtener los elementos del nodo
                        Element e = (Element) peli;
                        lista.add(e);
                        combo.addItem(e.getElementsByTagName("Titulo").item(0).getTextContent());
                    }
                }

            } catch (Exception e)
            {e.printStackTrace();}
        }

    }
}

