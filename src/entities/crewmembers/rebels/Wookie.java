package entities.crewmembers.rebels;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;

import java.io.Serializable;

public class Wookie extends CrewMember implements Serializable
{
    public Wookie(Coordinates coordinates)
    {
        super(Side.REBEL,"Wookie", Appointment.SOLDIER, 100, 50, coordinates);
    }
}
