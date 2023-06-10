package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;

/**
 * Represents the "O" piece in Tetris.
 */
public class PieceO extends Piece {

    public static Block[][] O = {
        {new Block('O', Color.ORANGE), new Block('O', Color.ORANGE)},
        {new Block('O', Color.ORANGE), new Block('O', Color.ORANGE)}
    };

    public PieceO() {
        super(O, 0, 0);
    }

}