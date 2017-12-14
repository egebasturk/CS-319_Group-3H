/**
 * Hero Type 2 Class
 * @ author Emre Gürçay
 * @ version 14.12.2017
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class HeroType2 extends Hero{
    protected Attacker target;
    private int time = 1000;

    public HeroType2(GameMap gameMap, int endRow, int endColumn){
        super(gameMap,endRow,endColumn);
        damage = 26;
        //   rateOfAttack = 300;
        target = null;

        try
        {
            image = ImageIO.read(new File(Assets.hero2));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void attack()
    {
        if(target == null)
        {
            target = killList();
            //System.out.println("attacker null");
        }
        if(target != null) {
            if ((this.getY() - target.yPosTile*GameMap.tileEdge) > 40 || (this.getX() - target.xPosTile * GameMap.tileEdge) > 40) {
                target = null;
                System.out.println("attacker is null null");
            } else {
                target.setHealth(target.getHealth() - damage);
                System.out.println("attacking");
                if (target.getHealth() <= 0) {
                    target = null;
                    System.out.println("target is dead");
                    move();
                }

            }
        }
    }
    public void draw(int xPosition, int yPosition, Graphics g, int width, int height) {
        //panel.paintComponent( g );
        g.drawImage( image, xPosition, yPosition, width, height, null, null);
    }
    @Override
    public void draw(Graphics g)
    {
        System.out.println("Graphics :" + x);
        g.drawImage(image,x, y, 50, 50,null,null);

    }
}

