package entities.ships.empire;

import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.empire.Neimoidiano;
import entities.crewmembers.empire.Sith;
import entities.crewmembers.empire.Stormtrooper;
import entities.ships.Ship;

import java.util.TreeMap;

public class DeathStar extends Ship
{
    public DeathStar() {
        super("Estrella de la Muerte", 15000, 7500, 7500, 0, 30, 500, 500, null, 0, 0);
        setCrewMembers();
    }

    public void setCrewMembers()
    {
        TreeMap<Coordinates, CrewMember> crewMembers = new TreeMap<>();

        for (int i = 0; i < 6; i++) {
            crewMembers.put(new Coordinates(), new Sith());
        }

        for (int i = 0; i < 4; i++) {
            crewMembers.put(new Coordinates(), new Neimoidiano());
        }

        for (int i = 0; i < 50; i++) {
            crewMembers.put(new Coordinates(), new Stormtrooper());
        }

        this.setCrewMembers(crewMembers);
    }
}