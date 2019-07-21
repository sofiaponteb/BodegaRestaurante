/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import restaurante.Main;
import static restaurante.Main.escribir;
import restaurante.Restaurante;

/**
 *
 * @author User
 */
public class Sistema extends javax.swing.JFrame {

    private Restaurante restaurante;
    /**
     * Creates new form Sistema
     */
    public Sistema(Restaurante restaurante) {
        initComponents();
        this.restaurante = restaurante;
        this.setResizable(false);
        this.setVisible(true);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent ev) {
                try { 
                    Main.escribir(restaurante);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.exit(0);
            }
        });
    }
    
    public void mostrarPromVentas(){
        String matrix[][] = new String[1][1] ;
        
        matrix[0][0] = Double.toString(restaurante.ventas/restaurante.cnt) ;
        
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
            matrix,
            new String [] {
                ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonColoredAction1 = new org.edisoncor.gui.button.ButtonColoredAction();
        buttonColoredAction2 = new org.edisoncor.gui.button.ButtonColoredAction();
        panelImageReflect1 = new org.edisoncor.gui.panel.PanelImageReflect();
        panelImageReflect2 = new org.edisoncor.gui.panel.PanelImageReflect();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo..jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calisto MT", 1, 24)); // NOI18N
        jLabel1.setText("Bienvenido al sistema de información");

        jLabel2.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        jLabel2.setText("Seleccione la bodega a la que desea ingresar");

        buttonColoredAction1.setBackground(new java.awt.Color(153, 153, 153));
        buttonColoredAction1.setForeground(new java.awt.Color(0, 0, 0));
        buttonColoredAction1.setText("Bodega materia prima");
        buttonColoredAction1.setColorDeSombra(new java.awt.Color(153, 153, 153));
        buttonColoredAction1.setFont(new java.awt.Font("Calisto MT", 1, 36)); // NOI18N
        buttonColoredAction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColoredAction1ActionPerformed(evt);
            }
        });

        buttonColoredAction2.setBackground(new java.awt.Color(153, 153, 153));
        buttonColoredAction2.setForeground(new java.awt.Color(0, 0, 0));
        buttonColoredAction2.setText("Bodega cocina");
        buttonColoredAction2.setColorDeSombra(new java.awt.Color(153, 153, 153));
        buttonColoredAction2.setFont(new java.awt.Font("Calisto MT", 1, 36)); // NOI18N
        buttonColoredAction2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonColoredAction2ActionPerformed(evt);
            }
        });

        panelImageReflect1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/olla.png"))); // NOI18N

        panelImageReflect2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MTP.png"))); // NOI18N

        jButton1.setText("Promedio ventas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(314, 314, 314))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panelImageReflect1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonColoredAction2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(panelImageReflect2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonColoredAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(157, 157, 157)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 414, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonColoredAction1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonColoredAction2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelImageReflect2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelImageReflect1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonColoredAction2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColoredAction2ActionPerformed
        // TODO add your handling code here:
        this.hide();
        new BodegaCocina(restaurante).setVisible(true);
    }//GEN-LAST:event_buttonColoredAction2ActionPerformed

    private void buttonColoredAction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonColoredAction1ActionPerformed
        // TODO add your handling code here:
        this.hide();
        try {
            new MateriaPrima(restaurante).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonColoredAction1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mostrarPromVentas();
    }//GEN-LAST:event_jButton1ActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public void comienza() {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Sistema().setVisible(true);
//               
//            }
//        });
//    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonColoredAction buttonColoredAction1;
    private org.edisoncor.gui.button.ButtonColoredAction buttonColoredAction2;
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelImageReflect panelImageReflect1;
    private org.edisoncor.gui.panel.PanelImageReflect panelImageReflect2;
    // End of variables declaration//GEN-END:variables







}

