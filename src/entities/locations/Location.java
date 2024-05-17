package entities.locations;

import assets.data.enums.Side;
import entities.Coordinates;

import java.io.Serializable;
import java.util.TreeMap;

public abstract class Location implements Serializable
{
    private String name;
    private Coordinates size;
    private int initialPoints;

    public Location(Coordinates size, String name)
    {
        this.size = size;
        this.name = name;
        this.initialPoints = calculateInitialPoints();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getSize() {
        return size;
    }

    public void setSize(Coordinates size) {
        this.size = size;
    }

    public int getInitialPoints() {
        return initialPoints;
    }

    public void setInitialPoints(int initialPoints) {
        this.initialPoints = initialPoints;
    }

    private int calculateInitialPoints() {
        return size.getX() * size.getY()/2;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", initialPoints=" + initialPoints +
                '}';
    }
}