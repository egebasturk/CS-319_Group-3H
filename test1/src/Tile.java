import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile extends Rectangle// extends GameObject { TODO: commented out for debugging
{
    public int id; // TODO gamebojects will have such id. Try to use it instead
	private int type;
	private int xPos = 0;
    private int yPos = 0;
    private int width = 10;
    private int height = 10;
	private boolean blocking = false; // For collision detection
	//private BufferedImage[] image; // TODO: Load image of tile

	public Tile() {
		// TODO - implement Tile.Tile
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
	    else
	        blocking = false;
	}

	/**
	 * 
	 * @param type
	 */
	public Tile(int type) {
		// TODO - implement Tile.Tile
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
		// TODO - implement Tile.Tile
		throw new UnsupportedOperationException();
	}
	
    public void draw( Graphics g )
    {
        //System.out.println("Tile draw called");
        g.drawRect( xPos, yPos, width, height );
        if (type == 0) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(xPos, yPos, width, height);
        }
        else if ( type == 1) {
            g.setColor(Color.GREEN);
            g.fillRect(xPos, yPos, width, height);
        }
    }

}
