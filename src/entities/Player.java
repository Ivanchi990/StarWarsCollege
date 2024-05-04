package entities;

import assets.data.enums.Side;
import entities.ships.Ship;

import java.util.ArrayList;
import java.util.TreeMap;

public class Player
{
    private Side team;
    private TreeMap<Coordinates, Ship> ships;
    private int points;
    private ArrayList<Message> playerLog;

    public Player(Side team, TreeMap<Coordinates, Ship> ships, int points, ArrayList<Message> playerLog)
    {
        this.team = team;
        this.ships = ships;
        this.points = points;
        this.playerLog = playerLog;
    }

    public Side getTeam()
    {
        return team;
    }

    public void setTeam(Side team)
    {
        this.team = team;
    }

    public TreeMap<Coordinates, Ship> getShips()
    {
        return ships;
    }

    public void setShips(TreeMap<Coordinates, Ship> ships)
    {
        this.ships = ships;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public ArrayList<Message> getPlayerLog()
    {
        return playerLog;
    }

    public void setPlayerLog(ArrayList<Message> playerLog)
    {
        this.playerLog = playerLog;
    }
}
