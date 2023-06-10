package tetris.lib.utils;

import java.util.Random;
import tetris.lib.pieces.Piece;
import tetris.lib.pieces.PieceI;
import tetris.lib.pieces.PieceJ;
import tetris.lib.pieces.PieceL;
import tetris.lib.pieces.PieceO;
import tetris.lib.pieces.PieceS;
import tetris.lib.pieces.PieceT;
import tetris.lib.pieces.PieceZ;

/**
 * Enumaration with the pieces of Tetris.
 */
public enum TetrisPiece {
    L(new PieceL()),
    O(new PieceO()),
    S(new PieceS()),
    Z(new PieceZ()),
    J(new PieceJ()),
    T(new PieceT()),
    I(new PieceI());

    Piece piece;

    private TetrisPiece(Piece piece) {
        this.piece = piece;
    }
    
    // Random generator
    private static Random rnd = new Random();

    /**
     * Generates a random Tetris piece.
     *
     * @return a random Tetris piece
     */
    public static Piece generateRandom() {
        return switch (rnd.nextInt(7)) {
            case 0 -> L.piece.getClone();
            case 1 -> O.piece.getClone();
            case 2 -> S.piece.getClone();
            case 3 -> Z.piece.getClone();
            case 4 -> J.piece.getClone();
            case 5 -> I.piece.getClone();
            case 6 -> T.piece.getClone();
            default -> T.piece.getClone();
        };
    }
}