import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Attacker Type 2 Class
 * An attacker.
 * These are the things which attack the objective and must be destroyed.
 * @ author Alp Ege Basturk
 * @ version 16.12.2017
 */


public class AttackerType2 extends Attacker {

    // TODO: Entry point is passed as parameter. May search for it in the future.
    public AttackerType2( int entryRow) {
        super(entryRow);
        this.bounty = bounty = 5;
        this.currentHealth = currentHealth = 100;
        try {
            image = ImageIO.read(new File(Assets.attacker2));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}