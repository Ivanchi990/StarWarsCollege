package entities.ships.rebels;

import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.rebels.Calamari;
import entities.crewmembers.rebels.Jedi;
import entities.crewmembers.rebels.Wookie;
import entities.ships.Ship;

import java.util.TreeMap;

public class StarCruiser extends Ship
{
    public StarCruiser()
    {
        super("Crucero Estelar", 8000, 9000, 9000, 6000, 16, 30, 4000, null, 15, 30);
        setCrewMembers();
    }

    public void setCrewMembers()
    {
        TreeMap<Coordinates, CrewMember> crewMembers = new TreeMap<>();

        for(int i = 0; i < 2; i++)
        {
            crewMembers.put(new Coordinates(), new Jedi());
        }

        for(int i = 0; i < 2; i++)
        {
            crewMembers.put(new Coordinates(), new Calamari());
        }

        for(int i = 0; i < 16; i++)
        {
            crewMembers.put(new Coordinates(), new Wookie());
        }

        this.setCrewMembers(crewMembers);
    }
}