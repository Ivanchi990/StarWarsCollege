package gui;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener
{
    private MainView view;

    public Controller(MainView view)
    {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand())
        {
            case "New Game":
                createNewGame();
                break;
            case "Continue":
                continueGame();
                break;
            case "Instructions":
                showInstructions();
                break;
            case "Exit":
                exitGame();
                break;
        }
    }

    private void createNewGame()
    {

    }

    private void continueGame()
    {

    }

    private void showInstructions()
    {

    }

    private void exitGame()
    {
        int ans = JOptionPane.showConfirmDialog(view.window, "¿Estás seguro?", "Salir", 0, 1);

        if(ans == 0)
        {
            System.exit(0);
        }
    }
}

