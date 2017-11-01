
// An AWT program inherits from the top-level container java.awt.Frame
import javax.swing.*;

//Main class
public class MainPage extends JFrame
{
    public static void main(String[] args)
    {
        JFrame game = new MainPageFrame();

        //Title will be shown at the top of the frame
        game.setTitle("DEFENDERS OF THE KINGDOM");


        // game.add(imgLabel);
        //Setting the size of the frame
        game.setSize(1280,720);

        //For closeing the frame
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);

    }
}
