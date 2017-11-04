/**
 * GameObject class
 * It is the parent of all drawable objects, such as attacker, tile etc.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */
import java.awt.*;
import java.awt.image.BufferedImage;
// TODO: Under construction. Will be useful when other classes are implemented.
public class GameObject extends Rectangle{

	private int xPosition;
	private int yPosition;
	private BufferedImage image;
	private int width;
	private int height;
	private int objectID;

	/**
	 * 
	 * @param image
	 * @param posX
	 * @param posY
	 */
	public void draw(int image, int posX, int posY) {
		// TODO - implement GameObject.draw
		throw new UnsupportedOperationException();
	}

	public int[][] getObjectLocation() {
		// TODO - implement GameObject.getObjectLocation
		throw new UnsupportedOperationException();
	}

}