import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

public class AreaAttackTower extends Tower {

    public void attack(int attackerID, double damage) {


    }

    public AreaAttackTower() {
        try {
            image = ImageIO.read(new File("C:/Users/Baris/Desktop/CS Stuff/CS 319/tower1.png"));
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