package entities.locations;

import entities.Coordinates;

public abstract class Location
{
    private String name;
    private String description;
    private Coordinates size;
    private int reward;

    public Location(Coordinates size, String name, String description)
    {
        this.size = size;
        this.name = name;
        this.description = description;
        this.reward = calculateReward();
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

    public Coordinates getSize() {
        return size;
    }

    public void setSize(Coordinates size) {
        this.size = size;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    private int calculateReward() {
        return size.getX() * size.getY()/2;
    }
}