/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris.lib.game;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import tetris.gui.GameOverDialog;
import tetris.lib.utils.GlobalVariables;
import tetris.lib.blocks.Empty;
import tetris.lib.utils.Configurations;

/**
 * The TetrisGame class represents the main game logic of the Tetris game.
 */
public class TetrisGame extends Board {

    Timer timer;
    private int Score = 0;

    private Configurations config = new Configurations();

    public TetrisGame() {
        super();
    }

    /**
     * Starts the game with the specified difficulty level.
     *
     * @param diff the difficulty level (0 = easy, 1 = medium, 2 = hard)
     */
    public void startGame(int diff) {
        timer = new Timer();
        switch (diff) {
            case 0 ->
                timer.schedule(new MoveGame(), 0, 600);
            case 1 ->
                timer.schedule(new MoveGame(), 0, 300);
            case 2 ->
                timer.schedule(new MoveGame(), 0, 100);
            default -> timer.schedule(new MoveGame(), 0, 300);   
        }
    }

    /**
     * Stops the game.
     */
    public void stopGame() {
        timer.cancel();
        //.........
    }

    /**
     * Checks if the game is over.
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return !canMovePiece(1, 0) && (current.getPositionY() == 1 || current.getPositionY() == 0 || current.getPositionY() == -1);
    }

    /**
     * The MoveGame class is a TimerTask responsible for moving the game pieces
     * down at regular intervals.
     */
    private class MoveGame extends TimerTask {

        private boolean isRunning = false;

        @Override
        public void run() {
            if (isRunning) {
                return; // Exit if the previous execution is still in progress
            }

            isRunning = true; // Set the flag to indicate the execution is in progress
            //  System.out.println(current.getPositionY());
            if (isGameOver()) {
                stopGame();
                openGameOverDialog();
            } else if (canMovePiece(1, 0)) {
                moveDown();
            } else {
                freezePiece();
                generateRandomPiece();
                config.playPieceSound(config.getFilePathSound("piece.wav"));
                config.setVolumePieceSound();
                setScore((int) (getScore() + 5 * getDifficultyBonus()));
                GlobalVariables.currentScore = getScore();
                GlobalVariables.jtext.setText(String.valueOf(getScore()));
            }

            isRunning = false; // Reset the flag after the execution is completed
        }
    }

    /**
     * Opens the game over dialog.
     */
    private void openGameOverDialog() {
        GlobalVariables.graphicsTetris.dispose();
        GameOverDialog gameOverDialog = new GameOverDialog();
        gameOverDialog.setVisible(true);
    }

    /**
     * Checks if a line in the game board is full.
     *
     * @param line the line index
     * @return true if the line is full, false otherwise
     */
    public boolean isLineFull(int line) {
        for (int x = 0; x < matrix[line].length; x++) {
            if (matrix[line][x] instanceof Empty) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the difficulty bonus based on the current difficulty level.
     *
     * @return the difficulty bonus
     */
    public float getDifficultyBonus() {
        float bonus = 0;
        switch (GlobalVariables.currentDifficulty) {
            case 0 ->
                bonus = (float) 1.5;
            case 1 ->
                bonus = (float) 2;
            case 2 ->
                bonus = (float) 3;
            default ->
                bonus = (float) 2;
        }
        return bonus;
    }

    /**
     * Deletes a line from the game board and updates the score.
     *
     * @param line the line index to delete
     */
    public void deleteLine(int line) {
        // Fall down all columns above the line
        for (int y = line; y > 0; y--) {
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x] = matrix[y - 1][x];
            }
        }
        // Put an empty line in the first line
        for (int x = 0; x < matrix[0].length; x++) {
            matrix[0][x] = new Empty(Color.BLACK);
        }
        this.Score += 100;
    }

    /**
     * Deletes all full lines from the game board and updates the score.
     */
    public void deleteFullLines() {
        boolean isFull = false;
        // Iterate lines from bottom
        for (int y = matrix.length - 1; y > 0; y--) {
            while (isLineFull(y)) {
                // Delete line
                deleteLine(y);
                isFull = true;
            }
        }
        if (isFull) {
            config.playLineSound(config.getFilePathSound("deletedLine.wav"));
            config.setVolumeLineSound();
        }
    }

    /**
     * Freezes the current piece onto the game board and performs line clearing.
     */
    @Override
    public void freezePiece() {
        // Call freeze of board
        super.freezePiece();
        // Delete full lines
        deleteFullLines();
    }

    /**
     * Retrieves the current score.
     *
     * @return the current score
     */
    public int getScore() {
        return Score;
    }

    /**
     * Sets the score to the specified value.
     *
     * @param Score the score to set
     */
    public void setScore(int Score) {
        this.Score = Score;
    }
}