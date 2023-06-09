package tetris.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import tetris.gui.GameOverDialog;
import tetris.gui.GraphicsTetrisDialog;
import tetris.gui.MainApp;
import tetris.lib.utils.GlobalVariables;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Telmo
 */
public class GameOverDialog extends javax.swing.JFrame {

    private boolean disposed;

    /**
     * Creates new form GameOverDialogs
     */
    public GameOverDialog() {
        initComponents();
        JLabel background;
setLayout(null);
        String userDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
           Path fullPathImage = Paths.get(userDirectory + "\\src\\tetris\\resources\\gameover.png"); 
           Path directoryPathImage = fullPathImage.getParent();
           String finalPathImage = (directoryPathImage + "\\gameover.png");
           String finalPathIcon = (directoryPathImage + "\\icon.png");
           setIconImage(Toolkit.getDefaultToolkit().getImage(finalPathIcon.replace("\\dist", "")));
        ImageIcon img = new ImageIcon(finalPathImage.replace("\\dist", ""));
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 330, 244);
        add(background);

        jLabel1.setText(String.valueOf(GlobalVariables.currentScore));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();  // Close the dialog
                new MainApp().setVisible(true);
            }
        });

        // Set dialog properties
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(338, 282);
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BT_PlayAgain = new javax.swing.JButton();
        BT_Menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BT_PlayAgain.setText("Play Again");
        BT_PlayAgain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_PlayAgainMouseClicked(evt);
            }
        });

        BT_Menu.setText("Menu");
        BT_Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BT_MenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(BT_PlayAgain)
                        .addGap(18, 18, 18)
                        .addComponent(BT_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_PlayAgain)
                    .addComponent(BT_Menu))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BT_PlayAgainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_PlayAgainMouseClicked
        dispose();  // Close the dialog
        GraphicsTetrisDialog a = new GraphicsTetrisDialog();
        GlobalVariables.graphicsTetris = a;
        a.setVisible(true);
    }//GEN-LAST:event_BT_PlayAgainMouseClicked

    private void BT_MenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BT_MenuMouseClicked
        dispose();  // Close the dialog
        new MainApp().setVisible(true);
    }//GEN-LAST:event_BT_MenuMouseClicked
    @Override
    public void setVisible(boolean visible) {
        if (!disposed) {
            super.setVisible(visible);
        }
    }

    @Override
    public void dispose() {
        disposed = true;
        super.dispose();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Frame");

        // Show the dialog on a button click
        JButton showDialogButton = new JButton("Show Dialog");
        showDialogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GameOverDialog();
            }
        });

        // Add the button to the frame
        frame.getContentPane().add(showDialogButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Menu;
    private javax.swing.JButton BT_PlayAgain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
