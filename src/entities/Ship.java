package entities;

import assets.data.enums.Side;

public class Ship
{
    private Side side;
    private String name;
    private String description;
    private int price;
    private int deflectorsEnergy;
    private int cannonEnergy;
    private int engineEnergy;
    private int size;
    private int power;
    private int destroyReward;
    private CrewMember[] crewMember;
    private Coordinates coordinates;
    private int maxMovement;
    private int movementEnergy;
    private boolean isDestroyed;

    public Ship(Side side, String name, String description, int price, int deflectorsEnergy, int cannonEnergy, int engineEnergy, int size, int power, int destroyReward, CrewMember[] crewMember, Coordinates coordinates, int maxMovement, int movementEnergy, boolean isDestroyed)
    {
        this.side = side;
        this.name = name;
        this.description = description;
        this.price = price;
        this.deflectorsEnergy = deflectorsEnergy;
        this.cannonEnergy = cannonEnergy;
        this.engineEnergy = engineEnergy;
        this.size = size;
        this.power = power;
        this.destroyReward = destroyReward;
        this.crewMember = crewMember;
        this.coordinates = coordinates;
        this.maxMovement = maxMovement;
        this.movementEnergy = movementEnergy;
        this.isDestroyed = isDestroyed;
    }

    public int getMovementEnergy()
    {
        return movementEnergy;
    }

    public void setMovementEnergy(int movementEnergy)
    {
        this.movementEnergy = movementEnergy;
    }

    public int getMaxMovement()
    {
        return maxMovement;
    }

    public void setMaxMovement(int maxMovement)
    {
        this.maxMovement = maxMovement;
    }

    public int getDeflectorsEnergy()
    {
        return deflectorsEnergy;
    }

    public void setDeflectorsEnergy(int deflectorsEnergy)
    {
        this.deflectorsEnergy = deflectorsEnergy;
    }

    public int getCannonEnergy()
    {
        return cannonEnergy;
    }

    public void setCannonEnergy(int cannonEnergy)
    {
        this.cannonEnergy = cannonEnergy;
    }

    public int getEngineEnergy()
    {
        return engineEnergy;
    }

    public void setEngineEnergy(int engineEnergy)
    {
        this.engineEnergy = engineEnergy;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean isDestroyed) {
        this.isDestroyed = isDestroyed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDestroyReward() {
        return destroyReward;
    }

    public void setDestroyReward(int destroyReward) {
        this.destroyReward = destroyReward;
    }

    public CrewMember[] getTripulation() {
        return crewMember;
    }

    public void setTripulation(CrewMember[] crewMember) {
        this.crewMember = crewMember;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


}