/**
 * Game Map Class
 * Model.GameMap stores the objects that will be drawn on the map such as tiles, attackers etc.
 * Calls their draw methods.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */

import java.awt.*;
import java.util.LinkedList;

public class GameMap {

    // Static Because there are other classes which should know these values
    public static int mapWidth = 20;
    public static int mapHeight =15;
    public static int tileEdge = 40;
    private int spawnCooldown = 1000;
    private int spawnTimer = 0;
    public static Tile[][] tiles;
    public static Attacker[] attackers;
    public static LinkedList<Tower> towers;
    // TODO This will be passed from the InputController
    private int[][] typeMatrix;

	public GameMap() {
	    AbstractFactory factory = new FactoryLevel1();
	    // TODO Input controller will read when it is implemented
        tiles = factory.createTiles();//new Model.Tile[mapHeight][mapWidth];
        attackers = factory.createAttackers();//new Model.Attacker[7 ];//TODO: Make according to level.(Also implement a proper formula)
        towers = new LinkedList<>();
        towers.add(new SingleAttackTower(this, 8*tileEdge,8*tileEdge));
        /*
        typeMatrix = new int[mapHeight][mapWidth];
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/map1.mat"));
            // Reads according to octaves output format
            // May directly read rows and columns from the file.
            for ( int i = 0; i < 5 ; i++) {
                String tmpLine = bufferedReader.readLine();
                System.out.println(tmpLine);
            }
            for (int y = 0; y < mapHeight; y++)
            {
                String []row = bufferedReader.readLine().trim().split(" ");
                for (int x = 0; x < mapWidth; x++) {
                    typeMatrix[y][x] = Integer.parseInt(row[x]);
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Error loading map");
        }

        for ( int y = 0; y < mapHeight; y++)
        {
            for ( int x = 0; x < mapWidth;x++)
                tiles[y][x] = new Model.Tile(x * tileEdge, y * tileEdge,
                        tileEdge, tileEdge, 0, typeMatrix[y][x]);
        }
        System.out.println("Tiles Created");
        createAttackers();*/
	}
    /**
     * Iterates over the list of attackers and checks if they entered or killed.
     * Spawns if they have not entered the game so far.
     * */
    // TODO: isGameOver check may be added here
    public void attackerSpawnLoop()
    {
        //System.out.println(spawnTimer);
        if ( spawnTimer >= spawnCooldown){
            spawnTimer = 0;
            for ( int i = 0; i < attackers.length; i++)
            {
                // Debug prints
                //System.out.println(i + " " + attackers[i].isAlive() + " " + attackers[i].isKilled());
                if (!attackers[i].isAlive() && !attackers[i].killed) {
                    attackers[i].spawn();
                    //System.out.println("Model.Attacker" + i + "Spawned");
                    break;
                }
            }
        }
        else
            spawnTimer++;
    }
    public void attackerMotionLoop()
    {
        for ( int i = 0; i < attackers.length; i++)
        {
            if (attackers[i].alive && !attackers[i].isKilled())
            {
                attackers[i].move();
            }
        }
    }
    public void towerAttackLoop()
    {
        for (Tower i: towers)
        {
            i.attack();
        }
    }
	/**
	 *
	 * @param x
	 * @param y
	 * @param objectType
	 * @param objectID
	 */
	public void updateMap(int x, int y, int objectType, int objectID) {
		// TODO - implement Model.GameMap.updateMap
		throw new UnsupportedOperationException();
	}

	/**
     * Calls draw methods of tiles.
     * */
	public void draw(Graphics g)
    {
        //System.out.println("Draw Model.GameMap called");
        for ( int y = 0; y < tiles.length; y++)
        {
            for ( int x = 0; x < tiles[0].length; x++)
                tiles[y][x].draw(g);
        }
        // Draws attackers
        for (int i = 0; i < attackers.length; i++)
        {
            if (attackers[i].isAlive())
                attackers[i].draw(g);
        }
        for (Tower i: towers)
        {
            i.draw(g);
        }
    }
    public Attacker[] getAttackers()
    {
        return attackers;
    }
}