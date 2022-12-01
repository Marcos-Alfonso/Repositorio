/*
   Ejemplo en el que se utiliza una interfaz gráfica y múltiples hilos
   para modificar los componentes de la ventana.

   El programa consistirá en una seríe de etiquetas que se van moviendo
   aleatoriamente en todas direcciones dentro de una ventana. 
   Para cada elemento crearemos un hilo

   Cuando trabajamos en una aplicación con interfaz gráfica debemos tener
   en cuenta que los métodos que acceden a modificar la ventana estarán 
   sincronizados para evitar inconsistencias debidas a la concurrencia.

 * Para saber como se crea una etiqueta
 * Véase https://www.geeksforgeeks.org/jlabel-java-swing/
 */
package Ej3_1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Santi
 */
public class CarreraSolidariaParar {

    final int SIZE_X = 1200; // Ancho ventana
    final int SIZE_Y = 700; // Alto ventana
    final int W_LABEL = 25 * 3; // Ancho etiqueta
    final int H_LABEL = 25; // Alto etiqueta

    final int SALTO = 15;   // Nº de pixels máximo que avanza en cada movimiento
    final int SEP_Y = 4;    // separación entre etiquetas
    final int SIZE_CARRIL = (H_LABEL + SEP_Y);

    final int MAX_SEPARACION = 150;

    final int DEMORA_BASE = 100; // Milisegundos que esperamos para realizar el siguiente movimiento
    final int VELOCIDAD = 15;

    final boolean ESPERA_ACTIVA = false; // Indica si la demora se hace con espera activa o con sleep

    final int N_HILOS = (int) SIZE_Y / SIZE_CARRIL;  // Nº de hilos y etiquetas que se mostrarán, tantas como caben en vertical

    final Random rnd = new Random();    // Generador de nºs aleatorios.

    JFrame frame;   // Ventana principal (marco)
    JPanel panel;   // La ventana principal tiene un marco

    final CarreraSolidariaParar.Hilo hilos[] = new CarreraSolidariaParar.Hilo[N_HILOS];

    public CarreraSolidariaParar() {
        initComponents();
        ejecutaHilos();
    }

    public static void main(String[] args) {
        CarreraSolidariaParar programa = new CarreraSolidariaParar();
    }


    public void initComponents() {
        // create a new frame to stor text field and button 
        frame = new JFrame("Etiquetas");
        panel = new JPanel(); // create a panel 
        panel.setLayout(null);

        // add panel to frame 
        //frame.add(panel);
        frame.getContentPane().add(panel);
        frame.setSize(SIZE_X, SIZE_Y); // set the size of frame 
        frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                finalizaHilos();
            }
        });
        frame.setVisible(true);

    }

    JLabel creaEtiqueta(int x, int y, String id) {

        JLabel label = new JLabel();

        label.setText(id);
        label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(x, y, W_LABEL, H_LABEL);
        label.setOpaque(true);
        panel.add(label);
        return label;
    }

    public void ejecutaHilos() {
        for (int i = 0; i < hilos.length; i++) {
            JLabel l = creaEtiqueta(0, i * SIZE_CARRIL + SEP_Y / 2, Integer.toString(i + 1));
            hilos[i] = new Hilo(l);
        }
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].start();
        }
    }

    public int posPrimero() {
        int x = 0;
        for (int i = 0; i < hilos.length; i++) {
            Rectangle rectLabel = hilos[i].getLabel().getBounds();
            if (hilos[i].continuarHilo && (int) rectLabel.getX() >= x) {
                x = (int) rectLabel.getX();
            }
        }
        return x;
    }

    public Hilo ultimo() {

        int idx = 0;
        boolean found = false;
        while(!found && idx < hilos.length){
            if(!hilos[idx].continuarHilo){
                idx++;
            }else{
                found = true;
            }
        }
        for (int i = 0; i < hilos.length; i++) {
            if (hilos[i].continuarHilo && hilos[i].getX() <= hilos[idx].getX()) {
                idx = i;
            }
        }

        return hilos[idx];
    }
    public void finalizaHilos() {
        for (int i = 0; i < hilos.length; i++) {
            hilos[i].finaliza();

        }
    }

    class Hilo extends Thread {

        private JLabel label;
        private String textLabel;
        boolean continuarHilo = true;


        public Hilo(JLabel label) {
            this.label = label;
            this.textLabel = label.getText();
        }

        @Override
        public void run() {
            try {
                while (continuarHilo) {
                    desplazaEtiqueta();
                    int espera = rnd.nextInt(DEMORA_BASE) * rnd.nextInt(VELOCIDAD);
                    if (ESPERA_ACTIVA) {
                        double inicio = System.currentTimeMillis();
                        while (System.currentTimeMillis() < inicio + espera);
                    } else {
                        try {
                            Thread.sleep(espera);
                        } catch (Exception Ex) {
                        }
                    }
                    System.out.println("\nFinalizado " + getLabel().getText());
                }
            } catch (Exception e) {
                System.out.println("\nFinalizado " + getLabel().getText() + " ANOMALO");
            }
        }

        public int getX() {
            return (int) label.getBounds().getX();
        }

        public void finaliza() {
            continuarHilo = false;
        }

        private void desplazaEtiqueta() throws Exception {
            Rectangle rectLabel = label.getBounds();
            Rectangle rectPanel = panel.getBounds();

            int newX = ((int) rectLabel.getX());
            int y = ((int) rectLabel.getY());
            int salto = SALTO;
            if (newX + salto < rectPanel.getWidth() - rectLabel.getWidth()) {
                newX += salto;
            } else {

                newX = (int) (rectPanel.getWidth() - rectLabel.getWidth());
                continuarHilo = false;
                System.out.print("\n** Termina " + getLabel().getText());
            }
            rectLabel.setLocation(newX, y);
            label.setBounds(rectLabel);
            Hilo ultimo = ultimo();
            int primeroX = posPrimero();
            int ultimoX = ultimo.getX();
            int separacion = newX - ultimoX;

            if (!ultimo.continuarHilo) {
                throw new Exception("El último no puede estar muerto");
            }

            if (newX == primeroX) {
                label.setForeground(Color.YELLOW);
                label.setBackground(Color.BLUE);
            } else if (newX == ultimoX) {
                label.setForeground(Color.ORANGE);
                label.setBackground(Color.CYAN);
            } else {
                label.setForeground(Color.BLACK);
                label.setBackground(Color.WHITE);
            }
            label.setText(textLabel + "(" + separacion + ")");
            if (separacion > MAX_SEPARACION) {
                // Penalizado
                label.setForeground(Color.RED);
                label.setBackground(Color.GRAY);
                System.out.print("\n" + getLabel().getText() + " Descalificado");
                this.continuarHilo = false;
                this.label.setText(textLabel + "<" + ultimo.textLabel + ">");
            }
        }
        public JLabel getLabel() {
            return label;
        }
    }

}
