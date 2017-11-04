/**
 * Game Panel Class
 * GamePanel class is the panel which game is shown. Tiles, path etc.
 * Draw methods of this class is called to draw the map.
 * Also it stores game objects like attackers, map which will be drawn.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */
import javax.swing.*;
import java.awt.*;

/*
 */
public class GamePanel extends JPanel// implements Runnable
{
    private int spawnCooldown = 1000;
    private int spawnTimer = 0;
    private GameMap gameMap;

    public static Attacker[] attackers = new Attacker[7 ];//TODO: Make according to level.(Also implement a proper formula)

    public GamePanel()
    {
        System.out.print("GamePanel Created");
        gameMap = new GameMap();
        /*
         * Creates attackers according to level.
         * TODO: This initializes only the parent Attacker class.
        * */
        for ( int i = 0; i < attackers.length; i++)
        {
            // TODO: Get rid of magic numbers
            attackers[i] = new Attacker(9);
        }
    }
    public void paintComponent( Graphics g )
    {
        g.clearRect(0,0,getWidth(),getHeight());
        // Call the draw method of the gameMap
        gameMap.draw(g);
        for (int i = 0; i < attackers.length; i++)
        {
            if (attackers[i].isAlive())
                attackers[i].draw(g);
        }
    }
    /**
    * Iterates over the list of attackers and checks if they entered or killed.
    * Spawns if they have not entered the game so far.
    * */
    // TODO: isGameOver check may be added here
    public void attackerSpawnLoop()
    {
        //System.out.println(spawnTimer);
        if ( spawnTimer >= spawnCooldown){
            spawnTimer = 0;
            for ( int i = 0; i < attackers.length; i++)
            {
                // Debug prints
                System.out.println(i + " " + attackers[i].isAlive() + " " + attackers[i].isKilled());
                if (!attackers[i].isAlive() && !attackers[i].killed) {
                    attackers[i].spawn();
                    System.out.println("Attacker" + i + "Spawned");
                    break;
                }
            }
        }
        else
            spawnTimer++;
    }
    /**
    * Calls move function of the Attackers. Which makes them update their locations
    * after checking their position according to path.
    * */
    public void motion()
    {
        for ( int i = 0; i < attackers.length; i++)
        {
            if (attackers[i].alive && !attackers[i].isKilled())
            {
                attackers[i].move();
            }
        }
    }
}
