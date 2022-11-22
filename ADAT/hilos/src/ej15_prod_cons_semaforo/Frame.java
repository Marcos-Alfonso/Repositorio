
package ej15_prod_cons_semaforo;

import javax.swing.JFrame;

/**
 * Ventana que mostrará la ocupación del almacen
 * @author santiago
 */
public class Frame extends JFrame {

    int maxSize=0;
    /**
     * Creates new form FrameBuffer
     */
    public Frame() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jProgressBarBuffer.enableInputMethods(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jProgressBarBuffer = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabelNElem = new javax.swing.JLabel();
        jLabelMax = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nº Elementos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Productor / Consumidor");

        jLabelNElem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNElem.setText("0");

        jLabelMax.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelMax.setForeground(new java.awt.Color(255, 51, 102));
        jLabelMax.setText("0");

        jLabel3.setText("Max");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jProgressBarBuffer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(jLabelNElem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMax, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNElem)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabelMax)))
                .addGap(18, 18, 18)
                .addComponent(jProgressBarBuffer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Registra el tamaño del almacen
     * @param maxSize 
     */
    synchronized public void setMaxSize(int maxSize) {
        this.maxSize=maxSize;
        jLabelMax.setText(Integer.toString(maxSize));
    }
    
    /**
     * Muestra en la ventana el nº de elementos que hay en el almacen
     * @param size 
     */
    synchronized public void setNElemAlmacen(int size) {
        if (maxSize==0) {
            // Puede darse el caso de que se invoque este método antes de incializar
            // el tamaño, evitamos dividir por 0
            return;
        }
        jLabelNElem.setText(String.valueOf(size));
        double porcentaje= size / (double) maxSize;
        jProgressBarBuffer.setValue((int) (porcentaje*100));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelMax;
    private javax.swing.JLabel jLabelNElem;
    private javax.swing.JProgressBar jProgressBarBuffer;
    // End of variables declaration//GEN-END:variables
}
