package entities.ships;

import entities.Coordinates;
import entities.Player;
import entities.crewmembers.CrewMember;
import exceptions.NotEnoughEnergyException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public abstract class Ship implements Serializable
{
    private String name;
    protected Coordinates coordinatesStart;
    private int price;
    private int deflectorsEnergy;
    private int cannonEnergy;
    protected int engineEnergy;
    private int size;
    private int power;
    private int destroyReward;
    protected ArrayList<CrewMember> crewMembers;
    protected int maxMovement;
    protected int movementEnergy;

    public Ship(String name, int price, int deflectorsEnergy, int cannonEnergy, int engineEnergy, int size, int power, int destroyReward, ArrayList<CrewMember> crewMembers, int maxMovement, int movementEnergy, Coordinates coordintatesStart) {
        this.name = name;
        this.coordinatesStart = coordintatesStart;
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

    public ArrayList<CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(ArrayList<CrewMember> crewMembers) {
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

    public Coordinates getCoordinatesStart() {
        return coordinatesStart;
    }

    public void setCoordinatesStart(Coordinates coordinatesStart) {
        this.coordinatesStart = coordinatesStart;
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

    public int recieveDamage(int damage, Coordinates coordinates)
    {
        if(this.deflectorsEnergy >= damage)
        {
            this.deflectorsEnergy -= damage;
        }
        else
        {
            damage -= this.deflectorsEnergy;
            this.deflectorsEnergy = 0;

            damageTripulation(damage, coordinates);
        }

        return 0;
    }

    private void damageTripulation(int damage, Coordinates coordinates)
    {
        for (CrewMember crewMember : crewMembers)
        {
            if(crewMember.getCoordinates().equals(coordinates))
            {
                if(crewMember.recieveDamage(damage))
                {
                    crewMembers.remove(crewMember);
                }
            }
        }
    }


    public abstract void move(Coordinates coordinatesStart) throws NotEnoughEnergyException;

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

    public int shoot() throws NotEnoughEnergyException
    {
        if(cannonEnergy >= power)
        {
            cannonEnergy -= power;
        }
        else
        {
            throw new NotEnoughEnergyException();
        }

        return power;
    }
}