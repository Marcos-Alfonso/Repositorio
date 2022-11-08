import javax.swing.*;
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

    private static void cargaXML(File f) {

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
