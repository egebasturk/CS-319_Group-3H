import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class AreaAttack implements AttackBehaviour {
    @Override
    public void attack() {

    }

    @Override
    public void singleAttack(Tower attackSource) {

    }

    @Override
    public void areaAttack(Tower attackSource)
    {
        if (attackSource.currentAttackCooldown >= attackSource.rateOfFire )
        {
            attackSource.currentAttackCooldown = 0;
            for (Attacker at:attackSource.getAttackersInRange())
            {
                //attackSource.currentGameMap.addParticle( new Particle(attackSource.xPos, attackSource.yPos,
                  //      attackSource.currentTarget.getX(),attackSource.currentTarget.getY(), attackSource.currentGameMap));
                at.setHealth(at.getHealth() - attackSource.damage);
            }
            attackSource.currentGameMap.addParticle( new Particle(attackSource.xPos, attackSource.yPos,
                    0,0, attackSource.currentGameMap,
                    Particle.ParticleTypes.circle, attackSource.range));
        }
        else
            attackSource.currentAttackCooldown++;
    }
}
