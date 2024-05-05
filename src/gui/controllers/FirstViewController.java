package gui.controllers;

import gui.views.FirstView;
import gui.views.MainView;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstViewController implements ActionListener
{
    private MainView mainView;
    private FirstView view;

    public FirstViewController(FirstView view, MainView mainView)
    {
        this.view = view;
        this.mainView = mainView;
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
        mainView.showFirstView();
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
        int ans = JOptionPane.showConfirmDialog(this.view, "¿Estás seguro?", "Salir", 0, 1);

        if(ans == 0)
        {
            System.exit(0);
        }
    }
}

