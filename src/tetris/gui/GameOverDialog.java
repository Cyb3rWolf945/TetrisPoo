package tetris.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import tetris.lib.utils.GlobalVariables;
import tetris.gui.GraphicsTetrisDialog;

public class GameOverDialog extends JDialog {
    private boolean disposed;
    public GameOverDialog(Frame parent) {
        super(parent, "Game Over", true);

        // Create the components
        JLabel gameOverLabel = new JLabel("Game Over");
        JButton playAgainButton = new JButton("Play Again");
        JButton menuButton = new JButton("Menu");

        // Set the layout manager for the content pane
        getContentPane().setLayout(new GridBagLayout());

        // Create GridBagConstraints to center align the label
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Add the label to the content pane
        getContentPane().add(gameOverLabel, gbc);

        // Create a panel for the buttons and set its layout manager
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // Add components to the button panel
        buttonPanel.add(playAgainButton);
        buttonPanel.add(menuButton);

        // Add the button panel below the label
        gbc.gridy = 1;
        getContentPane().add(buttonPanel, gbc);

        // Set the button actions
        playAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();  // Close the dialog
                GraphicsTetrisDialog a = new GraphicsTetrisDialog(null, true);
                GlobalVariables.graphicsTetris = a;
                a.setVisible(true);
            }
        });

        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();  // Close the dialog
                new MainApp().setVisible(true);
            }
        });
        
         addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();  // Close the dialog
                new MainApp().setVisible(true);
            }
        });

        // Set dialog properties
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setVisible(true);
        
        
        
        
        
        
       
    }
    
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
                new GameOverDialog(frame);
            }
        });

        // Add the button to the frame
        frame.getContentPane().add(showDialogButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
   
    
    
}