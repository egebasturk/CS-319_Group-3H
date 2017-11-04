/**
 * Tower Class
 * Parent class of towers.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */

import java.awt.image.BufferedImage;

public class Tower extends GameObject {

	protected double damage;
	protected double rateOfFire;
	protected int range;
	protected int towerType;
	protected BufferedImage image;

	public Tower() {
		// TODO - implement Tower.Tower
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attackerID
	 * @param damage
	 */
	public void attack(int attackerID, double damage) {
		// TODO - implement Tower.attack
		throw new UnsupportedOperationException();
	}

}