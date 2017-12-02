/**
 * HelpPage class
 * This class has the properties of HelpPage on JPanel.
 * It displays the contents.
 * @ author Emre Gürçay
 * @ version 04.11.2017
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class HelpPage extends JPanel {

    protected JButton mainMenuButton;
    private JPanel buttonContainer;
    private JPanel nameContainer;
    private JLabel gameName;
    private JLabel helpText;
    private JLabel construction;
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

        construction = new JLabel("     UNDER CONSTRUCTION ;)");
        construction.setDisplayedMnemonic(240);
        construction.setFont(new Font(helpText.getFont().getName(), Font.ITALIC, 18));

        helpContainer = new JPanel();
        helpContainer.setLayout(new BoxLayout(helpContainer, BoxLayout.PAGE_AXIS));
        helpContainer.add(Box.createRigidArea(new Dimension(0,2)));
        helpContainer.setBorder(BorderFactory.createEmptyBorder(40,500,40,0));
        helpContainer.setBackground(new Color(0,0,0,0));
        helpContainer.add(helpText);
        helpContainer.add(construction);

        buttonContainer = new JPanel();

        gameName = new JLabel("DEFENDERS OF THE KINGDOM");
        gameName.setDisplayedMnemonic(241);
        gameName.setFont(new Font(gameName.getFont().getName(), Font.ITALIC, 45));

        nameContainer = new JPanel(new BorderLayout());

        nameContainer.add(gameName,BorderLayout.CENTER);
        nameContainer.setBackground(new Color(0,0,0,0));

        buttonContainer.add(mainMenuButton);
        buttonContainer.setBackground(new Color(0,0,0,0));

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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


        add(nameContainer,BorderLayout.NORTH);
        add(helpContainer,BorderLayout.CENTER);
        add(buttonContainer,BorderLayout.SOUTH);
        setVisible(true);
        setSize(1280,720);
    }



}