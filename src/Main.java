import gui.Controller;
import gui.MainView;

public class Main
{
    public static void main(String[] args)
    {
        MainView view = new MainView();

        Controller manager = new Controller(view);

        view.event(manager);
    }
}