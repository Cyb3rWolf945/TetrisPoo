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
package tetris.lib.game;

import java.awt.Graphics;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;
import tetris.lib.blocks.BlockMatrix;
import tetris.lib.pieces.Piece;
import tetris.lib.utils.TetrisPiece;

/**
 * Created on 01/05/2023, 08:48:11
 *
 * represents a tetris board with a floating piece
 *
 * @author IPT - computer
 * @version 1.0
 */
public class Board extends BlockMatrix {

    @Override
    public void paintComponent(Graphics g) {
        draw(g, 0, 0, getWidth(), getHeight());
    }

    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        super.draw(gr, px, py, width, height);
        int sizeX = width / getColmuns();
        int sizeY = height / getLines();       
        current.draw(gr, px + current.getPositionX() * sizeX,
                py + current.getPositionY() * sizeY,
                sizeX * current.getColmuns(),
                sizeY * current.getLines());
    }

    /**
     * Floating piece in the board
     */
    Piece current;

    public Board() {
        this(30, 20);
    }

    /**
     * Constructor
     *
     * @param mat matrix of board blocks
     * @param current floating piece
     */
    public Board(Block[][] mat, Piece current) {
        super(mat); // call constructor of supercalsse
        this.current = current.getClone(); // clone piece
    }

    /**
     * Copy constructor
     *
     * @param b board
     */
    public Board(Board b) {
        this(b.matrix, b.current);
    }
    
    public Board(int rows, int columns, String a){
        this(rows, columns);
    }

    /**
     * Constructor with dimensions<br>
     * build a board with 2d board of empty pieces
     *
     * @param lines number of lines
     * @param columns number of columns
     */
    public Board(int lines, int columns) {
        resize(lines, columns);
    }

    @Override
    public void resize(int lines, int columns) {
        this.matrix = new Block[lines][columns];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {

                matrix[y][x] = new Empty();
            }
        }
        generateRandomPiece();
    }

    /**
     * generate a random floating piece
     */
    public void generateRandomPiece() {
        this.current = TetrisPiece.generateRandom();
        //update the position x of piece to the midle of the board
        this.current.setPositionX(getColmuns() / 2 - current.getColmuns() / 2);
        //top of the board
        this.current.setPositionY(0);
        repaint();
    }

    /**
     * transfer the floating piece to the board
     */
    public void freezePiece() {
        //iterate blocks
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColmuns(); x++) {
                //if block is not empty
                if (!(current.getMatrix()[y][x] instanceof Empty)) {
                    //freeze block
                    this.matrix[current.getPositionY() + y][current.getPositionX() + x] = current.getMatrix()[y][x];
                }
            }
        }
        repaint();
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        //clone board
        Board tmp = new Board(this);
        //freeze the floating piece
        tmp.freezePiece();
        //get the board        
        for (int y = 0; y < getLines(); y++) {
            for (int x = 0; x < getColmuns(); x++) {
                txt.append(tmp.matrix[y][x]);
            }
            txt.append("\n");
        }
        return txt.toString();
    }

    /**
     * floating piece can move to
     *
     * @param dy displacement in y
     * @param dx displacement ix
     * @return
     */
    public boolean canMovePiece(int dy, int dx) {
        //iterate current piece block matrix
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColmuns(); x++) {
                //if block is empty - continue to next
                if (current.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                //new position
                int px = current.getPositionX() + x + dx;
                int py = current.getPositionY() + y + dy;

                //is within limits
                if (px >= getColmuns() || px < 0 || py >= getLines() || py < 0
                        //not Empty
                        || !(matrix[py][px] instanceof Empty)) {
                    return false; // NOT MOVE
                }
            }
        }
        return true; //CAN MOVE
    }

    /**
     * Floating piece can rotate
     *
     * @return piece can rotate
     */
    public boolean canRotatePiece() {
        //clone piece
        Piece clone = current.getClone();
        //rotate clone
        clone.rotate();
        //piece is outside board
        if (clone.getPositionX() + clone.getColmuns() > getColmuns()) {
            return false;
        }
        //verify all the block of the clone
        for (int y = 0; y < clone.getLines(); y++) {
            for (int x = 0; x < clone.getColmuns(); x++) {
                //block is empty - continue to next
                if (clone.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                //is in the limits 
                if (x < getColmuns() && x >= 0 && y < getLines() && y >= 0
                        //is not empty
                        && !(matrix[y][x] instanceof Empty)) {
                    return false; // NOT Ratation avaiable
                }
            }
        }
        return true; // Can Rotate
    }

    /**
     * move piece to left
     */
    public void moveLeft() {
        if (canMovePiece(0, -1)) {
            current.moveLeft();
            repaint();
        }
    }

    /**
     * move piece to right
     */
    public void moveRight() {
        if (canMovePiece(0, 1)) {
            current.moveRight();
            repaint();
        }
    }

    /**
     * move piece down
     */
    public void moveDown() {
        if (canMovePiece(1, 0)) {
            current.moveDown();            
            repaint();
        }
    }

    /**
     * fall down the piece
     */
    public void fallDown() {
        while (canMovePiece(1, 0)) {
            current.moveDown();
        }
    }

    /**
     * rotate piece
     */
    public void rotate() {
        if (canRotatePiece()) {
            current.rotate();
            repaint();
        }
    }

    //encapsulation
    public Piece getCurrent() {
        return current;
    }

    public void setCurrent(Piece current) {
        this.current = current;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010848L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2023  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}
