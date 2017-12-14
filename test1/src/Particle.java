import java.awt.*;

public class Particle extends GameObject
{
    double sourceXPos, sourceYPos, targetXPos, targetYPos;
    double velocity;
    int timer;
    final int baseTimer = 100;
    final int targetPadding = 20;
    final int sourcePadding = 20;
    GameMap currentGameMap;
    public Particle( double sourceXPos, double sourceYPos, double targetXPos, double targetYPos, GameMap currentGameMap)
    {
        this.timer = baseTimer;
        this.currentGameMap = currentGameMap;
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
            g.setColor(Color.red);
            g.drawLine((int) sourceXPos + sourcePadding, (int) sourceYPos + sourcePadding,
                    (int) targetXPos + targetPadding, (int) targetYPos + targetPadding);
            timer--;
        }
    }
}
