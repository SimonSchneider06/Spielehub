
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

    
    public String PasswortAbfragen(String Benutzername){
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
                    if(zeile[0].equals(Benutzername)){
                        //System.out.println("------------------" + zeile[1]);
                        return  zeile[1];
                    }
                    //System.out.println(Benutzername);
                    //System.out.println(zeile[0]);
                    //System.out.println(zeile[1]);
                    //System.out.println(zeile[0] == Benutzername);
                    // System.out.println("Benutzername: " + zeile[0] + "   Passwort: " + zeile[1]+ "   LetztesSpielDinorun:  " +zeile[2]+ "    HighscoreDinorun: " + zeile[3]);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Defaultwert
        return "";
    }
    
    
    /**
     * Woerter mit Leerzeichen getrennt.
     * Parameterwert z.B. "Benutzername, Passwort, letzte Punkte, Highscore"
     * Voraussetzung: Die Datei "TestdatenStrichpunkt" ist im Projektordner und enthält bereits Datensätze
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
                 //System.out.println(inhalt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Neuen Datensatz an bereits enthaltene Datensätze anhängen
        System.out.println(inhalt);
        inhalt = inhalt + daten + ";";
        //System.out.println(inhalt);
        
        try (FileWriter writer = new FileWriter("Datenbank.txt");
        BufferedWriter bw = new BufferedWriter(writer)) {
            
            
            bw.write(inhalt);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

    }
    
}
