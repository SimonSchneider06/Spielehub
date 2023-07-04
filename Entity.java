import java.net.*;
import javax.swing.*;
import java.awt.*;

/**
 * Beschreiben Sie hier die Klasse Entity.
 * 
 * @author Simon Schneider + Maximilian Edenhofer 
 * @version 1.0
 */
public class Entity
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen    
    public int speed;
    public int pos_x;
    public int pos_y;
    public int size_x;
    public int size_y;
    
    public JLabel bild;
    String bild_ordner_pfad;
    String img_pfad;
    int img_number; 
    
    ImageIcon icon1;
    ImageIcon icon2;
    
    public boolean allowAnimate;
    
    Rectangle rectangle;

    /**
     * Konstruktor für Objekte der Klasse Entity
     */
    public Entity(String bild_ordner_pfad, int pos_x, int pos_y, int size_x, int size_y)
    {
        // Instanzvariable initialisieren
        // dinoBild
        bild_ordner_pfad = bild_ordner_pfad;
        img_number = 1;
        //bild = setBild(bild_ordner_pfad + "1.png", pos_x, pos_y);
        //bild = setBild(pos_x, pos_y);
        icon1 = new ImageIcon(bild_ordner_pfad + "1.png");
        icon2 = new ImageIcon(bild_ordner_pfad + "2.png");
        
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.size_x = size_x;
        this.size_y = size_y;
        
        this.allowAnimate = true;
        
        bild = new JLabel();
        bild.setIcon(icon1);
        bild.setLocation(pos_x,pos_y);
        bild.setSize(size_x, size_y);
        bild.setFocusable(true);
    }
    /**
     *  Animiert die Entitäten
     *  Wechselt zwischen Ihren Bildern
     */
    public void Animate(){
        if(this.allowAnimate){
                if(img_number == 1){
                img_number += 1;
                bild.setIcon(icon1);
            }
            else if(img_number == 2){
                img_number = 1;
                bild.setIcon(icon2);
            }
        }
        
        // setBild mit nächstem Bild
        //bild.setIcon(new ImageIcon(bild_ordner_pfad + img_number + ".png"));
    }
    
    JLabel gibBild(){
        return bild;
    }
    public void Update(){
        Animate();
    }
}
