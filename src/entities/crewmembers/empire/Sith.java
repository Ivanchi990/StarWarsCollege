package entities.crewmembers.empire;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;

import java.io.Serializable;

public class Sith extends CrewMember implements Serializable
{
    public Sith(Coordinates coordinates)
    {
        super(Side.EMPIRE,"Sith", Appointment.OFFICIAL, 200, 400, coordinates);
    }
}
