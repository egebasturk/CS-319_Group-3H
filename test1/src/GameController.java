import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameController {

	public long elapsedTime = 0;
	public static int level;
	private boolean isRunning;
	private boolean isPaused;
	private GamePanel gamePanel;
	private Frame frame;
	private TowerListController towerListController;
    /*
	private InputController inputController;
	private WındowController windowController;
	private ResourceController resourceController;
	private TowerListController towerListController;
	private FileController fileController;
	*/
    public static int gamePanelWidth = 800, gamePanelHeight = 700;

	public GameController() {
	    level = 1; // TODO: Properly implement this
		// TODO - implement GameController.GameController
        frame = new Frame();
        frame.setLayout(new BorderLayout());
        gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(gamePanelWidth, gamePanelHeight));
        towerListController = new TowerListController(gamePanelWidth, gamePanelHeight);
        towerListController.setPreferredSize( new Dimension(80,80));

		frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
		frame.getContentPane().add(towerListController, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);

        System.out.println("GameController created");
	}

	public void updateTime() {
		// TODO - implement GameController.updateTime
		throw new UnsupportedOperationException();
	}

	public void notifyDeath() {
		// TODO - implement GameController.notifyDeath
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param strategy
	 */
	public GameController(BufferStrategy strategy) {
		// TODO - implement GameController.GameController
		throw new UnsupportedOperationException();
	}

	private void updateBaseHealth() {
		// TODO - implement GameController.updateBaseHealth
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param level
	 */
	public void startGame(int level) {
		// TODO - implement GameController.startGame
		throw new UnsupportedOperationException();
	}

	private void decreaseBaseHealth() {
		// TODO - implement GameController.decreaseBaseHealth
		throw new UnsupportedOperationException();
	}

	private boolean isGameOver() {
		// TODO - implement GameController.isGameOver
		throw new UnsupportedOperationException();
	}

	private void saveScore() {
		// TODO - implement GameController.saveScore
		throw new UnsupportedOperationException();
	}

}