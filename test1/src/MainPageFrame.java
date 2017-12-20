/**
 * MainPageFrame class
 * This class is the main page of the game.
 * @ author Emre Gürçay
 * @ version 04.11.2017
 */


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class MainPageFrame extends JPanel {

    protected JButton help;
    protected JButton credits;
    protected JButton play;
    private JButton level1;
    private JButton level2;
    private JButton level3;
    private JButton level4;
    private JButton level5;
    private JPanel levelContainer;
    private JPanel buttonContainer;
    private JPanel playButtonContainer;
    private JPanel nameContainer;
    private BufferedImage starImage;
    private JLabel gameName;
    private int levelNumber;
    private int levelStar;
    private String txtFileString;
    private boolean playClicked;


    public MainPageFrame()
    {

        levelStar = 0;

        setLayout(new BorderLayout());
        setOpaque(false);
        setLayout(new BorderLayout(120,120));



        try {
            starImage = ImageIO.read(getClass().getResource(Assets.star));

        }
        catch (IOException e) {
            e.printStackTrace();
        }


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

        levelContainer = new JPanel();;
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
            levelStar = 0;
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

            }
        });
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        credits.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

            }
        });

        credits.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                credits.setForeground(new Color(0, 117, 191));
                repaint();
            }
            public void mouseExited(MouseEvent evt)
            {
                credits.setForeground(Color.BLACK);
                repaint();
            }
            public void mousePressed(MouseEvent evt)
            {
                credits.setBackground(new Color(0, 117, 191));
                repaint();
            }
            public void mouseReleased(MouseEvent evt)
            {
                credits.setBackground(Color.BLACK);
                repaint();
            }
        });

        help.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                help.setForeground(new Color(0, 117, 191));
                repaint();
            }
            public void mouseExited(MouseEvent evt)
            {
                help.setForeground(Color.BLACK);
                repaint();
            }
            public void mousePressed(MouseEvent evt)
            {
                help.setBackground(new Color(0, 117, 191));
                repaint();
            }
            public void mouseReleased(MouseEvent evt)
            {
                help.setBackground(Color.BLACK);
                repaint();
            }
        });
        play.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                play.setForeground(Color.red);
                repaint();
            }
            public void mouseExited(MouseEvent evt)
            {
                play.setForeground(Color.BLACK);
                repaint();
            }

        });
        level1.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                level1.setForeground(new Color(0, 117, 191));
                repaint();
            }
            public void mouseExited(MouseEvent evt)
            {
                level1.setForeground(Color.BLACK);
                repaint();
            }
            public void mousePressed(MouseEvent evt)
            {
                level1.setBackground(new Color(0, 117, 191));
                repaint();
            }
            public void mouseReleased(MouseEvent evt)
            {
                level1.setBackground(Color.BLACK);
                repaint();
            }
        });
        if(level2.isEnabled() == true) {
            level2.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent evt) {

                    level2.setForeground(new Color(0, 117, 191));
                    repaint();
                }

                public void mouseExited(MouseEvent evt) {
                    level2.setForeground(Color.BLACK);
                    repaint();
                }

                public void mousePressed(MouseEvent evt) {
                    level2.setBackground(new Color(0, 117, 191));
                    repaint();
                }

                public void mouseReleased(MouseEvent evt) {
                    level2.setBackground(Color.BLACK);
                    repaint();
                }
            });
        }
        if(level3.isEnabled() == true) {
            level3.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    level3.setForeground(new Color(0, 117, 191));
                    repaint();
                }

                public void mouseExited(MouseEvent evt) {
                    level3.setForeground(Color.BLACK);
                    repaint();
                }

                public void mousePressed(MouseEvent evt) {
                    level3.setBackground(new Color(0, 117, 191));
                    repaint();
                }

                public void mouseReleased(MouseEvent evt) {
                    level3.setBackground(Color.BLACK);
                    repaint();
                }
            });
        }
        if(level4.isEnabled() == true) {
            level4.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    level4.setForeground(new Color(0, 117, 191));
                    repaint();
                }

                public void mouseExited(MouseEvent evt) {
                    level4.setForeground(Color.BLACK);
                    repaint();
                }

                public void mousePressed(MouseEvent evt) {
                    level4.setBackground(new Color(0, 117, 191));
                    repaint();
                }

                public void mouseReleased(MouseEvent evt) {
                    level4.setBackground(Color.BLACK);
                    repaint();
                }
            });
        }
        if(level5.isEnabled() == true) {
            level5.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent evt) {
                    level5.setForeground(new Color(0, 117, 191));
                    repaint();
                }

                public void mouseExited(MouseEvent evt) {
                    level5.setForeground(Color.BLACK);
                    repaint();
                }

                public void mousePressed(MouseEvent evt) {
                    level5.setBackground(new Color(0, 117, 191));
                    repaint();
                }

                public void mouseReleased(MouseEvent evt) {
                    level5.setBackground(Color.BLACK);
                    repaint();
                }
            });
        }

        buttonContainer.add(help);
        buttonContainer.add(credits);
        buttonContainer.setBackground(new Color(0,0,0,0));

        playButtonContainer.add(play,BorderLayout.CENTER);
        playButtonContainer.setBackground(new Color(0,0,0,0));

        add(nameContainer,BorderLayout.NORTH);
        add(levelContainer,BorderLayout.CENTER);
        add(buttonContainer,BorderLayout.EAST);
        add(playButtonContainer,BorderLayout.SOUTH);
        //setVisible(true);
        setSize(1280,720);

    }

    private int createStars(int level){
        try {

            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(MainPage.class.getResourceAsStream(Assets.starTxt)));
            while((txtFileString = bufferedReader.readLine()) != null) {
                System.out.println(txtFileString);

                levelStar = Integer.parseInt(txtFileString.valueOf(txtFileString.charAt(level -1)));
            }

            bufferedReader.close();
        }
        catch(IOException ex) {

        }
        System.out.println(levelStar);
        return levelStar;
    }

    public void paintComponent(Graphics g)
    {
        if(levelStar == 3)
        {
            g.drawImage(starImage, 350, 250, 75,70,null);
            g.drawImage(starImage, 430, 250, 75,70,null);
            g.drawImage(starImage, 510, 250, 75,70,null);
        }
        else if (levelStar == 2)
        {
            g.drawImage(starImage, 395, 250, 75,70,null);
            g.drawImage(starImage, 475, 250, 75,70,null);
        }
        else if (levelStar == 1)
        {
            g.drawImage(starImage, 430, 250, 75,70,null);

        }
    }

    public boolean checkLevelAvailable(int level)
    {

        if(level == 1){
            return true;
        }
        else {
            if (createStars(level -1) == 0) {
                return false;
            } else return true;
        }
    }

    public void playLevels(int level)
    {
        //The desired level will be played
    }

    public int getLevelNumber() {
        return levelNumber;
    }

}















































