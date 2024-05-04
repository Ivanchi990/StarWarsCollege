package gui.views;

import assets.data.ApplicationValues;
import gui.Controller;

import javax.swing.*;
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
        mainPanel.setLayout(new GridBagLayout());
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
        button.setFont(new Font("Arial", Font.BOLD, 30));
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
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(gameTitle, gbc);

        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 10);
        mainPanel.add(empireLogoLabel, gbc);

        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 10, 0, 0);
        mainPanel.add(rebelLogoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        mainPanel.add(newGameButton, gbc);

        gbc.gridy = 2;
        mainPanel.add(continueButton, gbc);

        gbc.gridy = 3;
        mainPanel.add(instructionsButton, gbc);

        gbc.gridy = 4;
        mainPanel.add(exitButton, gbc);

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
