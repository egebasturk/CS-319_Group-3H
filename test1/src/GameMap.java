/**
 * Game Map Class
 * GameMap stores the objects that will be drawn on the map such as tiles, attackers etc.
 * Calls their draw methods.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 *   version2 13.12.2017
 *   version3 14.12.2017
 *   version4 15.12.2017
 */

import sun.rmi.runtime.Log;

import java.awt.*;
import java.util.*;

public class GameMap {

    // Static Because there are other classes which should know these values
    public static int mapWidth = 20;
    public static int mapHeight =15;
    public static int tileEdge = 40;
    private int spawnCooldown = 1000;
    private int spawnTimer = 0;
    public static Tile[][] tiles;
    //public static Attacker[] attackers;
    public static ArrayList<Attacker> attackers; // TODO: not all accesses use the getter
    private static LinkedList<Tower> towers;
    public static Hero hero;
    public Base base;
    public static Obstacle obstacle;
    public static LinkedList<Particle> particles;
    // TODO This will be passed from the InputController
    private int[][] typeMatrix;

    public int endRow;
    public int endColumn;

    GameController currentGameController;

	public GameMap( int selectedLevel, GameController currentGameController )
    {
        this.currentGameController = currentGameController;
	    particles = new LinkedList<>();
	    AbstractFactory factory = factorySelector(selectedLevel);
        endColumn = 18;
        endRow = 9;
	    // TODO Input controller will read when it is implemented
        tiles = factory.createTiles();
        attackers = new ArrayList<>(Arrays.asList(factory.createAttackers()));
        towers = new LinkedList<>();
        //towers.add(new AreaAttackTower(this, 8*tileEdge,8*tileEdge));

       // hero = new HeroType1(this, 9,18);
        base = new Base( this, 9, 19);
        //hero = new HeroType1(this, 9,18);
        //obstacle = new Obstacle(this,11,9);
	}
	/**
     * Returns a factory instance according to level
     * */
	private AbstractFactory factorySelector(int level)
    {
        if ( level == 1)
            return new FactoryLevel1();
        else if ( level == 2)
            return new FactoryLevel2();
        else if ( level == 3)
            return new FactoryLevel3();
        else if ( level == 4)
            return new FactoryLevel4();
        else if ( level == 5)
            return new FactoryLevel5();
        return null;
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
            for ( int i = 0; i < attackers.size(); i++)
            {
                // Debug prints
                //System.out.println(i + " " + attackers[i].isAlive() + " " + attackers[i].isKilled());
                if (!attackers.get(i).isAlive() && !attackers.get(i).killed) {
                    attackers.get(i).spawn();
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
        for ( int i = 0; i < attackers.size(); i++)
        {
            if (attackers.get(i).alive && !attackers.get(i).isKilled())
            {
                attackers.get(i).move();
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
    public void heroAttackLoop()
    {
        //hero.attack();
        //hero.move();

        // Somehow if (null) check does not always work.
        // It may be due to concurrent modification. Written try-catch in case it goes wrong
        try {
            if (hero != null) {
                hero.attack();
                hero.move(); 
            }
        } catch (NullPointerException ne)
        {

        }
       // obstacle.stopList();
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
        for (int i = 0; i < attackers.size(); i++)
        {
            if (attackers.get(i).isAlive())
                attackers.get(i).draw(g);
        }
        for (Tower i: towers)
        {
            i.draw(g);
        }
        if ( hero != null)
            hero.draw(g);
        base.draw(g);


       // obstacle.draw(g);
        try {
            for (Particle i: particles)
            {
                i.draw(g);
            }
        } catch (ConcurrentModificationException e) {

        }
    }
    public ArrayList<Attacker> getAttackers()
    {
        return attackers;
    }
    public void notifyDeath(GameObject object)
    {
        if ( object instanceof Attacker)
        {
            for (Iterator<Attacker> it = attackers.iterator(); it.hasNext();) {
                Attacker at = it.next();
                if (at ==object) {
                    currentGameController.setPlayerGold(at.getBounty() + currentGameController.getPlayerGold());
                    it.remove();
                }
            }
        }
        else if ( object instanceof Particle)
        {
            for (Iterator<Particle> it = particles.iterator(); it.hasNext();) {
                Particle par = it.next();
                if (par == object) {
                    it.remove();
                }
            }
        }
        else if ( object instanceof Tower )
        {
            for (Iterator<Tower> it = towers.iterator(); it.hasNext();) {
                Tower tow = it.next();
                if (tow == object) {
                    it.remove();
                }
            }
        }
        if ( object instanceof Hero )
        {
            hero = null;
        }
    }
    public boolean addTowerOrHero(GameObject newTowerOrHero)
    {
        if ( newTowerOrHero instanceof Tower )
        {
            //TODO: Solve index out of bounds error
            int tileXLocation = (int)newTowerOrHero.getX()/tileEdge;
            int tileYLocation = (int)newTowerOrHero.getY()/tileEdge;
            /*if (tileXLocation >= mapWidth)
                tileXLocation--;
            if (tileYLocation >= mapHeight)
                tileYLocation++;*/
            try {
                if ( tiles[tileYLocation][tileXLocation].getType() != 1 )
                {
                    System.out.println("Cannot add tower tile type is "  + tiles[tileXLocation][tileYLocation].getType());
                    return false;
                }
            } catch (IndexOutOfBoundsException ie)
            {
                return false;
            }
            for (Iterator<Tower> it = towers.iterator(); it.hasNext(); ) {
                Tower tow = it.next();
                if (tow.getX() == newTowerOrHero.getX() && tow.getY() == newTowerOrHero.getY()) {
                    System.out.println("Cannot add tower");
                    return false;
                }
            }
            towers.addLast((Tower) newTowerOrHero);
            System.out.println("Tower added");
            return true;
        }
        else if ( newTowerOrHero instanceof Hero )
        {
            hero = (Hero) newTowerOrHero;
            return true;
        }
        return false;
    }
    public void addParticle(Particle particle)
    {
        particles.addLast(particle);
    }
    // TODO: Methods can be merged. But not a priority
    public GameController.selectedTowerFromTheList upgradeTower( Point clickPoint )
    {
        for (Tower i: towers)
        {
            if ( i.getX() == clickPoint.getX() && i.getY() == clickPoint.getY() )
            {
                if ( i instanceof SingleAttackTower )
                {
                    // Switches implemented attack behaviour
                    ((SingleAttackTower)i).currentAttackBehaviour = new SingleAttackUpgraded1();
                    return GameController.selectedTowerFromTheList.tower2;
                }
            }
        }
        return GameController.selectedTowerFromTheList.None;
    }
    public GameController.selectedTowerFromTheList getSelectionFromTheMap ( Point clickPoint )
    {
        for (Tower i: towers)
        {
            if ( i.getX() == clickPoint.getX() && i.getY() == clickPoint.getY() )
            {
                if ( i instanceof SingleAttackTower )
                {
                    return GameController.selectedTowerFromTheList.tower2;
                }
            }
        }
        return GameController.selectedTowerFromTheList.None;
    }
    public GameController.selectedTowerFromTheList sellTower( Point clickPoint )
    {
        for (Tower i:towers )
        {
            if ( i.getX() == clickPoint.getX() && i.getY() == clickPoint.getY() )
            {
                notifyDeath(i);
                if ( i instanceof SingleAttackTower )
                {
                    return GameController.selectedTowerFromTheList.tower2;
                }
                else if ( i instanceof AreaAttackTower )
                {
                    return GameController.selectedTowerFromTheList.tower1;
                }
            }
        }
        return GameController.selectedTowerFromTheList.None;
    }
}