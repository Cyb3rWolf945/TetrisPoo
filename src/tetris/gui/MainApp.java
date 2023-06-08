/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tetris.gui;

import tetris.lib.utils.Configurations;
import tetris.lib.utils.SoundPlayer;
import tetris.lib.utils.GlobalVariables;
import tetris.gui.GraphicsTetrisDialog;
import tetris.lib.utils.SoundPlayer;

/**
 *
 * @author IPT
 */
public class MainApp extends javax.swing.JFrame {
    /**
     * Creates new form MainApp
     */
    public MainApp() {
        initComponents();
        setLocationRelativeTo(null);
        Configurations config = new Configurations();
        config.ReadConfig();
        if (SoundPlayer.clip == null){
        config.play("C:\\Users\\Telmo\\Documents\\NetBeansProjects\\TetrisPooaa\\src\\tetris\\resources\\Tetris.wav");
        } 
        config.changeVolume(config.getSound());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btAbout = new javax.swing.JButton();
        btPlay = new javax.swing.JButton();
        btAbout1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btAbout2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Text Tetris Demo");

        btAbout.setText("Acerca de ...");
        btAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAboutActionPerformed(evt);
            }
        });

        btPlay.setText("Jogar");
        btPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlayActionPerformed(evt);
            }
        });

        btAbout1.setText("Regras do jogo");
        btAbout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbout1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/tetris.png"))); // NOI18N
        jLabel1.setText("Tetris ver 0.2");

        btAbout2.setText("Configurações");
        btAbout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbout2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAbout1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btAbout2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(btAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAbout2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btAbout1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAboutActionPerformed
        dispose();
        AboutDialog about = new AboutDialog(this, true);
        about.setLocationRelativeTo(btAbout);
        about.setVisible(true);
    }//GEN-LAST:event_btAboutActionPerformed

    private void btPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlayActionPerformed
        dispose();
        GraphicsTetrisDialog a = new GraphicsTetrisDialog(this, true);
        GlobalVariables.graphicsTetris = a;
        a.setVisible(true);
    }//GEN-LAST:event_btPlayActionPerformed

    private void btAbout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbout1ActionPerformed
        dispose();
        new RulesDialog(this, true).setVisible(true);
    }//GEN-LAST:event_btAbout1ActionPerformed

    private void btAbout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbout2ActionPerformed
        dispose();
        Configurations config = new Configurations();
        SoundPlayer soundp = new SoundPlayer();
        System.out.println(SoundPlayer.clip);
        config.stop(SoundPlayer.clip);
        new Configs(this, true, config, soundp ).setVisible(true);
    }//GEN-LAST:event_btAbout2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainApp().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbout;
    private javax.swing.JButton btAbout1;
    private javax.swing.JButton btAbout2;
    private javax.swing.JButton btPlay;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
