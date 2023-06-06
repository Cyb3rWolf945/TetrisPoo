//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//::                                                                         ::
//::     Antonio Manuel Rodrigues Manso                                      ::
//::                                                                         ::
//::     I N S T I T U T O    P O L I T E C N I C O   D E   T O M A R        ::
//::     Escola Superior de Tecnologia de Tomar                              ::
//::     e-mail: manso@ipt.pt                                                ::
//::     url   : http://orion.ipt.pt/~manso                                  ::
//::                                                                         ::
//::     This software was build with the purpose of investigate and         ::
//::     learning.                                                           ::
//::                                                                         ::
//::                                                               (c)2023   ::
//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//////////////////////////////////////////////////////////////////////////////

package tetris.app;

import java.util.TimerTask;
import tetris.lib.game.Board;

/**
 * Created on 23/05/2023, 18:08:50 
 * @author manso - computer
 */
public class ClockTask extends TimerTask{
    
    Board board;
    
    public ClockTask (Board board){
        this.board = board;
    }
    
    @Override
    public void run() {
        board.moveDown();
        if (!board.canMovePiece(1, 0)) {
            board.freezePiece();
            board.generateRandomPiece();
        } 
       }
    
    

}
