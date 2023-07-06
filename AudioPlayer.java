
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;
/**
 * Beschreiben Sie hier die Klasse AudioPlayer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class AudioPlayer
{
   
    Clip clip;

    /**
     * Konstruktor für Objekte der Klasse AudioPlayer
     */
    public AudioPlayer()
    {
        // Instanzvariable initialisieren
        
    }
    
    /**
       Spielt Musik ab
       @param musicLoc = String; the path to the music file
       */
    void playMusic(String musicLoc){
                 try {
                         File musicPath = new File(musicLoc);
                          if(musicPath.exists()){ 
                                  AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                                  this.clip = AudioSystem.getClip();
                                  this.clip.open(audioInput);
                                  this.clip.start();
                                 

                           }
                          else{
                                   System.out.println("Couldn't find Music file");
                                }
                }
                catch (Exception ex){
                           ex.printStackTrace();
                     }
           }
    
}
