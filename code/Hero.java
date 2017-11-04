import java.awt.*;
import java.awt.image.BufferedImage;

public class Hero extends GameObject {

    private double damage;
    private double health;
    private double rateOfAttack;
    private BufferedImage image;
    private double heroType;
    protected int xPos = 0;
    protected int yPos = 0;
    protected int boxEdge = 20;
    boolean alive;

    // TO DO: needs to be placed in front of the entrance of the castle.
    public Hero() {
        // TODO - implement Hero.Hero
        health = 100;
        alive = true;
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param attackerID		//attackerID
     * @param damage           //damage power of the attacker
     */


    public void setrateOfAttack(double rateOfAttack) {
        this.rateOfAttack = rateOfAttack;
    }

    public void setHeroType(double heroType) {
        this.heroType = heroType;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getRateOfAttack() {
        return this.rateOfAttack;
    }

    public double getHealth() {
        return this.health;
    }

    public double getHeroType() {
        return this.heroType;
    }

    public boolean isAlive(){
        return this.alive;
    }

    public BufferedImage getImage(){
        // TO DO
        return void;
    }

    public void attack(int attackerID, double damage) {
        // TODO - implement Hero.attack

        //attackerHealth = attackerID.getHealth() - rateOfAttack;
        //attackerID.setHealth(attackerHealth);		// TODO: add set get methods
        health = health - damage;
        throw new UnsupportedOperationException();
    }

    public void notifyDeath() {
        // TODO - implement Hero.notifyDeath
        throw new UnsupportedOperationException();
    }

    public void initializeDeath() {
        // TODO - implement Hero.initializeDeath
        if(health < 1)  {
            this.destroy();
            this.alive = false;
        }
        throw new UnsupportedOperationException();
    }

    public void destroy(){
        this.health = 0;
        //this = null;
    }

    public void draw (Graphics g){
        g.drawRect(xPos, yPos, boxEdge, boxEdge);
        g.setColor(Color.BLACK);
        g.fillRect(xPos, yPos, boxEdge, boxEdge);
    }

}
