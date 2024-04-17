package entities;

import assets.data.enums.Side;

import java.util.ArrayList;

public class Player
{
    private Side team;
    private ArrayList<Ship> ships;
    private int points;
    private ArrayList<Message> playerLog;

    public Player(Side team, ArrayList<Ship> ships, int points, ArrayList<Message> playerLog)
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

    public ArrayList<Ship> getShips()
    {
        return ships;
    }

    public void setShips(ArrayList<Ship> ships)
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
