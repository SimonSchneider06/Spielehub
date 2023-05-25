import javax.swing.*;
import java.awt.event.*;
import java.net.*;
/**
 * Beschreiben Sie hier die Klasse Spielfeld.
 * 
 * @author Simon Schneider + Maximilian Edenhofer 
 * @version 1.0
 */
public class Fenster extends JFrame implements ActionListener,MouseListener
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JLabel labelPunkte;

    private Dino dino;

    private JLabel labelAnmelden;
    private JTextField bn;
    private JTextField pw;
    private JButton buttonweiter;
    private JButton buttonSp1;
    private JLabel labelSA;
    
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
                //---------------------Spieleauswahl(SA)------------------------
        
        labelSA = new JLabel();
        labelSA.setText("Spieleauswahl: ");
        labelSA.setLocation(20,20);
        labelSA.setSize(350,50);
        labelSA.setFont(labelSA.getFont().deriveFont(46f));
        
        buttonSp1 = new JButton();
        buttonSp1.setText("Dinorun");
        buttonSp1.setLocation(20, 100);
        buttonSp1.setSize (100, 70);
        buttonSp1.setEnabled(true);
        buttonSp1.setFont(buttonSp1.getFont().deriveFont(56f));
        buttonSp1.addActionListener(this);
        
        super.add(labelSA);
        super.add(buttonSp1);

        
       SpielfeldAufbauen();
       // AnmeldenAufbauen();
        //Spieleauswahl();
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
        // sichtbar
        labelPunkte.setVisible(true);
        dino.gibBild().setVisible(true);
        
        //unsichtbar
        bn.setVisible(false);
        pw.setVisible(false);
        buttonweiter.setVisible(false);
        labelSA.setVisible(false);
        buttonSp1.setVisible(false);
        labelAnmelden.setVisible(false);
    }
    /**
     * Zeigt den Anmeldebildschirm
     */
    public void AnmeldenAufbauen(){
        // Anmelden sichtbar
        labelAnmelden.setVisible(true);
        bn.setVisible(true);
        pw.setVisible(true);
        buttonweiter.setVisible(true);
        labelPunkte.setVisible(false);
        labelSA.setVisible(false);
       buttonSp1.setVisible(false);
    }
    /**
     * Zeigt die Spielauswahl
     */
    public void Spieleauswahl(){
       labelSA.setVisible(true);
       buttonSp1.setVisible(true);
       labelAnmelden.setVisible(false);
        bn.setVisible(false);
        pw.setVisible(false);
        buttonweiter.setVisible(false);
        labelPunkte.setVisible(false);
        
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {
    }
    
    /**
     * Registriert button presses, ect
     */
    public void actionPerformed(ActionEvent e){
        
    }
}
