package gui;

import assets.data.ApplicationValues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView
{
    protected JFrame window;

    //Introducction stuff
    private JPanel mainPanel;
    private JLabel gameTitle;
    private ImageIcon empireLogo;
    private JLabel empireLogoLabel;
    private ImageIcon rebelLogo;
    private JLabel rebelLogoLabel;
    private JButton newGameButton;
    private JButton continueButton;
    private JButton instructionsButton;
    private JButton exitButton;


    public MainView()
    {
        createItems();
        placeItems();
    }

    private void createItems()
    {
        window = new JFrame(ApplicationValues.APPLICATION_NAME);
        ImageIcon logoIcon = new ImageIcon(ApplicationValues.APPLICATION_LOGO_PATH);
        window.setIconImage(logoIcon.getImage());

        createIntroductionStuff();
    }

    private void placeItems()
    {
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setResizable(true);

        placeIntroductionStuff();

        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
    }

    public void createIntroductionStuff()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4,2));
        mainPanel.setBackground(ApplicationValues.BACKGROUND_COLOR);

        gameTitle = new JLabel(ApplicationValues.APPLICATION_NAME);
        gameTitle.setFont(new Font("Arial", Font.BOLD, 40));
        gameTitle.setForeground(Color.BLACK);

        empireLogo = new ImageIcon(ApplicationValues.EMPIRE_LOGO_PATH);
        rebelLogo = new ImageIcon(ApplicationValues.REBEL_LOGO_PATH);

        empireLogoLabel = new JLabel(new ImageIcon(empireLogo.getImage().getScaledInstance(100, 100, 1)));

        rebelLogoLabel = new JLabel(new ImageIcon(rebelLogo.getImage().getScaledInstance(100, 100, 1)));

        newGameButton = createCustomButton("Nueva partida");
        continueButton = createCustomButton("Continuar partida");
        instructionsButton = createCustomButton("Instrucciones");
        exitButton = createCustomButton("Salir");
    }


    private JButton createCustomButton(String text) {
        JButton button = new JButton(text);

        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBorder(new LineBorder(Color.WHITE, 2));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.DARK_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.BLACK);
            }
        });

        return button;
    }

    public void placeIntroductionStuff()
    {
        mainPanel.add(gameTitle);
        mainPanel.add(new JLabel());

        mainPanel.add(empireLogoLabel);
        mainPanel.add(rebelLogoLabel);

        mainPanel.add(newGameButton);
        mainPanel.add(continueButton);
        mainPanel.add(instructionsButton);
        mainPanel.add(exitButton);

        window.add(mainPanel);
    }

    public void event(Controller manager)
    {
        window.setVisible(true);

        setEventsIntroductionStuff(manager);
    }

    private void setEventsIntroductionStuff(Controller manager)
    {
        newGameButton.addActionListener(manager);
        continueButton.addActionListener(manager);
        instructionsButton.addActionListener(manager);
        exitButton.addActionListener(manager);
    }
}
