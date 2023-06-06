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
package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;

/**
 * Created on 01/05/2023, 08:20:18
 *
 * @author IPT - computer
 * @version 1.0
 */
public class PieceI extends Piece {

    public static Block[][] M = {
        {new Block('I', Color.DARK_GRAY), new Block('I',Color.DARK_GRAY),new Block('I', Color.DARK_GRAY),new Block('I', Color.DARK_GRAY)},        
    };

    public PieceI() {
        super(M, 0, 0);
    }

  
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010820L;
    //:::::::::::::::::::::::::::  Copyright(c) M@nso  2023  :::::::::::::::::::
    ///////////////////////////////////////////////////////////////////////////
}
