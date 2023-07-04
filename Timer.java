

/**
 * Beschreiben Sie hier die Klasse Timer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Timer
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    public long cooldown;
    public long currentTime;
    public long startTime;
    public boolean active;
    /**
     * Konstruktor für Objekte der Klasse Timer
     * @param cooldown in Milliseconds
     */
    public Timer(long cooldown)
    {
        // Instanzvariable initialisieren
        this.cooldown = cooldown;
        this.active = false;
    }

    /**
     * Activate the Timer
     * 
     * */
    public void activate(){
        this.active = true;
        this.startTime = System.currentTimeMillis();
    
    }
    /**
     * Deactivate the Timer
     * 
     * */
    public void deactivate(){
        this.active = false;
        this.startTime = 0;
    
    }
    
    
    /**
     * Update the Timer
     *  
     */
    public boolean Update()
    {
        // tragen Sie hier den Code ein
        currentTime = System.currentTimeMillis();
        if(this.currentTime - this.startTime >= this.cooldown){
            if(this.startTime != 0){
                return true;
            }
            this.deactivate();
        }
        return false;
    }
}
