import javax.swing.*;
import java.awt.*;


// GamePanel class is the panel which game is shown. Tiles, path etc.
public class GamePanel extends JPanel implements Runnable
{
    private Thread thread = new Thread(this);
    public static int frame = 0, fps = 60;
    private boolean firstFlag = true;
    private GameMap gameMap;

    public GamePanel()
    {
        System.out.print("GamePanel Created");
        gameMap = new GameMap();

        //setBackground(Color.BLACK);
        //this.setVisible(true);

        thread.start();
    }
    public void paintComponent( Graphics g )
    {
        if ( firstFlag)
        {
            gameMap = new GameMap();

            firstFlag = false;
        }

        g.clearRect(0,0,getWidth(),getHeight());
        gameMap.draw(g);
    }


    @Override
    public void run()
    {
        while( true )
        {
            if (!firstFlag)
            {

            }
            repaint();

            try {
                Thread.sleep(1);
            } catch (Exception e){}
        }
    }
}
