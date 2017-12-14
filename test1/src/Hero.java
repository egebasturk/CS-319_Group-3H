import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Hero extends GameObject {
    protected double damage;
    //protected double health;
    protected double rateOfAttack;
    protected BufferedImage image;
    protected int heroType;
    GameMap gameMap;
    protected int x;
    protected int y;

    public Hero(GameMap gameMap, int x , int y){

        this.x = x;
        this.y = y;
        this.gameMap = gameMap;


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
            if ((this.getY() - attackers.get(i).yPosTile*GameMap.tileEdge) < 2*GameMap.tileEdge && (this.getX() - attackers.get(i).xPosTile * GameMap.tileEdge) < 2*GameMap.tileEdge) {
                System.out.println("Attacker catched");
                for(int j = 0; j < attackers.size(); j++)
                    attackers.get(j).speed = 0;
                return attackers.get(i);
            }
        }
        return null;
    }
    public void move(){
        ArrayList<Attacker> attackers2 = gameMap.getAttackers();

        for(int i = 0; i < attackers2.size(); i++)
        {
           // attackers2.get(i).speed = 20;
        }
    }

    public void attack(int attackerID, double damage){}

    public void notifyDeath(){}

    public void initializeDeath(){}

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
