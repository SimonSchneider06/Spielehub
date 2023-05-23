import javax.swing.*;
import java.awt.event.*;

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
    
    
    /**
     * Konstruktor für Objekte der Klasse Spielfeld
     */
    public Fenster()
    {
        // Punkte label
        labelPunkte = new JLabel();
        labelPunkte.setText("Punkte: ");
        labelPunkte.setLocation(20,20);
        
        // label hinzufügen
        super.add(labelPunkte);
        
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
