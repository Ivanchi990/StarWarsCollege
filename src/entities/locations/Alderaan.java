package entities.locations;

import entities.Coordinates;

import java.io.Serializable;

public class Alderaan extends Location implements Serializable
{

    public Alderaan()
    {
        super(new Coordinates(400, 400), "Alderaan");
    }
}
