import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.*;

/**
 * Beschreiben Sie hier die Klasse Spielfeld.
 * 
 * @author Simon Schneider + Maximilian Edenhofer 
 * @version 1.0
 */
public class Fenster extends JFrame implements ActionListener,MouseListener, KeyListener
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private JLabel labelPunkte;

    private Dino dino;
    
    private JLabel labelAnmelden;
    private JTextField bn;
    private JTextField pw;

    private JLabel pwÜberprüfen;
    private JLabel bnÜberprüfen;
    private JLabel GameOver;
    private JLabel AnzeigePunkte;
    private JLabel AnzeigeHighscore;
    private JLabel labelPÜ;
    private JLabel labelSA;
    private JLabel RErfolg;
    private JLabel AnmeldenF;
    private JButton buttonAnmelden;
    private JButton buttonRegistrieren;
    private JButton buttonSp1;
    private JButton buttonBestätigen;
    private JButton buttonAbbrechen;
    private JButton buttonAbmelden; 
    private JButton buttonZurück;
    private JButton buttonZurückZurSA;
    private JButton buttonPÜ;
    private JButton buttonEV;
    
    private JLabel RegistrierenFehler;
    private JButton buttonRegistrierenFehler;
    
    private Thread gameLoopThread;
    private String Benutzername;
    private String Passwort;
    private int LetztesSpielDinorun;
    private int HighscoreDinorun;
    
    private Daten datenManager;
    
    public int ground;
    
    Random rand;
    
    GameLoop gameLoop;
    public boolean gameOver;
    
    public int Punkte;
    public int Highscore;

    /**
     * Konstruktor für Objekte der Klasse Spielfeld
     */
    public Fenster()
    {
        // Datenmanager
        datenManager = new Daten();
        
        //random 
        this.rand = new Random();
        this.gameOver = false;
       
        //---------------------Spielfeld------------------------
        // Punkte label
        this.Punkte = 0;
        labelPunkte = new JLabel();
        labelPunkte.setText("Punkte: " + Punkte);
        labelPunkte.setLocation(20,20);
        labelPunkte.setSize(300,50);
        labelPunkte.setFont(labelPunkte.getFont().deriveFont(46f));
        
        // ground
        ground = 400;

        dino = new Dino(ground);
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
        bnÜberprüfen.setText(Benutzername);
        bnÜberprüfen.setLocation(280,250);
        bnÜberprüfen.setSize (550,80);
        bnÜberprüfen.setFont(pw.getFont().deriveFont(56f));

        pwÜberprüfen = new JLabel();
        pwÜberprüfen.setText(Passwort);
        pwÜberprüfen.setLocation(280,330);
        pwÜberprüfen.setSize (550,80);
        pwÜberprüfen.setFont(pw.getFont().deriveFont(56f));

        super.add(buttonBestätigen);
        super.add(RErfolg);
        super.add(bnÜberprüfen);
        super.add(pwÜberprüfen);
        super.add(buttonAbbrechen);
             //---------------------Anmeldungfehlgeschlagen------------------------
        AnmeldenF = new JLabel();
        AnmeldenF.setText("Die Anmeldung ist fehlgeschlagen!");
        AnmeldenF.setLocation(250,40);
        AnmeldenF.setSize (900, 200);       
        AnmeldenF.setFont(RErfolg.getFont().deriveFont(46f));

        buttonEV = new JButton();
        buttonEV.setText("Erneut versuchen");
        buttonEV.setLocation(320, 440);
        buttonEV.setSize (550, 70);
        buttonEV.setEnabled(true);
        buttonEV.setFont(buttonBestätigen.getFont().deriveFont(56f));
        buttonEV.addActionListener(this);


        super.add(buttonEV);
        super.add(AnmeldenF);
        
              //---------------------Registrierung fehlgeschlagen------------------------
        RegistrierenFehler = new JLabel();
        RegistrierenFehler.setText("Der Benutzername existiert bereits!");
        RegistrierenFehler.setLocation(250,40);
        RegistrierenFehler.setSize (900, 200);       
        RegistrierenFehler.setFont(RErfolg.getFont().deriveFont(46f));

        buttonRegistrierenFehler = new JButton();
        buttonRegistrierenFehler.setText("Erneut versuchen");
        buttonRegistrierenFehler.setLocation(320, 440);
        buttonRegistrierenFehler.setSize (550, 70);
        buttonRegistrierenFehler.setEnabled(true);
        buttonRegistrierenFehler.setFont(buttonBestätigen.getFont().deriveFont(56f));
        buttonRegistrierenFehler.addActionListener(this);


        super.add(buttonRegistrierenFehler);
        super.add(RegistrierenFehler);
        
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
        buttonPÜ.setLocation(20, 650);
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
        
        buttonZurück = new JButton();
        buttonZurück.setText("Zurück");
        buttonZurück.setLocation(20, 650);
        buttonZurück.setSize (470, 60);
        buttonZurück.setEnabled(true);
        buttonZurück.setFont(buttonSp1.getFont().deriveFont(56f));
        buttonZurück.addActionListener(this);
        
        super.add(buttonZurück);
        super.add(labelPÜ);
        //------------------------gameloop--------------------
        gameLoop = new GameLoop(dino,this);

             //---------------------Game Over------------------------
        GameOver = new JLabel();
        GameOver.setText("Game Over");
        GameOver.setLocation(250,40);
        GameOver.setSize (900, 200);       
        GameOver.setFont(RErfolg.getFont().deriveFont(46f));

        buttonZurückZurSA = new JButton();
        buttonZurückZurSA.setText("Erneut versuchen");
        buttonZurückZurSA.setLocation(320, 440);
        buttonZurückZurSA.setSize (550, 70);
        buttonZurückZurSA.setEnabled(true);
        buttonZurückZurSA.setFont(buttonBestätigen.getFont().deriveFont(56f));
        buttonZurückZurSA.addActionListener(this);
        
        
        AnzeigePunkte = new JLabel();
        AnzeigePunkte.setText("Punktestand: "+Punkte);
        AnzeigePunkte.setLocation(280,250);
       AnzeigePunkte.setSize (550,80);
        AnzeigePunkte.setFont(pw.getFont().deriveFont(56f));

        AnzeigeHighscore = new JLabel();
        AnzeigeHighscore.setText("Highscore: " +Highscore);
        AnzeigeHighscore.setLocation(280,330);
        AnzeigeHighscore.setSize (550,80);
        AnzeigeHighscore.setFont(pw.getFont().deriveFont(56f));
        
        super.add(buttonZurückZurSA);
        super.add(GameOver);
        super.add(AnzeigeHighscore);
        super.add(AnzeigePunkte);

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
        buttonZurück.addActionListener(this);
        buttonEV.addActionListener(this);
        buttonZurückZurSA.addActionListener(this);
        pw.addMouseListener(this);
        bn.addMouseListener(this);



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
        AnmeldungFGruppeSichtbar(false);
        gameOverGruppeSichtbar(false);
        RegistrierenFehlerSichtbar(false);
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
        AnmeldungFGruppeSichtbar(false);
        gameOverGruppeSichtbar(false);
        RegistrierenFehlerSichtbar(false);
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
        AnmeldungFGruppeSichtbar(false);
        gameOverGruppeSichtbar(false);
        RegistrierenFehlerSichtbar(false);
    }

    public void Registrieren(){
        // Spieleauswahl sichtbar

        DinoSpielGruppeSichtbar(false);
        AnmeldeGruppeSichtbar(false);
        RegistrierGruppeSichtbar(true);
        SpielauswahlGruppeSichtbar(false);
        PunkteübersichtGruppeSichtbar(false); 
        AnmeldungFGruppeSichtbar(false);
        bnÜberprüfen.setVisible(true);
        pwÜberprüfen.setVisible(true);
        gameOverGruppeSichtbar(false);
        RegistrierenFehlerSichtbar(false);
    }

    public void Punkteübersicht(){
        DinoSpielGruppeSichtbar(false);
        AnmeldeGruppeSichtbar(false);
        RegistrierGruppeSichtbar(false);
        SpielauswahlGruppeSichtbar(false);
        PunkteübersichtGruppeSichtbar(true); 
        buttonAbmelden.setVisible(true);
        AnmeldungFGruppeSichtbar(false);
        gameOverGruppeSichtbar(false);
        RegistrierenFehlerSichtbar(false);
    }
    public void Anmeldenfehlgeschlagen(){
        DinoSpielGruppeSichtbar(false);
        AnmeldeGruppeSichtbar(false);
        RegistrierGruppeSichtbar(false);
        SpielauswahlGruppeSichtbar(false);
        PunkteübersichtGruppeSichtbar(false);
        AnmeldungFGruppeSichtbar(true);
        bnÜberprüfen.setVisible(true);
        pwÜberprüfen.setVisible(true);
        gameOverGruppeSichtbar(false);
        RegistrierenFehlerSichtbar(false);
        
    }
    public void GameOver(){
        DinoSpielGruppeSichtbar(false);
        AnmeldeGruppeSichtbar(false);
        RegistrierGruppeSichtbar(false);
        SpielauswahlGruppeSichtbar(false);
        PunkteübersichtGruppeSichtbar(false); 
        AnmeldungFGruppeSichtbar(false);
        gameOverGruppeSichtbar(true);
        RegistrierenFehlerSichtbar(false);
        gameLoopThread.stop();
    
    }

    void DinoSpielGruppeSichtbar(boolean sichtbar){
        dino.gibBild().setVisible(sichtbar);
        labelPunkte.setVisible(sichtbar);
        if(sichtbar){
            try{
                gameLoop.gameOver = false;
                TimeUnit.SECONDS.sleep(2);
                gameLoopThread = new Thread(gameLoop);
                gameLoopThread.start();
                
                this.spawnEnemy();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public void RegistrierenFehler(){
        DinoSpielGruppeSichtbar(false);
        AnmeldeGruppeSichtbar(false);
        RegistrierGruppeSichtbar(false);
        SpielauswahlGruppeSichtbar(false);
        PunkteübersichtGruppeSichtbar(false); 
        AnmeldungFGruppeSichtbar(false);
        gameOverGruppeSichtbar(false);
        RegistrierenFehlerSichtbar(true);
    
    }

    void AnmeldeGruppeSichtbar(boolean sichtbar){
        labelAnmelden.setVisible(sichtbar);
        bn.setVisible(sichtbar);
        pw.setVisible(sichtbar);
        buttonRegistrieren.setVisible(sichtbar);
        buttonAnmelden.setVisible(sichtbar);
        
    }

    void RegistrierGruppeSichtbar(boolean sichtbar){
        RErfolg.setVisible(sichtbar);
        buttonBestätigen.setVisible(sichtbar);
        buttonAbbrechen.setVisible(sichtbar);
        bnÜberprüfen.setVisible(sichtbar);
        pwÜberprüfen.setVisible(sichtbar);
        

    }
      void AnmeldungFGruppeSichtbar(boolean sichtbar){
        AnmeldenF.setVisible(sichtbar);
        buttonEV.setVisible(sichtbar);
        
        

    }

    void SpielauswahlGruppeSichtbar(boolean sichtbar){
        labelSA.setVisible(sichtbar);
        buttonSp1.setVisible(sichtbar);
        buttonAbmelden.setVisible(sichtbar);
        buttonPÜ.setVisible(sichtbar);

    }

    void PunkteübersichtGruppeSichtbar(boolean sichtbar){
        labelPÜ.setVisible(sichtbar);
        buttonZurück.setVisible(sichtbar);

    }
    
    public void gameOverGruppeSichtbar(boolean sichtbar){
        buttonZurückZurSA.setVisible(sichtbar);
        AnzeigePunkte.setText("Punkte: " + this.Punkte);
        AnzeigePunkte.setVisible(sichtbar);
        String highScore = datenManager.getHighScore(this.Benutzername);
        AnzeigeHighscore.setText("HighScore: " + highScore);
        AnzeigeHighscore.setVisible(sichtbar);
        GameOver.setVisible(sichtbar);
        
    }
    
    public void RegistrierenFehlerSichtbar(boolean sichtbar){
        RegistrierenFehler.setVisible(sichtbar);
        buttonRegistrierenFehler.setVisible(sichtbar);
    }

    /**
       Spawn Kaktus und füge ihn zur enemyList hinzu
       
       */
    public void spawnEnemy(){
        int pos_x = 1200 + rand.nextInt(300);
        Kaktus enemy = new Kaktus(pos_x,ground,gameLoop.kaktusSpeed);
        // add JLabel of enemy
        
        this.EnemyVisibility(enemy,true);
        super.add(enemy.gibBild());
        gameLoop.addEnemyToList(enemy);
    }
    
    public void EnemyVisibility(Entity enemy,boolean sichtbar){
        JLabel bild = enemy.gibBild();
        bild.setVisible(sichtbar);
    }
    
    
    /**
     * Punkte erhöhen bei gewissen Wert und Anzeige updaten
     * @parma increment = um wie viel die Punkte erhöht werden sollen 
       */
    public void erhöhePunkte(int increment){
        this.Punkte += increment;
        labelPunkte.setText("Punkte: " + this.Punkte);
    }
    
    
    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == pw)
            pw.setText("");
    else if(e.getSource() == bn)
            bn.setText("");
    }

    @Override public void keyReleased(KeyEvent e){
    }

    @Override public void keyPressed(KeyEvent e){

        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            JLabel dinoBild = dino.gibBild();
            if(dino.canjump){
                dino.isJumping = true;
            }

        }
        repaint();
    }

    @Override public void keyTyped(KeyEvent e){
    }

    /**
     * Registriert button presses, ect
     */
    public void actionPerformed(ActionEvent e){


        if(e.getSource()==this.buttonAnmelden ){
            this.Benutzername = bn.getText();
            this.Passwort = pw.getText();
             if(datenManager.PasswortAbfragen(Benutzername).equals(this.Passwort)){
                this.Spieleauswahl();
                }
             else{
                pwÜberprüfen.setText(Passwort);
                bnÜberprüfen.setText(Benutzername);
                 this.Anmeldenfehlgeschlagen();
                }   

           }        


    else if(e.getSource()==this.buttonRegistrieren)
    {
        if(!datenManager.BenutzernameEnthalten(this.Benutzername)){
            this.Registrieren();
            Benutzername = bn.getText();
            Passwort = pw.getText();
            pwÜberprüfen.setText(Passwort);
            bnÜberprüfen.setText(Benutzername);
        }
        else{
            this.RegistrierenFehler();
        }
    }

    

        else if(e.getSource() == this.buttonSp1){
            this.SpielfeldAufbauen();
        }

        else if(e.getSource()==this.buttonAbbrechen)
        {this.AnmeldenAufbauen();
        }
        else if(e.getSource()==this.buttonBestätigen)

        {
            datenManager.DatensatzEinfuegen( Benutzername+" "+Passwort+ " "+LetztesSpielDinorun+" "+HighscoreDinorun );
            this.Spieleauswahl();
        }

        else if(e.getSource()==this.buttonAbmelden)
        {this.AnmeldenAufbauen();}

        
        else if(e.getSource()==this.buttonPÜ)
        {this.Punkteübersicht();}
        
        else if(e.getSource()==this.buttonZurück)
        {this.Spieleauswahl();}
         else if(e.getSource()==this.buttonEV || e.getSource() == this.buttonRegistrierenFehler)
        {this.AnmeldenAufbauen();}
        else if(e.getSource()==this.buttonZurückZurSA)
        {this.Spieleauswahl();}
        
    

}
}

        

