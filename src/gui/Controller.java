package gui;

import gui.views.MainView;

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
            case "Nueva partida":
                createNewGame();
                break;
            case "Continuar partida":
                continueGame();
                break;
            case "Instrucciones":
                showInstructions();
                break;
            case "Salir":
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
        JOptionPane.showMessageDialog(null, "", "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
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

