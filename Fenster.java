import javax.swing.*;
import java.awt.event.*;
import java.net.*;
/**
 * Beschreiben Sie hier die Klasse Spielfeld.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Fenster extends JFrame implements ActionListener
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JLabel labelPunkte;
    private JLabel dinoBild;
    URL kaktus_url = this.getClass().getResource("kaktus.png");
    
    /**
     * Konstruktor für Objekte der Klasse Spielfeld
     */
    public Fenster()
    {
        //---------------------Spielfeld------------------------
        // Punkte label
        labelPunkte = new JLabel();
        labelPunkte.setText("Punkte: ");
        labelPunkte.setLocation(20,20);
        labelPunkte.setSize(200,50);
        labelPunkte.setFont(labelPunkte.getFont().deriveFont(46f));
        
        // dinoBild
        dinoBild = new JLabel();
        dinoBild.setIcon(new ImageIcon(kaktus_url));
        dinoBild.setLocation(20,300);
        dinoBild.setSize(300,300);
        
        
        // labelPunkte, dinoBild hinzufügen
        super.add(labelPunkte);
        super.add(dinoBild);
        
        SpielfeldAufbauen();
        
        // Fenster konfigurieren
        super.setLayout(null);
        super.setSize(1300,750);
        super.setVisible(true);
    }
    
    /**
     * Zeigt das Spielfeld des Dinosaurierspiels an, wo der Dino rennt
     */
    public void SpielfeldAufbauen(){
        // Punkte sichtbar
        labelPunkte.setVisible(true);
    }
    
    /**
     * Registriert button presses, ect
     */
    public void actionPerformed(ActionEvent e){
        
    }
}
