 /**
 * Pause Menu Class
 * This class is the pause page of the game.
 * @ author Emre Gürçay
 * @ version 04.11.2017
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PauseMenu extends JPanel {

    public JButton resumeButton;
    public JButton mainMenuButton;
    public JPanel buttonContainer;
    public JPanel nameContainer;
    public JLabel gameName;
    public JLabel paused;
    public JPanel centerPanel;
    private GameController game;
    public PauseMenu(GameController game) {

        this.game = game;
        setLayout(new BorderLayout());
        setOpaque(false);
        setLayout(new BorderLayout(120,120));

        resumeButton = new JButton("RESUME");
        resumeButton.setEnabled(true);
        resumeButton.setPreferredSize(new Dimension(100, 40));
        mainMenuButton = new JButton("MAIN MENU");
        mainMenuButton.setEnabled(true);
        mainMenuButton.setPreferredSize(new Dimension(100, 40));

        buttonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));

        gameName = new JLabel("DEFENDERS OF THE KINGDOM");
        gameName.setDisplayedMnemonic(240);
        gameName.setFont(new Font(gameName.getFont().getName(), Font.ITALIC, 45));

        paused = new JLabel("GAME PAUSED");
        paused.setDisplayedMnemonic(240);
        paused.setFont(new Font(gameName.getFont().getName(), Font.ITALIC, 20));;

        centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(Box.createRigidArea(new Dimension(0,66)));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        centerPanel.setBackground(new Color(0,0,0,0));

        centerPanel.add(paused);

        nameContainer = new JPanel(new BorderLayout());

        nameContainer.add(gameName,BorderLayout.CENTER);
        nameContainer.setBackground(new Color(0,0,0,0));

        buttonContainer.add(resumeButton);
        buttonContainer.add(mainMenuButton);
        buttonContainer.setBackground(new Color(0,0,0,0));

        centerPanel.add(buttonContainer);

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {}
        });

        resumeButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                resume();
            }
        });

        mainMenuButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                mainMenuButton.setForeground(new Color(0, 143, 255));
            }

            public void mouseExited(MouseEvent evt) {
                mainMenuButton.setForeground(Color.BLACK);
            }

            public void mousePressed(MouseEvent evt) {
                mainMenuButton.setBackground(new Color(0, 143, 255));
            }

            public void mouseReleased(MouseEvent evt) {
                mainMenuButton.setBackground(Color.BLACK);
            }
        });

        resumeButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                resumeButton.setForeground(new Color(0, 143, 255));
            }

            public void mouseExited(MouseEvent evt) {
                resumeButton.setForeground(Color.BLACK);
            }

            public void mousePressed(MouseEvent evt) {
                resumeButton.setBackground(new Color(0, 143, 255));
            }

            public void mouseReleased(MouseEvent evt) {
                resumeButton.setBackground(Color.BLACK);
            }
        });

        add(nameContainer,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);
        setVisible(true);
        setSize(GameMap.mapWidth,GameMap.mapHeight);
    }


    public void resume() {
        game.resumeGame();
    }


}