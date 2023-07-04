import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;
/**
 * Beschreiben Sie hier die Klasse Dino.
 * 
 * @author Simon Schneider + Maximilan Edenhofer
 * @version 1.0
 */
public class Dino extends Entity
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    boolean canjump;
    boolean isJumping;
    
    int gravity;
    int jumpStrength;
    int currentJumpStrength;
    
    int ground;
    /**
     * Konstruktor für Objekte der Klasse Dino
     */
    public Dino(int ground)
    {
        // Instanzvariable initialisieren
        
        super("Bilder-Transparent/Dino/",200,ground,100,100);
        this.ground = ground;
        
        this.canjump = true;
        this.isJumping = false;
        
        this.gravity = 6;
        this.currentJumpStrength = 50;
        this.jumpStrength = 50;
        
    }
    
    
    public void Jump(){
        if(this.isJumping){
            this.canjump = false;
            this.bild.setLocation(this.bild.getLocation().x,this.bild.getLocation().y - this.currentJumpStrength);
            this.currentJumpStrength -= this.gravity;
            // check if ground reached -> not jump anymore
            if(this.bild.getLocation().y >= this.ground){
                this.isJumping = false;
                this.canjump = true;
                this.currentJumpStrength = this.jumpStrength;
                this.bild.setLocation(this.bild.getLocation().x,this.ground);
            }
        }   
    }
    
    @Override public void Update(){
        Animate();
        this.Jump();
        //System.out.println(System.currentTimeMillis());
    }
}
