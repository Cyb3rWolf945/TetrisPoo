package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

/**
 * Represents the "J" piece in Tetris.
 */
public class PieceJ extends Piece {

    public static Block[][] J = {
        {new Empty(new Color(255, 255, 255, 100)), new Block('J', Color.blue)},
        {new Empty(new Color(255, 255, 255, 80)), new Block('J', Color.blue)},
        {new Block('J', Color.blue), new Block('J', Color.blue)}
    };

    public PieceJ() {
        super(J, 0, 0);
    }

}