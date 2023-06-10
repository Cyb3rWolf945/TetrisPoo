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
 * The Configurations class handles the configuration settings of the Tetris
 * game.
 */
public class Configurations extends SoundPlayer implements Config {

    private int lines;
    private int cols;
    private float sound;
    private int difficulty;

    /**
     * Empty constructor.
     */
    public Configurations() {
        this(10, 10, -30, 1);
    }

    /**
     * Constructor with specified configuration values.
     *
     * @param lines the number of lines
     * @param cols the number of columns
     * @param sound the sound value
     * @param difficulty the difficulty level
     */
    public Configurations(int lines, int cols, float sound, int difficulty) {
        this.lines = lines;
        this.cols = cols;
        this.sound = sound;
        this.difficulty = difficulty;
    }

    /**
     * Writes the configuration to a file for persistent memory.
     *
     * @param files the file to write the configuration to
     */
    public void WriteConfig(File files) {
        try {
            files.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Configurations.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (FileWriter fileWriter = new FileWriter(files); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(this.getLines() + "\n" + this.getCols() + "\n" + this.getSound() + "\n" + this.getDifficulty());

            //System.out.println("Data written to the file.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads the configuration from a file.
     *
     * @param files the file to read the configuration from
     */
    public void ReadConfig(File files) {
        if (files.exists()) {
            int counter = 0;
            int test = 0;
            try (FileReader fileReader = new FileReader(files); BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    try {
                        switch (counter) {
                            case 0:
                                if (Integer.parseInt(line) < 8 || Integer.parseInt(line) > 30) {
                                    this.setLines(10);
                                } else {
                                    this.setLines(Integer.parseInt(line));
                                }
                                break;
                            case 1:
                                if (Integer.parseInt(line) < 8 || Integer.parseInt(line) > 30) {
                                    this.setCols(10);
                                } else {
                                    this.setLines(Integer.parseInt(line));
                                }
                                break;
                            case 2:
                                if (Integer.parseInt(line) < -80.0 || Integer.parseInt(line) > 6.0205994) {
                                    this.setSound(-30);
                                } else {
                                    this.setSound(Float.parseFloat(line));
                                }
                                break;

                            case 3:
                                if (Integer.parseInt(line) <0 || Integer.parseInt(line) > 2) {
                                    this.setDifficulty(1);
                                } else {
                                    this.setDifficulty(Integer.parseInt(line));
                                }
                                break;
                        }

                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                        this.setLines(10);
                        this.setCols(10);
                        this.setSound(-30);
                        this.setDifficulty(1);
                        WriteConfig(getCurrentPath());
                    }

                    counter += 1;
                }
            } catch (IOException e) {

                System.out.println(e.getMessage());
            }
        } else {
            try {
                files.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Configurations.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getMessage());
            }

            WriteConfig(getCurrentPath());
        }

    }

    /**
     * Retrieves the user directory path.
     *
     * @return the user directory path
     */
    public String getUserDirectory() {
        String userDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
        return userDirectory;
    }

    /**
     * Retrieves the file path for an image.
     *
     * @param fileName the image file name
     * @return the file path for the image
     */
    public String getFilePathImage(String fileName) {
        Path fullPathImage = Paths.get(getUserDirectory() + "\\src\\tetris\\resources\\" + fileName);
        Path directoryPathImage = fullPathImage.getParent();
        String finalPathImage = (directoryPathImage + "\\" + fileName);
        return finalPathImage.replace("\\dist", "");
    }

    /**
     * Retrieves the file path for a sound file.
     *
     * @param fileName the sound file name
     * @return the file path for the sound file
     */
    public String getFilePathSound(String fileName) {
        Path fullPathImage = Paths.get(getUserDirectory() + "\\src\\tetris\\resources\\" + fileName);
        Path directoryPathImage = fullPathImage.getParent();
        String finalPathImage = (directoryPathImage + "\\" + fileName);
        return finalPathImage.replace("\\dist", "");
    }

    /**
     * Retrieves the current number of lines.
     *
     * @return the number of lines
     */
    public int getLines() {
        return lines;
    }

    /**
     * Retrieves the current number of columns.
     *
     * @return the number of columns
     */
    public int getCols() {
        return cols;
    }

    /**
     * Retrieves the current difficulty level.
     *
     * @return the difficulty level
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty level to the specified value.
     *
     * @param diff the difficulty level to set
     */
    public void setDifficulty(int diff) {
        this.difficulty = diff;
    }

    /**
     * Retrieves the current sound value.
     *
     * @return the sound value
     */
    public float getSound() {
        return sound;
    }

    /**
     * Sets the number of lines to the specified value.
     *
     * @param lines the number of lines to set
     */
    public void setLines(int lines) {
        this.lines = lines;
    }

    /**
     * Sets the number of columns to the specified value.
     *
     * @param cols the number of columns to set
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

    /**
     * Sets the sound value to the specified value.
     *
     * @param sound the sound value to set
     */
    public void setSound(float sound) {
        this.sound = sound;
    }

    /**
     * Retrieves the current path.
     *
     * @return the current path
     */
    public File getCurrentPath() {
        String userDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
        File files = new File(userDirectory + "\\config");

        return files;
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
