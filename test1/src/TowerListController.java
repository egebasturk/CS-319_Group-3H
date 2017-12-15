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
	private int towerNumber = 3;
	private int boxEdge = 50;
	private int paddingLeft = 20;
	private int paddingTop = 40;
	private int paddingAmongBoxes = 10;
	private int[] towerCosts = {0,10,15, 40};

	private Rectangle[] towers = new Rectangle[towerNumber];
	public static int panelWidth = 20;
	public static int panelHeight = 40;
	//private JPanel listBox;

    public TowerListController()
    {
        towerImages = new BufferedImage[3];
        try {
            towerImages[0] = ImageIO.read(new File(Assets.tower1));
            towerImages[1] = ImageIO.read(new File(Assets.tower2));
            towerImages[2] = ImageIO.read(new File(Assets.hero1));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        for ( int i = 0; i < towers.length; i++)
        {
            towers[i] = new Rectangle( paddingLeft, paddingTop + i * boxEdge + paddingAmongBoxes, boxEdge, boxEdge - paddingAmongBoxes);
        }
    }
    // TODO:Might be unnecessary, remove if not used
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
            towerImages[2] = ImageIO.read(new File(Assets.hero1));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
    public void paintComponent( Graphics g )
    {
        // TODO: Draw Borders. This is not working
        g.drawRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());

        for ( int i = 0; i < towers.length; i++)
        {
            if ( isInRectangle(GameController.mouseX, GameController.mouseY, towers[i]) )
                g.setColor(Color.RED);
            else
                g.setColor(Color.YELLOW);
            g.drawRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
            g.fillRect(towers[i].x, towers[i].y, towers[i].width, towers[i].height);
            g.drawImage(towerImages[i],towers[i].x, towers[i].y, boxEdge, boxEdge,null,null);
        }
    }

    public boolean isInRectangle(int x, int y, Rectangle rectangle)
    {
        /*
        System.out.println("Check bounds");
        System.out.println(rectangle.getX());
        System.out.println(rectangle.getY());*/
        if (x >= rectangle.getX() &&
                x <= rectangle.getX() + rectangle.getWidth() &&
                y >= rectangle.getY() &&
                y <= rectangle.getY() + rectangle.getHeight())
            return true;
        return false;
    }
    public int getElementIndexFromTheList( double xPos, double yPos)
    {
        for ( int i = 0; i < towers.length; i++)
        {
            if ( isInRectangle(GameController.mouseX, GameController.mouseY, towers[i]) )
                return i;
        }
        return -1;
    }
    public int getTowerCost( int index )
    {
        return towerCosts[index];
    }
}