/**
 * GameObject class
 * It is the parent of all drawable objects, such as attacker, tile etc.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 *   version2 14.12.2017
 *   version3 15.12.2017
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

	/**
	 * 
	 * @param image
	 * @param posX
	 * @param posY
	 */
	// Not used directly.
	public void draw(int image, int posX, int posY) {
		// TODO - implement Model.GameObject.draw
		throw new UnsupportedOperationException();
	}

	@Override
	public double getX() {
		return this.xPos;
	}
	@Override
	public double getY() {
		return this.yPos;
	}
}