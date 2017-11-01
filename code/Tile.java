import java.awt.image.BufferedImage;

public class Tile extends GameObject {

	private int type;
	private boolean blocking;
	private BufferedImage[] image;

	public Tile() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 */
	public Tile(int type) {
		this.type = type;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param type
	 * @param xPos
	 * @param yPos
	 */
	public Tile(int type, int xPos, int yPos) {
		this.type = type;
		super.xPosition = xPos;
		super.YPosition = yPos;
		throw new UnsupportedOperationException();
	}

}