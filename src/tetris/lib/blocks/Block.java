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
package tetris.lib.blocks;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import tetris.gui.Drawable;

/**
 * Created on 26/04/2023, 04:05:22
 *
 * @author manso - computer
 */
public class Block extends JComponent implements Drawable{

    
    @Override
    public void paintComponent(Graphics gr){
        super.paintComponent(gr); //build component
        draw(gr, 0, 0, getWidth()-1, getHeight()-1);
    }
     @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
    //color of fill
        gr.setColor(myColor);
        //fill block
        gr.fill3DRect(px, py, width, height,true);
     
        //color of line
        gr.setColor(Color.BLACK);
        //draw line
        gr.draw3DRect(px, py, width, height,true);
    }
    
        
    protected char txt;
    protected Color myColor;

    public Color getMyColor() {
        return myColor;
    }

    public void setMyColor(Color myColor) {
        this.myColor = myColor;
    }
    
    public Block(char ch,Color color) {
        this.txt = ch;
        this.myColor = color;
    }
    

     public Block(){
         this(' ', Color.BLUE);
     }
    
    public Block(char ch) {
        this(ch, Color.GREEN);
    }

    public Block(Block b) {
        this(b.txt, b.myColor);
    }

    public char getTxt() {
        return txt;
    }

    public void setTxt(char txt) {
        this.txt = txt;
    }

    @Override
    public String toString() {
        return txt + "";
    }

    public Block getClone() {
        return new Block(this);
    }

   

}
