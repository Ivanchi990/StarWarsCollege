package entities;

import entities.locations.Location;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable
{
    private Player player1;
    private Player player2;
    private int round;
    private Location location;
    private ArrayList<Message> gameLog;

    public Game(Player player1, Player player2, int round, Location location, ArrayList<Message> gameLog)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.round = round;
        this.location = location;
        this.gameLog = gameLog;
    }

    public Player getPlayer1()
    {
        return player1;
    }

    public void setPlayer1(Player player1)
    {
        this.player1 = player1;
    }

    public Player getPlayer2()
    {
        return player2;
    }

    public void setPlayer2(Player player2)
    {
        this.player2 = player2;
    }

    public int getRound()
    {
        return round;
    }

    public void setRound(int round)
    {
        this.round = round;
    }

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public ArrayList<Message> getGameLog()
    {
        return gameLog;
    }

    public void setGameLog(ArrayList<Message> gameLog)
    {
        this.gameLog = gameLog;
    }
}
