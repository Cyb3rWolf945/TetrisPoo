//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2023   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////

package tetris.lib.blocks;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import tetris.gui.Drawable;

/**
 * Represents a block in the Tetris game.
 * It extends JComponent and implements the Drawable interface.
 * Created on 26/04/2023, 04:05:22
 * 
 * @author manso - computer
 */
public class Block extends JComponent implements Drawable {
    
    protected char txt; // Character representing the block
    protected Color myColor; // Color of the block

    /**
     * Default constructor.
     * Creates a Block with a space character and blue color.
     */
    public Block() {
        this(' ', Color.BLUE);
    }
    
    /**
     * Constructor with character and color parameters.
     * 
     * @param ch the character representing the block
     * @param color the color of the block
     */
    public Block(char ch, Color color) {
        this.txt = ch;
        this.myColor = color;
    }
    
    /**
     * Constructor with character parameter.
     * Creates a Block with the specified character and default white color.
     * 
     * @param ch the character representing the block
     */
    public Block(char ch) {
        this(ch, Color.WHITE);
    }
    
    /**
     * Copy constructor.
     * Creates a Block with the same character and color as the specified Block.
     * 
     * @param b the Block to be copied
     */
    public Block(Block b) {
        this(b.txt, b.myColor);
    }
    
    /**
     * Get the character representing the block.
     * 
     * @return the character representing the block
     */
    public char getTxt() {
        return txt;
    }
    
    /**
     * Set the character representing the block.
     * 
     * @param txt the character representing the block
     */
    public void setTxt(char txt) {
        this.txt = txt;
    }
    
    /**
     * Get the color of the block.
     * 
     * @return the color of the block
     */
    public Color getMyColor() {
        return myColor;
    }
    
    /**
     * Set the color of the block.
     * 
     * @param myColor the color of the block
     */
    public void setMyColor(Color myColor) {
        this.myColor = myColor;
    }
    
    /**
     * Paint the component by drawing the block.
     * 
     * @param gr the Graphics object
     */
    @Override
    public void paintComponent(Graphics gr) {
        super.paintComponent(gr); // Build component
        draw(gr, 0, 0, getWidth() - 1, getHeight() - 1);
    }

    /**
     * Draw the block with the specified dimensions and color.
     * 
     * @param gr the Graphics object
     * @param px the x-coordinate of the block's top-left corner
     * @param py the y-coordinate of the block's top-left corner
     * @param width the width of the block
     * @param height the height of the block
     */
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        // Set color for filling
        gr.setColor(myColor);
        
        // Fill the block
        gr.fill3DRect(px, py, width, height, true);
        gr.setColor(myColor);
        gr.drawRect(px, py, width, height);
        
        // Set color for lines
        gr.setColor(new Color(255, 255, 255, 0));
        
        // Draw lines
        gr.draw3DRect(px, py, width, height, true);
    }
    
    /**
     * Get a clone of the Block.
     * 
     * @return a new Block object with the same character and color
     */
    public Block getClone() {
        return new Block(this);
    }

    /**
     * Get a string representation of the Block.
     * 
     * @return a string representation of the character
     */
    @Override
    public String toString() {
        return String.valueOf(txt);
    }

}