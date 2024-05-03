package entities.ships.empire;

import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.empire.Neimoidiano;
import entities.crewmembers.empire.Sith;
import entities.crewmembers.empire.Stormtrooper;
import entities.ships.ManageShip;
import entities.ships.Ship;

import java.util.TreeMap;

public class DeathStar extends Ship implements ManageShip
{
    public DeathStar()
    {
        super(Side.EMPIRE, "Estrella de la Muerte", "La Estrella de la Muerte (plataforma EM-1 ), también conocida como la Estrella de " +
                "la Muerte I, es una estación de combate espacial móvil tamaño lunar construida por " +
                "el Imperio Galáctico.", 15000, 7500, 7500, 0, 30, 500, 500, null, new Coordinates(), 0, 0);
        setCrewMembers();
    }

    @Override
    public boolean moveShip() {
        return false;
    }

    @Override
    public boolean damageShip() {
        return false;
    }

    @Override
    public boolean shoot() {
        return false;
    }

    @Override
    public void setCrewMembers()
    {
        TreeMap<Coordinates, CrewMember> crewMembers = new TreeMap<>();

        for(int i = 0; i < 6; i++)
        {
            crewMembers.put(new Coordinates(), new Sith());
        }

        for(int i = 0; i < 4; i++)
        {
            crewMembers.put(new Coordinates(), new Neimoidiano());
        }

        for(int i = 0; i < 50; i++)
        {
            crewMembers.put(new Coordinates(), new Stormtrooper());
        }

        this.setCrewMembers(crewMembers);
    }
}
