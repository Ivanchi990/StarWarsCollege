package entities.ships.empire;

import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.empire.Neimoidiano;
import entities.crewmembers.empire.Stormtrooper;
import entities.ships.Ship;

import java.util.TreeMap;

public class TIE extends Ship
{
    public TIE()
    {
        super("TIE", 500, 0, 1000, 500, 1, 20, 250, null, 2, 25);
        setCrewMembers();
    }

    public void setCrewMembers()
    {
        TreeMap<Coordinates, CrewMember> crewMembers = new TreeMap<>();

        crewMembers.put(new Coordinates(), new Neimoidiano());
        crewMembers.put(new Coordinates(), new Stormtrooper());

        this.setCrewMembers(crewMembers);
    }
}
