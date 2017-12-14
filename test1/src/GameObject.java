/**
 * Model.GameObject class
 * It is the parent of all drawable objects, such as attacker, tile etc.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */
import java.awt.*;
import java.awt.image.BufferedImage;
// TODO: Under construction. Will be useful when other classes are implemented.
public class GameObject extends Rectangle{

	protected int xPos;
	protected int yPos;
	protected BufferedImage image;
	protected int width;
	protected int height;
	private int objectID;

	/**
	 * 
	 * @param image
	 * @param posX
	 * @param posY
	 */
	public void draw(int image, int posX, int posY) {
		// TODO - implement Model.GameObject.draw
		throw new UnsupportedOperationException();
	}

	public int[][] getObjectLocation() {
		// TODO - implement Model.GameObject.getObjectLocation
		throw new UnsupportedOperationException();
	}

}