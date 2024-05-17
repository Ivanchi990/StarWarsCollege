package entities.crewmembers.rebels;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;

import java.io.Serializable;

public class Jedi extends CrewMember implements Serializable
{
    public Jedi(Coordinates coordinates)
    {
        super(Side.REBEL, "Jedi", Appointment.OFFICIAL, 200, 400, coordinates);
    }
}
