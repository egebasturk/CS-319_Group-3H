
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

public class GamePanel extends JPanel
{
    public GameMap gameMap;

    public GamePanel(GameMap gameMap)
    {
        System.out.print("GamePanel Created");
        //currentGameMap = new GameMap();
        this.gameMap = gameMap;
    }
    public GamePanel(InputController inputController)
    {
        System.out.print("GamePanel Created");
        //currentGameMap = new GameMap();
        this.addMouseListener(inputController);
        this.addMouseMotionListener(inputController);
    }
    public void paintComponent( Graphics g )
    {
        g.clearRect(0,0,getWidth(),getHeight());
        // Call the draw method of the currentGameMap
        gameMap.draw(g);
    }

    @Override
    public Graphics getGraphics() {
        return super.getGraphics();
    }
}
