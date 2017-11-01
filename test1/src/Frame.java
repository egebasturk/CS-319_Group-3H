import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
    public static String title = "Game";
    //public static Dimension dim = new Dimension(700,700);
    
    public Frame()
    {
        setTitle(title);
        //setSize(dim);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
