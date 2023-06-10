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

/**
 * Represents an empty block in the Tetris game.
 * It extends the Block class.
 * Created on 26/04/2023, 04:06:26
 * 
 * @author manso - computer
 */
public class Empty extends Block {
    
    public static Color colorPiece; // Color of the empty block
    
    /**
     * Default constructor.
     * Creates an empty block with the specified color.
     * 
     * @param color the color of the block
     */
    public Empty(Color color) {
        super('.', color);
        colorPiece = new Color(255, 255, 255, 1);
    }

    /**
     * Get a clone of the Empty block.
     * 
     * @return a new Empty block object with the same color
     */
    @Override
    public Block getClone() {
        return new Empty(colorPiece);
    }
}