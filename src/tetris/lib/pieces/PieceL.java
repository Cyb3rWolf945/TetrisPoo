package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

/**
 * Represents the "L" piece in Tetris.
 */
public class PieceL extends Piece {

    public static Block[][] L = {
        {new Block('L', Color.MAGENTA), new Empty(new Color(255, 255, 255, 80))},
        {new Block('L', Color.MAGENTA), new Empty(new Color(255, 255, 255, 80))},
        {new Block('L', Color.MAGENTA), new Block('L', Color.MAGENTA)},
    };

    public PieceL() {
        super(L, 0, 0);
    }

}