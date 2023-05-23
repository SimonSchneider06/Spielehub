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
    
    protected JComponent anzeige;
    
    private int speed;
    private URL pfad_img_1;
    private URL pfad_img_2;
    
    private JLabel bild;
    URL bild_url;

    /**
     * Konstruktor für Objekte der Klasse Entity
     */
    public Entity(String bild_pfad, int x, int y, int size_x, int size_y)
    {
        // Instanzvariable initialisieren
        // dinoBild
        bild_url = this.getClass().getResource(bild_pfad);
        
        bild = new JLabel();
        bild.setIcon(new ImageIcon(bild_url));
        bild.setLocation(x,y);
        bild.setSize(size_x, size_y);        
        
        
        
    }

    /**
     * Ein Beispiel einer Methode - ersetzen Sie diesen Kommentar mit Ihrem eigenen
     * 
     * @param  y    ein Beispielparameter für eine Methode
     * @return        die Summe aus x und y
     */
    public int beispielMethode(int y)
    {
        // tragen Sie hier den Code ein
        return 0;
    }
    JLabel gibBild(){
        return bild;
    }
}
