import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Attacker Type 1 Class
 * An attacker.
 * These are the things which attack the objective and must be destroyed.
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 *   version2 16.12.2017
 */


public class AttackerType1 extends Attacker {

    // TODO: Entry point is passed as parameter. May search for it in the future.
	public AttackerType1( int entryRow) {
	    super(entryRow);
	    this.bounty = bounty = 10;
	    this.maxHealth = 250;
	    this.currentHealth = maxHealth;
		try {
			image = ImageIO.read(new File(Assets.attacker1));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}