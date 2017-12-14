/**
 * Model.SingleAttackTower Class
 * Type of Model.Tower
 * @ author Barış Eymür
 * @ version 04.11.2017
 */

import com.sun.org.apache.regexp.internal.RE;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class SingleAttackTower extends Tower {
    protected Attacker currentTarget;


    public void attack(int attackerID, double damage) {

        throw new UnsupportedOperationException();
    }

    public SingleAttackTower(GameMap currentGameMap, int xPos, int yPos) {
        super(currentGameMap, xPos, yPos);
        damage = 5;
        currentTarget = null;
        rateOfFire = 300;
        currentAttackCooldown = 0;
        range = 350;

        try {
            // TODO: Implement better resource loading methods
            image = ImageIO.read(new File(Assets.tower2));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void attack()
    {
        if (currentAttackCooldown >= rateOfFire )
        {
            currentAttackCooldown = 0;
            if (currentTarget == null) {
                Queue attackersInRange = this.getAttackersInRange();
                // If List is empty catch the exception and set target to null to pass
                try {
                    currentTarget = (Attacker) attackersInRange.remove();
                    while ( currentTarget.isKilled() || !currentTarget.isAlive())
                        currentTarget = (Attacker) attackersInRange.remove();
                }catch (NoSuchElementException e) {
                    currentTarget = null;
                    currentAttackCooldown = 20;
                }
            }
            if (currentTarget != null)
            {
                //System.out.println("Target is not null");
                //System.out.println(currentTarget.getHealth());
                // Check condition if it is in range
                if ( super.getDistanceBetweenTowerAndTarget(this, currentTarget) > this.range)
                {
                    currentTarget = null;
                }
                else// Attack
                {
                    //Graphics g;
                    //g.drawLine((int)this.getX(), (int)this.getY(), (int)currentTarget.getX(), (int)currentTarget.getY());
                    currentGameMap.addParticle( new Particle(this.xPos, this.yPos, currentTarget.getX(),currentTarget.getY(),currentGameMap));
                    currentTarget.setHealth(currentTarget.getHealth() - damage);
                    if (currentTarget.getHealth() <= 0)
                        currentTarget = null;
                }
            }
        }
        else
            currentAttackCooldown++;
    }
    public void draw( int xPosition, int yPosition, Graphics g, int width, int height) {
        //panel.paintComponent( g );
        g.drawImage( image, xPosition, yPosition, width, height, null, null);
    }
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(image,xPos, yPos, height, width,null,null);
    }

}