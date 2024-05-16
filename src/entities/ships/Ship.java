package entities.ships;

import entities.Coordinates;
import entities.Player;
import entities.crewmembers.CrewMember;
import exceptions.NotEnoughEnergyException;

import java.util.TreeMap;

public abstract class Ship
{
    private String name;
    private int price;
    private int deflectorsEnergy;
    private int cannonEnergy;
    private int engineEnergy;
    private int size;
    private int power;
    private int destroyReward;
    private TreeMap<Coordinates, CrewMember> crewMembers;
    private int maxMovement;
    private int movementEnergy;

    public Ship(String name, int price, int deflectorsEnergy, int cannonEnergy, int engineEnergy, int size, int power, int destroyReward, TreeMap<Coordinates, CrewMember> crewMembers, int maxMovement, int movementEnergy) {
        this.name = name;
        this.price = price;
        this.deflectorsEnergy = deflectorsEnergy;
        this.cannonEnergy = cannonEnergy;
        this.engineEnergy = engineEnergy;
        this.size = size;
        this.power = power;
        this.destroyReward = destroyReward;
        this.crewMembers = crewMembers;
        this.maxMovement = maxMovement;
        this.movementEnergy = movementEnergy;
    }

    public int getMovementEnergy() {
        return movementEnergy;
    }

    public void setMovementEnergy(int movementEnergy) {
        this.movementEnergy = movementEnergy;
    }

    public int getMaxMovement() {
        return maxMovement;
    }

    public void setMaxMovement(int maxMovement) {
        this.maxMovement = maxMovement;
    }

    public TreeMap<Coordinates, CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(TreeMap<Coordinates, CrewMember> crewMembers) {
        this.crewMembers = crewMembers;
    }

    public int getDestroyReward() {
        return destroyReward;
    }

    public void setDestroyReward(int destroyReward) {
        this.destroyReward = destroyReward;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getEngineEnergy() {
        return engineEnergy;
    }

    public void setEngineEnergy(int engineEnergy) {
        this.engineEnergy = engineEnergy;
    }

    public int getCannonEnergy() {
        return cannonEnergy;
    }

    public void setCannonEnergy(int cannonEnergy) {
        this.cannonEnergy = cannonEnergy;
    }

    public int getDeflectorsEnergy() {
        return deflectorsEnergy;
    }

    public void setDeflectorsEnergy(int deflectorsEnergy) {
        this.deflectorsEnergy = deflectorsEnergy;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String shootInfo()
    {
        return "Nave: " + name + "\n" +
                "Energía de cañones: " + cannonEnergy + "\n" +
                "Potencia: " + power;
    }

    public String moveInfo()
    {
        return "Nave: " + name + "\n" +
                "Energía de motores: " + engineEnergy + "\n" +
                "Movimiento máximo: " + maxMovement;
    }

    public void shoot(Player reciever, Coordinates coordinates, Player shooter) throws NotEnoughEnergyException
    {
        if(this.cannonEnergy >= this.power)
        {
            this.cannonEnergy -= this.power;

            Ship recieverShip = reciever.getShip(coordinates);

            if(recieverShip != null)
            {
                recieverShip.getDamage(this.power, coordinates, reciever);

                if(recieverShip.crewMembers.isEmpty())
                {
                    shooter.updatePoints(recieverShip.destroyReward);
                    reciever.removeShip(coordinates);
                }
            }
        }
        else
        {
            throw new NotEnoughEnergyException();
        }
    }

    private void getDamage(int damage, Coordinates coordinates, Player reciever)
    {
        if(this.deflectorsEnergy >= damage)
        {
            this.deflectorsEnergy -= damage;
        }
        else
        {
            damage -= this.deflectorsEnergy;
            this.deflectorsEnergy = 0;

            if(crewMembers.get(coordinates).recieveDamage(damage))
            {
                reciever.notifyDestruction(this);
                crewMembers.remove(coordinates);
            }
        }
    }


    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", deflectorsEnergy=" + deflectorsEnergy +
                ", cannonEnergy=" + cannonEnergy +
                ", engineEnergy=" + engineEnergy +
                ", power=" + power +
                ", maxMovement=" + maxMovement +
                ", movementEnergy=" + movementEnergy +
                ", crewMembers=" + crewMembers.size() +
                '}';
    }
}