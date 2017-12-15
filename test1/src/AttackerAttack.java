/**
 * Attacker Attack Class
 * Implements an attack method for Attackers
 * @ author Baris Eymur
 * @ version 15.12.2017
 * @ author Alp Ege Basturk
 * @ version2 15.12.2017
 */

public class AttackerAttack implements AttackBehaviour {
    public void attackerAttack(Attacker attackSource){
        if (attackSource.currentAttackCooldown >= attackSource.rateOfFire ) {
            attackSource.currentAttackCooldown = 0;
            attackSource.currentGameMap.base.setHealth((attackSource.currentGameMap.base.getHealth()) - attackSource.damage);
        }
        else
            attackSource.currentAttackCooldown++;
    }
    public void attack(){}
    public void singleAttack( Tower attackSource){}
    public void areaAttack( Tower attackSource){}
    public boolean heroAttack( Hero attackSource ){return false;}
}
