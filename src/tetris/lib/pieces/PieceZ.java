package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

/**
 * Represents the "Z" piece in Tetris.
 */
public class PieceZ extends Piece {

    public static Block[][] Z = {
        {new Block('Z', Color.RED), new Block('Z', Color.RED), new Empty(new Color(255, 255, 255, 80))},
        {new Empty(new Color(255, 255, 255, 80)), new Block('Z', Color.RED), new Block('Z', Color.RED)}
    };

    public PieceZ() {
        super(Z, 0, 0);
    }

}