package gui;

import assets.data.ApplicationValues;

import javax.swing.*;

public class MainView
{
    private JFrame window;;

    public MainView()
    {
        createItems();
        placeItems();
    }

    private void createItems()
    {
        window = new JFrame(ApplicationValues.APPLICATION_NAME);
    }

    private void placeItems()
    {
        window.setSize(ApplicationValues.WINDOW_WIDTH, ApplicationValues.WINDOW_HEIGHT);
        window.setResizable(true);
    }

    public void event(Controller manager)
    {
        window.setVisible(true);
    }
}
