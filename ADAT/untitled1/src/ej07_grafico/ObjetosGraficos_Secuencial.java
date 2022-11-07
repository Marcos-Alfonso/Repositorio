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


 Este programa no es concurrente, simula lo que hace el otro que tiene el
 mismo nombre.

Observad la diferencia de velocidad comparado con el que utiliza hilos.
 
 */
package ej07_grafico;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Santiago
 */
public class ObjetosGraficos_Secuencial {

    final int DERECHA = 0, IZQUIERDA = 1, ARRIBA = 2, ABAJO = 3;

    final int SIZE_X = 500; // Ancho ventana
    final int SIZE_Y = 500; // Alto ventana
    final int W_LABEL = 30; // Ancho etiqueta
    final int H_LABEL = 30; // Alto etiqueta

    final int OFFSET = 5;   // Nº de pixels que avanza en cada movimiento

    final int DEMORA = 100; // Milisegundos que esperamos para realizar el siguiente movimiento

    final int PROB_CAMBIADIRECCION = 5; // Porcentaje por el que se cambia de dirección

    final static int N_HILOS = 10;  // Nº de hilos, y etiquetas que se mostrarán

    final Random rnd = new Random();    // Generador de nºs aleatorios. 
    // Cuando trabajamos en concurrencia debemos tratar
    // de garantizar que este objeto es accedido en modo exclusivo
    // en otro caso no hay garantía de que los números sean aleatorios

    JFrame frame;   // Ventana principal (marco)
    JPanel panel;   // La ventana principal tiene un marco

    ObjetosGraficos_Secuencial.SeudoHilo hilos[] = new ObjetosGraficos_Secuencial.SeudoHilo[N_HILOS];

    boolean finaliza = false;

    //
    // METODOS =========================================================
    // 
    // default constructor 
    ObjetosGraficos_Secuencial() {
        initComponents();
    }

    // main class 
    public static void main(String[] args) {
        ObjetosGraficos_Secuencial programa = new ObjetosGraficos_Secuencial();
        programa.ejecutaHilos();
    }

    /**
     * Creamos la ventana principal
     */
    public void initComponents() {
        // create a new frame to stor text field and button 
        frame = new JFrame("Etiquetas");
        panel = new JPanel(); // create a panel 
        panel.setLayout(null);

        // add panel to frame 
        frame.add(panel);
        frame.setSize(SIZE_X, SIZE_Y); // set the size of frame 
        frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

        /**
         * Evento que captura cuando se cierra la ventana. Comunica a los hilos
         * que finalicen
         */
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                finalizaHilos();
            }
        });
        frame.show();   // Obsoleto, aunque a nosotros no nos preocupa

    }

    /**
     * Crea una etiqueta JLabel y la situa en la posición indicada
     *
     * @param x
     * @param y
     * @return
     */
    JLabel creaEtiqueta(int x, int y, String id) {
        // create a label to display text 
        JLabel label = new JLabel();

        // add text to label 
        label.setText(id);
        label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(x, y, W_LABEL, H_LABEL);
        panel.add(label);
        return label;
    }

    /**
     * Lanza los hilos
     */
    public void ejecutaHilos() {
        Rectangle rPanel = panel.getBounds();
        for (int i = 0; i < hilos.length; i++) {
            JLabel l = creaEtiqueta(
                    rnd.nextInt((int) rPanel.getWidth() - W_LABEL),
                    rnd.nextInt((int) rPanel.getHeight() - H_LABEL),
                    Integer.toString(i));
            hilos[i] = new SeudoHilo(l);
            //hilos[i].start();
        }
        bucleHilos();
    }

    /**
     * Bucle infinito que simula el implementado por los hilos
     */
    private void bucleHilos() {
        while (!finaliza) {
            for (int i = 0; i < hilos.length && !finaliza; i++) {
                hilos[i].runOne();
            }
        }
    }

    /**
     * Comunica a todos los hilos que deben finalizar
     */
    public void finalizaHilos() {
        finaliza = true;
    }

    /**
     * *********************************************************************
     * CLASE ANIDADA
     * **********************************************************************
     */
    class SeudoHilo /*extends Thread*/ {

        JLabel label;
        boolean continuarHilo = true;
        int direccion = ABAJO;
        boolean obligaCambioDireccion = false;

        /**
         * Constructor
         *
         * @param label
         */
        public SeudoHilo(JLabel label) {
            this.label = label;
        }

        /**
         * Realiza un movimiento. El bucle principal es el que lanza este método
         */
        public void runOne() {
            calculaDireccion();
            desplazaEtiqueta();
            try {
                Thread.sleep(DEMORA);
            } catch (Exception Ex) {
            }
        }

        /**
         * Marca el hilo para que se finalice
         */
        public void finaliza() {
            continuarHilo = false;
        }

        /**
         * Calcula la dirección en la que se debe mover la etiqueta
         */
        private void calculaDireccion() {
            // Calculamos dirección de movimiento
            if (rnd.nextInt(100) < PROB_CAMBIADIRECCION || obligaCambioDireccion) {
                direccion = rnd.nextInt(4);
                obligaCambioDireccion = false;
            }
        }

        /**
         * Mueve la etiqueta en la dirección calculada y comprueba que no se
         * salga de los límites de la ventana
         */
        private void desplazaEtiqueta() {
            Rectangle rLabel = label.getBounds();
            Rectangle rPanel = panel.getBounds();

            int newX = ((int) rLabel.getX());
            int newY = ((int) rLabel.getY());
            System.out.print("\nDirección " + label.getText() + " =" + direccion + "(" + newX + "," + newY + ")");

            switch (direccion) {
                case DERECHA:
                    if (newX + OFFSET < rPanel.getWidth() - rLabel.getWidth()) {
                        newX += OFFSET;
                    } else {
                        obligaCambioDireccion = true;
                    }
                    break;
                case IZQUIERDA:
                    if (newX - OFFSET > 0) {
                        newX -= OFFSET;
                    } else {
                        obligaCambioDireccion = true;
                    }
                    break;
                case ARRIBA:
                    if (newY - OFFSET > 0) {
                        newY -= OFFSET;
                    } else {
                        obligaCambioDireccion = true;
                    }
                    break;
                case ABAJO:
                    if (newY + OFFSET < rPanel.getHeight() - rLabel.getHeight()) {
                        newY += OFFSET;
                    } else {
                        obligaCambioDireccion = true;
                    }
                    break;
            }
            rLabel.setLocation(newX, newY);
            label.setBounds(rLabel);
        }
    }

}
