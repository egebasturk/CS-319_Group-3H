import java.awt.*;
import java.awt.image.BufferedImage;

public class Attacker extends GameObject {

	protected double speed = 1;
	protected double health = 100;
	protected BufferedImage image;
	protected int bounty = 0;
	protected int attackerType = 0;
	protected int boxEdge = 20;
	protected boolean alive = false;
	protected boolean killed = false;
	protected int xPos = 0;
	protected int yPos = 0;
	protected int xPosTile = 0;
	protected int yPosTile = 0;
	protected int attackerID;

	public Attacker() {

	}
	public Attacker(int entryRow)
    {
        // 0 - boxEdge, to start off the map
        this.xPos = 0;
        this.xPosTile = 0;
        int entryPosition = entryRow * GameMap.tileEdge;
        this.yPos = entryPosition;
        this.yPosTile = entryRow;
        //this.alive = true;
        //spawn(xPos, yPos);
    }
    // Spawns in the given location
    public void spawn(int xPos, int yPos)
    {
        System.out.println("Attacker spawned");
        this.alive = true;
        // x - boxEdge, to better transition from outside of the map to inside
        this.setBounds(xPos, yPos, boxEdge, boxEdge);
    }
    // Wrapper method for the one above. Used for testing. Probably will be deleted.
    // TODO: Delete if not necessary.
    public void spawn()
    {
        spawn(this.xPos, this.yPos);
    }

	public void move() {
		// TODO - implement Attacker.move
		xPos += 1;

	}

	public void notifyDeath() {
		// TODO - implement Attacker.notifyDeath
        // Intention: Caller will see this and set reference to null.
        // TODO: Should be implemented for this class and the caller
        if (health <= 0)
        {
            alive = false;
        }
	}

	public void initializeDeath() {
		// TODO - implement Attacker.initializeDeath
		throw new UnsupportedOperationException();
	}

	public void draw(Graphics g)
    {
        if (alive || !killed) {
            g.drawRect(xPos, yPos, boxEdge, boxEdge);
            g.setColor(Color.BLACK);
            g.fillRect(xPos, yPos, boxEdge, boxEdge);
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isKilled() {
        return killed;
    }
}