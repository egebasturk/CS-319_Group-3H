
/**
 * MainFrame class
 * This class is the main frame of the game.
 * It displays displays all the panels such as HelpPage, CreditsPage.
 * @ author Emre Gürçay
 * @ version 04.11.2017
 */



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class MainFrame extends JFrame {

    private  MainPageFrame main;
    private  PauseMenu pause;
    private  CreditsPage credits = new  CreditsPage();
    private  HelpPage help;
    private BufferedImage img;
    private GameController gameController;

    public MainFrame()
    {
        setTitle("DEFENDERS OF THE KINGDOM");
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon(Assets.background)));
        setLayout(new BorderLayout(0,0));

        main = new  MainPageFrame();
        pause = new  PauseMenu();
        help = new  HelpPage();


        main.play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gameController = new GameController();
                setVisible(false);
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