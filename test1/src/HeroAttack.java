/**
 * Hero Attack implementation
 * Implements hero attack
 * @ author Alp Ege Basturk
 * @ version 15.12.2017
 */
public class HeroAttack implements AttackBehaviour {
    @Override
    public void attack() {

    }

    @Override
    public void singleAttack(Tower attackSource) {

    }

    @Override
    public void areaAttack(Tower attackSource) {

    }

    @Override
    public boolean heroAttack(Hero attackSource)
    {
        boolean flag = false;
        if (attackSource.currentAttackCooldown >= attackSource.rateOfFire )
        {
            attackSource.currentAttackCooldown = 0;
            for (Attacker at:attackSource.getAttackersInRange())
            {
                //attackSource.currentGameMap.addParticle( new Particle(attackSource.xPos, attackSource.yPos,
                //      attackSource.currentTarget.getX(),attackSource.currentTarget.getY(), attackSource.currentGameMap));
                at.setxPosTile( at.getxPosTile() - 1);
                at.setX(at.getX() - 20);
                at.setHealth(at.getHealth() - attackSource.damage);
                flag = true;
            }
        }
        else
            attackSource.currentAttackCooldown++;
        return flag;
    }

    public void attackerAttack(Attacker attackSource){}

}
