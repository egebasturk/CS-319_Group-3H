import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputController implements MouseMotionListener, MouseListener {

	private boolean mouseClicked;
	private int xPos, yPos;

	public InputController() {
		// TODO - implement InputController.InputController
		//throw new UnsupportedOperationException();
        xPos = 0;
        yPos = 0;
	}

	public int getxPos()
    {
        return xPos;
    }
    public int getyPos()
    {
	    return yPos;
    }

	public void mouseClicked() {
		// TODO - implement InputController.mouseClicked
		throw new UnsupportedOperationException();
	}

	public void mouseReleased() {
		// TODO - implement InputController.mouseReleased
		throw new UnsupportedOperationException();
	}

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}