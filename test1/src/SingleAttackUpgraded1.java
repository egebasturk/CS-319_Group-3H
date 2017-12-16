/**
 * Single Attack implementation
 * Implements upgraded single attack method for attack behaviour
 * @ author Alp Ege Basturk
 * @ version 16.12.2017
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class SingleAttackUpgraded1 implements AttackBehaviour
{

    @Override
    public void attack() {

    }

    @Override
    public void singleAttack(Tower attackSource)
    {
        ArrayList<Attacker> currentTargets = new ArrayList<>();
        if (attackSource.currentAttackCooldown >= attackSource.rateOfFire )
        {
            attackSource.currentAttackCooldown = 0;
            if ( currentTargets.isEmpty())
            {
                Queue attackersInRange = attackSource.getAttackersInRange();
                // If List is empty catch the exception and set target to null to pass
                try {
                    // Select two targets
                    for (int i = 0; i < 2; i++)
                    {
                        currentTargets.add((Attacker) attackersInRange.remove());
                        /*while (attackSource.currentTarget.isKilled() || !attackSource.currentTarget.isAlive())
                            attackSource.currentTarget = (Attacker) attackersInRange.remove();*/
                    }
                }catch (NoSuchElementException e) {
                    /*attackSource.currentTarget = null;*/
                    attackSource.currentAttackCooldown = 20;
                }
            }
            if (!currentTargets.isEmpty())
            {
                for ( int i = 0; i < 2 && !currentTargets.isEmpty(); i++)
                {
                    // If one of the attackers die because of another reason while this is trying to attack it,
                    // this would cause Index out of bounds exception
                    try {
                        // Check condition if it is in range
                        if (attackSource.getDistanceBetweenTowerAndTarget(attackSource, currentTargets.get(i)) > attackSource.range) {
                            currentTargets.remove(i);
                        } else// Attack
                        {
                            attackSource.currentGameMap.addParticle(new Particle(attackSource.xPos, attackSource.yPos,
                                    currentTargets.get(i).getX(), currentTargets.get(i).getY(), attackSource.currentGameMap,
                                    Particle.ParticleTypes.line, attackSource.range));
                            currentTargets.get(i).setHealth(currentTargets.get(i).getHealth() - attackSource.damage);
                            if (currentTargets.get(i).getHealth() <= 0)
                                currentTargets.remove(i);
                        }
                    }catch (IndexOutOfBoundsException ie)
                    {
                        // Skip the problematic attack
                    }

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

    @Override
    public void attackerAttack(Attacker attackSource) {

    }
}
