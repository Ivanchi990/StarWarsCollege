package entities.ships.rebels;

import entities.Coordinates;
import entities.crewmembers.empire.Stormtrooper;
import entities.crewmembers.rebels.Calamari;
import entities.crewmembers.rebels.Jedi;
import entities.ships.Ship;
import exceptions.NotEnoughEnergyException;

import java.io.Serializable;
import java.util.ArrayList;

public class MilenniumFalcon extends Ship implements Serializable
{
    public MilenniumFalcon(Coordinates coordinates)
    {
        super("Halcón Milenario", 2000, 1500, 2000, 2500, 4, 40, 1000, new ArrayList<>(), 99999, 500, coordinates);
        setCrewMembers();
    }

    public void setCrewMembers()
    {
        Coordinates cord = this.coordinatesStart;

        this.crewMembers.add(new Jedi(cord));
        this.crewMembers.add(new Jedi(new Coordinates(cord, 1)));

        this.crewMembers.add(new Calamari(new Coordinates(cord, 3)));
        this.crewMembers.add(new Calamari(new Coordinates(cord, 4)));

        int cont = 4;

        for (int i = 0; i < 16; i++)
        {
            this.crewMembers.add(new Stormtrooper(new Coordinates(cord, cont)));
            cont++;

            if(cont == 16)
            {
                cont = 4;
            }
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
