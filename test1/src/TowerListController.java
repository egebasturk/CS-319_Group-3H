/**
 * TowerList Controller Class
 * This is also the panel which it controls. It shows the list of towers,
 * near the game map, which player can click and deploy towers.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */
// TODO: Current implementation is primitive
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TowerListController extends JPanel{

    // TODO deal with the magic numbers
	private BufferedImage[] towerImages;
	private int towerNumber = 2;
	private int boxEdge = 50;
	private int paddingLeft = 40;
	private int paddingTop = 40;
	private int paddingAmongBoxes = 10;
	private int[] towerCosts = {10,15};

	private Rectangle[] towers = new Rectangle[towerNumber];
	public static int panelWidth = 20;
	public static int panelHeight = 40;
	//private JPanel listBox;

    public TowerListController()
    {
        // TODO: Implement default constructor
    }
	public TowerListController(int gamePanelWidth, int gamePanelHeight)
    {
        towerImages = new BufferedImage[2];
		for ( int i = 0; i < towers.length; i++)
        {
            towers[i] = new Rectangle( paddingLeft, paddingTop + i * boxEdge + paddingAmongBoxes, boxEdge, boxEdge - paddingAmongBoxes);
        }
        try {
            towerImages[0] = ImageIO.read(new File(Assets.tower1));
            towerImages[1] = ImageIO.read(new File(Assets.tower2));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}

    /**
     * paints rectangles(later they will be tower images) list.
     */
    public void paintComponent( Graphics g )
    {
        for ( int i = 0; i < towers.length; i++)
        {
            g.drawImage(towerImages[i],towers[i].x, towers[i].y, boxEdge, boxEdge,null,null);
            //g.drawRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
            //g.setColor(Color.BLUE);
            //g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
        }
    }

}