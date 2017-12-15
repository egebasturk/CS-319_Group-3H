import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * InputController Class
 * Takes inputs from user.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */


public class InputController implements MouseMotionListener, MouseListener {
    // TODO: Will be implemented
	private boolean mouseClicked;
	private int xPos, yPos;
	GamePanel currentGamePanel;
	TowerListController currentTowerListPanel;
	GameController currentGameController;

	public InputController( GamePanel currentGamePanel, TowerListController currentTowerListPanel, GameController currentGameController) {
	    this.currentGamePanel = currentGamePanel;
	    this.currentTowerListPanel = currentTowerListPanel;
	    this.currentGameController = currentGameController;
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
        GameController.mouseX = mouseEvent.getX();
        GameController.mouseY = mouseEvent.getY();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
	    // First is: When clicked on the TowerList
	    if ( mouseEvent.getComponent() == currentTowerListPanel)
        {
            int index = currentTowerListPanel.getElementIndexFromTheList(mouseEvent.getX(), mouseEvent.getY());
            if ( index != -1)
            {
                // +1 because element zero is none
                currentGameController.setCurrentSelectedTowerFromTheList( GameController.selectedTowerFromTheList.values()[index + 1]);
                System.out.println("Selected tower: " + index);
            }
        }
        // Second is: if clicked on the main game panel
	    else if ( mouseEvent.getComponent() == currentGamePanel )
        {
            System.out.println("Clicked on: " + mouseEvent.getX() + " " + mouseEvent.getY());
            // If there is a previous selection, continue else if none, don't do anything
            if ( currentGameController.getCurrentSelectedTowerFromTheList() != GameController.selectedTowerFromTheList.None)
            {
                Point clickPoint = getTileLocationOfClick( mouseEvent );
                if ( currentGameController.getCurrentSelectedTowerFromTheList() != GameController.selectedTowerFromTheList.tower1 )
                {
                    currentGameController.addTower(new SingleAttackTower(currentGameController.gameMap,
                            (int) clickPoint.getX(), (int) clickPoint.getY()));
                }
                else if (currentGameController.getCurrentSelectedTowerFromTheList() != GameController.selectedTowerFromTheList.tower2 )
                {
                    currentGameController.addTower(new AreaAttackTower(currentGameController.gameMap,
                            (int) clickPoint.getX(), (int) clickPoint.getY()));
                }
                currentGameController.setCurrentSelectedTowerFromTheList(GameController.selectedTowerFromTheList.None);
            }

        }
	    else
	        System.out.println("Failed to detect main panel");
    }
    private Point getTileLocationOfClick( MouseEvent mouseEvent)
    {
        Point point = new Point();
        // This calculation may be bad
        point.setLocation( mouseEvent.getX() / GameMap.tileEdge * GameMap.tileEdge, mouseEvent.getY() / GameMap.tileEdge * GameMap.tileEdge);

        return point;
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