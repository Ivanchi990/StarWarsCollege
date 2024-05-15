package entities.crewmembers.empire;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.crewmembers.CrewMember;

public class Sith extends CrewMember
{
    public Sith()
    {
        super(Side.EMPIRE,"Sith", Appointment.OFFICIAL, 200, 400);
    }
}
