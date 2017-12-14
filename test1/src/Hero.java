/**
 * Hero Class
 * @ author Emre Gürçay
 * @ version 14.12.2017
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Hero extends GameObject {

    protected double speed = 1.0;
    protected int currentMoveCounter = 0;
    protected enum direction { right, left, up, down}
    protected int location = 0;
    protected direction currentDirection = Hero.direction.left;
    protected double damage;
    //protected double health;
    protected double rateOfAttack;
    protected BufferedImage image;
    protected int heroType;
    GameMap gameMap;
    protected int x;
    protected int y;

    protected int entry;

    protected int xPosTile;
    protected int yPosTile;

    protected int time = 0;

    protected boolean alive = false;

    public Hero(GameMap gameMap ,int endRow, int endColumn){

        xPosTile = endColumn;
        yPosTile = endRow;
        //System.out.println("y tile is: " +  yPosTile + " x tile is: " +  xPosTile );
        this.x = endColumn * GameMap.tileEdge;
        this.gameMap = gameMap;
        entry  =  endRow * GameMap.tileEdge;
        this.y = entry;

    }
    public void attack()
    {

    }

    public Attacker killList() {
        ArrayList<Attacker> attackers = gameMap.getAttackers();
        for (int i = 0; i < attackers.size(); i++) {
            // System.out.println(attackers.get(i).xPosTile * GameMap.tileEdge);
         //   System.out.println(this.getX() + "and Y is: " + this.getY());
         //    System.out.println(this.getX() - attackers.get(i).xPosTile * GameMap.tileEdge);
            if ((this.getY() - attackers.get(i).yPosTile*GameMap.tileEdge) < GameMap.tileEdge && (this.getX() - attackers.get(i).xPosTile * GameMap.tileEdge) < GameMap.tileEdge) {
                System.out.println("Attacker catched");
                for(int j = 0; j < attackers.size(); j++)
                    attackers.get(j).speed = 0;
                return attackers.get(i);
            }
        }
        return null;
    }
    public void moveAttackers(){
        ArrayList<Attacker> attackers2 = gameMap.getAttackers();

        for(int i = 0; i < attackers2.size(); i++)
        {
            attackers2.get(i).speed = 1;
        }
    }
    public void move()
    {
        //System.out.println(" x tile is: " +  xPosTile );
        try{
            if(currentMoveCounter >= 700) {
                location++;
                if (location >= GameMap.tileEdge) {
                    xPosTile--;
                    location = 0;
                }
                //System.out.println(GameMap.tiles[this.yPosTile][xPosTile - 1].heroPass());
                if (GameMap.tiles[yPosTile][xPosTile - 1].heroPass()) {
                    x -= speed;
                    xPosTile--;
                    speed = 0;
                    currentMoveCounter = 0;
                }
                x -= speed;
                //System.out.println("x is : " + x);

            }else
            {
                currentMoveCounter += speed;
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            //System.out.println("y tile is: " +  yPosTile + " x tile is: " +  xPosTile );
        }

    }

    public void attack(int attackerID, double damage){}

    public void notifyDeath(){
        if(time  == 20)
        initializeDeath();
    }

    public void initializeDeath(){
        alive =  false;
        gameMap.notifyDeath(this);
    }

    public void draw(Graphics g){ }
    public double getX()
    {
        return this.x;
    }
    public double getY()
    {
        return this.y;
    }

}
