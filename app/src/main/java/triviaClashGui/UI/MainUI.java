package triviaClashGui.UI;

import triviaClashGui.util.UIConstructor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton; 

import java.awt.Component;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font; 

public class MainUI implements UIConstructor {
    Container mainContainer;
    JPanel titlePanel, buttonPanel, mainUIPanel;
    JLabel titleLabel;
    JButton playButton, exitButton;
    GridLayout menuButtonLayout = new GridLayout(2, 1);

    Font titleFont = new Font("monospaced", Font.BOLD, 50);
    Font buttonFont = new Font("serif", Font.BOLD, 20);
    
    @Override
    public void construct() {
        initializeWindow();
        initializeComponents();
    }
    
    @Override
    public void destroy() {
        mainContainer.setVisible(false); 
    }

    @Override 
    public void initializeWindow() {
        mainUIPanel = new JPanel(null);
        
        mainUIPanel.setBackground(Color.BLACK);
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
        titlePanel.setBounds(100, 90, 400, 50);
        titlePanel.add(titleLabel);
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setForeground(Color.WHITE);

        // Start button configuration 
        menuButtonLayout.setVgap(3);
        buttonPanel = new JPanel(menuButtonLayout);
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBackground(Color.BLACK); // testing
        buttonPanel.setBounds(200, 230, 200, 80);
        buttonPanel.setForeground(Color.WHITE);

        playButton = new JButton("PLAY");
        playButton.setFont(buttonFont);
        playButton.setBackground(Color.BLACK);
        playButton.setForeground(Color.WHITE);
        playButton.setFocusPainted(false);

        exitButton = new JButton("EXIT");
        exitButton.setFont(buttonFont);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.RED);
        exitButton.setFocusPainted(false);

        buttonPanel.add(playButton);
        buttonPanel.add(exitButton);

        mainUIPanel.add(buttonPanel);
        mainUIPanel.add(titlePanel);
    }

    @Override 
    public Component getPanel() {
        return mainUIPanel;
    }
}
