import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.io.IOException;


public class HeroType1 extends Hero{
    protected Attacker target;


    public HeroType1(GameMap gameMap, int x,int y){
        super(gameMap,x,y);
        damage = 2;
     //   rateOfAttack = 300;
        target = null;

        try
        {
            image = ImageIO.read(new File(Assets.hero1));
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
    public void draw( int xPosition, int yPosition, Graphics g, int width, int height) {
        //panel.paintComponent( g );
        g.drawImage( image, xPosition, yPosition, width, height, null, null);
    }
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(image,x, y, 50, 50,null,null);
    }
}


