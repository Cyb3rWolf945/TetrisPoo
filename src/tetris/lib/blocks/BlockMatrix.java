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
import javax.swing.JPanel;
import tetris.gui.Drawable;

/**
 * Represents a 2D matrix of blocks in the Tetris game.
 * It extends JPanel and implements the Drawable interface.
 * Created on 01/05/2023, 08:12:47
 * 
 * @author IPT - computer
 * @version 1.0
 */
public class BlockMatrix extends JPanel implements Drawable {

    protected Block[][] matrix; // Matrix of blocks
    
    /**
     * Default constructor.
     * Creates a BlockMatrix with a single empty block.
     */
    public BlockMatrix() {
        this(new Block[][]{{new Empty(Color.BLACK)}});
    }

    /**
     * Constructor with matrix parameter.
     * Creates a BlockMatrix with the specified matrix of blocks.
     * 
     * @param mat the matrix of blocks
     */
    public BlockMatrix(Block[][] mat) {
        this.matrix = new Block[mat.length][mat[0].length];
        for (int y = 0; y < mat.length; y++) {
            for (int x = 0; x < mat[y].length; x++) {
                this.matrix[y][x] = mat[y][x].getClone();
            }
        }
    }

    /**
     * Copy constructor.
     * Creates a BlockMatrix with the same matrix of blocks as the specified BlockMatrix.
     * 
     * @param blockMat the BlockMatrix to be copied
     */
    public BlockMatrix(BlockMatrix blockMat) {
        this(blockMat.matrix);
    }

    /**
     * Get the matrix of blocks.
     * 
     * @return the matrix of blocks
     */
    public Block[][] getMatrix() {
        return matrix;
    }

    /**
     * Get the number of lines in the matrix.
     * 
     * @return the number of lines
     */
    public int getLines() {
        return matrix.length;
    }

    /**
     * Get the number of columns in the matrix.
     * 
     * @return the number of columns
     */
    public int getColmuns() {
        return matrix[0].length;
    }

    /**
     * Rotate the matrix to the right side.
     */
    public void rotate() {
        int lines = matrix.length;
        int cols = matrix[0].length;
        Block[][] tmp = new Block[cols][lines];
        for (int y = 0; y < lines; y++) {
            for (int x = 0; x < cols; x++) {
                tmp[x][lines - y - 1] = matrix[y][x];
            }
        }
        this.matrix = tmp;
    }

    /**
     * Paint the component by drawing the matrix of blocks.
     * 
     * @param g the Graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g, 0, 0, getWidth(), getHeight());
    }

    /**
     * Draw the matrix of blocks on the graphics context.
     * 
     * @param gr the Graphics object
     * @param px the x-coordinate of the top-left corner
     * @param py the y-coordinate of the top-left corner
     * @param width the width of the drawing area
     * @param height the height of the drawing area
     */
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        int sizeX = width / getColmuns();
        int sizeY = height / getLines();
        for (int y = 0; y < getLines(); y++) {
            for (int x = 0; x < getColmuns(); x++) {
                matrix[y][x].draw(gr, px + x * sizeX, py + y * sizeY, sizeX, sizeY);
            }
        }
    }

    /**
     * Get a clone of the BlockMatrix.
     * 
     * @return a new BlockMatrix object with the same matrix of blocks
     */
    public BlockMatrix getClone() {
        return new BlockMatrix(this);
    }

    /**
     * Get a string representation of the BlockMatrix.
     * 
     * @return a string representation of the matrix of blocks
     */
    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (Block[] matrixLine : matrix) {
            for (Block block : matrixLine) {
                txt.append(block.toString()).append(" ");
            }
            txt.append("\n");
        }
        return txt.toString();
    }

    private static final long serialVersionUID = 202305010812L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2023  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}