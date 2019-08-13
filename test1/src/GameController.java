
/**
 * Game Controller Class
 * Controls the other classes of the game. Creates other objects and calls their operations while running.
 * Also creates a frame which panels are added.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 *   version(last - 1) 15.12.2017
 *   version(last) 16.12.2017 (frequently updated)
 */


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

public class GameController implements Runnable{

    //enum ThreadFunctionality {ONE, TWO, THREE};
    private Thread thread = new Thread(this);
    private int playerGold;
    /*private ThreadMethod threadMethod1 = new ThreadMethod( this, this, ThreadFunctionality.ONE);
    private ThreadMethod threadMethod2 = new ThreadMethod( this, this, ThreadFunctionality.TWO);
    private ThreadMethod threadMethod3 = new ThreadMethod( this, this, ThreadFunctionality.THREE);*/
    protected PauseMenu pause = new PauseMenu(this);
    // Thread is not used currently. Cannot control concurrent errors.
    /*class ThreadMethod extends Thread{
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
    }*/

	private long elapsedTime = 0; // TODO: Will be used for resource calculations
	public static int level; // TODO: Will be used for the attacker list calculations
    // States
    private boolean isRunning = true;
	private boolean isPaused = false;

    private int score;
    private int star;
	private GamePanel gamePanel;
	private Frame frame;
	private TowerListController towerListController;
	private InputController inputController;
	public GameMap gameMap;
	public enum selectedTowerFromTheList { None, tower1, tower2, hero1, hero2, upgrade, sell,pause}
	private selectedTowerFromTheList currentSelectedTowerFromTheList;
	public Graphics g;

	public static int mouseX = 0, mouseY = 0;

	// TODO: Change magic numbers
    public static int gamePanelWidth = 800, gamePanelHeight = 600;


	public GameController(int selectedLevel) {
        level = selectedLevel; // TODO: Properly implement this
        playerGold = level * 100;
	    currentSelectedTowerFromTheList = selectedTowerFromTheList.None;
        score = 0;
        star = 0;
        gameMap = new GameMap(selectedLevel, this);
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
        towerListController.setPlayerGold(playerGold);


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
		while( isRunning ) // isRunning is redundant
		{
            if(!isPaused) {
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
                //currentGameMap.draw(g);
                gamePanel.repaint();
                towerListController.repaint();
                // TODO: Do save operations to txt
                if (gameMap.getAttackers().isEmpty()) {
                    int choice = JOptionPane.showConfirmDialog(null, "Level Has Finished. You are victorious. Do you want to exit game?", "End of Level", JOptionPane.YES_NO_OPTION);
                    score = ((int)gameMap.base.getHealth() );
                    saveScore();
                    if( choice == 0 )
                        System.exit(0);
                    else {
                        MainFrame main = new MainFrame();
                        visible();
                    }


                    break;
                } else if (gameMap.base.getHealth() <= 0) {
                    int choice = JOptionPane.showConfirmDialog(null, "Level Has Finished. You were defeated. Do you want to exit game?", "End of Level", JOptionPane.YES_NO_OPTION);
                    if( choice == 0 )
                        System.exit(0);
                    else {
                        MainFrame main = new MainFrame();
                        visible();
                    }
                    break;
                }
                //System.out.println(mouseX + " " + mouseY);

                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }
            else
            {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }
            }
		}
	}
	public void setCurrentSelectedTowerFromTheList( selectedTowerFromTheList selectedTower)
    {
        this.currentSelectedTowerFromTheList = selectedTower;
    }

    public selectedTowerFromTheList getCurrentSelectedTowerFromTheList() {
        return currentSelectedTowerFromTheList;
    }

    // This method adds tower or here. Input controller calls this according to the object selected
    // Checks if player has enough gold and tells the map to add it.
    // Map will check if it can add it. If it can be added it adds and returns true
    // Then this method reduces gold from the player
    public void addTowerOrHero(GameObject newTowerOrHero)
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
            if ( gameMap.addTowerOrHero(newTowerOrHero) )
            {
                setPlayerGold(playerGold - towerListController.getTowerCost(i));
            }
        }
    }
    // Upgrades tower. Similar to the method above this gets the click point and if
    // player has enough gold tells map to upgrade. Map decides the rest
    public void upgradeTower( Point clickPoint )
    {
        selectedTowerFromTheList selectionOnTheMap = gameMap.getSelectionFromTheMap( clickPoint );
        int i;
        for ( i = 0; i < selectedTowerFromTheList.values().length; i++)
        {
            if ( selectedTowerFromTheList.values()[i] == selectionOnTheMap )
                break;
        }
        if ( towerListController.getTowerCost(i) <= playerGold )
        {
            gameMap.upgradeTower( clickPoint );
            setPlayerGold(playerGold - towerListController.getTowerCost(i));
        }
    }
    // Works similar to methods above.
    public void sellTower( Point clickPoint )
    {
        selectedTowerFromTheList selectionOnTheMap = gameMap.sellTower(clickPoint);
        int i;
        for ( i = 0; i < selectedTowerFromTheList.values().length; i++)
        {
            if ( selectedTowerFromTheList.values()[i] == selectionOnTheMap )
                break;
        }
        setPlayerGold( getPlayerGold() + towerListController.getTowerCost(i) / 3);
    }
    // Works like a observer pattern. When gold gets updated it notifies towerlist controller.
    // However it does not seem like a observer pattern when drawn on diagram.
    public void setPlayerGold( int playerGold )
    {
        this.playerGold = playerGold;
        // Update the view when this changes
        towerListController.setPlayerGold(playerGold);
    }

    public int getPlayerGold() {
        return playerGold;
    }

	// Not used currently
	private boolean isGameOver() {

		return false;
	}
	// Saves scores to text file
	private void saveScore()
    {
        String textFileContent = "";
        String textFileString = "";
        int levelStar = 0;
        if( score >= 4 )
            star = 3;
        else if( score >= 2)
            star = 2;
        else
            star = 1;
        try {
            URL url = getClass().getResource(Assets.starTxt);
            File file = new File(url.getPath());
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(MainPage.class.getResourceAsStream(Assets.starTxt)));
            if((textFileString = bufferedReader.readLine()) != null) {
                levelStar = Integer.parseInt(textFileString.valueOf(textFileString.charAt(level -1)));
                textFileContent = textFileString;
            }
            bufferedReader.close();
        }
        catch(IOException ex) {
        }
        if( star > levelStar ){
            try {

                URL url = getClass().getResource(Assets.starTxt);
                File file = new File(url.getPath());
                BufferedWriter bufferedWriter =
                        new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                char starChar = (char)star;
                char toBeChanged = textFileContent.charAt(level-1);
                textFileContent = ( textFileContent.substring(0,level-1) + star + textFileContent.substring(level) );
                System.out.println(textFileContent);
                bufferedWriter.write( textFileContent );
                bufferedWriter.close();
            }
            catch( FileNotFoundException e ){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
	}
	// Pauses the game and sets pause menu instead of the game panel
    public void pauseGame() {
        isPaused = true;
        gamePanel.setVisible(false);
        pause.setVisible(true);
        pause.repaint();
        System.out.println("Pause");
        frame.getContentPane().add(pause, BorderLayout.CENTER);
    }
    // Resumes the game and sets game panel instead of the pause menu
    public void resumeGame() {
        isPaused = false;
        pause.setVisible(false);
        gamePanel.setVisible(true);
        gamePanel.repaint();
        System.out.println("resume");
	}
    public void visible()
    {
        frame.setVisible(false);
    }

}