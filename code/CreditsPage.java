import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CreditsPage extends JFrame {

    private JButton mainMenuButton;
    public JPanel buttonContainer;
    public JPanel nameContainer;
    public JLabel gameName;
    public JLabel creditsText;
    public JLabel ALP;
    public JLabel BARIS;
    public JLabel EMRE;
    public JLabel OYKU;
    public JLabel GITHUB;
    public JPanel credits;

    public CreditsPage() {

        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("/Users/egurcay/Desktop/background.png")));
        setLayout(new BorderLayout(120,120));

        mainMenuButton = new JButton("MAIN MENU");
        mainMenuButton.setEnabled(true);
        mainMenuButton.setPreferredSize(new Dimension(100, 40));


        creditsText = new JLabel("CREDITS...");
        creditsText.setDisplayedMnemonic(240);
        creditsText.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 30));

        ALP = new JLabel("ALP EGE BAŞTÜRK");
        ALP.setDisplayedMnemonic(240);
        ALP.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 20));

        BARIS = new JLabel("BARIŞ EYMÜR");
        BARIS.setDisplayedMnemonic(240);
        BARIS.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 20));

        EMRE = new JLabel("EMRE GÜRÇAY");
        EMRE.setDisplayedMnemonic(240);
        EMRE.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 20));

        OYKU = new JLabel("ÖYKÜ ECE AYAZ");
        OYKU.setDisplayedMnemonic(240);
        OYKU.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 20));

        GITHUB = new JLabel("https://github.com/egebasturk/CS-319_Group-3H");
        GITHUB.setDisplayedMnemonic(240);
        GITHUB.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 20));

        credits = new JPanel();
        credits.setLayout(new BoxLayout(credits, BoxLayout.PAGE_AXIS));
        credits.add(Box.createRigidArea(new Dimension(0,5)));
        credits.setBorder(BorderFactory.createEmptyBorder(40,500,40,0));
        credits.add(creditsText);
        credits.add(ALP);
        credits.add(BARIS);
        credits.add(EMRE);
        credits.add(OYKU);
        credits.add(GITHUB);
        credits.setBackground(new Color(0,0,0,0));

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
                returnMainMenu();
            }
        });

        add(nameContainer,BorderLayout.NORTH);
        add(credits,BorderLayout.CENTER);
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