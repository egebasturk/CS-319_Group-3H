import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseMenu extends JFrame {

    private JButton resumeButton;
    private JButton mainMenuButton;
    public JPanel buttonContainer;
    public JPanel nameContainer;
    public JLabel gameName;

    public PauseMenu() {

        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("/Users/egurcay/Desktop/background.png")));
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

        nameContainer = new JPanel(new BorderLayout());

        nameContainer.add(gameName,BorderLayout.CENTER);
        nameContainer.setBackground(new Color(0,0,0,0));

        buttonContainer.add(resumeButton);
        buttonContainer.add(mainMenuButton);
        buttonContainer.setBackground(new Color(0,0,0,0));

        mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnMainMenu();
            }
        });

        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resume();
            }
        });

        add(nameContainer,BorderLayout.NORTH);
        add(buttonContainer,BorderLayout.CENTER);
        setVisible(true);
        setSize(1280,720);
    }

    public void returnMainMenu() {
        new MainPageFrame().setVisible(true);
        this.setVisible(false);
        throw new UnsupportedOperationException();
    }

    public void resume() {

        throw new UnsupportedOperationException();
    }

}