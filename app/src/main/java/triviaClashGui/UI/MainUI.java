package triviaClashGui.UI;

import triviaClashGui.util.UIConstructor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton; 
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;
import java.awt.Component;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font; 

public class MainUI implements UIConstructor {
    private Container mainContainer;
    private JPanel mainUIPanel;
    private JPanel titlePanel;
    private JPanel buttonPanel, additionalButtonPanel;
    private JPanel holderPanel;
    
    private JLabel titleLabel;
    private JButton playButton, exitButton;
    private JButton singlePlayerButton, multiPlayerButton, helpButton, backButton;

    private GridLayout menuButtonLayout = new GridLayout(4, 1);
    private GridLayout additionalMenuButtonLayout = new GridLayout(4, 1);
    private GridLayout mainUIlayout = new GridLayout(2, 1);
    private CardLayout cl;

    private Font titleFont = new Font("monospaced", Font.BOLD, 50);
    private Font buttonFont = new Font("serif", Font.BOLD, 20);    
    
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
        mainUIlayout.setVgap(10);
        mainUIlayout.setHgap(50);
        mainUIPanel = new JPanel(mainUIlayout);
       
        holderPanel = new JPanel();
        holderPanel.setLayout(new CardLayout());

        cl = (CardLayout)holderPanel.getLayout();
        mainUIPanel.setBackground(Color.BLACK);
    } 

    @Override
    public void initializeComponents() {
        
        // Title label and panel configuration
        titlePanel = new JPanel(new BorderLayout(50, 50));
        titleLabel = new JLabel("Trivia Clash!", JLabel.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.ORANGE);
        titlePanel.add(titleLabel);
        titlePanel.setBackground(Color.BLACK);
        titlePanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10))); 
        // Start button configuration 
        menuButtonLayout.setVgap(5);
        menuButtonLayout.setHgap(60);
        
        buttonPanel = new JPanel(menuButtonLayout);
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setSize(200, 80);
        buttonPanel.setForeground(Color.WHITE);
        buttonPanel.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));
       
        playButton = new JButton("PLAY");
        playButton.setFont(buttonFont);
        playButton.setBackground(Color.BLACK);
        playButton.setForeground(Color.WHITE);
        playButton.setFocusPainted(false);
        setPlayButtonAction();

        exitButton = new JButton("EXIT");
        exitButton.setFont(buttonFont);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.RED);
        exitButton.setFocusPainted(false);

        buttonPanel.add(playButton);
        buttonPanel.add(exitButton);
        
        additionalMenuButtonLayout.setHgap(60);
        additionalMenuButtonLayout.setVgap(5);

        additionalButtonPanel = new JPanel(additionalMenuButtonLayout);
        additionalButtonPanel.setBackground(Color.BLACK);
        additionalButtonPanel.setSize(200, 80);
        additionalButtonPanel.setForeground(Color.WHITE);
        additionalButtonPanel.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));

        
        singlePlayerButton = new JButton("SINGLE PLAYER");
        singlePlayerButton.setFont(buttonFont);
        singlePlayerButton.setBackground(Color.BLACK);
        singlePlayerButton.setForeground(Color.WHITE);
        singlePlayerButton.setFocusPainted(false);

        multiPlayerButton = new JButton("MULTI PLAYER");
        multiPlayerButton.setFont(buttonFont);
        multiPlayerButton.setBackground(Color.BLACK);
        multiPlayerButton.setForeground(Color.WHITE);
        multiPlayerButton.setFocusPainted(false);

        helpButton = new JButton("HELP");
        helpButton.setFont(buttonFont);
        helpButton.setBackground(Color.BLACK);
        helpButton.setForeground(Color.WHITE);
        helpButton.setFocusPainted(false);

        backButton = new JButton("BACK");
        backButton.setFont(buttonFont);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.BLUE);
        backButton.setFocusPainted(false);
        
        additionalButtonPanel.add(singlePlayerButton);
        additionalButtonPanel.add(multiPlayerButton);
        additionalButtonPanel.add(helpButton);
        additionalButtonPanel.add(backButton);
       
        holderPanel.add(buttonPanel);
        holderPanel.add(additionalButtonPanel);

        mainUIPanel.add(titlePanel);
        mainUIPanel.add(holderPanel); 
    }

    @Override 
    public Component getPanel() {
        return mainUIPanel;
    }

    private void setPlayButtonAction() {
        playButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent event) {
                    cl.next(holderPanel);
                }
            }         
        ); 
    }
}
