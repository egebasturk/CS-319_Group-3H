/**
 * Model.SingleAttackTower Class
 * Type of Model.Tower
 * @ author Barış Eymür
 * @ version 04.11.2017
 */

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.io.IOException;

public class SingleAttackTower extends Tower {

    public void attack(int attackerID, double damage) {

        throw new UnsupportedOperationException();
    }

    public SingleAttackTower() {
        try {
            // TODO: Implement better resource loading methods
            image = ImageIO.read(new File(Assets.tower2));
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