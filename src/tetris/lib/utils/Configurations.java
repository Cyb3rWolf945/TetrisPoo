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
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import tetris.interfaces.Config;

/**
 *
 * @author ajose
 */
public class Configurations extends SoundPlayer implements Config {

    private int lines;
    private int cols;
    private float sound;
    private int difficulty;

    /**
     * *
     * Empty constructor
     */
    public Configurations() {
        this(10, 10, -30, 1);
    }

    /**
     * *
     *
     * @param lines
     * @param cols
     * @param sound
     * @param difficulty
     */
    public Configurations(int lines, int cols, float sound, int difficulty) {
        this.lines = lines;
        this.cols = cols;
        this.sound = sound;
        this.difficulty = difficulty;
    }

    /**
     * *
     * Write config in the file for persistent memory.
     *
     * @param files
     */
    public void WriteConfig(File files) {
        try {
            files.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Configurations.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (FileWriter fileWriter = new FileWriter(files); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(this.getLines() + "\n" + this.getCols() + "\n" + this.getSound() + "\n" + this.getDifficulty());

            System.out.println("Data written to the file.");
        } catch (IOException e) {
        }        // TODO add your handling c
    }

    /**
     * *
     * Read config from the file.
     *
     * @param files
     */
    public void ReadConfig(File files) {
        if (files.exists()) {
            int counter = 0;

            try (FileReader fileReader = new FileReader(files); BufferedReader bufferedReader = new BufferedReader(fileReader)) {

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
        } else {
            try {
                files.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Configurations.class.getName()).log(Level.SEVERE, null, ex);
            }

            WriteConfig(getCurrentPath());
        }

    }

    public String getUserDirectory() {
        String userDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
        return userDirectory;
    }

    public String getFilePathMenuImage() {
        Path fullPathImage = Paths.get(getUserDirectory() + "\\src\\tetris\\resources\\menu.png");
        Path directoryPathImage = fullPathImage.getParent();
        String finalPathImage = (directoryPathImage + "\\menu.png");
        return finalPathImage.replace("\\dist", "");
    }

    public String getFilePathGameImage() {
        Path fullPathImage = Paths.get(getUserDirectory() + "\\src\\tetris\\resources\\jogo.png");
        Path directoryPathImage = fullPathImage.getParent();
        String finalPathImage = (directoryPathImage + "\\jogo.png");
        return finalPathImage.replace("\\dist", "");
    }
    public String getFilePathGameOverImage() {
        Path fullPathImage = Paths.get(getUserDirectory() + "\\src\\tetris\\resources\\gameover.png");
        Path directoryPathImage = fullPathImage.getParent();
        String finalPathImage = (directoryPathImage + "\\gameover.png");
        return finalPathImage.replace("\\dist", "");
    }
    
    public String getFilePathPauseImage() {
        Path fullPathImage = Paths.get(getUserDirectory() + "\\src\\tetris\\resources\\pausa.png");
        Path directoryPathImage = fullPathImage.getParent();
        String finalPathImage = (directoryPathImage + "\\pausa.png");
        return finalPathImage.replace("\\dist", "");
    }

    public String getFilePathIcon() {
        Path fullPathImage = Paths.get(getUserDirectory() + "\\src\\tetris\\resources\\icon.png");
        Path directoryPathImage = fullPathImage.getParent();
        String finalPathImage = (directoryPathImage + "\\icon.png");
        return finalPathImage.replace("\\dist", "");
    }

    public String getFilePathTetrisMusic() {
        Path fullPathImage = Paths.get(getUserDirectory() + "\\src\\tetris\\resources\\Tetris.wav");
        Path directoryPathImage = fullPathImage.getParent();
        String finalPathImage = (directoryPathImage + "\\Tetris.wav");
        return finalPathImage.replace("\\dist", "");
    }

    public String getFilePathPieceSound() {
        Path fullPathImage = Paths.get(getUserDirectory() + "\\src\\tetris\\resources\\piece.wav");
        Path directoryPathImage = fullPathImage.getParent();
        String finalPathImage = (directoryPathImage + "\\piece.wav");
        return finalPathImage.replace("\\dist", "");
    }
    
    public String getFilePathDeletedLine() {
        Path fullPathImage = Paths.get(getUserDirectory() + "\\src\\tetris\\resources\\deletedLine.wav");
        Path directoryPathImage = fullPathImage.getParent();
        String finalPathImage = (directoryPathImage + "\\deletedLine.wav");
        return finalPathImage.replace("\\dist", "");
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

    public File getCurrentPath() {
        String userDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
        File files = new File(userDirectory + "\\config");

        return files;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int diff) {
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

    @Override
    public void WriteConfig() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ReadConfig() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
