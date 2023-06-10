package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

/**
 * Represents the "S" piece in Tetris.
 */
public class PieceS extends Piece {

    public static Block[][] S = {
        {new Empty(new Color(255, 255, 255, 80)), new Block('S', Color.YELLOW), new Block('S', Color.YELLOW)},
        {new Block('S', Color.YELLOW), new Block('S', Color.YELLOW), new Empty(new Color(255, 255, 255, 80))}
    };

    public PieceS() {
        super(S, 0, 0);
    }


}