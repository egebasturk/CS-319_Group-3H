import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameController extends JPanel implements Runnable {

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

    private Thread thread = new Thread(this);
    public static long elapsedTime = 0;
    private int spawnCooldown = 1000;
    private int spawnTimer = 0;
    private boolean firstFlag = true;
    private GameMap gameMap;
    public static int gamePanelWidth = 800, gamePanelHeight = 700;

    public static Attacker[] attackers = new Attacker[1 ];//TODO: 1 should be the level.(Also implement a proper formula)

	public GameController() {

        gameMap = new GameMap();
        for ( int i = 0; i < attackers.length; i++)
        {
            // TODO: Get rid of magic numbers
            attackers[i] = new Attacker(9);
        }

        thread.start();

	    level = 1; // TODO: Properly implement this

        System.out.println("GameController created");
	}
	public void addToFrame()
    {
        Frame frame = (Frame) SwingUtilities.getWindowAncestor(this);

        this.setPreferredSize(new Dimension(gamePanelWidth, gamePanelHeight));
        towerListController = new TowerListController(gamePanelWidth, gamePanelHeight);
        towerListController.setPreferredSize( new Dimension(80,80));

        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.getContentPane().add(towerListController, BorderLayout.EAST);
        frame.pack();
    }
    public void paintComponent( Graphics g )
    {

        g.clearRect(0,0,getWidth(),getHeight());
        // Tells gameMap to draw its objects
        gameMap.draw(g);
        // Tells attackers to draw themselves
        for (int i = 0; i < attackers.length; i++)
        {
            if (attackers[i].isAlive())
                attackers[i].draw(g);
        }
    }
    // Spawns attackers
    public void attackerSpawnLoop()
    {
        //System.out.println(spawnTimer);
        if ( spawnTimer >= spawnCooldown){
            spawnTimer = 0;
            for ( int i = 0; i < attackers.length; i++)
            {
                // Debug prints
                System.out.println(i + " " + attackers[i].isAlive() + " " + attackers[i].isKilled());
                if (!attackers[i].isAlive() && !attackers[i].killed) {
                    attackers[i].spawn();
                    System.out.println("Attacker" + i + "Spawned");
                    break;
                }
            }
        }
        else
            spawnTimer++;
    }
    // Tells attackers to move
    public void motion()
    {
        for ( int i = 0; i < attackers.length; i++)
        {
            if (attackers[i].alive && !attackers[i].isKilled())
            {
                attackers[i].move();
            }
        }
    }

    @Override
    public void run()
    {
        elapsedTime++;
        while( true )
        {
            attackerSpawnLoop();
            motion();
            repaint();

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

	private boolean isGameOver() {
		// TODO - implement GameController.isGameOver
		throw new UnsupportedOperationException();
	}

	private void saveScore() {
		// TODO - implement GameController.saveScore
		throw new UnsupportedOperationException();
	}

}