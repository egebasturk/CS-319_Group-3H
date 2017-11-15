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
public class GamePanel extends JPanel
{
    //private int spawnCooldown = 1000;
    //private int spawnTimer = 0;
    public GameMap gameMap;

//    public static Attacker[] attackers = new Attacker[7 ];//TODO: Make according to level.(Also implement a proper formula)

    public GamePanel()
    {
        System.out.print("GamePanel Created");
        gameMap = new GameMap();

    }
    public GamePanel(InputController inputController)
    {
        System.out.print("GamePanel Created");
        gameMap = new GameMap();
        this.addMouseListener(inputController);
        this.addMouseMotionListener(inputController);
    }
    public void paintComponent( Graphics g )
    {
        g.clearRect(0,0,getWidth(),getHeight());
        // Call the draw method of the gameMap
        gameMap.draw(g);
    }

    /**
    * Calls move function of the Attackers. Which makes them update their locations
    * after checking their position according to path.
    * */
    public void motion()
    {
        gameMap.attackerMotionLoop();
    }
    public void spawnAttackers()
    {
        gameMap.attackerSpawnLoop();;
    }
}
