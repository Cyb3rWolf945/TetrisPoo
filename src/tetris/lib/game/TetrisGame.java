/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris.lib.game;

import java.util.Timer;
import java.util.TimerTask;
import tetris.gui.GameOver;
import tetris.gui.GraphicsTetrisDialog;
import tetris.lib.blocks.Empty;

/**
 *
 * @author ajose
 */
public class TetrisGame extends Board{
    
    Timer timer;
    private int Score = 0;
    

    public TetrisGame() {
        super();
    }

 

    public void startGame(int delay) {
        timer = new Timer();
        timer.schedule(new MoveGame(), 0, delay);
    }

 

    public void stopGame() {
        timer.cancel();
        System.out.println("ja fostesssss");
        //.........

    }


    
 public boolean isGameOver() {
        return current.getPositionY() == 0 //esta no top
                && !canMovePiece(1, 0); //não pode descer

 

    }

    private class MoveGame extends TimerTask {

 

        @Override
        public void run() {
            if (isGameOver()) {
                stopGame();
            } else if (canMovePiece(1, 0)) {
                moveDown();
            } else {
                freezePiece();
                generateRandomPiece();
                setScore((getScore() + 10));
            }
        }

 

    }

 

    public boolean isLineFull(int line) {
        for (int x = 0; x < matrix[line].length; x++) {
            if (matrix[line][x] instanceof Empty) {
                return false;
            }
        }
        return true;

 

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
            matrix[0][x] = new Empty();
        }
    }
    
    public void deleteFullLines(){
        //iterate lines from bottom
        for(int y = matrix.length-1 ; y > 0; y--){
            //verify if line is full
            while( isLineFull(y)){
                //delete line
                deleteLine(y);
            } 
        }
        
        this.Score += 10;
        
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
