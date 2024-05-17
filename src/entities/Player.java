package entities;

import assets.data.enums.Side;
import entities.ships.Ship;
import exceptions.NotEnoughEnergyException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Player implements Serializable
{
    private Side team;
    private TreeMap<Coordinates, Ship> ships;
    private int points;
    private ArrayList<Message> playerLog;

    public Player(Side team, int points)
    {
        this.team = team;
        this.ships = new TreeMap<>();
        this.points = points;
        this.playerLog = new ArrayList<>();
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

    public void addShip(Coordinates coordinates, Ship ship)
    {
        ships.put(coordinates, ship);
    }

    public void updatePoints(int i)
    {
        this.points += i;
    }

    public void addMessage(Message message)
    {
        playerLog.add(message);
    }

    public Ship getShip(Coordinates coordinates)
    {
        if(ships.containsKey(coordinates))
        {
            return ships.get(coordinates);
        }
        else
        {
            return null;
        }
    }

    public void removeShip(Coordinates coordinates)
    {
       Ship shipToRemove = ships.get(coordinates);
       ArrayList<Coordinates> coordinatesToRemove = new ArrayList<>();

        for (Map.Entry<Coordinates, Ship> entry : ships.entrySet())
        {

            if (entry.getValue().equals(shipToRemove))
            {
                coordinatesToRemove.add(entry.getKey());
            }
        }

        for (Coordinates c : coordinatesToRemove)
        {
            ships.remove(c);
        }
    }

    public void notifyDestruction(Ship ship)
    {

    }

    public void moveShip(Ship shipName, Coordinates coordinates) throws NotEnoughEnergyException
    {
        shipName.move(coordinates);
    }

    public void updateShips()
    {
        for (Map.Entry<Coordinates, Ship> entry : ships.entrySet())
        {
            if(entry.getValue().getCrewMembers().isEmpty())
            {
                removeShip(entry.getKey());
            }
        }
    }
}