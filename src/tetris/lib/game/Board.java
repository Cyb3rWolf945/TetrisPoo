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

import java.awt.Color;
import java.awt.Graphics;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;
import tetris.lib.blocks.BlockMatrix;
import tetris.lib.pieces.Piece;
import tetris.lib.utils.TetrisPiece;

/**
 * Represents a Tetris board with a floating piece.
 * It extends the BlockMatrix class.
 * Created on 01/05/2023, 08:48:11
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
     * The floating piece on the board.
     */
    Piece current;

    /**
     * Default constructor.
     * Creates a board with default dimensions (30 lines, 20 columns).
     */
    public Board() {
        this(10, 10);
    }

    /**
     * Constructor with matrix and current piece.
     *
     * @param mat the matrix of board blocks
     * @param current the floating piece
     */
    public Board(Block[][] mat, Piece current) {
        super(mat);
        this.current = current.getClone();
    }

    /**
     * Copy constructor.
     *
     * @param b the board
     */
    public Board(Board b) {
        this(b.matrix, b.current);
    }

    /**
     * Constructor with dimensions.
     * Builds a board with a 2D matrix of empty pieces.
     *
     * @param lines the number of lines
     * @param columns the number of columns
     */
    public Board(int lines, int columns) {
        resize(lines, columns);
    }

    @Override
    public void resize(int lines, int columns) {
        this.matrix = new Block[lines][columns];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x] = new Empty(Color.BLACK);
            }
        }
        generateRandomPiece();
    }

    /**
     * Generate a random floating piece.
     */
    public void generateRandomPiece() {
        this.current = TetrisPiece.generateRandom();
        this.current.setPositionX(getColmuns() / 2 - current.getColmuns() / 2);
        this.current.setPositionY(-1);
        repaint();
    }

    /**
     * Transfer the floating piece to the board.
     */
    public void freezePiece() {
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColmuns(); x++) {
                if (!(current.getMatrix()[y][x] instanceof Empty)) {
                    this.matrix[current.getPositionY() + y][current.getPositionX() + x] = current.getMatrix()[y][x];
                }
            }
        }
        repaint();
    }

    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        Board tmp = new Board(this);
        tmp.freezePiece();
        for (int y = 0; y < getLines(); y++) {
            for (int x = 0; x < getColmuns(); x++) {
                txt.append(tmp.matrix[y][x]);
            }
            txt.append("\n");
        }
        return txt.toString();
    }

    /**
     * Check if the floating piece can move in the specified direction.
     *
     * @param dy the displacement in the y-axis
     * @param dx the displacement in the x-axis
     * @return true if the piece can move, false otherwise
     */
    public boolean canMovePiece(int dy, int dx) {
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColmuns(); x++) {
                if (current.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                int px = current.getPositionX() + x + dx;
                int py = current.getPositionY() + y + dy;
                if (px >= getColmuns() || px < 0 || py >= getLines() || py < 0
                        || !(matrix[py][px] instanceof Empty)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if the floating piece can rotate.
     *
     * @return true if the piece can rotate, false otherwise
     */
    public boolean canRotatePiece() {
        Piece clone = current.getClone();
        clone.rotate();

        if (clone.getPositionX() + clone.getColmuns() > getColmuns() ||
            clone.getPositionY() + clone.getLines() > getLines()) {
            return false;
        }

        for (int y = 0; y < clone.getLines(); y++) {
            for (int x = 0; x < clone.getColmuns(); x++) {
                if (clone.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                int absoluteX = clone.getPositionX() + x;
                int absoluteY = clone.getPositionY() + y;
                if (absoluteX < 0 || absoluteX >= getColmuns() ||
                    absoluteY < 0 || absoluteY >= getLines() ||
                    !(matrix[absoluteY][absoluteX] instanceof Empty)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Move the floating piece to the left.
     */
    public void moveLeft() {
        if (canMovePiece(0, -1)) {
            current.moveLeft();
            repaint();
        }
    }

    /**
     * Move the floating piece to the right.
     */
    public void moveRight() {
        if (canMovePiece(0, 1)) {
            current.moveRight();
            repaint();
        }
    }

    /**
     * Move the floating piece down.
     */
    public void moveDown() {
        if (canMovePiece(1, 0)) {
            current.moveDown();
            repaint();
        }
    }

    /**
     * Move the floating piece all the way down.
     */
    public void fallDown() {
        while (canMovePiece(1, 0)) {
            current.moveDown();
        }
    }

    /**
     * Rotate the floating piece.
     */
    public void rotate() {
        if (canRotatePiece()) {
            current.rotate();
            repaint();
        }
    }

    // Getters and Setters

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

