import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TowerListController extends JPanel{

    // TODO deal with the magic numbers
	private BufferedImage[] towerImages;
	private int towerNumber = 2;
	private int boxEdge = 40;
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
		for ( int i = 0; i < towers.length; i++)
        {
            towers[i] = new Rectangle( paddingLeft, paddingTop + i * boxEdge + paddingAmongBoxes, boxEdge, boxEdge - paddingAmongBoxes);
        }
	}

    public void paintComponent( Graphics g )
    {
        for ( int i = 0; i < towers.length; i++)
        {
            g.drawRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
            g.setColor(Color.BLUE);
            g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
        }
    }

}