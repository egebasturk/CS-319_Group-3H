/**
 * HelpPage class
 * This class has the properties of HelpPage on JPanel.
 * It displays the contents.
 * @ author Emre Gürçay
 * @ version 04.11.2017
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class HelpPage extends JPanel {

    protected JButton mainMenuButton;
    private JPanel buttonContainer;
    private JPanel nameContainer;
    private JLabel gameName;
    private JLabel helpText;
    private JLabel description;
    private JLabel singleAttackTowerDescription;
    private JLabel areaAttackTowerDescription;
    private JLabel heroDescription;
    private JLabel buttonInfo;
    private JLabel updateMoneyInfo;
    private JLabel enjoy;
    private JPanel helpContainer;

    public HelpPage() {

        setLayout(new BorderLayout());
        setOpaque(false);
        setLayout(new BorderLayout(120,120));

        mainMenuButton = new JButton("MAIN MENU");
        mainMenuButton.setEnabled(true);
        mainMenuButton.setPreferredSize(new Dimension(100, 40));

        helpText = new JLabel("HOW TO DEFEND THE KINGDOM? ...");
        helpText.setDisplayedMnemonic(240);
        helpText.setFont(new Font(helpText.getFont().getName(), Font.ITALIC, 18));
        helpText.setForeground(Color.white);

        description = new JLabel("You can use attack towers and heroes to defend your kingdom from enemy invasion.");
        description.setDisplayedMnemonic(240);
        description.setFont(new Font(description.getFont().getName(),Font.ITALIC, 15));
        description.setForeground(Color.white);

        singleAttackTowerDescription = new JLabel("Single attack towers can attack a single enemy by firing their weapons,");
        singleAttackTowerDescription.setDisplayedMnemonic(240);
        singleAttackTowerDescription.setFont(new Font(singleAttackTowerDescription.getFont().getName(),Font.ITALIC, 15));
        singleAttackTowerDescription.setForeground(Color.white);

        areaAttackTowerDescription = new JLabel("whereas area attack towers can attack enemies in their range circle, which means a catastrophe for your enemy.");
        areaAttackTowerDescription.setDisplayedMnemonic(240);
        areaAttackTowerDescription.setFont(new Font(areaAttackTowerDescription.getFont().getName(),Font.ITALIC, 15));
        areaAttackTowerDescription.setForeground(Color.white);



        heroDescription = new JLabel("Heroes can guard your castle and combat with your enemies. There are 2 types of heroes with different strength.");
        heroDescription.setDisplayedMnemonic(240);
        heroDescription.setFont(new Font(heroDescription.getFont().getName(),Font.ITALIC, 15));
        heroDescription.setForeground(Color.white);

        buttonInfo = new JLabel("You can use the buttons on the right to buy your desired tower or hero. Your selected item will be placed wherever you click on the map.");
        buttonInfo.setDisplayedMnemonic(240);
        buttonInfo.setFont(new Font(buttonInfo.getFont().getName(),Font.ITALIC, 15));
        buttonInfo.setForeground(Color.white);

        updateMoneyInfo = new JLabel("You can sell an item by pressing the money button and upgrade an item by pressing the arrow button.");
        updateMoneyInfo.setDisplayedMnemonic(240);
        updateMoneyInfo.setFont(new Font(updateMoneyInfo.getFont().getName(),Font.ITALIC, 15));
        updateMoneyInfo.setForeground(Color.white);

        enjoy = new JLabel("HAVE FUN!");
        enjoy.setDisplayedMnemonic(240);
        enjoy.setFont(new Font(enjoy.getFont().getName(),Font.ITALIC, 16));
        enjoy.setForeground(Color.white);

        helpContainer = new JPanel();
        helpContainer.setLayout(new BoxLayout(helpContainer, BoxLayout.PAGE_AXIS));
        helpContainer.add(Box.createRigidArea(new Dimension(0,7)));
        helpContainer.setBorder(BorderFactory.createEmptyBorder(40,150,40,0));
        helpContainer.setBackground(new Color(0,0,0,0));
        helpContainer.add(helpText);
        helpContainer.add(description);
        helpContainer.add(singleAttackTowerDescription);
        helpContainer.add(areaAttackTowerDescription);
        helpContainer.add(heroDescription);
        helpContainer.add(buttonInfo);
        helpContainer.add(updateMoneyInfo);
        helpContainer.add(enjoy);

        buttonContainer = new JPanel();

        gameName = new JLabel("DEFENDERS OF THE KINGDOM");
        gameName.setDisplayedMnemonic(241);
        gameName.setFont(new Font(gameName.getFont().getName(), Font.ITALIC, 45));

        nameContainer = new JPanel(new BorderLayout());

        nameContainer.add(gameName,BorderLayout.CENTER);
        nameContainer.setBackground(new Color(0,0,0,0));

        buttonContainer.add(mainMenuButton);
        buttonContainer.setBackground(new Color(0,0,0,0));


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


        add(nameContainer,BorderLayout.NORTH);
        add(helpContainer,BorderLayout.CENTER);
        add(buttonContainer,BorderLayout.SOUTH);
        setVisible(true);
        setSize(1280,720);
    }



}