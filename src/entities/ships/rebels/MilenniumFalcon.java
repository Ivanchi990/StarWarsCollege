package entities.ships.rebels;

import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.rebels.Calamari;
import entities.crewmembers.rebels.Wookie;
import entities.ships.Ship;

import java.util.TreeMap;

public class MilenniumFalcon extends Ship
{
    public MilenniumFalcon()
    {
        super("Halcón Milenario", 2000, 1500, 2000, 2500, 4, 40, 1000, null, 99999, 500);
    }

    public void setCrewMembers()
    {
        TreeMap<Coordinates, CrewMember> crewMembers = new TreeMap<>();

        crewMembers.put(new Coordinates(), new Calamari());

        crewMembers.put(new Coordinates(), new Wookie());
        crewMembers.put(new Coordinates(), new Wookie());
        crewMembers.put(new Coordinates(), new Wookie());

        this.setCrewMembers(crewMembers);
    }
}
