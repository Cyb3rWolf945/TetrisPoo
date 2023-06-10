/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris.lib.game;

import java.awt.Color;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;
import tetris.gui.Configs;
import tetris.gui.GameOverDialog;
import tetris.gui.GraphicsTetrisDialog;
import tetris.lib.utils.GlobalVariables;
import tetris.lib.blocks.Empty;
import tetris.lib.utils.Configurations;
import tetris.lib.utils.SoundPlayer;

/**
 *
 * @author ajose
 */
public class TetrisGame extends Board {

    Timer timer;
    private int Score = 0;

    private Configurations config = new Configurations();

    public TetrisGame() {
        super();

    }

    public void startGame(int diff) {
        timer = new Timer();
        switch (diff) {
            case 0 ->
                timer.schedule(new MoveGame(), 0, 600);
            case 1 ->
                timer.schedule(new MoveGame(), 0, 300);
            case 2 ->
                timer.schedule(new MoveGame(), 0, 100);
        }
    }

    public void stopGame() {
        timer.cancel();
        //.........

    }

    public boolean isGameOver() {
        return !canMovePiece(1, 0) && (current.getPositionY() == 1 || current.getPositionY() == 0 || current.getPositionY() == -1);

    }

    private class MoveGame extends TimerTask {

        private boolean isRunning = false;

        @Override
        public void run() {
            if (isRunning) {
                return; // Exit if the previous execution is still in progress
            }

            isRunning = true; // Set the flag to indicate the execution is in progress
            System.out.println(current.getPositionY());
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

    private void openGameOverDialog() {
        GlobalVariables.graphicsTetris.dispose();
        GameOverDialog gameOverDialog = new GameOverDialog();
        gameOverDialog.setVisible(true);
    }

    public boolean isLineFull(int line) {
        for (int x = 0; x < matrix[line].length; x++) {
            if (matrix[line][x] instanceof Empty) {
                return false;
            }
        }
        return true;

    }

    public float getDifficultyBonus() {
        float bonus = 0;
        switch (GlobalVariables.currentDifficulty) {
            case 0 ->
                bonus = (float) 1.5;
            case 1 ->
                bonus = (float) 2;
            case 2 ->
                bonus = (float) 3;
        }
        return bonus;
    }

    public void deleteLine(int line) {
        //fall down all columns above line
        for (int y = line; y > 0; y--) //copy line y
        {
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x] = matrix[y - 1][x];
            }
        }
        //put an empty line in the first line
        for (int x = 0; x < matrix[0].length; x++) {
            matrix[0][x] = new Empty(Color.BLACK);
        }
        this.Score += 100;
    }

    public void deleteFullLines() {
        boolean isFull = false;
        //iterate lines from bottom
        for (int y = matrix.length - 1; y > 0; y--) {
            while (isLineFull(y)) {
                //delete line
                deleteLine(y);
                isFull = true;

            }
        }
        if (isFull) {

            config.playLineSound(config.getFilePathSound("deletedLine.wav"));
            config.setVolumeLineSound();
        }
    }

    @Override
    public void freezePiece() {
        //call freeze of board
        super.freezePiece();
        //delete lines
        deleteFullLines();
    }

    /**
     * @return the Score
     */
    public int getScore() {
        return Score;
    }

    /**
     * @param Score the Score to set
     */
    public void setScore(int Score) {
        this.Score = Score;
    }

}
