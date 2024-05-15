package entities;

import assets.data.enums.Side;
import entities.ships.Ship;
import exceptions.NotEnoughEnergyException;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Player
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

    public boolean shoot(Player reciever, Coordinates coordinates, Ship shooter) throws NotEnoughEnergyException {
        boolean hitted = false;

        if(reciever != null)
        {
            shooter.shoot(reciever, coordinates);
        }

        return hitted;
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

    public void removeShip(Ship ship)
    {
        ArrayList<Coordinates> coordinatesToRemove = new ArrayList<>();

        for (Map.Entry<Coordinates, Ship> entry : ships.entrySet())
        {
            if (entry.getValue().equals(ship))
            {
                coordinatesToRemove.add(entry.getKey());
            }
        }

        for (Coordinates c : coordinatesToRemove)
        {
            ships.remove(c);
        }
    }
}