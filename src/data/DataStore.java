package data;

import entities.Game;

import java.io.*;

public class DataStore
{
    public DataStore()
    {

    }

    public void saveData(Game game)
    {
        try
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(game);
            oos.close();

            FileOutputStream fos = new FileOutputStream("gameData.bin");
            fos.write(baos.toByteArray());
            fos.close();
        }
        catch (IOException i)
        {
            System.err.println("Error: " + i.getMessage());
        }
    }

    public Game loadData(String name)
    {
        Game game = null;
        try
        {
            FileInputStream fis = new FileInputStream(name);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            fis.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            ObjectInputStream ois = new ObjectInputStream(bais);
            game = (Game) ois.readObject();
            ois.close();
        }
        catch (IOException i)
        {
            System.err.println("Error: " + i.getMessage());
        }
        catch (ClassNotFoundException c)
        {
            System.err.println("Error: " + c.getMessage());
        }

        return game;
    }
}
