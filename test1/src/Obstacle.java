/**
 * Obstacle
 * Implements obstacle. Not used yet.
 * @ author Emre Gurcay
 * @ version 15.12.2017
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Obstacle extends GameObject {
    protected double speed = 1.0;
    protected int currentMoveCounter = 0;
    private static int count = 0;
    protected int location = 0;
    protected double damage;

    protected BufferedImage image;

    GameMap gameMap;
    private int x;
    private int y;

    private int xPosTile;
    private int yPosTile;

    private int time = 0;

    private boolean alive = false;

    public Obstacle(GameMap gameMap ,int x, int y) {

        xPosTile = x;
        yPosTile = y;

        this.x = xPosTile*GameMap.tileEdge;
        this.y = yPosTile*GameMap.tileEdge;

        this.gameMap = gameMap;
        this.height = 50;
        this.width = 50;

        try
        {
            image = ImageIO.read(new File(Assets.rock));
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public Attacker stopList() {
        ArrayList<Attacker> attackers = gameMap.getAttackers();
        for (int i = 0; i < attackers.size(); i++) {
            // System.out.println(attackers.get(i).xPosTile * GameMap.tileEdge);
            //   System.out.println(this.getX() + "and Y is: " + this.getY());
            //    System.out.println(this.getX() - attackers.get(i).xPosTile * GameMap.tileEdge);
            if ((this.getY() - attackers.get(i).yPosTile*GameMap.tileEdge) < GameMap.tileEdge && (this.getX() - attackers.get(i).xPosTile * GameMap.tileEdge) < GameMap.tileEdge) {
                System.out.println("Attacker catched");
                startCountDown();
                for(int j = 0; j < attackers.size(); j++)
                    attackers.get(j).speed = 0;
                return attackers.get(i);

            }
        }
        return null;
    }
    public void startCountDown()
    {
        while (count < 10000)
        {
            System.out.println(count);
            count++;
        }
        count = 0;
        initializeDeath();
    }

    public void moveAttackers(){
        ArrayList<Attacker> attackers2 = gameMap.getAttackers();

        for(int i = 0; i < attackers2.size(); i++)
        {
            attackers2.get(i).speed = 1;
        }
    }


    public void notifyDeath(){
        if(time  == 20)
            initializeDeath();
    }

    public void initializeDeath(){
        alive =  false;
        gameMap.notifyDeath(this);
        moveAttackers();
    }


    public void draw(int xPosition, int yPosition, Graphics g, int width, int height) {
        //panel.paintComponent( g );
        g.drawImage( image, xPosition, yPosition, width, height, null, null);
    }
    public void draw(Graphics g)
    {
        // System.out.println("Graphics :" + x);
        g.drawImage(image,x, y, 50, 50,null,null);
        if(alive)
        {
            //System.out.println("kapoww");
         //   g.drawImage(kapowImage,x- GameMap.tileEdge/2, y-GameMap.tileEdge/2, 75, 75,null,null);
        }
    }
    public double getX()
    {
        return this.x;
    }
    public double getY()
    {
        return this.y;
    }

}


