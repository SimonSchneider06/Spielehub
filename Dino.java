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
    boolean jump;
    
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
        
        this.jump = true;
        
        this.cooldown = 800;
        jumpTimer = new Timer(cooldown);
    }
    
    public void CheckTimer(){
        if(this.jumpTimer.active && !this.jump){
            this.jump = this.jumpTimer.Update();
        }
    }
    
    @Override public void Update(){
        Animate();
        this.Gravity(this.ground);
        this.CheckTimer();
        //System.out.println(System.currentTimeMillis());
    }
}
