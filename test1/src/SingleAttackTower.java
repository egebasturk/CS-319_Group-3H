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


    public void attack(int attackerID, double damage) {

        throw new UnsupportedOperationException();
    }

    public SingleAttackTower(GameMap currentGameMap, int xPos, int yPos) {
        super(currentGameMap, xPos, yPos);
        currentAttackBehaviour = new SingleAttack();
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
        currentAttackBehaviour.singleAttack(this);
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