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
    private String userDirectory = FileSystems.getDefault()
            .getPath("")
            .toAbsolutePath()
            .toString();
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
                timer.schedule(new MoveGame(), 0, 400);
            case 2 ->
                timer.schedule(new MoveGame(), 0, 100);
        }
    }

    public void stopGame() {
        timer.cancel();
        //.........

    }

    public boolean isGameOver() {
        return current.getPositionY() == -0 //esta no top
                && !canMovePiece(1, 0); //não pode descer

    }

    private class MoveGame extends TimerTask {

        @Override
        public void run() {
            if (isGameOver()) {
                stopGame();
                openGameOverDialog();
            } else if (canMovePiece(1, 0)) {
                moveDown();
            } else {
                freezePiece();
                generateRandomPiece();
                Path fullPath = Paths.get(userDirectory + "\\src\\tetris\\resources\\piece.wav");
                Path directoryPath = fullPath.getParent();
                String finalPath = (directoryPath + "\\piece.wav");
                config.playPieceSound(finalPath.replace("\\dist", ""));
                config.setVolume();
                if (getScore() == 0) {
                    setScore(10);
                } else {
                    setScore((int) (getScore() * getDifficultyBonus()));
                }
                GlobalVariables.currentScore = getScore();
                GlobalVariables.jtext.setText(String.valueOf(getScore()));
            }
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
                bonus = (float) 1.25;
            case 1 ->
                bonus = (float) 1.5;
            case 2 ->
                bonus = (float) 1.65;
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
            Path fullPath = Paths.get(userDirectory + "\\src\\tetris\\resources\\deletedLine.wav");
            Path directoryPath = fullPath.getParent();
            String finalPath = (directoryPath + "\\deletedLine.wav");

            config.playLineSound(finalPath.replace("\\dist", ""));
            config.setVolume();
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
