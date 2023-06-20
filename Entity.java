import java.net.*;
import javax.swing.*;

/**
 * Beschreiben Sie hier die Klasse Entity.
 * 
 * @author Simon Schneider + Maximilian Edenhofer 
 * @version 1.0
 */
public class Entity
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int pos_x;
    private int pos_y;

    private int size_x;
    private int size_y;
    
    private int speed;
    
    public JLabel bild;
    String bild_ordner_pfad;
    String img_pfad;
    int img_number; 

    /**
     * Konstruktor für Objekte der Klasse Entity
     */
    public Entity(String bild_ordner_pfad, int pos_x, int pos_y, int size_x, int size_y)
    {
        // Instanzvariable initialisieren
        // dinoBild
        bild_ordner_pfad = bild_ordner_pfad;
        size_x = size_x;
        size_y = size_y;
        pos_x = pos_x;
        pos_y = pos_y;
        img_number = 1;
        //bild = setBild(bild_ordner_pfad + "1.png", pos_x, pos_y);
        //bild = setBild(pos_x, pos_y);
        bild = new JLabel();
        bild.setIcon(new ImageIcon(bild_ordner_pfad + img_number + ".png"));
        bild.setLocation(pos_x,pos_y);
        bild.setSize(size_x, size_y);
    }

    /**
     *  Bewegt die Entitäten nach links(Kakteen,...)
     */
    protected void Move_left()
    {
        pos_x -= speed;
    }
    /**
     *  Animiert die Entitäten
     *  Wechselt zwischen Ihren Bildern
     */
    protected void Animate(){
        if(img_number == 1){
            img_number += 1;
        }
        else{
            img_number = 1;
        }
        // setBild mit nächstem Bild
        //bild.setIcon(new ImageIcon(bild_ordner_pfad + img_number + ".png"));
    }
    JLabel gibBild(){
        return bild;
    }
    public void Update(){
        Move_left();
        Animate();
    }
}
