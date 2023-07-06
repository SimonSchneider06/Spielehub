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
    
    AudioPlayer audioPlayer;
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
        
        audioPlayer = new AudioPlayer();
    }
    
    /**
     * Add an Enemy to the EnemyList
     * @param e = Entity, the enemy to add
       */
    public void addEnemyToList(Entity e){
        this.enemyList.add(e);
    }
    
    /**
       Check the collision between an enemy and the dino
       @param enemy: the enemy to check the collisions
       @param index: the index of the enemy in the enemyList
       */
    public void checkCollision(Entity enemy,int index){
        JLabel enemyBild = enemy.gibBild();
        JLabel dinoBild = this.dino.gibBild();
        int sizePuffer = 30;
        Rectangle enemyRect = new Rectangle(enemyBild.getLocation().x + sizePuffer,enemyBild.getLocation().y - sizePuffer,enemy.size_x - sizePuffer,enemy.size_y - sizePuffer);
        Rectangle dinoRect = new Rectangle(dinoBild.getLocation().x + sizePuffer,dinoBild.getLocation().y - sizePuffer,this.dino.size_x - sizePuffer,this.dino.size_y - sizePuffer);
        
        if(dinoRect.intersects(enemyRect)){
            this.gameOver = true;
            this.deleteEnemy(index,enemy);
        }
    }
    
    /**
       Delete an Enemy and remove it from the list, if it gets of the screen
       @param e = Enemy
       
       */
    public void deleteEnemy(int index,Entity e){
        JLabel enemyBild = e.gibBild();
        
            // Delete object
            this.fenster.EnemyVisibility(e,false);
            this.enemyList.remove(index);
            e = null;
        
    }
    
    /**
       Delete All Enemys
       */
    public void deleteAllEnemys(){
        // loop von hinten durch die Liste
        for(int i = this.enemyList.size() - 1; i>=0; i--){
            Entity enemy = this.enemyList.get(i);
            this.deleteEnemy(i,enemy);
        }
    }
    
    /**
       * Update all Enemys in the ArrayList enemyList
       */
    public void updateEnemys(){
        for(int i = 0; i < this.enemyList.size(); i ++){
            Entity enemy = this.enemyList.get(i);
            if(enemy.gibBild().getLocation().x <= -100){
                this.deleteEnemy(i,enemy);
            }
            this.checkCollision(enemy,i);
            enemy.Update();
        }
    }

    /**
       Die GameLoop
       Updated Dino und Enemys, spawnt neue Enemys
       Erhöht die Spielschwierigkeit
       */
    public void run(){
        //dino.Update();
        int spawnChance = 20;
        int loopCount = 0;
        this.fenster.Punkte = 0;
        this.audioPlayer.playMusic("Musik/music.wav");
        this.kaktusSpeed = 25;
        //System.out.println("GameLoop.gameOver: "+ this.gameOver);
        while(!gameOver){
            this.dino.Update();
            this.updateEnemys();
            
            // kaktus spawnen mit wahrscheinlichkeit
            if(rand.nextInt(spawnChance) == 0){
                // to avoid having to many enemys
                if(this.enemyList.size() <= 2){
                    this.fenster.spawnEnemy();
                }
            }
            // nach 100 loops Speed und Punkte erhöhen
            // 1 loop dauert 50ms
            //  -> alle 5s
            if(loopCount % 100 == 0){
                this.fenster.erhöhePunkte(1);
                this.kaktusSpeed += 3;
            }
            if(loopCount % 1000 == 0){
                spawnChance -= 1;
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
        //this.allEnemysVisible(false);
        this.audioPlayer.clip.stop();
        this.deleteAllEnemys();
        this.fenster.GameOver();
    }
    }
