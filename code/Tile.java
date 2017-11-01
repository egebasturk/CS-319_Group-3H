public class Tile// extends GameObject { TODO: commented out for debugging
{
	private int type;
	private boolean blocking; // For collision detection
	private BufferedImage[] image; // TODO: Load image of tile

	public Tile() {
		// TODO - implement Tile.Tile
		throw new UnsupportedOperationException();
	}
	public Tile(int xPos, int yPos, int height, int width) {
	    
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
	
    public void paintComponent( Graphics g )
    {
        g.drawRect( xPos, yPos, width, height );
    }

}
