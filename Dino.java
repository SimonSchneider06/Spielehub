
/**
 * Beschreiben Sie hier die Klasse Dino.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Dino extends Entity
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen

    /**
     * Konstruktor für Objekte der Klasse Dino
     */
    public Dino()
    {
        // Instanzvariable initialisieren
        super("Bilder/dino_1.png",20,300,100,100);

    }

    /**
     * lässt den Dino bei input springen
     */
    private void input(){
    
    }
    
    @Override public void Update(){
        input();
        Animate();
    }
}
