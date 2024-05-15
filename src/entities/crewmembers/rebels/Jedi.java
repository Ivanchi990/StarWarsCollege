package entities.crewmembers.rebels;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.crewmembers.CrewMember;

public class Jedi extends CrewMember
{
    public Jedi()
    {
        super(Side.REBEL, "Jedi", Appointment.OFFICIAL, 200, 400);
    }
}
