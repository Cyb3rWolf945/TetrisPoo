/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tetris.gui;

import java.awt.Toolkit;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import tetris.lib.utils.Configurations;
import tetris.lib.utils.SoundPlayer;
import tetris.lib.utils.GlobalVariables;
import tetris.gui.GraphicsTetrisDialog;
import tetris.interfaces.Config;
import tetris.lib.utils.SoundPlayer;

/**
 *
 * @author IPT
 */
public class MainApp extends javax.swing.JFrame {

    Configurations config = new Configurations();

    /**
     * Creates new form MainApp
     */
    public MainApp() {
        // Initialize components
        initComponents();

        // Set the location of the frame relative to the center of the screen
        setLocationRelativeTo(null);

        // Declare a JLabel variable for the background
        JLabel background;

        // Set the layout to null (no layout manager)
        setLayout(null);

        // Set the background image
        ImageIcon img = new ImageIcon(config.getFilePathImage("menu.png"));
        setIconImage(Toolkit.getDefaultToolkit().getImage(config.getFilePathImage("icon.png")));
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 312, 300);
        add(background);

        setVisible(true);

        // Read configuration
        config.ReadConfig(config.getCurrentPath());

        // Set the actual volume for sound
        SoundPlayer.actualVolume = config.getSound();

        // Play Tetris music if the clip is null
        if (SoundPlayer.clip == null) {
            config.play(config.getFilePathSound("Tetris.wav"));
        }

        // Set volume for Tetris music, piece sound, and line sound
        config.setVolumeTetrisMusic();
        config.setVolumePieceSound();
        config.setVolumeLineSound();

        // Set the current difficulty
        GlobalVariables.currentDifficulty = config.getDifficulty();
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
        btPlay = new javax.swing.JButton();
        btAbout1 = new javax.swing.JButton();
        btAbout2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Text Tetris Demo");
        setResizable(false);

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
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btAbout1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btAbout2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btAbout2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btAbout1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlayActionPerformed
        // Close the current dialog
        dispose();

        // Create a new instance of GraphicsTetrisDialog
        GraphicsTetrisDialog a = new GraphicsTetrisDialog();

        // Assign the new instance to the GlobalVariables.graphicsTetris variable
        GlobalVariables.graphicsTetris = a;

        // Set the new dialog as visible
        a.setVisible(true);
    }//GEN-LAST:event_btPlayActionPerformed

    private void btAbout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbout1ActionPerformed
        // Close the current dialog
        dispose();

        // Create a new instance of ControlsDialog and set it as visible
        new ControlsDialog(config).setVisible(true);
    }//GEN-LAST:event_btAbout1ActionPerformed

    private void btAbout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbout2ActionPerformed
        // Close the current dialog
        dispose();

        // Create a new instance of Configurations with the specified parameters
        Configurations config = new Configurations(3, 3, SoundPlayer.actualVolume, GlobalVariables.currentDifficulty);

        // Create a new instance of SoundPlayer
        SoundPlayer soundp = new SoundPlayer();

        // Output the value of SoundPlayer.clip to the console
        System.out.println(SoundPlayer.clip);

        // Create a new instance of Configs and set it as visible
        new Configs(config, soundp).setVisible(true);
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
    private javax.swing.JButton btAbout1;
    private javax.swing.JButton btAbout2;
    private javax.swing.JButton btPlay;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
