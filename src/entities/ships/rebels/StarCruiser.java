package entities.ships.rebels;

import entities.Coordinates;
import entities.crewmembers.rebels.Calamari;
import entities.crewmembers.rebels.Wookie;
import entities.ships.Ship;
import exceptions.NotEnoughEnergyException;

import java.io.Serializable;

public class StarCruiser extends Ship implements Serializable
{
    public StarCruiser(Coordinates coordinates)
    {
        super("Crucero Estelar", 8000, 9000, 9000, 6000, 16, 30, 4000, null, 15, 30, coordinates);
        setCrewMembers();
    }

    public void setCrewMembers()
    {
        this.crewMembers.add(new Calamari(coordinatesStart));

        this.crewMembers.add(new Wookie(new Coordinates(this.coordinatesStart, 1)));
        this.crewMembers.add(new Wookie(new Coordinates(this.coordinatesStart, 2)));
        this.crewMembers.add(new Wookie(new Coordinates(this.coordinatesStart, 3)));
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