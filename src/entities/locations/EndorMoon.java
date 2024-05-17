package entities.locations;

import entities.Coordinates;

import java.io.Serializable;

public class EndorMoon extends Location implements Serializable
{
    public EndorMoon()
    {
        super(new Coordinates(200, 200), "EndorMoon");
    }
}
