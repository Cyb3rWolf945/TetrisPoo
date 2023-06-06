/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tetris.interfaces;

/**
 *
 * @author ajose
 */
public interface Config {

    /**
     * Write chosen configuration lines and cols for board.
     */
    public void WriteConfig();
    /***
     * Read chosen configuration lines and cols for board.
     */
    public void ReadConfig();
}
