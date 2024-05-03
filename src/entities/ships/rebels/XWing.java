package entities.ships.rebels;

import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.rebels.Calamari;
import entities.crewmembers.rebels.Wookie;
import entities.ships.ManageShip;
import entities.ships.Ship;

import java.util.TreeMap;

public class XWing extends Ship implements ManageShip
{
    public XWing(Side side, String name, String description, int price, int deflectorsEnergy, int cannonEnergy, int engineEnergy, int size, int power, int destroyReward, TreeMap<Coordinates, CrewMember> crewMembers, Coordinates coordinates, int maxMovement, int movementEnergy) {
        super(side, name, description, price, deflectorsEnergy, cannonEnergy, engineEnergy, size, power, destroyReward, crewMembers, coordinates, maxMovement, movementEnergy);
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

        this.setCrewMembers(crewMembers);
    }
}