/**
 * Single Attack implementation
 * Implements single attack method for attack behaviour
 * @ author Alp Ege Basturk
 * @ version 15.12.2017
 */
import java.util.NoSuchElementException;
import java.util.Queue;

public class SingleAttack implements AttackBehaviour {
    @Override
    public void attack() {

    }

    @Override
    public void singleAttack(Tower attackSource)
    {
        if (attackSource.currentAttackCooldown >= attackSource.rateOfFire )
        {
            attackSource.currentAttackCooldown = 0;
            if (attackSource.currentTarget == null) {
                Queue attackersInRange = attackSource.getAttackersInRange();
                // If List is empty catch the exception and set target to null to pass
                try {
                    attackSource.currentTarget = (Attacker) attackersInRange.remove();
                    while ( attackSource.currentTarget.isKilled() || !attackSource.currentTarget.isAlive())
                        attackSource.currentTarget = (Attacker) attackersInRange.remove();
                }catch (NoSuchElementException e) {
                    attackSource.currentTarget = null;
                    attackSource.currentAttackCooldown = 20;
                }
            }
            if (attackSource.currentTarget != null)
            {
                //System.out.println("Target is not null");
                //System.out.println(currentTarget.getHealth());
                // Check condition if it is in range
                if ( attackSource.getDistanceBetweenTowerAndTarget(attackSource, attackSource.currentTarget) > attackSource.range)
                {
                    attackSource.currentTarget = null;
                }
                else// Attack
                {
                    //Graphics g;
                    //g.drawLine((int)this.getX(), (int)this.getY(), (int)currentTarget.getX(), (int)currentTarget.getY());
                    attackSource.currentGameMap.addParticle( new Particle(attackSource.xPos, attackSource.yPos,
                            attackSource.currentTarget.getX(),attackSource.currentTarget.getY(), attackSource.currentGameMap,
                            Particle.ParticleTypes.line, attackSource.range));
                    attackSource.currentTarget.setHealth(attackSource.currentTarget.getHealth() - attackSource.damage);
                    if (attackSource.currentTarget.getHealth() <= 0)
                        attackSource.currentTarget = null;
                }
            }
        }
        else
            attackSource.currentAttackCooldown++;
    }

    @Override
    public void areaAttack(Tower attackSource) {

    }

    @Override
    public boolean heroAttack(Hero attackSource) {
        return false;
    }
    public void attackerAttack(Attacker attackSource){};
}
