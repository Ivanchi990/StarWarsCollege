import gui.console.MainInterface;
import gui.swing.views.MainView;

public class Main
{
    public static void main(String[] args)
    {
        //MainView view = new MainView();
        runApp();
    }

    private static void runApp()
    {
        MainInterface mainInterface = new MainInterface();

        mainInterface.startGame();
    }
}