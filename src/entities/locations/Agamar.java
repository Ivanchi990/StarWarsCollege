package entities.locations;

import entities.Coordinates;

import java.io.Serializable;

public class Agamar extends Location implements Serializable
{
    public Agamar()
    {
        super(new Coordinates(300, 100), "Agamar");
    }
}
