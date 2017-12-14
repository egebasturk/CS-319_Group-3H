/**
 * Model.Tower Class
 * Parent class of towers.
 * @ author Barış Eymür
 * @ version 04.11.2017
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Tower extends GameObject {

	protected double damage;
	protected double rateOfFire;
	protected int range;
	protected int towerType;
	protected BufferedImage image;
	public int height;
	public int width;
	protected int xPos;
	protected int yPos;
	protected int xPosTile = 0;
	protected int yPosTile = 0;
	GameMap currentGameMap;
	int currentAttackCooldown;
	protected boolean attackedFlag;

	public Tower( GameMap currentGameMap, int xPos, int yPos) {
	    //super();
        this.xPos = xPos;
        this.yPos = yPos;
	    this.currentGameMap = currentGameMap;
	    this.height = 50;
	    this.width = 50;
	    range = 1000;
	    rateOfFire = 20;
	    currentAttackCooldown = 0;
	    attackedFlag = false;
	}



	public LinkedList getAttackersInRange()
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
        /*
        int p = 0;
        for (Attacker i: listOfAttackersInRange)
        {
            System.out.print(p++ +" ");
        }
        System.out.println();*/
        return listOfAttackersInRange;
    }
    protected double getDistanceBetweenTowerAndTarget( Tower tower, Attacker attacker)
    {
        return Math.sqrt(Math.pow((attacker.getX() - tower.xPos), 2) + Math.pow((attacker.getY() - tower.yPos), 2));
    }
    public void attack()
    {

    }
    /**
     *
     * @param attackerID
     * @param damage
     */
	public void attack(int attackerID, double damage) {

	}
	public void draw(Graphics g)
    {

    }
    @Override
    public double getX()
    {
        return this.xPos;
    }
    @Override
    public double getY()
    {
        return this.yPos;
    }
}