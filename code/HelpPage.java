import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HelpPage extends JFrame {

    private JButton mainMenuButton;
    public JPanel buttonContainer;
    public JPanel nameContainer;
    public JLabel gameName;
    public JLabel helpText;
    public JPanel helpContainer;

    public HelpPage() {

        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("/Users/egurcay/Desktop/background.png")));
        setLayout(new BorderLayout(120,120));

        mainMenuButton = new JButton("MAIN MENU");
        mainMenuButton.setEnabled(true);
        mainMenuButton.setPreferredSize(new Dimension(100, 40));


        helpText = new JLabel("HOW TO DEFENDERS OF THE KINGDOM? ...");
        helpText.setDisplayedMnemonic(240);
        helpText.setFont(new Font(helpText.getFont().getName(), Font.ITALIC, 15));

        helpContainer = new JPanel();
        helpContainer.add(helpText);
        helpContainer.setBackground(new Color(0,0,0,0));

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
                new PauseMenu().setVisible(true);
                setVisible(false);
            }
        });

        add(nameContainer,BorderLayout.NORTH);
        add(helpContainer,BorderLayout.CENTER);
        add(buttonContainer,BorderLayout.SOUTH);
        setVisible(true);
        setSize(1280,720);
    }

    public void returnMainMenu() {
        new MainPageFrame().setVisible(true);
        this.setVisible(false);
        throw new UnsupportedOperationException();
    }

}