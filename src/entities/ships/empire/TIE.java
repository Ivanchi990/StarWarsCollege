package entities.ships.empire;

import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.empire.Neimoidiano;
import entities.crewmembers.empire.Stormtrooper;
import entities.ships.ManageShip;
import entities.ships.Ship;

import java.util.TreeMap;

public class TIE extends Ship implements ManageShip
{
    public TIE()
    {
        super(Side.EMPIRE, "TIE", "La serie de cazas TIE (Motores de Iones Gemelos) diseñados por Sistemas de Flotas " +
                "Sienar, son el símbolo de la superioridad numérica y de la voluntad implacable del " +
                "Imperio para imponer el orden en la Galaxia", 500, 0, 1000, 500, 1, 20, 250, null, new Coordinates(), 2, 25);
        setCrewMembers();
    }

    @Override
    public boolean moveShip()
    {
        return false;
    }

    @Override
    public boolean damageShip()
    {
        return false;
    }

    @Override
    public boolean shoot()
    {
        return false;
    }

    @Override
    public void setCrewMembers()
    {
        TreeMap<Coordinates, CrewMember> crewMembers = new TreeMap<>();

        crewMembers.put(new Coordinates(), new Neimoidiano());
        crewMembers.put(new Coordinates(), new Stormtrooper());

        this.setCrewMembers(crewMembers);
    }
}
