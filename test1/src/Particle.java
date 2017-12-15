/**
 * Particle implementation
 * Implements particle objects which are stored in a list to be drawn
 * @ author Alp Ege Basturk
 * @ version 14.12.2017
 *   version2 15.12.2017
 */
import java.awt.*;

public class Particle extends GameObject
{
    enum ParticleTypes {line, circle};
    double sourceXPos, sourceYPos, targetXPos, targetYPos;
    double velocity;
    int timer;
    final int baseTimer = 100;
    final int targetPadding = 20;
    final int sourcePadding = 20;
    GameMap currentGameMap;
    ParticleTypes particleType;
    double range;
    public Particle( double sourceXPos, double sourceYPos, double targetXPos, double targetYPos, GameMap currentGameMap,
                     ParticleTypes particleType, double range)
    {
        this.timer = baseTimer;
        this.currentGameMap = currentGameMap;
        this.particleType = particleType;
        this.range = range;
        this.sourceXPos = sourceXPos;
        this.sourceYPos = sourceYPos;
        this.targetXPos = targetXPos;
        this.targetYPos = targetYPos;
    }


    public void draw(Graphics g)
    {
        if ( timer < 0)
        {
            currentGameMap.notifyDeath(this);
            //g.clearRect((int)sourceXPos, (int)sourceYPos, (int)targetXPos,(int)targetYPos);
            timer = baseTimer;
        }
        else
        {
            if ( particleType == ParticleTypes.line)
            {
                g.setColor(Color.red);
                g.drawLine((int) sourceXPos + sourcePadding, (int) sourceYPos + sourcePadding,
                        (int) targetXPos + targetPadding, (int) targetYPos + targetPadding);
            }
            else if ( particleType == ParticleTypes.circle)
            {
                g.setColor(Color.red);
                g.drawOval((int) (sourceXPos - range / 2) + sourcePadding, (int) (sourceYPos - range / 2) +sourcePadding,
                        (int)range, (int) range);
            }
            timer--;
        }
    }
}
