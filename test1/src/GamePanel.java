import javax.swing.*;
import java.awt.*;


// GamePanel class is the panel which game is shown. Tiles, path etc.
public class GamePanel extends JPanel implements Runnable
{
    private Thread thread = new Thread(this);
    public static long elapsedTime = 0;
    private int spawnCooldown = 1000;
    private int spawnTimer = 0;
    public static int frame = 0, fps = 60;
    private boolean firstFlag = true;
    private GameMap gameMap;

    public static Attacker[] attackers = new Attacker[1 ];//TODO: 1 should be the level.(Also implement a proper formula)


    public GamePanel()
    {
        System.out.print("GamePanel Created");
        gameMap = new GameMap();
        for ( int i = 0; i < attackers.length; i++)
        {
            // TODO: Get rid of magic numbers
            attackers[i] = new Attacker(9);
        }

        thread.start();
    }
    public void paintComponent( Graphics g )
    {
        /*
        if ( firstFlag)
        {
            //
            gameMap = new GameMap();
            firstFlag = false;
        }*/

        g.clearRect(0,0,getWidth(),getHeight());
        gameMap.draw(g);
        for (int i = 0; i < attackers.length; i++)
        {
            if (attackers[i].isAlive())
                attackers[i].draw(g);
        }
    }
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
    @Override
    public void run()
    {
        elapsedTime++;
        while( true )
        {

            if (firstFlag)
            {
                attackerSpawnLoop();
                motion();
            }
            repaint();

            try {
                Thread.sleep(1);
            } catch (Exception e){}
        }
    }
}
