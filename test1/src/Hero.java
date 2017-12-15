/**
 * Hero Class
 * @ author Emre Gürçay
 * @ version 14.12.2017
 * @ author Alp Ege Basturk
 * @ version 15.12.2017
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

public class Hero extends GameObject {
    protected double speed = 1.0;
    protected int currentMoveCounter = 0;
    protected enum direction { right, left, up, down}
    protected int location = 0;
    protected direction currentDirection = Hero.direction.left;
    protected double damage;
    //protected double currentHealth;
    protected BufferedImage image;
    protected int heroType;

    GameMap currentGameMap;
    AttackBehaviour currentAttackBehaviour;
    protected double rateOfFire;
    protected double range;
    protected double currentAttackCooldown;

    protected int entry;
    protected int xPosTile;
    protected int yPosTile;

    protected int time = 0;
    protected int numberOfAttacks;
    protected int maxNumberOfAttacks;

    protected boolean alive = false;

    public Hero(GameMap gameMap ,int endRow, int endColumn)
    {
        super();
        numberOfAttacks = 0;
        this.currentGameMap = gameMap;
        currentAttackBehaviour = new HeroAttack();
        currentAttackCooldown = 0;
        rateOfFire = 20;
        range = 20;

        xPosTile = endColumn;
        yPosTile = endRow;
        //System.out.println("y tile is: " +  yPosTile + " x tile is: " +  xPosTile );
        xPos = endColumn * GameMap.tileEdge;
        entry  =  endRow * GameMap.tileEdge;
        yPos = entry;

    }
    public void attack()
    {

    }

    public LinkedList<Attacker> getAttackersInRange()
    {
        //Attacker[] attackers = currentGameMap.getAttackers();
        ArrayList<Attacker> attackers = currentGameMap.getAttackers();
        // Will store calculated distances
        double distanceArray[] = new double[attackers.size()];
        LinkedList<Attacker> listOfAttackersInRange = new LinkedList<>();

        // Calculate distance with sqrt((x1-x2)^2 + (y1-y2)^2)
        for ( int i = 0; i < attackers.size(); i++)
        {
            distanceArray[i] = getDistanceBetweenTowerAndTarget(this, attackers.get(i));

            //System.out.println("Distance: " + distanceArray[i] +" Tower place: " + this.getX() + " " + this.getY());
            // If in range add attacker to the list
            if ( distanceArray[i] <= range && (!attackers.get(i).isKilled() && attackers.get(i).isAlive() ))
            {
                listOfAttackersInRange.add(attackers.get(i));
            }
        }
        return listOfAttackersInRange;
    }
    protected double getDistanceBetweenTowerAndTarget( Hero hero, Attacker attacker)
    {
        return Math.sqrt(Math.pow((attacker.getX() - hero.xPos), 2) + Math.pow((attacker.getY() - hero.yPos), 2));
    }
    /*public Attacker killList() {
        ArrayList<Attacker> attackers = currentGameMap.getAttackers();
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
        ArrayList<Attacker> attackers2 = currentGameMap.getAttackers();

        for(int i = 0; i < attackers2.size(); i++)
        {
            attackers2.get(i).speed = 1;
        }
    }*/
    public void move()
    {
        //System.out.println(" x tile is: " +  xPosTile );
        /*
        try{
            if(currentMoveCounter >= 700) {
                location++;
                if (location >= GameMap.tileEdge) {
                    xPosTile--;
                    location = 0;
                }
                //System.out.println(GameMap.tiles[this.yPosTile][xPosTile - 1].heroPass());
                if (GameMap.tiles[yPosTile][xPosTile - 1].heroPass()) {
                    xPos -= speed;
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
        }*/

    }

    public void attack(int attackerID, double damage){}

    public void notifyDeath(){
        if(time  == 20)
            initializeDeath();
    }

    public void initializeDeath(){
        alive =  false;
        currentGameMap.notifyDeath(this);
    }

    public void draw(Graphics g){ }
    public double getX()
    {
        return this.xPos;
    }
    public double getY()
    {
        return this.yPos;
    }

}
