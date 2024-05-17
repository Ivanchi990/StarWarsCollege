package entities.crewmembers.empire;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;

import java.io.Serializable;

public class Stormtrooper extends CrewMember implements Serializable
{
    public Stormtrooper(Coordinates coordinates)
    {
        super(Side.EMPIRE, "Stormtrooper", Appointment.SOLDIER, 100, 50, coordinates);
    }
}
