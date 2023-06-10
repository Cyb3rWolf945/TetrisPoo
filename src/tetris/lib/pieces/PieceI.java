package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

/**
 * Represents the "I" piece in Tetris.
 */
public class PieceI extends Piece {

    public static Block[][] I = {
        {new Block('I', Color.GREEN), new Block('I', Color.GREEN), new Block('I', Color.GREEN), new Block('I', Color.GREEN)}
    };

    public PieceI() {
        super(I, 0, 0);
    }


}