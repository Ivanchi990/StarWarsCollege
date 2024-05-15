package entities.crewmembers.rebels;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.crewmembers.CrewMember;

public class Wookie extends CrewMember
{
    public Wookie()
    {
        super(Side.REBEL,"Wookie", Appointment.SOLDIER, 100, 50);
    }
}
