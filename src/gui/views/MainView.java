package gui.views;

import assets.data.ApplicationValues;

import javax.swing.*;
import java.awt.*;

public class MainView
{
    private JFrame window;
    private CardLayout cardLayout;

    //Views
    private FirstView firstView;

    public MainView()
    {
        configView();
        showFirstView();
    }

    public void configView()
    {
        window = new JFrame();
        cardLayout = new CardLayout();

        window.setTitle(ApplicationValues.APPLICATION_NAME);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon logoIcon = new ImageIcon(ApplicationValues.APPLICATION_LOGO_PATH);
        window.setIconImage(logoIcon.getImage());

        window.setLayout(cardLayout);

        firstView = new FirstView(this);
        window.add(firstView);

        window.pack();
        window.setVisible(true);
    }

    public void showFirstView()
    {
        cardLayout.show(window.getContentPane(), "firstView");
    }
}
