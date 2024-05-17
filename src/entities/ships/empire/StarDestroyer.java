package entities.ships.empire;

import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.empire.Neimoidiano;
import entities.crewmembers.empire.Stormtrooper;
import entities.ships.Ship;
import exceptions.NotEnoughEnergyException;

import java.io.Serializable;
import java.util.TreeMap;

public class StarDestroyer extends Ship implements Serializable
{
    public StarDestroyer(Coordinates coordinates)
    {
        super("Destructor Estelar",  2500, 1000, 1000, 500, 8, 80, 1500, null, 20, 100, coordinates);
        setCrewMembers();
    }

    public void setCrewMembers()
    {
        this.crewMembers.add(new Neimoidiano(new Coordinates(this.coordinatesStart, 0)));

        for (int i = 1; i <= 7; i++)
        {
            this.crewMembers.add(new Stormtrooper(new Coordinates(this.coordinatesStart, i)));
        }
    }

    @Override
    public void move(Coordinates coordinatesStart) throws NotEnoughEnergyException
    {
        if(this.engineEnergy >= this.movementEnergy)
        {
            this.engineEnergy -= this.movementEnergy;
            this.coordinatesStart = coordinatesStart;
            setCrewMembers();
        }
        else
        {
            throw new NotEnoughEnergyException();
        }
    }
}
