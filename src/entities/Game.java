package entities;

import assets.data.enums.Side;
import entities.locations.Location;
import entities.ships.Ship;
import exceptions.InvalidCoordenatesException;
import exceptions.NotEnoughEnergyException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Game implements Serializable
{
    private Player player1;
    private Player player2;
    private int round;
    private Location location;
    private TreeMap<Coordinates, Side> usedCoordinates;
    private ArrayList<Message> gameLog;
    private Side winner;

    public Game(Player player1, Player player2, int round, Location location)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.round = round;
        this.location = location;
        this.gameLog = new ArrayList<>();
        this.winner = null;
        this.usedCoordinates = new TreeMap<>();
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

    public Side getWinner()
    {
        return winner;
    }

    public void setWinner(Side winner)
    {
        this.winner = winner;
    }

    public void increaseRound() {
        this.round++;
    }

    public boolean isCoordenatesAvailable(Coordinates coordinates)
    {
        return !usedCoordinates.containsKey(coordinates);
    }

    public void addUsedCoordinates(Coordinates cor, Side team) {
        usedCoordinates.put(cor, team);
    }

    public void playerAttack(Side team, Coordinates coordinates, Ship ship) throws NotEnoughEnergyException
    {
        if(!isCoordenatesAvailable(coordinates))
        {
            int damage = ship.shoot();

            if(usedCoordinates.get(coordinates) != team)
            {
                Ship shipToAttack = null;

                if(player1.getTeam() == team)
                {
                    shipToAttack = player2.getShip(coordinates);
                }
                else
                {
                    shipToAttack = player1.getShip(coordinates);
                }

                givePoints(team, shipToAttack.recieveDamage(damage, coordinates));
            }
            else
            {
                //Aliado viejo
            }
        }
        else
        {
            //Agua viejo
        }
    }

    private void givePoints(Side team, int i)
    {
        if(team == player1.getTeam())
        {
            player1.updatePoints(i);
        }
        else
        {
            player2.updatePoints(i);
        }
    }

    public void updateShips()
    {
        player1.updateShips();
        player2.updateShips();
    }

    public void playerMoveShip(Side team, Ship ship, int quantity) throws NotEnoughEnergyException, InvalidCoordenatesException
    {
        Coordinates coordinates = checkCoordinates(ship.getCoordinatesStart(), quantity, ship.getSize(), team);

        if(coordinates != null)
        {
            if (player1.getTeam() == team)
            {
                player1.moveShip(ship, coordinates);
            }
            else
            {
                player2.moveShip(ship, coordinates);
            }
        }
        else
        {
            throw new InvalidCoordenatesException();
        }
    }

    private Coordinates checkCoordinates(Coordinates coordinates, int quantity, int size, Side team)
    {
        boolean valid = false;
        Coordinates cord = null;

        for(int i = 0; i < quantity; i++)
        {
            if(isCoordenatesAvailable(new Coordinates(coordinates, i)))
            {
                valid = true;
            }
            else
            {
                valid = false;
                break;
            }
        }

        if(valid)
        {
            cord = new Coordinates(coordinates, quantity);
            cleanCoordinates(coordinates, quantity, size, team);
        }

        return cord;
    }

    private void cleanCoordinates(Coordinates coordinates, int quantity, int size, Side team)
    {
        for(int i = 0; i < size; i++)
        {
            usedCoordinates.remove(new Coordinates(coordinates, i));
        }

        for(int i = 0; i < size; i++)
        {
            usedCoordinates.put(new Coordinates(coordinates, i+quantity), team);
        }
    }
}
