/**
 * SingleAttackTower Class
 * Type of Tower
 * @ author
 * @ version 04.11.2017
 */

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class SingleAttackTower extends Tower {

    public void attack(int attackerID, double damage) {

        throw new UnsupportedOperationException();
    }

    public SingleAttackTower() {
        try {
            // TODO: Implement better resource loading methods
            image = ImageIO.read(new File("C:/Users/Baris/Desktop/CS Stuff/CS 319/tower2.png"));
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