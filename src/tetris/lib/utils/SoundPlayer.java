package tetris.lib.utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The SoundPlayer class is responsible for playing sound effects and controlling the volume.
 */
public class SoundPlayer {

    public static Clip clip;
    public static Clip clipSoundPiece;
    public static Clip clipSoundLine;
    public static FloatControl volumeControl;
    public static float actualVolume;

    /**
     * Plays the audio file specified by the filePath.
     *
     * @param filePath the path of the audio file to play
     */
    public void play(String filePath) {
        try {
            File file = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Plays the piece sound effect specified by the filePath.
     *
     * @param filePath the path of the piece sound effect file to play
     */
    public void playPieceSound(String filePath) {
        try {
            File file = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clipSoundPiece = AudioSystem.getClip();
            clipSoundPiece.open(audioInputStream);
           
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Plays the line sound effect specified by the filePath.
     *
     * @param filePath the path of the line sound effect file to play
     */
    public void playLineSound(String filePath) {
        try {
            File file = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clipSoundLine = AudioSystem.getClip();
            clipSoundLine.open(audioInputStream);
          
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Changes the volume using a slider value.
     *
     * @param volume the volume value from the slider
     */
    public void changeVolumeSlide(float volume) {
        float linearVolume = volume / 100.0f;
        float minVolume = volumeControl.getMinimum();
        float maxVolume = volumeControl.getMaximum();
        actualVolume = minVolume + (linearVolume * (maxVolume - minVolume));
        // System.out.println(volumeControl);
        // System.out.println(actualVolume);
    }

    /**
     * Sets the volume for the Tetris music.
     */
    public void setVolumeTetrisMusic() {
       
        volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volumeControl.setValue(actualVolume);
    }
    
    /**
     * Sets the volume for the piece sound effect.
     */
    public void setVolumePieceSound() {
        if (clipSoundPiece != null) {
            volumeControl = (FloatControl) clipSoundPiece.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(actualVolume);
            clipSoundPiece.start();
        }
    }
     
    /**
     * Sets the volume for the line sound effect.
     */
    public void setVolumeLineSound() {
        if (clipSoundLine != null) {
            volumeControl = (FloatControl) clipSoundLine.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(actualVolume);
            clipSoundLine.start();
        }
    }

    /**
     * Converts the volume value to match the slider range.
     *
     * @return the volume value for the slider
     */
    public float getVolumeToSlider() {
        float volumeSlider;
        float minVolume = volumeControl.getMinimum();
        float maxVolume = volumeControl.getMaximum();
        return volumeSlider = ((actualVolume - minVolume) / (maxVolume - minVolume) * 100.0f);
    }

    /**
     * Stops and closes the specified Clip.
     *
     * @param c the Clip to stop and close
     */
    public void stop(Clip c) {
        if (c != null) {
            c.stop();
            c.close();
        }
    }

    /**
     * Pauses the main clip.
     */
    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    /**
     * Resumes the main clip.
     */
    public void resume() {
        if (clip != null && !clip.isRunning()) {
            clip.start();
        }
    }
}