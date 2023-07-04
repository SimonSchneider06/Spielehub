
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
        super("Bilder-Transparent/Kaktus/",pos_x,ground,100,100);
        this.ground = ground;
        this.speed = 15;
    }
    /**
     *  Bewegt die Kakteen nach links(Kakteen,...)
     */
    public void Move_left()
    {
        this.bild.setLocation(this.bild.getLocation().x - this.speed,this.bild.getLocation().y);
    }

    @Override public void Update(){
        this.Move_left();
    }
}