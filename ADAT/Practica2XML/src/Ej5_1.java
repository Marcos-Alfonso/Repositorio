import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Ej5_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi primera GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout bl = new BorderLayout();
        frame.setLayout(bl);
        frame.setSize(300, 300);

        JButton b = new JButton("Presionar");
        frame.getContentPane().add(b, BorderLayout.CENTER);
        b.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File f = chooser.getSelectedFile();

            } else {

            }
        });

        frame.setVisible(true);
    }

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


}
