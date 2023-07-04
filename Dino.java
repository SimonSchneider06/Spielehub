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
    /**
     * Konstruktor für Objekte der Klasse Dino
     */
    public Dino()
    {
        // Instanzvariable initialisieren
        super("Bilder/Dino/",200,600,100,100);
        this.jump = true;
    }
    
    @Override public void Update(){
        Animate();
        Gravity(600);
    }
}
