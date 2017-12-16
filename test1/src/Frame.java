 /**
 * Basic JFrame adaptation
 * Frame where panels are put
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
    public static String title = "DEFENDERS OF THE KINGDOM";
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
