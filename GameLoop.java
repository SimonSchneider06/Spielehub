import java.util.concurrent.TimeUnit;
/**
 * Beschreiben Sie hier die Klasse GameLoop.
 * 
 * @author Simon Schneider + Maximilan Edenhofer
 * @version 1.0
 */
public class GameLoop implements Runnable
{
    private Dino dino;   
    boolean gameOver;
    /**
     * Konstruktor für Objekte der Klasse GameLoop
     */
    public GameLoop(Dino dino)
    {
        this.dino = dino;
        gameOver = false;
    }
    
    public void run(){
        //dino.Update();
        while(!gameOver){
            this.dino.Update();
            //System.out.println("--START--");
            try
            {
                TimeUnit.MILLISECONDS.sleep(50);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
    }
