/**
 * SingleAttackTower Class
 * Type of Tower
 * @ author Baris Eymur
 * @ version 04.11.2017
 * @ author Alp Ege Basturk
 * @ version 13.12.2017
 *   version2 15.12.2017
 */

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.io.IOException;

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
            image = ImageIO.read(getClass().getResource(Assets.tower2));
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
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(image,xPos, yPos, height, width,null,null);
    }

}