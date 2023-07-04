
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

    /**
     * Konstruktor für Objekte der Klasse Timer
     * @param cooldown in Milliseconds
     */
    public Timer(long cooldown)
    {
        // Instanzvariable initialisieren
        cooldown = cooldown;
    }

    /**
     * Starts/Resets the Timer
     * 
     * */
    public void StartTimer(){
        this.startTime = System.currentTimeMillis();
    
    }
    
    /**
     * Checks if the variable can be changed
     * Returns true or false
     * 
     * */
    public boolean CheckTimer(){
        if(this.currentTime - this.startTime >= this.cooldown){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Update the Timer
     * 
     * 
     */
    public boolean Update()
    {
        // tragen Sie hier den Code ein
        currentTime = System.currentTimeMillis();
        return this.CheckTimer();
        
    }
}
