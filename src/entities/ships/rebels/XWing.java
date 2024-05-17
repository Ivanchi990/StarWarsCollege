package entities.ships.rebels;

import entities.Coordinates;
import entities.crewmembers.rebels.Calamari;
import entities.crewmembers.rebels.Wookie;
import entities.ships.Ship;
import exceptions.NotEnoughEnergyException;

import java.io.Serializable;

public class XWing extends Ship implements Serializable
{
    public XWing(Coordinates coordinatesStart)
    {
        super("Ala-X", 500, 500, 500, 500, 1, 10, 250, null,2, 25, coordinatesStart);
        setCrewMembers();
    }

    public void setCrewMembers()
    {
        this.crewMembers.add(new Calamari(coordinatesStart));
        this.crewMembers.add(new Wookie(coordinatesStart));
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