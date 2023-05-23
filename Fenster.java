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
    
    private Entity dino;

    private JLabel labelAnmelden;
    private JTextField bn;
    private JTextField pw;
    private JButton buttonweiter;

    
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
        
        
        dino = new Dino();
        // labelPunkte, dinoBild hinzufügen
        super.add(labelPunkte);
        super.add(dino.gibBild());
        
        //---------------------Anmelden------------------------
        labelAnmelden = new JLabel();
        labelAnmelden.setText("Anmelden: ");
        labelAnmelden.setLocation(50,150);
        labelAnmelden.setSize(300,50);
        labelAnmelden.setFont(labelAnmelden.getFont().deriveFont(46f));
        
        //Benutzernameeingabefeld
        bn = new JTextField();
        bn.setText("Benutzername");
        bn.setLocation(280,250);
        bn.setSize (550,80);
        bn.setEnabled(true);
        bn.setFont(bn.getFont().deriveFont(56f));
        
        //Passworteingabefeld
        pw = new JTextField();
        pw.setText("Passwort");
        pw.setLocation(280,330);
        pw.setSize (550,80);
        pw.setEnabled(true);
        pw.setFont(pw.getFont().deriveFont(56f));
       
        //Knopf
        buttonweiter = new JButton();
        buttonweiter.setText("Fortfahren");
        buttonweiter.setLocation(320, 450);
        buttonweiter.setSize (470, 50);
        buttonweiter.setEnabled(true);
        buttonweiter.setFont(buttonweiter.getFont().deriveFont(56f));
        buttonweiter.addActionListener(this);
        
        // Anmelden, Benutzernameeingabefeld,Passworteingabefeld, Knopf hinzufügen
        super.add(labelAnmelden);
        super.add(bn);
        super.add(pw);
        super.add(buttonweiter);
        
       // SpielfeldAufbauen();
        AnmeldenAufbauen();
        
        buttonweiter.addActionListener(this);
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
        labelAnmelden.setVisible(false);
    }
    public void AnmeldenAufbauen(){
        // Anmelden sichtbar
        labelAnmelden.setVisible(true);
        bn.setVisible(true);
        pw.setVisible(true);
        buttonweiter.setVisible(true);
        labelPunkte.setVisible(false);
    }
    
    /**
     * Registriert button presses, ect
     */
    public void actionPerformed(ActionEvent e){
        
    }
}
