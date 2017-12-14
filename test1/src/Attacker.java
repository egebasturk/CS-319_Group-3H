/**
 * Model.Attacker Class
 * Parent of all attacker. Currently it is the only attacker.
 * These are the things which attack the objective and must be destroyed.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Attacker extends GameObject
{
    // Motion vals
    // TODO: this should not be a double, else path shifts. Or change some ints to double, worse.
	protected double speed = 1.0;
	protected double currentMoveCounter = 0;
	protected int moveThreshold = 30;
	protected double health = 100;
	protected enum direction { right, left, up, down}
	protected direction currentDirection = direction.right;
	protected int locationTrackerInTile = 0;

	protected BufferedImage image;
	protected int bounty = 0;
	protected int attackerType = 0;
	protected int boxEdge = 50;
	// Boolean vals
	protected boolean alive = false;
	protected boolean killed = false;

	// Position vals
	protected int xPos = 0;
	protected int yPos = 0;
	protected int xPosTile = 0;
	protected int yPosTile = 0;
	protected int attackerID;

	protected GameMap currentGameMap;
	public Attacker() {

	}
	// TODO: Attackers may find entry point themselves.
	public Attacker(int entryRow)
    {
        // 0 - boxEdge, to start off the map
        this.xPos = 0;
        this.xPosTile = 0;
        int entryPosition = entryRow * GameMap.tileEdge;
        this.yPos = entryPosition;
        this.yPosTile = entryRow;
        //this.alive = true;
        try {
            image = ImageIO.read(new File(Assets.attacker2));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Spawns in the given location
    public void spawn(int xPos, int yPos)
    {
        //System.out.println("Model.Attacker spawned");
        this.alive = true;
        // x - boxEdge, to better transition from outside of the map to inside
        this.setBounds(xPos, yPos, boxEdge, boxEdge);
    }
    // Wrapper method for the one above. Used for testing. Probably will be deleted or changed.
    // TODO: Delete if not necessary.
    public void spawn()
    {
        spawn(this.xPos, this.yPos);
    }

    /**
     * This is the decision mechanic for the motion of an attacker
     * Object moves in a direction, checks map in the path. If it cannot move,
     * then it changes its direction accordingly.
     * */
    // TODO: This part is Buggy. Direction change works but position update is problematic.
	public void move()
    {
        try {
/*            if (this.getHealth() <= 0)
                initializeDeath();*/
            if (currentMoveCounter >= moveThreshold) {

                locationTrackerInTile++;

                // If it passed the tile, update which tile it is in
                if (locationTrackerInTile >= GameMap.tileEdge) {
                    if (currentDirection == direction.right)
                        xPosTile++;
                    else if (currentDirection == direction.up)
                        yPosTile--;
                    else if (currentDirection == direction.down)
                        yPosTile++;
                    else if (currentDirection == direction.left)
                        xPosTile--;
                    locationTrackerInTile = 0;
                }

                // Complicated, delete after writing more efficient
                // TODO: Collision detection should be updated/cleaned. Addition of hero class changes the logic
                // Was moving right, hit sth from left
                //System.out.println("x,y" + xPosTile + "," + yPosTile);
                if (currentDirection == direction.right &&
                        this.xPos + boxEdge + speed
                                >= GameMap.tiles[yPosTile][xPosTile + 1].getX() &&
                        GameMap.tiles[yPosTile][xPosTile + 1].isBlocking()) {
                    // check top if it is also blocking, change direction to up or down
                    if (this.yPos - speed
                            <= GameMap.tiles[yPosTile - 1][xPosTile].getY() + boxEdge &&
                            GameMap.tiles[yPosTile - 1][xPosTile].isBlocking()) {
                        currentDirection = direction.down;
                    } else
                        currentDirection = direction.up;
                }
                // Was moving left, hit sth from right
                else if (currentDirection == direction.left &&
                        this.xPos - speed
                                <= GameMap.tiles[yPosTile][xPosTile - 1].getBounds().getX() &&
                        GameMap.tiles[yPosTile][xPosTile - 1].isBlocking()) {
                    // check top if it is also blocking, change direction to down
                    if (this.yPos - 1
                            <= GameMap.tiles[yPosTile - 1][xPosTile].getBounds().getY() + boxEdge &&
                            GameMap.tiles[yPosTile - 1][xPosTile].isBlocking()) {
                        currentDirection = direction.down;
                    } else
                        currentDirection = direction.up;
                }
                // Was moving up, hit sth from bottom
                else if (currentDirection == direction.up &&
                        this.yPos - speed - GameMap.tileEdge
                                <= GameMap.tiles[yPosTile - 1][xPosTile].getY() &&
                        GameMap.tiles[yPosTile - 1][xPosTile].isBlocking()) {
                    // check right if it is also blocking, change direction to right or left
                    if (this.xPos + boxEdge + speed
                            >= GameMap.tiles[yPosTile][xPosTile + 1].getBounds().getX() + boxEdge &&
                            GameMap.tiles[yPosTile][xPosTile + 1].isBlocking()) {
                        currentDirection = direction.left;
                    } else
                        currentDirection = direction.right;
                }
                // Was moving down, hit sth from top
                else if (currentDirection == direction.down &&
                        this.yPos - GameMap.tileEdge - speed
                                <= GameMap.tiles[yPosTile + 1][xPosTile].getY() &&
                        GameMap.tiles[yPosTile + 1][xPosTile].isBlocking()) {
                    // check right if it is also blocking, change direction to down
                    if (this.xPos + boxEdge + speed
                            >= GameMap.tiles[yPosTile][xPosTile + 1].getBounds().getX() + boxEdge &&
                            GameMap.tiles[yPosTile][xPosTile + 1].isBlocking()) {
                        currentDirection = direction.left;
                    } else
                        currentDirection = direction.right;
                }

                if (currentDirection == direction.right) {
                    xPos += speed;
                } else if (currentDirection == direction.left) {
                    xPos -= speed;
                } else if (currentDirection == direction.up) {
                    yPos -= speed;
                } else if (currentDirection == direction.down) {
                    yPos += speed;
                }
                currentMoveCounter = 0;

            } else {
                currentMoveCounter += speed;
            }
        }catch (ArrayIndexOutOfBoundsException e)
        {
            // TODO: Implement a proper exit strategy
            System.out.println("Game has finished. This is primitive end. Work in progress");
            JOptionPane.showMessageDialog(null, "Game Has Finished");
            System.exit(0);
        }
	}
	public void setHealth(double health)
    {
	    this.health = health;
	    if (this.health <= 0)
	        initializeDeath();
    }
    public double getHealth()
    {
        return health;
    }
	public void notifyDeath() {
		// TODO - implement Model.Attacker.notifyDeath
        // Intention: Caller will know this and set reference to null.
        // TODO: Should be implemented for this class and the caller
        if (health <= 0)
        {
            alive = false;
        }
	}
	public void setCurrentGameMap(GameMap gameMap)
    {
        currentGameMap = gameMap;
    }

	public void initializeDeath() {
		killed = true;
		currentGameMap.notifyDeath(this);
	}

	public void draw(Graphics g)
    {

        if (alive || !killed) {
            g.drawImage(image,xPos, yPos, boxEdge, boxEdge,null,null);
            //g.drawRect(xPos, yPos, boxEdge, boxEdge);
            //g.setColor(Color.BLACK);
            //g.fillRect(xPos, yPos, boxEdge, boxEdge);
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isKilled() {
        return killed;
    }
}