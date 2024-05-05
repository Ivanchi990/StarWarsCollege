package gui.views;

import assets.data.ApplicationValues;
import gui.controllers.FirstViewController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FirstView extends JPanel
{
    //Introducction stuff
    private JLabel gameTitle;
    private ImageIcon empireLogo;
    private JLabel empireLogoLabel;
    private ImageIcon rebelLogo;
    private JLabel rebelLogoLabel;
    private JButton newGameButton;
    private JButton continueButton;
    private JButton instructionsButton;
    private JButton exitButton;

    public FirstView(MainView mainView)
    {
        createItems();
        placeItems();
        setEventsIntroductionStuff(new FirstViewController(this, mainView));
    }


    private void createItems()
    {
        this.setLayout(new GridBagLayout());
        this.setBackground(ApplicationValues.BACKGROUND_COLOR);

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


    private void placeItems()
    {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(gameTitle, gbc);

        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 0, 10);
        this.add(empireLogoLabel, gbc);

        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0, 10, 0, 0);
        this.add(rebelLogoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);
        this.add(newGameButton, gbc);

        gbc.gridy = 2;
        this.add(continueButton, gbc);

        gbc.gridy = 3;
        this.add(instructionsButton, gbc);

        gbc.gridy = 4;
        this.add(exitButton, gbc);
    }


    private JButton createCustomButton(String text)
    {
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


    private void setEventsIntroductionStuff(FirstViewController manager)
    {
        newGameButton.addActionListener(manager);
        continueButton.addActionListener(manager);
        instructionsButton.addActionListener(manager);
        exitButton.addActionListener(manager);
    }
}
