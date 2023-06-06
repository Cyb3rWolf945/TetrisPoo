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
package tetris.lib.pieces;

import tetris.lib.blocks.Block;
import tetris.lib.blocks.BlockMatrix;

/**
 * Created on 01/05/2023, 08:20:18
 * moveable Piece in the tetris game
 * 
 * @author IPT - computer
 * @version 1.0
 */
public class Piece extends BlockMatrix {

    //position in the tetris board
    protected int positionX;
    protected int positionY;

    /**
     * Constructor
     * @param mat matriz of blocks
     * @param y position y
     * @param x  position x
     */
    public Piece(Block[][] mat, int y, int x) {
        super(mat); // call constructor of superclasse
        this.positionX = x;
        this.positionY = y;
    }
   /**
    * Copy constructor
    * @param p piece to clone
    */
    public Piece(Piece p) {
        this(p.matrix, p.positionY, p.positionX);
    }

    /**
     * Move piece to left
     */
    public void moveLeft() {
        positionX--;
    }

    /**
     * Move piece to right
     */
    public void moveRight() {
        positionX++;
    }

    /**
     * Move piece to down
     */
    
    public void moveDown() {
        positionY++;
    }

    /**
     * Clone piece
     * @return piece clone
     */
    
    @Override
    public Piece getClone() {
        return new Piece(this);
    }
    //encapsulation of atributes

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "(" + positionY + "," + positionX + ")\n" + super.toString();
    }
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010820L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2023  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////

}
