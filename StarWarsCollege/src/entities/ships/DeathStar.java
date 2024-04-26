package entities.ships;

import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;

public class DeathStar extends Ship implements ManageShip
{
    public DeathStar(Side side, String name, String description, int price, int deflectorsEnergy, int cannonEnergy, int engineEnergy, int size, int power, int destroyReward, CrewMember[] crewMember, Coordinates coordinates, int maxMovement, int movementEnergy) {
        super(side, name, description, price, deflectorsEnergy, cannonEnergy, engineEnergy, size, power, destroyReward, crewMember, coordinates, maxMovement, movementEnergy);
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
}
