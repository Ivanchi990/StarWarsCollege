package entities.locations;

import entities.Coordinates;

import java.io.Serializable;

public class Coruscant extends Location implements Serializable
{
    public Coruscant()
    {
        super(new Coordinates(500, 300), "Coruscant");
    }
}
