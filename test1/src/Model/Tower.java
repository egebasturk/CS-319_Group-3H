package Model; /**
 * Model.Tower Class
 * Parent class of towers.
 * @ author Barış Eymür
 * @ version 04.11.2017
 */

import java.awt.image.BufferedImage;

public class Tower extends GameObject {

	protected double damage;
	protected double rateOfFire;
	protected int range;
	protected int towerType;
	protected BufferedImage image;
	public int height;
	public int width;

	public Tower() {
	    super();
	    this.height = 50;
	    this.width = 50;
	}

	/**
	 * 
	 * @param attackerID
	 * @param damage
	 */
	public void attack(int attackerID, double damage) {
		// TODO - implement Model.Tower.attack
		throw new UnsupportedOperationException();
	}

}