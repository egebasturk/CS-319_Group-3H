import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {

    public MainPageFrame main;
    public PauseMenu pause;
    public CreditsPage credits;
    public  HelpPage help;

    public MainFrame()
    {
        setTitle("DEFENDERS OF THE KINGDOM");
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("/Users/egurcay/Desktop/background.png")));
        setLayout(new BorderLayout(0,0));

        main = new MainPageFrame();
        pause = new PauseMenu();
        credits = new CreditsPage();
        help = new HelpPage();



        main.play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                add(pause,BorderLayout.CENTER);
                pause.setVisible(true);
            }
        });
        main.help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                add(help,BorderLayout.CENTER);
                help.setVisible(true);
            }
        });

        main.credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setVisible(false);
                add(credits,BorderLayout.CENTER);
                credits.setVisible(true);
            }
        });

        credits.mainMenuButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            credits.setVisible(false);
            add(main,BorderLayout.CENTER);
            main.setVisible(true);
        }
         });

        help.mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                help.setVisible(false);
                add(main,BorderLayout.CENTER);
                main.setVisible(true);
            }
        });

        pause.mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pause.setVisible(false);
                add(main,BorderLayout.CENTER);
                main.setVisible(true);
            }
        });



        add(main,BorderLayout.CENTER);

        setVisible(true);
        setSize(1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



}