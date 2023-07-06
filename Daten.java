
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
*  Beipiel für die Speicherung von Daten in deinem Projekt.
*  Ergänze die txt.-Datei "TestdatenStrichpunkt.txt" in deinem Projektordner.
*  Ergänze die Klasse Daten in deinem Projekt.
*  Erzeuge ein Objekt und teste die Methoden.
*  Passe die Klasse an dein Projekt an.
*  
*/
public class Daten {

    public void AllesAuslesen() {
        try {
            java.io.BufferedReader FileReader=                      //ein Reader um die Datei Zeilenweise auszulesen
                new java.io.BufferedReader(
                    new java.io.FileReader(
                        new java.io.File("Datenbank.txt")
                    )
                );

            String text="";

            while(null!=(text=FileReader.readLine())){         //lesen jeder Zeile  
                String[] split=text.split(";");                //hier wird die Zeile zerlegt als Trennzeichen ; 
                for (String word : split) {
                    String[] zeile = word.split(" ");
                    System.out.println("Benutzername: " + zeile[1] + "   Passwort: " + zeile[2]+ "   LetztesSpielDinorun:  " +zeile[3]+ "    HighscoreDinorun: " + zeile[4]);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean BenutzernameEnthalten(String Benutzername) {
        try {
            java.io.BufferedReader FileReader=                      //ein Reader um die Datei Zeilenweise auszulesen
                new java.io.BufferedReader(
                    new java.io.FileReader(
                        new java.io.File("Datenbank.txt")
                    )
                );

            String text="";

            while(null!=(text=FileReader.readLine())){         //lesen jeder Zeile  
                String[] split=text.split(";");                //Die Datensätze werden mit Strichpunkt getrennt
                for (String word : split) {
                    String[] zeile = word.split(" ");  //Die einzelnen Wörter eines Datensatzes mit Leerzeichen
                    if(zeile[0].equals(Benutzername)){return true;}
                    // System.out.println("Benutzername: " + zeile[0] + "   Passwort " + zeile[1]+ "   LetztesSpielDinorun:  " +zeile[2]+ "    HighscoreDinorun: " + zeile[3]);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    
    /**
     * Woerter mit Leerzeichen getrennt.
     * Parameterwert z.B. "Benutzername, Passwort, letzte Punkte, Highscore"
     * Voraussetzung: Die Datei "TestdatenStrichpunkt" ist im Projektordner und enthält bereits Datensätze
     * @param: daten: String in obiger Reihenfolge
     */
    public void DatensatzEinfuegen(String daten){
        
        // Beispiel für "daten" im Format Vorname Nachname Alter Punkte
        //String daten = "SchneiderS 1234 150 260;

        String inhalt="";
             try {
            java.io.BufferedReader FileReader=                      //ein Reader um die Datei Zeilenweise auszulesen
                new java.io.BufferedReader(
                    new java.io.FileReader(
                        new java.io.File("Datenbank.txt")
                    )
                );

            String text="";

            while(null!=(text=FileReader.readLine())){         //lesen jeder Zeile  
                 inhalt = inhalt + text;
                 //System.out.println("INHALT: " + inhalt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Neuen Datensatz an bereits enthaltene Datensätze anhängen
        //System.out.println("PRINT: " + inhalt);
        inhalt = inhalt + daten + ";";
        //System.out.println(inhalt);
        
        try (FileWriter writer = new FileWriter("Datenbank.txt");
        BufferedWriter bw = new BufferedWriter(writer)) {
            
            
            bw.write(inhalt);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }
    
    /**
       Löscht einen Datensatz, vom entsprechendem Benutzernamen aus der Datenbank
       @param Benutzername = String;
       */
    public void DatensatzLöschen(String Benutzername){
        String inhalt="";
             try {
            java.io.BufferedReader FileReader=                      //ein Reader um die Datei Zeilenweise auszulesen
                new java.io.BufferedReader(
                    new java.io.FileReader(
                        new java.io.File("Datenbank.txt")
                    )
                );

            String text="";
            while(null!=(text=FileReader.readLine())){         //lesen jeder Zeile  
                String[] split=text.split(";");                //Die Datensätze werden mit Strichpunkt getrennt
                for (String word : split) {
                    String[] zeile = word.split(" "); //Die einzelnen Wörter eines Datensatzes mit Leerzeichen
                    //System.out.println("Benutzername: " + zeile[0] + "   Passwort: " + zeile[1]+ "   LetztesSpielDinorun:  " +zeile[2]+ "    HighscoreDinorun: " + zeile[3]);
                    if(!zeile[0].equals(Benutzername)){
                        //System.out.println("------------------" + zeile[index]);
                        inhalt += word + ";";
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(inhalt);
        
        try (FileWriter writer = new FileWriter("Datenbank.txt");
        BufferedWriter bw = new BufferedWriter(writer)) {
            
            //System.out.println("Löschen/neuer Inhalt: " + inhalt);
            bw.write(inhalt);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    
    }
    
    /**
       Ändert die Daten des jeweiligen Benutzers
       @param Benutzername = String;
       @param neuerDatensatz = String; z.B. "Benutzername Passwort LetztePunkte HighScore"
       */
    public void DatensatzÄndern(String Benutzername, String neuerDatensatz){
        this.DatensatzLöschen(Benutzername);
        this.DatensatzEinfuegen(neuerDatensatz);
    }
    
    /**
       Checks if Punkte über HighScore und aktuallisiert die Punkte in der Datenbank;
       Returns the new HighScore = int;
       @param Benutzername = String; der Benutzername des zu aktuallisierenden Datensets;
       @param Punkte = int; Punkte, die dieses Spiel erreicht wurden;
       */
    public int CheckHighScore(String Benutzername, int Punkte){
        try{
            int HighScore = Integer.parseInt(this.getHighScore(Benutzername));
            if(Punkte > HighScore){
                String letztePunkte = this.getLastPoints(Benutzername);
                this.setPunkteStand(Benutzername, Punkte,letztePunkte);
                return Punkte;
            }
            else{
                this.setPunkteStand(Benutzername, HighScore, String.valueOf(Punkte));
                return HighScore;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        // don't like it
        return 0;
    }
    
    /**
       Aktuallisiert den Punktestand
       Setzt HighScore und letzte Punkte
       @param Benutzername = String; der Benutzername, wo der HighScore geändert werden soll
       @param newHighScore = int; der neue HighScore;
       @param letztePunkte = String; letzte Punkte;
       */
    public void setPunkteStand(String Benutzername,int newHighScore,String letztePunkte){
        String Passwort = this.PasswortAbfragen(Benutzername);
        
        String neuerDatensatz = Benutzername + " " + Passwort + " " + letztePunkte + " " + newHighScore;
        this.DatensatzÄndern(Benutzername, neuerDatensatz);
    }
    
    /**
       Get the HighScore by the Username
       @param Benutzername = String
       */
    public String getHighScore(String Benutzername){
        return this.getDatenbankEntryByUserName(Benutzername, 3);
    }
    
    /**
       Get the Passwort from the Username
       @param Benutzername = String
       */
    public String PasswortAbfragen(String Benutzername){
        return this.getDatenbankEntryByUserName(Benutzername, 1);
    }
    
    /**
       Get the LastPoints from the Username
       @param Benutzername = String
       */
    public String getLastPoints(String Benutzername){
        return this.getDatenbankEntryByUserName(Benutzername, 2);
    }
    
    /**
       Returns a selected Entry of the Database; Returnvalue = String
       @param Benutzername = String; the Benutzername, from which to get the data
       @param index = int; the index of the Database Entry
       */
    public String getDatenbankEntryByUserName(String Benutzername, int index){
        try{
            java.io.BufferedReader FileReader=                      //ein Reader um die Datei Zeilenweise auszulesen
                new java.io.BufferedReader(
                    new java.io.FileReader(
                        new java.io.File("Datenbank.txt")
                    )
                );
                
            String text="";
            while(null!=(text=FileReader.readLine())){         //lesen jeder Zeile  
                String[] split=text.split(";");                //Die Datensätze werden mit Strichpunkt getrennt
                for (String word : split) {
                    String[] zeile = word.split(" "); //Die einzelnen Wörter eines Datensatzes mit Leerzeichen
                    //System.out.println("Benutzername: " + zeile[0] + "   Passwort: " + zeile[1]+ "   LetztesSpielDinorun:  " +zeile[2]+ "    HighscoreDinorun: " + zeile[3]);
                    if(zeile[0].equals(Benutzername)){
                        //System.out.println("------------------" + zeile[index]);
                        return  zeile[index];
                    }
                    //System.out.println(Benutzername);
                    //System.out.println(zeile[0]);
                    //System.out.println(zeile[1]);
                    //System.out.println(zeile[0] == Benutzername);
                    // System.out.println("Benutzername: " + zeile[0] + "   Passwort: " + zeile[1]+ "   LetztesSpielDinorun:  " +zeile[2]+ "    HighscoreDinorun: " + zeile[3]);
                }

            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        return "";
    }
    
}
