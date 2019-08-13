/**
 * Tower Class
 * Parent class of towers.
 * @ author Barış Eymür
 * @ version 04.11.2017
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 *   version 15.12.2017
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Tower extends GameObject {
    AttackBehaviour currentAttackBehaviour;
    Attacker currentTarget;
	protected double damage;
	protected double rateOfFire;
	int range;
	protected int xPosTile = 0;
	protected int yPosTile = 0;
	GameMap currentGameMap;
	int currentAttackCooldown; // Counter for cooldown after attack
	private boolean attackedFlag; // Flag to control cooldown

	public Tower( GameMap currentGameMap, int xPos, int yPos) {
	    super();
        this.xPos = xPos;
        this.yPos = yPos;
	    this.currentGameMap = currentGameMap;
	    this.height = 50;
	    this.width = 50;
	    range = 500;
	    rateOfFire = 20;
	    currentAttackCooldown = 0;
	    attackedFlag = false;
	}
	LinkedList<Attacker> getAttackersInRange()
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
            if ( distanceArray[i] <= range / 2 && (!attackers.get(i).isKilled() && attackers.get(i).isAlive() ))
            {
                listOfAttackersInRange.add(attackers.get(i));
            }
        }
        return listOfAttackersInRange;
    }
    double getDistanceBetweenTowerAndTarget(Tower tower, Attacker attacker)
    {
        return Math.sqrt(Math.pow((attacker.getX() - tower.xPos), 2) + Math.pow((attacker.getY() - tower.yPos), 2));
    }
    // Not functional
    public void attack()
    {

    }
    // Not functional
    /**
     *
     * @param attackerID
     * @param damage
     */
	public void attack(int attackerID, double damage) {

	}
	// Not functional
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