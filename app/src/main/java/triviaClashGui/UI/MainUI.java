package triviaClashGui.UI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton; 

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font; 

public class MainUI implements UIConstructor {
    JFrame mainFrame;
    Container mainContainer;
    JPanel titlePanel, buttonPanel;
    JLabel titleLabel;
    JButton playButton;

    Font titleFont = new Font("Times New Roman", Font.BOLD, 40);
    Font buttonFont = new Font("serif", Font.BOLD, 20);
    
    @Override
    public void construct() {
        initializeWindow();
        initializeComponents();
        mainFrame.add(titlePanel);
        mainFrame.add(buttonPanel);
    }
    
    @Override
    public void destroy() {
    
    }

    @Override 
    public void initializeWindow() {
        mainFrame = new JFrame("Trivia Clash!");
        mainContainer = mainFrame.getContentPane();

        mainContainer.setBackground(Color.BLACK);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(null);
        mainFrame.setSize(new Dimension(600, 500));
        mainFrame.setVisible(true);

    } 

    @Override
    public void initializeComponents() {
        
        // Title label and panel configuration
        titlePanel = new JPanel(new BorderLayout());
        titleLabel = new JLabel("Trivia Clash!", JLabel.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setBackground(Color.BLACK);
        titleLabel.setForeground(Color.WHITE);

        titlePanel.add(titleLabel);
        titlePanel.setBackground(Color.RED); // testing 
        titlePanel.setBounds(150, 150, 300, 50);
        titlePanel.add(titleLabel);
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setForeground(Color.WHITE);

        // Start button configuration 
        buttonPanel = new JPanel(new BorderLayout());
        playButton = new JButton("PLAY");
        playButton.setFont(buttonFont);
        playButton.setBackground(Color.BLACK);
        playButton.setForeground(Color.WHITE);
        playButton.setFocusPainted(false);

        buttonPanel.add(playButton);
        buttonPanel.setBackground(Color.BLUE); // testing
        buttonPanel.setBounds(250, 230, 100, 50);
        buttonPanel.add(playButton);
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setForeground(Color.WHITE);
    }
}
