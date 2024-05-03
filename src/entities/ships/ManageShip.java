package entities.ships;

import entities.Coordinates;
import entities.crewmembers.CrewMember;

import java.util.TreeMap;

public interface ManageShip
{
    boolean moveShip();
    boolean damageShip();
    boolean shoot();
    void setCrewMembers();
}
