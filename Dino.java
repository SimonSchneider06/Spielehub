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
    
    int ground;
    public Timer jumpTimer;
    public int cooldown;
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
        this.jumpStrength = 50;
        
        this.cooldown = 800;
        jumpTimer = new Timer(cooldown);
    }
    
    public void CheckTimer(){
        if(this.jumpTimer.active && !this.canjump){
            this.canjump = this.jumpTimer.Update();
        }
    }
    /**
     * Gravity up to a certain point, the ground
     * @param ground = the y- Koordinate, wo die Entity stehen bleibt
     * */
    public void Gravity(int ground){
        //System.out.println(bild.getLocation().y);
        // only apply if not at ground level
        if( bild.getLocation().y < ground){
            // gravity
            //System.out.println("G");
            this.allowAnimate = false;
            bild.setLocation(bild.getLocation().x,bild.getLocation().y + 20);
        }
        else{
            // no gravity
            // set pos_y to ground,for the case, that it goes
            // below the ground level
            //System.out.println("NO");
            this.allowAnimate = true;
            bild.setLocation(bild.getLocation().x,ground);
        }
    }
    
    public void Jump(){
        if(this.isJumping){
            this.bild.setLocation(this.bild.getLocation().x,this.bild.getLocation().y - this.jumpStrength);
            this.jumpStrength -= this.gravity;
        }   
    }
    
    @Override public void Update(){
        Animate();
        //this.Gravity(this.ground);
        this.CheckTimer();
        this.Jump();
        //System.out.println(System.currentTimeMillis());
    }
}
