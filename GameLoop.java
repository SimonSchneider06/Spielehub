import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Random;
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
    
    int kaktusSpeed;
    /**
     * Konstruktor für Objekte der Klasse GameLoop
     */
    public GameLoop(Dino dino,Fenster fenster)
    {
        this.dino = dino;
        this.ground = ground;
        this.fenster = fenster;
        
        this.kaktusSpeed = 15;
        
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
            Entity enemy = this.enemyList.get(i);
            this.deleteEnemy(i,enemy);
            enemy.Update();
        }
    }
    
    public void run(){
        //dino.Update();
        int loopCount = 0;
        while(!gameOver){
            this.dino.Update();
            this.updateEnemys();
            
            // alle 30 Runden, jede Runde 50ms -> alle 1,5s
            // kaktus spawnen
            if(loopCount % 30 == 0){
                this.fenster.spawnEnemy();
            }
            if(loopCount % 100 == 0){
                this.fenster.erhöhePunkte(1);
                this.kaktusSpeed += 3;
            }
            
            //System.out.println("--START--");
            try
            {
                TimeUnit.MILLISECONDS.sleep(50);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
            loopCount++;
        }
    }
    }
