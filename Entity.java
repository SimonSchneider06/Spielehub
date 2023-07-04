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
    public int speed;
    public int pos_x;
    
    public JLabel bild;
    String bild_ordner_pfad;
    String img_pfad;
    int img_number; 
    
    ImageIcon icon1;
    ImageIcon icon2;
    
    public boolean allowAnimate;

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
        
        this.allowAnimate = true;
        
        bild = new JLabel();
        bild.setIcon(icon1);
        bild.setLocation(pos_x,pos_y);
        bild.setSize(size_x, size_y);
        bild.setFocusable(true);
    }

    /**
     *  Bewegt die Entitäten nach links(Kakteen,...)
     */
    public void Move_left()
    {
        this.bild.setLocation(this.bild.getLocation().x - this.speed,this.bild.getLocation().y);
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
    JLabel gibBild(){
        return bild;
    }
    public void Update(){
        Move_left();
        Animate();
    }
}
