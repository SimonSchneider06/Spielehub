import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Beschreiben Sie hier die Klasse GameLoop.
 * 
 * @author Simon Schneider + Maximilan Edenhofer
 * @version 1.0
 */
public class GameLoop implements Runnable
{
    private Dino dino;
    public Entity enemy;
    public ArrayList<Entity> enemyList;
    
    int ground;
    
    boolean gameOver;
    
    Random rand;
    
    Fenster fenster;
    /**
     * Konstruktor für Objekte der Klasse GameLoop
     */
    public GameLoop(Dino dino,Fenster fenster)
    {
        this.dino = dino;
        this.ground = ground;
        this.fenster = fenster;
        
        gameOver = false;
        rand = new Random();
        
        this.enemyList = new ArrayList<Entity>(); 
    }
    
    public void addEnemyToList(Entity e){
        this.enemyList.add(e);
    }
    
    /**
       Delete an Enemy and remove it from the list, if it gets of the screen
       @param e = Enemy
       
       */
    public void deleteEnemy(int index,Entity e){
        JLabel enemyBild = e.gibBild();
        if(enemyBild.getLocation().x < -100){
            // Delete object
            this.enemyList.remove(index);
            e = null;
        }
    }
    
    /**
       * Update all Enemys in the ArrayList enemyList
       */
    public void updateEnemys(){
        for(int i = 0; i < this.enemyList.size(); i ++){
            Entity e = this.enemyList.get(i);
            //this.deleteEnemy(i,e);
            e.Update();
        }
    }
    
    public void run(){
        //dino.Update();
        while(!gameOver){
            this.dino.Update();
            this.updateEnemys();
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
