package entities.ships.rebels;

import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.rebels.Calamari;
import entities.crewmembers.rebels.Wookie;
import entities.ships.Ship;

import java.util.TreeMap;

public class XWing extends Ship
{
    public XWing()
    {
        super("Ala-X", 500, 500, 500, 500, 1, 10, 250, null,2, 25);
        setCrewMembers();
    }

    public void setCrewMembers()
    {
        TreeMap<Coordinates, CrewMember> crewMembers = new TreeMap<>();

        crewMembers.put(new Coordinates(), new Calamari());
        crewMembers.put(new Coordinates(), new Wookie());

        this.setCrewMembers(crewMembers);
    }
}