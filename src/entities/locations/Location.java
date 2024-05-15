package entities.locations;

import entities.Coordinates;
import entities.ships.Ship;

import java.util.ArrayList;

public abstract class Location
{
    private String name;
    private Coordinates size;
    private int initialPoints;
    private ArrayList<Coordinates> usedCoordinates;

    public Location(Coordinates size, String name)
    {
        this.size = size;
        this.name = name;
        this.initialPoints = calculateInitialPoints();
        this.usedCoordinates = new ArrayList<>();
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

    public boolean isCoordinatesAvailables(ArrayList<Coordinates> coordinates)
    {
        boolean available = true;

        for (Coordinates coordinate : coordinates)
        {
            if (usedCoordinates.contains(coordinate))
            {
                available = false;
                break;
            }
        }

        return available;
    }

    public boolean isCoordinatesAvailables(Coordinates coordinates)
    {
        return usedCoordinates.contains(coordinates);
    }


    public void addUsedCoordinates(Coordinates coordinates)
    {
        usedCoordinates.add(coordinates);
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", initialPoints=" + initialPoints +
                '}';
    }

    public boolean isCoordinatesAvailable(Coordinates coordinates) {
        return usedCoordinates.contains(coordinates);
    }
}