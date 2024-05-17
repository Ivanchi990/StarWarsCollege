package entities.locations;

import entities.Coordinates;

import java.io.Serializable;

public class PlanetAtollon extends Location implements Serializable
{
    public PlanetAtollon()
    {
        super(new Coordinates(100, 100), "Planeta Atollon");
    }
}
