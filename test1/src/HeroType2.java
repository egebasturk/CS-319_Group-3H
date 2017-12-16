/**
 * Hero Type 2 Class
 * Implements hero type 2
 * @ author Emre Gürçay
 * @ version 14.12.2017
 * @ author Alp Ege Basturk
 * @ version2 15.12.2017
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class HeroType2 extends Hero{
    protected Attacker target;
    protected BufferedImage kapowImage;
    private boolean fight = false;
    private int waitTime = 0;

    public HeroType2(GameMap gameMap, int endRow, int endColumn){
        super(gameMap,endRow,endColumn);
        damage = 30;
        maxNumberOfAttacks = 25;
        //   rateOfAttack = 300;
        target = null;

        xPos = endColumn * GameMap.tileEdge;
        yPos = endRow * GameMap.tileEdge;
        try
        {
            image = ImageIO.read(new File(Assets.hero2));
            kapowImage = ImageIO.read(new File(Assets.kapow2));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void attack()
    {
        fight = currentAttackBehaviour.heroAttack( this );
        if (fight)
        {
            numberOfAttacks++;
            if (numberOfAttacks > maxNumberOfAttacks)
                initializeDeath();
        }
    }
    public void draw(int xPosition, int yPosition, Graphics g, int width, int height) {
        //panel.paintComponent( g );
        g.drawImage( image, xPosition, yPosition, width, height, null, null);
    }
    @Override
    public void draw(Graphics g)
    {
        // System.out.println("Graphics :" + x);
        g.drawImage(image,xPos, yPos, 50, 50,null,null);
        if(fight)
        {
            //System.out.println("kapoww");
            g.drawImage(kapowImage,xPos- GameMap.tileEdge/2, yPos-GameMap.tileEdge/2, 75, 75,null,null);
            fight = false;
        }
    }
}

