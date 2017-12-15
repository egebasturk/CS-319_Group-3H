/**
 * Base class
 * Implements the object which player will be defending
 * @ author Baris Eymur
 * @ version 15.12.2017
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Base extends GameObject{
    // attributes
    protected double currentHealth;
    protected double maxHealth = 100;
    protected final int heightOfHealthBar = 10;
    protected final int widthOfHealthBar = 40;
    protected final int paddingTopOfHealthBar = 15;
    protected final int paddingLeftOfHealthBar = 0;
    protected boolean standing = true;
    protected int boxEdge = 40;

    GameMap currentGameMap;
    //TODO: GameMap already has the two ints, don't need to pass
    public Base(GameMap gameMap ,int endRow, int endColumn) {
        super();
        currentGameMap = gameMap;
        xPos = endColumn * GameMap.tileEdge;
        yPos = endRow * GameMap.tileEdge;
        currentHealth = maxHealth;
        try {
            image = ImageIO.read(new File(Assets.closed));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setHealth(double health){
        this.currentHealth = health;
        if(this.currentHealth <= 0)
            gameIsOver();
    }

    public double getHealth(){
        return currentHealth;
    }

    public void gameIsOver(){
        standing = false;
    }

    int temp = 0;
    public void draw(Graphics g)
    {
            g.drawImage(image,xPos, yPos, boxEdge, boxEdge,null,null);
            g.setColor(Color.magenta);
            temp = (int)(currentHealth * widthOfHealthBar / maxHealth);
            g.fillRect(xPos + paddingLeftOfHealthBar,yPos - paddingTopOfHealthBar, temp, heightOfHealthBar);
            if(standing) {
                g.setColor(Color.red);
                g.fillRect(xPos + temp + paddingLeftOfHealthBar, yPos - paddingTopOfHealthBar, widthOfHealthBar - temp, heightOfHealthBar);
            }
    }
}
