/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package soundboard.app.soundSection.buttondata;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Student
 */
public class button {
    
    String name;
    String path;
    AudioInputStream audioIn;
    Clip clip;
    public button(String path) {
        System.out.println("\tsetting path...");
        setPath(path);
         System.out.println("\tpath set");
        try {
            
            URL url = this.getClass().getClassLoader().getResource(getPath());
             System.out.println(getPath());
            audioIn = AudioSystem.getAudioInputStream(url);
            this.clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(button.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                audioIn.close();
            } catch (IOException ex) {
                Logger.getLogger(button.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String getName(){
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    public String getPath(){
        return path;
    }
    public void setPath(String path){
        this.path = path;
        setName(new File(path).getName());
    }
    
    public void clipStartStop(boolean continuous){
       if(clip.isRunning()){
           if(continuous){
               clip.setFramePosition(0);
               clip.loop(Clip.LOOP_CONTINUOUSLY);
           }
           else{
               clip.setFramePosition(0);
               clip.start();
           }   
       }
       else{
           clip.stop();
       }
    }
}
