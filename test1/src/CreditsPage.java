/**
 * CreditsPage class
 * This class has the properties of CredistsPage on JPanel.
 * @ author Emre Gürçay
 * @ version 04.11.2017
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class CreditsPage extends JPanel {

    protected JButton mainMenuButton;
    private JPanel buttonContainer;
    private JPanel nameContainer;
    private JLabel gameName;
    private JLabel creditsText;
    private JLabel group;
    private JLabel ALP;
    private JLabel BARIS;
    private JLabel EMRE;
    private JLabel OYKU;
    private JLabel GITHUB;
    private JPanel credits;

    public CreditsPage() {

        setLayout(new BorderLayout());
        setOpaque(false);
        setLayout(new BorderLayout(120,120));

        mainMenuButton = new JButton("MAIN MENU");
        mainMenuButton.setEnabled(true);
        mainMenuButton.setPreferredSize(new Dimension(100, 40));


        creditsText = new JLabel("CREDITS...");
        creditsText.setDisplayedMnemonic(240);
        creditsText.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 30));
        creditsText.setForeground(Color.white);

        group = new JLabel("GROUP 3-H ");
        group.setDisplayedMnemonic(240);
        group.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 25));
        group.setForeground(Color.lightGray);


        ALP = new JLabel("ALP EGE BAŞTÜRK ");
        ALP.setDisplayedMnemonic(240);
        ALP.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 20));
        ALP.setForeground(Color.white);

        BARIS = new JLabel("BARIŞ EYMÜR ");
        BARIS.setDisplayedMnemonic(240);
        BARIS.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 20));
        BARIS.setForeground(Color.white);

        EMRE = new JLabel("EMRE GÜRÇAY ");
        EMRE.setDisplayedMnemonic(240);
        EMRE.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 20));
        EMRE.setForeground(Color.white);

        OYKU = new JLabel("ÖYKÜ ECE AYAZ ");
        OYKU.setDisplayedMnemonic(240);
        OYKU.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 20));
        OYKU.setForeground(Color.white);

        GITHUB = new JLabel("<html> PROJECT WEBSITE : <a href=\"\">https://github.com/egebasturk/CS-319_Group-3H/</a></html>");
        GITHUB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        GITHUB.setDisplayedMnemonic(240);
        GITHUB.setFont(new Font(creditsText.getFont().getName(), Font.ITALIC, 15));
        GITHUB.setForeground(Color.white);

        credits = new JPanel();
        credits.setLayout(new BoxLayout(credits, BoxLayout.PAGE_AXIS));
        credits.add(Box.createRigidArea(new Dimension(0,2)));
        credits.setBorder(BorderFactory.createEmptyBorder(40,500,40,0));
        credits.add(creditsText);
        credits.add(group);
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

      /*  mainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }); */

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

        open(GITHUB);

        add(nameContainer,BorderLayout.NORTH);
        add(credits,BorderLayout.CENTER);
        add(buttonContainer,BorderLayout.SOUTH);
        setVisible(true);
        setSize(1280,720);
    }

    private void open(JLabel website) {
        website.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/egebasturk/CS-319_Group-3H/"));
                } catch (URISyntaxException | IOException ex) {
                    //Not connected
                }
            }
        });
    }

}