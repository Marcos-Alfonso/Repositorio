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
package Ej3_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

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

    final int MAX_SEPARACION = 200;

    final int DEMORA_BASE = 100; // Milisegundos que esperamos para realizar el siguiente movimiento
    final int VELOCIDAD = 15;

    final boolean ESPERA_ACTIVA = false; // Indica si la demora se hace con espera activa o con sleep

    final int N_HILOS = (int) SIZE_Y / SIZE_CARRIL;  // Nº de hilos y etiquetas que se mostrarán, tantas como caben en vertical

    final Random rnd = new Random();    // Generador de nºs aleatorios. 
    // Cuando trabajamos en concurrencia debemos tratar
    // de garantizar que este objeto es accedido en modo exclusivo
    // en otro caso no hay garantía de que los números sean aleatorios

    JFrame frame;   // Ventana principal (marco)
    JPanel panel;   // La ventana principal tiene un marco

    final Hilo hilos[] = new Hilo[N_HILOS];

    //
    // METODOS =========================================================
    // 
    // default constructor 
    public CarreraSolidariaParar() {
        initComponents();
        ejecutaHilos();
    }

    // main class 
    public static void main(String[] args) {
        CarreraSolidariaParar programa = new CarreraSolidariaParar();
    }

    /**
     * Creamos la ventana principal
     */
    public void initComponents() {

        frame = new JFrame("Etiquetas");
        panel = new JPanel(); // create a panel 
        panel.setLayout(null);

        frame.getContentPane().add(panel);
        frame.setSize(SIZE_X, SIZE_Y); // set the size of frame 
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                finalizaHilos();
            }
        });

        frame.setVisible(true);

    }

    //Crea una etiqueta JLabel y la situa en la posición indicada

    JLabel creaEtiqueta(int x, int y, String id) {
        // create a label to display text 
        JLabel label = new JLabel();

        // add text to label 
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
        boolean encontrado = false;
        while(!encontrado && idx < 24){
            if(!hilos[idx].continuarHilo){
                idx++;
            }else{
                encontrado = true;
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
        Hilo bloqueadoPor = null;

        public Hilo(JLabel label) {
            this.label = label;
            this.textLabel = label.getText();
        }

        @Override
        public void run() {
            try {
                while (continuarHilo) {
                    //System.out.print("\n [ " + getLabel().getText() + " ]");
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




            this.label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
            label.setText(textLabel + "(" + separacion + ")");
            if (separacion > MAX_SEPARACION) {
                // Penalizado
                label.setForeground(Color.RED);
                label.setBackground(Color.GRAY);
                System.out.print("\n" + getLabel().getText() + " Bloqueado");

                this.label.setText(textLabel + "<" + ultimo.textLabel + ">");

                try {
                    this.bloqueadoPor = ultimo;
                    synchronized (this) {
                        wait();
                    }
                    System.out.print("\n" + getLabel().getText() + " Despierta");
                    this.label.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));
                } catch (InterruptedException interruptedException) {}


            }
            despiertaDemas();
        }
        private void despiertaDemas(){
            for (Hilo h:hilos) {
                if(h.bloqueadoPor == this && h.getX() <= this.getX()){
                    synchronized (h) {
                        h.notify();
                        h.bloqueadoPor = null;
                    }
                }
            }
        }
        public JLabel getLabel() {
            return label;
        }
    }

}
