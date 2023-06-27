import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

/**
 * Beschreiben Sie hier die Klasse Spielfeld.
 * 
 * @author Simon Schneider + Maximilian Edenhofer 
 * @version 1.0
 */
public class Fenster extends JFrame implements ActionListener,MouseListener,KeyListener
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JLabel labelPunkte;

    private Dino dino;

    private JLabel labelAnmelden;
    private JTextField bn;
    private JTextField pw;
    private JLabel pwÜberprüfen;
    private JLabel bnÜberprüfen;
    private JLabel labelPÜ;
    private JLabel labelSA;
    private JLabel RErfolg;
    private JButton buttonAnmelden;
    private JButton buttonRegistrieren;
    private JButton buttonSp1;
    private JButton buttonBestätigen;
    private JButton buttonAbbrechen;
    private JButton buttonAbmelden; 

    private JButton buttonPÜ;

    private Thread gameLoop;
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
        dino.gibBild().addKeyListener(this);
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

        //KnopfAnmelden
        buttonAnmelden = new JButton();
        buttonAnmelden.setText("Anmelden");
        buttonAnmelden.setLocation(320, 520);
        buttonAnmelden.setSize (470, 70);
        buttonAnmelden.setEnabled(true);
        buttonAnmelden.setFont(buttonAnmelden.getFont().deriveFont(56f));
        buttonAnmelden.addActionListener(this);
        //KnopfRegistrieren
        buttonRegistrieren = new JButton();
        buttonRegistrieren.setText("Registrieren");
        buttonRegistrieren.setLocation(320,440);
        buttonRegistrieren.setSize (470, 70);
        buttonRegistrieren.setEnabled(true);
        buttonRegistrieren.setFont(buttonRegistrieren.getFont().deriveFont(56f));
        buttonRegistrieren.addActionListener(this);
        // Anmelden, Benutzernameeingabefeld,Passworteingabefeld, Knopf hinzufügen
        super.add(labelAnmelden);
        super.add(bn);
        super.add(pw);
        super.add(buttonAnmelden);
        super.add(buttonRegistrieren);
        //---------------------Registrieren------------------------
        RErfolg = new JLabel();
        RErfolg.setText("Die Registrierung war erfolgreich!");
        RErfolg.setLocation(250,40);
        RErfolg.setSize (900, 200);       
        RErfolg.setFont(RErfolg.getFont().deriveFont(46f));

        buttonBestätigen = new JButton();
        buttonBestätigen.setText("Bestätigen");
        buttonBestätigen.setLocation(320, 440);
        buttonBestätigen.setSize (470, 70);
        buttonBestätigen.setEnabled(true);
        buttonBestätigen.setFont(buttonBestätigen.getFont().deriveFont(56f));
        buttonBestätigen.addActionListener(this);

        buttonAbbrechen = new JButton();
        buttonAbbrechen.setText("Abbrechen");
        buttonAbbrechen.setLocation(320, 520);
        buttonAbbrechen.setSize (470, 70);
        buttonAbbrechen.setEnabled(true);
        buttonAbbrechen.setFont(buttonBestätigen.getFont().deriveFont(56f));
        buttonAbbrechen.addActionListener(this);

        bnÜberprüfen = new JLabel();
        bnÜberprüfen.setText("Benutzername");
        bnÜberprüfen.setLocation(280,250);
        bnÜberprüfen.setSize (550,80);
        bnÜberprüfen.setFont(pw.getFont().deriveFont(56f));

        pwÜberprüfen = new JLabel();
        pwÜberprüfen.setText("Passwort");
        pwÜberprüfen.setLocation(280,330);
        pwÜberprüfen.setSize (550,80);
        pwÜberprüfen.setFont(pw.getFont().deriveFont(56f));

        super.add(buttonBestätigen);
        super.add(RErfolg);
        super.add(bnÜberprüfen);
        super.add(pwÜberprüfen);
        super.add(buttonAbbrechen);
        //---------------------Spieleauswahl(SA)------------------------

        labelSA = new JLabel();
        labelSA.setText("Spieleauswahl: ");
        labelSA.setLocation(20,20);
        labelSA.setSize(350,50);
        labelSA.setFont(labelSA.getFont().deriveFont(46f));

        buttonSp1 = new JButton();
        buttonSp1.setText("Dinorun");
        buttonSp1.setLocation(20, 100);
        buttonSp1.setSize (300, 70);
        buttonSp1.setEnabled(true);
        buttonSp1.setFont(buttonSp1.getFont().deriveFont(56f));
        buttonSp1.addActionListener(this);

        buttonPÜ = new JButton();
        buttonPÜ.setText("Punkteübersicht");
        buttonPÜ.setLocation(50, 650);
        buttonPÜ.setSize (600, 60);
        buttonPÜ.setEnabled(true);
        buttonPÜ.setFont(buttonPÜ.getFont().deriveFont(56f));
        buttonPÜ.addActionListener(this);

        buttonAbmelden = new JButton();
        buttonAbmelden.setText("Abmelden");
        buttonAbmelden.setLocation(800, 650);
        buttonAbmelden.setSize (470, 60);
        buttonAbmelden.setEnabled(true);
        buttonAbmelden.setFont(buttonSp1.getFont().deriveFont(56f));
        buttonAbmelden.addActionListener(this);

        super.add(labelSA);
        super.add(buttonSp1);
        super.add(buttonAbmelden);

        super.add(buttonPÜ);

        //---------------------Punkteübersicht(PÜ)------------------------
        labelPÜ = new JLabel();
        labelPÜ.setText("PÜ: ");
        labelPÜ.setLocation(50,150);
        labelPÜ.setSize(300,50);
        labelPÜ.setFont(labelPÜ.getFont().deriveFont(46f));

        super.add(labelPÜ);
        //------------------------gameloop--------------------
        gameLoop = new Thread(new GameLoop(dino));

        // SpielfeldAufbauen();
        AnmeldenAufbauen();
        //Spieleauswahl();
        //Registrieren();
        buttonAnmelden.addActionListener(this);
        buttonRegistrieren.addActionListener(this);
        buttonBestätigen.addActionListener(this);
        buttonAbbrechen.addActionListener(this);
        buttonAbmelden.addActionListener(this);
        buttonPÜ.addActionListener(this);

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
        DinoSpielGruppeSichtbar(true);
        AnmeldeGruppeSichtbar(false);
        RegistrierGruppeSichtbar(false);
        SpielauswahlGruppeSichtbar(false);
        PunkteübersichtGruppeSichtbar(false); 

    }

    /**
     * Zeigt den Anmeldebildschirm
     */
    public void AnmeldenAufbauen(){
        // Anmelden sichtbar
        DinoSpielGruppeSichtbar(false);
        AnmeldeGruppeSichtbar(true);
        RegistrierGruppeSichtbar(false);
        SpielauswahlGruppeSichtbar(false);
        PunkteübersichtGruppeSichtbar(false); 
    }

    /**
     * Zeigt die Spielauswahl
     */
    public void Spieleauswahl(){
        // Spieleauswahl sichtbar
        DinoSpielGruppeSichtbar(false);
        AnmeldeGruppeSichtbar(false);
        RegistrierGruppeSichtbar(false);
        SpielauswahlGruppeSichtbar(true);
        PunkteübersichtGruppeSichtbar(false); 

    }

    public void Registrieren(){
        // Spieleauswahl sichtbar

        DinoSpielGruppeSichtbar(false);
        AnmeldeGruppeSichtbar(false);
        RegistrierGruppeSichtbar(true);
        SpielauswahlGruppeSichtbar(false);
        PunkteübersichtGruppeSichtbar(false); 

    }

    public void Punkteübersicht(){
        DinoSpielGruppeSichtbar(false);
        AnmeldeGruppeSichtbar(false);
        RegistrierGruppeSichtbar(false);
        SpielauswahlGruppeSichtbar(false);
        PunkteübersichtGruppeSichtbar(true); 
        buttonAbmelden.setVisible(true);
    }

    void DinoSpielGruppeSichtbar(boolean sichtbar){
        dino.gibBild().setVisible(sichtbar);
        labelPunkte.setVisible(sichtbar);
        if(sichtbar){
            try{
                TimeUnit.SECONDS.sleep(2);
                gameLoop.start();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }

    void AnmeldeGruppeSichtbar(boolean sichtbar){
        labelAnmelden.setVisible(sichtbar);
        bn.setVisible(sichtbar);
        pw.setVisible(sichtbar);
        buttonAnmelden.setVisible(sichtbar);
        buttonRegistrieren.setVisible(sichtbar);
    }

    void RegistrierGruppeSichtbar(boolean sichtbar){
        RErfolg.setVisible(sichtbar);
        buttonBestätigen.setVisible(sichtbar);
        buttonAbbrechen.setVisible(sichtbar);
        bnÜberprüfen.setVisible(sichtbar);
        pwÜberprüfen.setVisible(sichtbar);

    }

    void SpielauswahlGruppeSichtbar(boolean sichtbar){
        labelSA.setVisible(sichtbar);
        buttonSp1.setVisible(sichtbar);
        buttonAbmelden.setVisible(sichtbar);
        buttonPÜ.setVisible(sichtbar);

    }

    void PunkteübersichtGruppeSichtbar(boolean sichtbar){
        labelPÜ.setVisible(sichtbar);

    }

    /*
    Game Loop
     */
    public static void gameLoop(){
        int fps = 30;

    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {
    }

    @Override public void keyReleased(KeyEvent e){
    }

    @Override public void keyPressed(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){

            JLabel dinoBild = dino.gibBild();
            dinoBild.setLocation(dinoBild.getLocation().x, dinoBild.getLocation().y - 200);
        }
        repaint();
    }

    @Override public void keyTyped(KeyEvent e){
    }

    /**
     * Registriert button presses, ect
     */
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==this.buttonAnmelden){
            this.Spieleauswahl();

        }
        else if(e.getSource()==this.buttonRegistrieren)
        {
            this.Registrieren();

        }

        else if(e.getSource() == this.buttonSp1){
            this.SpielfeldAufbauen();
        }

        else if(e.getSource()==this.buttonAbbrechen)
        {this.AnmeldenAufbauen();
        }
        else if(e.getSource()==this.buttonBestätigen)

        {this.Spieleauswahl();}

        else if(e.getSource()==this.buttonAbmelden)
        {this.AnmeldenAufbauen();}

        else if(e.getSource()==this.buttonPÜ)
        {this.Punkteübersicht();}

    }}
