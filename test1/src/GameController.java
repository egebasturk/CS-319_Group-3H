
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

    enum ThreadFunctionality {ONE, TWO, THREE};
    private Thread thread = new Thread(this);
    private int playerGold;
    /*private ThreadMethod threadMethod1 = new ThreadMethod( this, this, ThreadFunctionality.ONE);
    private ThreadMethod threadMethod2 = new ThreadMethod( this, this, ThreadFunctionality.TWO);
    private ThreadMethod threadMethod3 = new ThreadMethod( this, this, ThreadFunctionality.THREE);*/

    class ThreadMethod extends Thread{
        GameController gameController;
        GameController.ThreadFunctionality threadFunctionality;
        public ThreadMethod(Runnable runnable, GameController gameController, GameController.ThreadFunctionality threadFunctionality)
        {
            this.threadFunctionality = threadFunctionality;
            this.gameController = gameController;
        }
        @Override
        public void run()
        {
            while ( isRunning) {
                if (threadFunctionality == ThreadFunctionality.ONE)
                    gameController.gameMap.towerAttackLoop();
                else if (threadFunctionality == ThreadFunctionality.TWO)
                    gameController.gameMap.attackerMotionLoop();
                else if (threadFunctionality == ThreadFunctionality.THREE)
                    gameController.gameMap.attackerSpawnLoop();
            }
            try {
                ThreadMethod.sleep(1);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

	public long elapsedTime = 0; // TODO: Will be used for resource calculations
	public static int level; // TODO: Will be used for the attacker list calculations
    // States
	private boolean isRunning = true;
	private boolean isPaused;

	private GamePanel gamePanel;
	private Frame frame;
	private TowerListController towerListController;
	private InputController inputController;
	public GameMap gameMap;
	public enum selectedTowerFromTheList { None, tower1, tower2};
	public selectedTowerFromTheList currentSelectedTowerFromTheList;
	public Graphics g;

	public static int mouseX = 0, mouseY = 0;

	// TODO: Change magic numbers
    public static int gamePanelWidth = 800, gamePanelHeight = 600;


	public GameController() {
        level = 1; // TODO: Properly implement this
        playerGold = level * 100;
	    currentSelectedTowerFromTheList = selectedTowerFromTheList.None;
        gameMap = new GameMap();
        setGameMaps();
        frame = new Frame();
        frame.setLayout(new BorderLayout());
        gamePanel = new GamePanel(gameMap);
        gamePanel.setPreferredSize(new Dimension(gamePanelWidth, gamePanelHeight));
        towerListController = new TowerListController();
        inputController = new InputController( gamePanel, towerListController, this);
        gamePanel.addMouseMotionListener(inputController);
        gamePanel.addMouseListener(inputController);

        towerListController.setPreferredSize( new Dimension(80,80));
        towerListController.addMouseMotionListener(inputController);
        towerListController.addMouseListener(inputController);

		frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
		frame.getContentPane().add(towerListController, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);

        System.out.println("GameController created");
        thread.start();/*
        threadMethod1.start();
        threadMethod2.start();
        threadMethod3.start();*/
	}
	// Sets game map references of the attackers. They need it to notify the controller when they die.
	private void setGameMaps()
    {
        for (Attacker i: gameMap.getAttackers())
        {
            i.setCurrentGameMap(gameMap);
        }
    }

	/**
     *  Run method. Calls paint method of gamePanel which calls the draw method of all objects.
	*/
	@Override
	public void run()
	{
		while( isRunning )
		{
            elapsedTime++;
            /*
			gamePanel.spawnAttackers();
			gamePanel.motion();
			*/

            gameMap.attackerMotionLoop();
            gameMap.attackerSpawnLoop();
            gameMap.towerAttackLoop();
            gameMap.heroAttackLoop();
			//gamePanel.repaint();
			//g = gamePanel.getGraphics();
			//gameMap.draw(g);
            gamePanel.repaint();
			towerListController.repaint();
            //System.out.println(mouseX + " " + mouseY);

			try {
				Thread.sleep(1);
			} catch (Exception e){}
		}
	}
	public void setCurrentSelectedTowerFromTheList( selectedTowerFromTheList selectedTower)
    {
        this.currentSelectedTowerFromTheList = selectedTower;
    }

    public selectedTowerFromTheList getCurrentSelectedTowerFromTheList() {
        return currentSelectedTowerFromTheList;
    }

    public void addTower(Tower newTower)
    {
        // The loop finds the selected tower
        int i;
        for (i = 0; i < selectedTowerFromTheList.values().length; i++)
        {
            if ( selectedTowerFromTheList.values()[i] == currentSelectedTowerFromTheList )
                break;
        }
        System.out.println("Player gold is: " + playerGold);
        // Add only if the player has enough gold
        if ( towerListController.getTowerCost(i) <= playerGold)
        {
            if ( gameMap.addTower(newTower) )
                playerGold = playerGold - towerListController.getTowerCost(i);
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