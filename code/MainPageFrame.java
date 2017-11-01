import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainPageFrame extends JFrame {

    public JButton help;
    public JButton credits;
    public JButton play;
    public JButton level1;
    public JButton level2;
    public JButton level3;
    public JButton level4;
    public JButton level5;
    public JPanel levelContainer;
    public JPanel starContainer;
    public JPanel buttonContainer;
    public JPanel playButtonContainer;
    public JPanel nameContainer;
    public JLabel gameName;
    public int levelNumber;


    public MainPageFrame()
    {
        //new ImageIcon("/Users/egurcay/Desktop/background.png");


        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("/Users/egurcay/Desktop/background.png")));
        setLayout(new BorderLayout(120,120));


        JLabel starPic = new JLabel(new ImageIcon("/Users/egurcay/Desktop/star.png"));
        starPic.setSize(50,50);



        // stars = new

        help = new JButton("HELP");
        help.setPreferredSize(new Dimension(100, 40));
        credits = new JButton("VIEW CREDITS");
        credits.setPreferredSize(new Dimension(100, 40));
        play = new JButton("PLAY");
        play.setPreferredSize(new Dimension(100, 40));
        level1 = new JButton("LEVEL 1");
        level1.setEnabled(false);
        level1.setPreferredSize(new Dimension(100, 40));
        level2 = new JButton("LEVEL 2");
        level2.setEnabled(false);
        level2.setPreferredSize(new Dimension(100, 40));
        level3 = new JButton("LEVEL 3");
        level3.setEnabled(false);
        level3.setPreferredSize(new Dimension(100, 40));
        level4 = new JButton("LEVEL 4");
        level4.setEnabled(false);
        level4.setPreferredSize(new Dimension(100, 40));
        level5 = new JButton("LEVEL 5");
        level5.setEnabled(false);
        level5.setPreferredSize(new Dimension(100, 40));

        levelContainer = new JPanel();
        starContainer = new JPanel(new BorderLayout());
        buttonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        playButtonContainer = new JPanel(new BorderLayout());
        nameContainer = new JPanel(new BorderLayout());

        gameName = new JLabel("DEFENDERS OF THE KINGDOM");
        gameName.setDisplayedMnemonic(120);
        gameName.setFont(new Font(gameName.getFont().getName(), Font.ITALIC, 45));

        nameContainer.add(gameName,BorderLayout.CENTER);
        nameContainer.setBackground(new Color(0,0,0,0));

        levelContainer.add(level1);
        levelContainer.add(level2);
        levelContainer.add(level3);
        levelContainer.add(level4);
        levelContainer.add(level5);
        levelContainer.setBackground(new Color(0,0,0,0)); //

        //checks wheter the levels are available to play
        for(int i = 1; i < 6; i++)
        {
            boolean available =  checkLevelAvailable(i);
            if(available)
            {
                if(i == 1)
                    level1.setEnabled(true);
                if(i == 2)
                    level2.setEnabled(true);
                if(i == 3)
                    level3.setEnabled(true);
                if(i == 4)
                    level4.setEnabled(true);
                if(i == 5)
                    level5.setEnabled(true);
            }

        }

        levelNumber = 0;
        level1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                levelNumber = 1;
                createStars(levelNumber);
                for(int i = 0; i < 3; i ++)
                {
                    levelContainer.add(starPic, i * 50);
                }

            }
        });
        level2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                levelNumber = 2;
                createStars(levelNumber);
            }
        });
        level3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                levelNumber = 3;
                createStars(levelNumber);
            }
        });
        level4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                levelNumber = 4;
                createStars(levelNumber);
            }
        });
        level5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                levelNumber = 5;
                createStars(levelNumber);
            }
        });

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playLevels(levelNumber);
            }
        });

        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HelpPage().setVisible(true);
                setVisible(false);
            }
        });

        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreditsPage().setVisible(true);
                setVisible(false);

            }
        });

        buttonContainer.add(help);
        buttonContainer.add(credits);
        buttonContainer.setBackground(new Color(0,0,0,0));

        playButtonContainer.add(play,BorderLayout.CENTER);
        playButtonContainer.setBackground(new Color(0,0,0,0));

        add(nameContainer,BorderLayout.NORTH);
        add(levelContainer,BorderLayout.CENTER);
        add(buttonContainer,BorderLayout.EAST);
        add(playButtonContainer,BorderLayout.SOUTH);
        setVisible(true);
        setSize(1280,720);

    }

    public int createStars(int level){
        ///Burada text32 filedan yıldız sayısı gelmesi lazım
        return 0;
    }

    public boolean checkLevelAvailable(int level)
    {
        if(level == 1){
            return true;
        }
        else {
            if (createStars((level - 1)) == 0) {
                return false;
            } else return true;
        }
    }

    public void playLevels(int level)
    {
        //İstenilen bölüm oynanıcak
    }


}















































