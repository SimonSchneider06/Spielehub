import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Random;
import java.awt.*;

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
        
        this.kaktusSpeed = 25;
        
        gameOver = false;
        rand = new Random();
        
        this.enemyList = new ArrayList<Entity>(); 
    }
    
    public void addEnemyToList(Entity e){
        this.enemyList.add(e);
    }
    
    public void checkCollision(Entity enemy){
        JLabel enemyBild = enemy.gibBild();
        JLabel dinoBild = this.dino.gibBild();
        int sizePuffer = 30;
        Rectangle enemyRect = new Rectangle(enemyBild.getLocation().x + sizePuffer,enemyBild.getLocation().y - sizePuffer,enemy.size_x - sizePuffer,enemy.size_y - sizePuffer);
        Rectangle dinoRect = new Rectangle(dinoBild.getLocation().x + sizePuffer,dinoBild.getLocation().y - sizePuffer,this.dino.size_x - sizePuffer,this.dino.size_y - sizePuffer);
        
        if(dinoRect.intersects(enemyRect)){
            this.gameOver = true;
        }
    }
    
    /**
       Delete an Enemy and remove it from the list, if it gets of the screen
       @param e = Enemy
       
       */
    public void deleteEnemy(int index,Entity e){
        JLabel enemyBild = e.gibBild();
        if(enemyBild.getLocation().x < -100){
            // Delete object
            this.fenster.EnemyVisibility(e,false);
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
            this.checkCollision(enemy);
            enemy.Update();
        }
    }
    
    public void enemysVisible(boolean sichtbar){
        for(int i = 0; i< this.enemyList.size(); i++){
            Entity enemy = this.enemyList.get(i);
            this.fenster.EnemyVisibility(enemy, sichtbar);
        }
    }
    
    public void run(){
        //dino.Update();
        int loopCount = 0;
        System.out.println("GameLoop.gameOver: "+ this.gameOver);
        while(!gameOver){
            this.dino.Update();
            this.updateEnemys();
            
            // alle 30 Runden, jede Runde 50ms -> alle 1,5s
            // kaktus spawnen
            if(loopCount % 40 == 0){
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
        this.enemysVisible(false);
        this.fenster.GameOver();
    }
    }
