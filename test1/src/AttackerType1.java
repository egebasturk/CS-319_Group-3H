/**
 * Model.Attacker Class
 * An attacker. Unused currently
 * These are the things which attack the objective and must be destroyed.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */


public class AttackerType1 extends Attacker {

    // TODO: Entry point is passed as parameter. May search for it in the future.
	public AttackerType1( int entryRow) {
	    super(entryRow);
	    this.bounty = bounty = 10;
	    this.speed = speed = 20;
	    this.currentHealth = currentHealth = 100;
	}

}