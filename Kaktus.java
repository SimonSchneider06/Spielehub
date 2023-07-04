
/**
 * Beschreiben Sie hier die Klasse Kaktus.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Kaktus extends Entity
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    int ground;

    /**
     * Konstruktor für Objekte der Klasse Kaktus
     */
    public Kaktus(int pos_x,int ground)
    {
        // Instanzvariable initialisieren
        super("Bilder-Transparent",pos_x,ground,100,100);
        this.ground = ground;
    }

    @Override public void Animate(){
        System.out.println("Animate");
    }
}
