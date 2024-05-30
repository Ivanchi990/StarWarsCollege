package entities.ships.empire;

import entities.Coordinates;
import entities.crewmembers.empire.Neimoidiano;
import entities.crewmembers.empire.Stormtrooper;
import entities.ships.Ship;
import exceptions.NotEnoughEnergyException;

import java.io.Serializable;
import java.util.ArrayList;

public class TIE extends Ship implements Serializable
{
    public TIE(Coordinates coordinates)
    {
        super("TIE", 500, 0, 1000, 500, 1, 20, 250, new ArrayList<>(), 2, 25, coordinates);
        setCrewMembers();
    }

    public void setCrewMembers()
    {
        this.crewMembers.add(new Neimoidiano(this.coordinatesStart));
        this.crewMembers.add(new Stormtrooper(this.coordinatesStart));
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
