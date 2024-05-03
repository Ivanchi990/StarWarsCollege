package entities.ships.rebels;

import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.rebels.Calamari;
import entities.crewmembers.rebels.Wookie;
import entities.ships.ManageShip;
import entities.ships.Ship;

import java.util.TreeMap;

public class MilenniumFalcon extends Ship implements ManageShip
{
    public MilenniumFalcon()
    {
        super(Side.REBEL, "Halcón Milenario", "", 2000, 1500, 2000, 2500, 4, 40, 1000, null, new Coordinates(), 99999, 500);
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

        crewMembers.put(new Coordinates(), new Calamari());

        crewMembers.put(new Coordinates(), new Wookie());
        crewMembers.put(new Coordinates(), new Wookie());
        crewMembers.put(new Coordinates(), new Wookie());

        this.setCrewMembers(crewMembers);
    }
}
