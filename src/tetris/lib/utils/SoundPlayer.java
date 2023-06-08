/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris.lib.utils;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author ajose
 */
public class SoundPlayer {
    public static Clip clip;
    public static FloatControl volumeControl;
    public static float actualVolume;

    public void play(String filePath) {
        try {
           
            File file = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

                
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        }
    }

    public void changeVolume(float volume){
            float linearVolume = volume / 100.0f;
            float minVolume = volumeControl.getMinimum();
            float maxVolume = volumeControl.getMaximum();
            actualVolume = minVolume + (linearVolume * (maxVolume - minVolume));
            volumeControl.setValue(actualVolume);      
            System.out.println(volumeControl);
    }
    
   
    public float getVolumeToSlider(){
        float volumeSlider;
        float minVolume = volumeControl.getMinimum();
        float maxVolume = volumeControl.getMaximum();
        return volumeSlider = ((actualVolume - minVolume) / (maxVolume - minVolume) * 100.0f);
    }
    public void stop(Clip c) {
        if (c != null) {
            c.stop();
            c.close();
        }
    }


    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void resume() {
        if (clip != null && !clip.isRunning()) {
            clip.start();
        }
    }
}
