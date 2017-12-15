public class AttackerAttack implements AttackBehaviour {
    public void attackerAttack(Attacker attackSource){
        if (attackSource.currentAttackCooldown >= attackSource.rateOfFire ) {
            attackSource.currentAttackCooldown = 0;
            GameMap.base.setHealth((GameMap.base.getHealth()) - attackSource.damage);
        }
        else
            attackSource.currentAttackCooldown++;
    }
    public void attack(){}
    public void singleAttack( Tower attackSource){}
    public void areaAttack( Tower attackSource){}
    public boolean heroAttack( Hero attackSource ){return false;}
}
