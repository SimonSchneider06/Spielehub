import javax.swing.*;
import java.awt.event.*;

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
        
        super("Bilder/Dino/",200,ground,100,100);
        this.ground = ground;
        
        this.jump = true;
        this.cooldown = 10000;
        jumpTimer = new Timer(cooldown);
    }
    
    @Override public void Update(){
        Animate();
        this.Gravity(this.ground);
    }
}
