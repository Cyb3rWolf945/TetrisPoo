/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris.lib.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import tetris.interfaces.Config;
/**
 *
 * @author ajose
 */
public class Configurations extends SoundPlayer implements Config {
    
    private int lines;
    private int cols;
    private float sound; 
    private int difficulty = 1;
    /***
     * Empty constructor
     */
    public Configurations(){
        super();
    }
    
    
    /***
     * 
     * @param lines
     * @param cols 
     * @param sound 
     * @param difficulty 
     */
    public Configurations(int lines, int cols, float sound, int difficulty){
        this.lines = lines;
        this.cols = cols;
        this.sound = sound;
        this.difficulty = difficulty;
    }
            
    /***
     * Write config in the file for persistent memory.
     */
    @Override
    public void WriteConfig() {
        File file = new File("C:\\Users\\Telmo\\Documents\\NetBeansProjects\\TetrisPooaa\\newfile");

        try (FileWriter fileWriter = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(this.getLines() + "\n" + this.getCols() + "\n" + this.getSound()+ "\n" + this.getDifficulty());

            System.out.println("Data written to the file.");
        } catch (IOException e) {
        }        // TODO add your handling c
    }
    
    /***
     * Read config from the file.
     */
    @Override
    public void ReadConfig() {
        File file = new File("C:\\Users\\Telmo\\Documents\\NetBeansProjects\\TetrisPooaa\\newfile");
        int counter = 0;

        try (FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                switch (counter) {
                    case 0 ->
                        this.setLines(Integer.parseInt(line));

                    case 1 ->
                        this.setCols(Integer.parseInt(line));
                        
                    case 2 ->
                        this.setSound(Float.parseFloat(line));
                        case 3 ->
                        this.setDifficulty(Integer.parseInt(line));
                }
                counter += 1;
            }
        } catch (IOException e) {
        }
    }

    
    /**
     * @return the lines
     */
    public int getLines() {
        return lines;
    }

    /**
     * @return the cols
     */
    public int getCols() {
        return cols;
    }

    public int getDifficulty(){
        return difficulty;
    }
    
    public void setDifficulty(int diff){
        difficulty = diff;
    }
    /**
     * @return the sound
     */
    public float getSound() {
        return sound;
    }

    /**
     * @param lines the lines to set
     */
    public void setLines(int lines) {
        this.lines = lines;
    }

    /**
     * @param cols the cols to set
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

    /**
     * @param sound the sound to set
     */
    public void setSound(float sound) {
        this.sound = sound;
    }
    
}
