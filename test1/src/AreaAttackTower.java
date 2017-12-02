/**
 * Model.AreaAttackTower class
 * A tower type
 * @ Barış Eymür
 * @ version 04.11.2017
 */

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.io.IOException;

public class AreaAttackTower extends Tower {

    public void attack(int attackerID, double damage) {
    }
    public AreaAttackTower() {
        try {
            image = ImageIO.read(new File(Assets.tower1));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw( int xPosition, int yPosition, Graphics g, int width, int height) {
        //panel.paintComponent( g );
        g.drawImage( image, xPosition, yPosition, width, height, null, null);
    }

}