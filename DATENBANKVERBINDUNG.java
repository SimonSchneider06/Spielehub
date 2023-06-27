
import java. sql. *;

/**
 * Stellt die Methoden zum Zugriff auf die Datenbank zur Verfügung.
 * 
 * @author ret
 * @version 1.0
 */
class DATENBANKVERBINDUNG
{
    /** Speichert die Verbindung zur Datenbank. */
    private Connection conn;
    private String Benutzername;

    /**
     * Im Konstruktor wird eine Verbindung zur Datenbank aufgebaut.
     */
    DATENBANKVERBINDUNG ()
    {
        // Lädt den Treiber für die Datenbankverbindung (bei älteren Versionen noch nötig)
        // Class.forName ("com.mysql.jdbc.Driver").newInstance();        
        // Öffent die Verbindung, alle Daten sind über die URL angegeben
        // Protokoll (jdbc:mysql): Der JDBC-Treiber für MySQL wird verwendet
        // Rechner/Pfad (IP-Adresse/Datenbankname): Der Sever läuft auf dem Rechner IP-Adresse, die DB heißt Datenbankname
        // Parameter: Geben Benutzer Schueler und Passwort GymBeiln an.
        VerbindungOeffnen("jdbc:mysql://172.16.0.99/Testdatenbank?user=Schueler&password=GymBeiln");
    }

    /**
     * Verbindung öffnen
     * @param Server Zeichenkette, die die Internetadresse des Servers repraesentiert
     */
    void VerbindungOeffnen (String server)
    {
        try
        {
            conn = DriverManager. getConnection(server);
            System. out. println ("Verbindung aufgebaut.");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Beendet die Verbindung, danach ist Schluss.
     */
    void VerbindungSchliessen ()
    {
        try
        {
            conn. close ();
            System. out. println ("Verbindung beendet.");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Fuehrt die Datenmanipulationsanweisung (INSERT, DELETE, UPDATE) aus. => geht gut
     * @param anweisung SQL-Anweisung
     */
    void AnweisungAbsetzen()
    //void AnweisungAbsetzen(String anweisung)
    {
        System.out.println("Eingefuegt Anfang");
        try
        {
            Statement st = conn. createStatement (); 
            st. executeUpdate ("INSERT INTO personen (ID, Vorname, Nachname,Passwort, Status, Benutzername, GerichtMo, GerichtDi, GerichtMi, GerichtDo, GerichtFr) VALUES ('1', 'Max', 'Muster','pass212','M', 'DoSc', '1','1', '0', '1','0')");
            //st. executeUpdate ("DELETE FROM personen WHERE Nachname = 'Reschauer'");
            
            
           // st. executeUpdate (anweisung);
            st. close ();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    void AbrufPasswort( String Benutzername )
    //void AnweisungAbsetzen(String anweisung)
    {
        System.out.println("Passwortabfrage");
        try
        {
            Statement st = conn. createStatement (); 
            st. executeUpdate ("SELECT FROM personen WHERE Benutzername = ' Benutzername'(Benutzername, Passwort )");
            //st. executeUpdate ("DELETE FROM personen WHERE Nachname = 'Reschauer'");
            
            
           // st. executeUpdate (anweisung);
            st. close ();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Fuehrt die SQL-Abfrage (SELECT) aus.
     * @param anweisung SQL-Abfrage
     */
    void AbfrageAbsetzen(String abfrage)
    {        
        try
        {
            Statement st = conn. createStatement ();

            System. out. println ("SQL-Abfrage"); 
            //  "SELECT Benutzername, GerichtMo FROM personen"
            ResultSet rs = st. executeQuery (abfrage);

            //Geht die Ergebnistabelle Zeile für Zeile durch
            while (rs. next ())
            {
                 //rs. get... holt die Spaltenwerte der aktuellen Zeile
                 System. out. println ("Benutzer = " + rs.getString("Benutzername") + ", Mo = " + rs.getString("GerichtMo"));
              
                }
            rs. close ();
            st. close ();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    
    /**
     * Zählt die Anzahl der Datensaetze in der Tabelle personen und gibt die Anzahl auf der Konsole aus.
     *   -> geht gut
       */
    void AuswahloptionenZaehlen ()
    {
        try
        {
            Statement st = conn. createStatement ();
            //Setzt die Anfrage ab, auf die Ergebnistabelle kann mit rs zugegriffen werden
            ResultSet rs = st. executeQuery ("SELECT count(*) AS anzahl FROM personen");
            System. out. println ("Anzahl Personen");
            //Geht die Ergebnistabelle Zeile für Zeile durch
            while (rs. next ())
            {
                //rs. get... holt die Spaltenwerte der aktuellen Zeile
               System. out. println ("Anzahl = " + rs. getInt ("anzahl"));
            }
            rs. close ();
            st. close ();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    

    /**
     * Löscht Person mit ID 12 // geht gut
     */
    void PersonLoeschen ()
    {
        try
        {
            Statement st = conn. createStatement ();
            st. executeUpdate ("DELETE FROM personen WHERE ID = 7");
            st. close ();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
   }

