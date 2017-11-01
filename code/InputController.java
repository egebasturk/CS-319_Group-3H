import java.awt.*;
import java.awt.event.MouseEvent;

public class InputController {

	private boolean mouseClicked;
	private int[] mousePos;

	public InputController() {
		mouseClicked = false;
		mousePos =  new int[2];
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posX
	 * @param posY
	 */
	public void getMousePos(int posX, int posY) {
		if(mouseClicked) {
			PointerInfo info = MouseInfo.getPointerInfo();
			Point location = info.getLocation();
			mousePos[0] = (int) location.getX();
			mousePos[1] = (int) location.getY();
		}
		throw new UnsupportedOperationException();

	}

	public void mouseClicked(MouseEvent e) {
		mouseClicked = true;
		throw new UnsupportedOperationException();
	}

	public void mouseReleased(MouseEvent e) {
		mouseClicked = false;
		// TODO - implement InputController.mouseReleased
		throw new UnsupportedOperationException();
	}

}