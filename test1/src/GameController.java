/**
 * Game Controller Class
 * Controls the other classes of the game. Creates other objects and calls their operations while running.
 * Also creates a frame which panels are added.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameController implements Runnable{

    private Thread thread = new Thread(this);
	public long elapsedTime = 0; // TODO: Will be used for resource calculations
	public static int level; // TODO: Will be used for the attacker list calculations
    // States
	private boolean isRunning = true;
	private boolean isPaused;

	private GamePanel gamePanel;
	private Frame frame;
	private TowerListController towerListController;

	// TODO: Change magic numbers
    public static int gamePanelWidth = 800, gamePanelHeight = 700;


	public GameController() {
	    level = 1; // TODO: Properly implement this
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
        thread.start();
	}
	/**
     *  Run method. Calls paint method of gamePanel which calls the draw method of all objects.
	*/
	@Override
	public void run()
	{
		elapsedTime++;
		while( isRunning )
		{
			gamePanel.attackerSpawnLoop();
			gamePanel.motion();
			gamePanel.repaint();

			try {
				Thread.sleep(1);
			} catch (Exception e){}
		}
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

	// Currently this is implemented by checking the ArrayIndexOutOfBounds Exception, which is thrown when an attacker finishes the path.
	private boolean isGameOver() {
		// TODO - implement GameController.isGameOver
		throw new UnsupportedOperationException();
	}

	private void saveScore() {
		// TODO - implement GameController.saveScore
		throw new UnsupportedOperationException();
	}

}