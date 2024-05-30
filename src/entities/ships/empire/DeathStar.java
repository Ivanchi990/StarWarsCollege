package entities.ships.empire;

import entities.Coordinates;
import entities.crewmembers.empire.Neimoidiano;
import entities.crewmembers.empire.Sith;
import entities.crewmembers.empire.Stormtrooper;
import entities.ships.Ship;
import exceptions.NotEnoughEnergyException;

import java.io.Serializable;
import java.util.ArrayList;


public class DeathStar extends Ship implements Serializable
{
    public DeathStar(Coordinates coordinates)
    {
        super("Estrella de la Muerte", 15000, 7500, 7500, 0, 30, 500, 500, new ArrayList<>(), 0, 0, coordinates);
        setCrewMembers();
    }

    public void setCrewMembers()
    {
        Coordinates cord = this.coordinatesStart;

        for (int i = 0; i < 6; i++)
        {
            this.crewMembers.add(new Sith(new Coordinates(cord, i)));
        }

        for (int i = 6; i < 10; i++)
        {
            this.crewMembers.add(new Neimoidiano(new Coordinates(cord, i)));
        }

        int cont = 10;

        for (int i = 0; i < 50; i++)
        {
            this.crewMembers.add(new Stormtrooper(new Coordinates(cord, cont)));
            cont++;

            if(cont == 30)
            {
                cont = 10;
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