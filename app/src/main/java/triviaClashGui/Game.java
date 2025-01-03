package triviaClashGui;

import triviaClashGui.UI.MainUI;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.CardLayout; 
import java.awt.Dimension;

public class Game {
    private JPanel currentPanel, mainPanel, gameMenuPanel;
    private JFrame mainFrame;
    private CardLayout cl;

    public Game() {
        initializeWindow();
        currentPanel = new JPanel();
        currentPanel.setLayout(new CardLayout());
        
        MainUI ui = new MainUI();
        ui.construct(); 
        mainPanel = (JPanel)ui.getPanel();
        currentPanel.add(mainPanel, "main"); 
        cl = (CardLayout)currentPanel.getLayout();
        cl.show(currentPanel, "main");
        mainFrame.add(currentPanel);
    }

    private void initializeWindow() {
        mainFrame = new JFrame("Trivia Clash!");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new CardLayout());
        mainFrame.setMinimumSize(new Dimension(600, 500));
        mainFrame.setMaximumSize(new Dimension(800, 700));
        mainFrame.setResizable(true);
        mainFrame.setVisible(true);
    } 
}
