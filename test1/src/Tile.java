/**
 * Model.Tile Class
 * Model.Tile will be used to fill the map. Also they will be used to store information
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
;

public class Tile extends GameObject// extends Model.GameObject { TODO: commented out for debugging
{
    public int id; // TODO gamebojects will have such id. Try to use it instead
	private int type;
	protected BufferedImage closedGateImage;
	protected BufferedImage openGateImage;
	//protected BufferedImage grassImage;
	//protected BufferedImage tileImage;
	private int xPos = 0;
    private int yPos = 0;
    private int width = 10;
    private int height = 10;
    private int gateCounter = 0;
	private boolean blocking = false; // For collision detection
	private boolean heroCantPass = false;
	//private BufferedImage[] image; // TODO: Load image of tile

    // Not used currently
	public Tile() {
		// TODO - implement Model.Tile.Model.Tile
		//throw new UnsupportedOperationException();
	}

	public Tile(int xPos, int yPos, int width, int height, int id, int type) {
	    setBounds(xPos, yPos, width, height);
	    this.xPos = xPos;
	    this.yPos = yPos;
	    this.width = width;
	    this.height = height;
	    this.type = type;
	    this.id = id;
	    if (type == 1)
	    	blocking = true;
	    else if (type == 2){
	    	blocking = false;
	    	heroCantPass = true;
		}
		else if(type==3){
			blocking = true;
		}
	    else
	        blocking = false;
		try
		{
			closedGateImage = ImageIO.read(new File(Assets.closed));
			openGateImage = ImageIO.read(new File(Assets.open));
			//grassImage = ImageIO.read(new File(Assets.grass));
			//tileImage = ImageIO.read(new File(Assets.rocktile));
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param type
	 */
	public Tile(int type) {
		// TODO - implement Model.Tile.Model.Tile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 * @param xPos
	 * @param yPos
	 */
	 // This call may be missing. Using the one above
	public Tile(int type, int xPos, int yPos) {
		// TODO - implement Model.Tile.Model.Tile
		throw new UnsupportedOperationException();
	}
	/**
     * Draws a rectangle for tiles
     * */
    public void draw( Graphics g )
    {
        //System.out.println("Model.Tile draw called");
        g.drawRect( xPos, yPos, width, height );
        if (type == 0 || type == 2) {
			//g.drawImage(tileImage,x, y, 50, 50,null,null);
            g.setColor(Color.GRAY);
            g.fillRect(xPos, yPos, width, height);
        }
        else if ( type == 1) {
			//g.drawImage(grassImage,x, y, 50, 50,null,null);
            g.setColor(Color.GREEN);
            g.fillRect(xPos, yPos, width, height);
        }

        else if (type==3) {
        	if(heroPass()){
				g.drawImage(closedGateImage,x, y, 50, 50,null,null);
			//	System.out.println("closeddddddddddddddddddddddddd");
			}

        	else {
				g.drawImage(openGateImage, x, y, 50, 50, null, null);
			//	System.out.println("opennnnnnnnnnnnnnnnnnn");
			//System.out.println(heroPass());
				//g.drawImage(openGateImage,x, y, 50, 50,null,null);
				//for(int i = 0; i < 500000; i++ ){}
				//g.drawImage(closedGateImage,x, y, 50, 50,null,null);
			}
			gateCounter++;
        	if( gateCounter >= 500 )
				heroCantPass = true;
		}
    }
    public boolean isBlocking()
	{
		return blocking;
	}
	public boolean heroPass()
	{
		return heroCantPass;
	}

    @Override
    public double getX() {
        return xPos;
    }

    @Override
    public double getY() {
        return yPos;
    }
}
