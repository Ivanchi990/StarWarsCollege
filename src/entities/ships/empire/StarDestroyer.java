package entities.ships.empire;

import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.empire.Neimoidiano;
import entities.crewmembers.empire.Stormtrooper;
import entities.ships.Ship;

import java.util.TreeMap;

public class StarDestroyer extends Ship
{
    public StarDestroyer() {
        super("Destructor Estelar",  2500, 1000, 1000, 500, 8, 80, 1500, null, 20, 100);
        setCrewMembers();
    }

    public void setCrewMembers()
    {
        TreeMap<Coordinates, CrewMember> crewMembers = new TreeMap<>();

        crewMembers.put(new Coordinates(), new Neimoidiano());

        for(int i = 0; i < 7; i++)
        {
            crewMembers.put(new Coordinates(), new Stormtrooper());
        }

        this.setCrewMembers(crewMembers);
    }
}
