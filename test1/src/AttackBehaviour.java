/**
 * Attack Behaviour Interface
 * Interface for all attack methods in the game. Implemented like this for extensibility
 * Currently there are one implementation for each algorithm. However they can be increased easily for game complexity
 * @ author Alp Ege Basturk
 * @ version 15.12.2017
 * @ author Baris Eymur
 * @ version2 15.12.2017
 */
public interface AttackBehaviour {
    void attack();
    void singleAttack( Tower attackSource);
    void areaAttack( Tower attackSource);
    boolean heroAttack( Hero attackSource );
    void attackerAttack( Attacker attackSource );
}
