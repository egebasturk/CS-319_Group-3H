import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * InputController Class
 * Takes inputs from user.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 *   version(last - 1) 15.12.2017
 *   version(last)     16.12.2017 (frequently updated)
 */


public class InputController implements MouseMotionListener, MouseListener {
    // TODO: Will be implemented
	private boolean mouseClicked;
	private int xPos, yPos;
	private GamePanel currentGamePanel;
	private TowerListController currentTowerListPanel;
	private GameController currentGameController;

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
            // Returns -1 when it is not in  the list
            int index = currentTowerListPanel.getElementIndexFromTheList(mouseEvent.getX(), mouseEvent.getY());
            if ( index != -1)
            {
                // +1 because element zero is none
                // Sets selection in the GameController to use in later operations
                currentGameController.setCurrentSelectedTowerFromTheList( GameController.selectedTowerFromTheList.values()[index + 1]);
                System.out.println("Selected tower: " + index);
                // Hero 1
                if ( currentGameController.getCurrentSelectedTowerFromTheList() == GameController.selectedTowerFromTheList.hero1)
                {
                    currentGameController.addTowerOrHero(new HeroType1(currentGameController.gameMap
                            , currentGameController.gameMap.endRow, currentGameController.gameMap.endColumn));
                }
                // Hero2
                else if ( currentGameController.getCurrentSelectedTowerFromTheList() == GameController.selectedTowerFromTheList.hero2)
                {
                    currentGameController.addTowerOrHero(new HeroType2(currentGameController.gameMap
                            , currentGameController.gameMap.endRow, currentGameController.gameMap.endColumn));
                }
                // Pause
                else if(currentGameController.getCurrentSelectedTowerFromTheList() == GameController.selectedTowerFromTheList.pause)
                {
                    System.out.println("Pause game method called");
                    currentGameController.pauseGame();
                }
            }
        }
        // Second is: if clicked on the main game panel
        // Operations below require position selection on the map. Thus they are a separate group
	    else if ( mouseEvent.getComponent() == currentGamePanel )
        {
            System.out.println("Clicked on: " + mouseEvent.getX() + " " + mouseEvent.getY());
            // If there is a previous selection, continue else if none, don't do anything
            if ( currentGameController.getCurrentSelectedTowerFromTheList() != GameController.selectedTowerFromTheList.None)
            {
                // Get the location on the map
                Point clickPoint = getTileLocationOfClick( mouseEvent );
                // Tower1
                if ( currentGameController.getCurrentSelectedTowerFromTheList() == GameController.selectedTowerFromTheList.tower1 )
                {
                    currentGameController.addTowerOrHero(new AreaAttackTower(currentGameController.gameMap,
                            (int) clickPoint.getX(), (int) clickPoint.getY()));
                }
                // Tower2
                else if (currentGameController.getCurrentSelectedTowerFromTheList() == GameController.selectedTowerFromTheList.tower2 )
                {
                    currentGameController.addTowerOrHero(new SingleAttackTower(currentGameController.gameMap,
                            (int) clickPoint.getX(), (int) clickPoint.getY()));
                }
                // Tower upgrade
                else if ( currentGameController.getCurrentSelectedTowerFromTheList() == GameController.selectedTowerFromTheList.upgrade)
                {
                    currentGameController.upgradeTower( clickPoint );
                }
                // Tower sell
                else if ( currentGameController.getCurrentSelectedTowerFromTheList() == GameController.selectedTowerFromTheList.sell)
                {
                    currentGameController.sellTower( clickPoint );
                }
                // Reset back to none
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