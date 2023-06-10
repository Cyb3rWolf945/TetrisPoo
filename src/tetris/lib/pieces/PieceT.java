package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

/**
 * Represents the "T" piece in Tetris.
 */
public class PieceT extends Piece {

    public static Block[][] T = {
        {new Block('T', Color.LIGHT_GRAY), new Block('T', Color.LIGHT_GRAY), new Block('T', Color.LIGHT_GRAY)},
        {new Empty(new Color(255, 255, 255, 80)), new Block('T', Color.LIGHT_GRAY), new Empty(Color.LIGHT_GRAY)}
    };

    public PieceT() {
        super(T, 0, 0);
    }

}