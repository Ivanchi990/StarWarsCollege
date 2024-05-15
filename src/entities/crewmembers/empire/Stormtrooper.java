package entities.crewmembers.empire;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.crewmembers.CrewMember;

public class Stormtrooper extends CrewMember
{
    public Stormtrooper()
    {
        super(Side.EMPIRE,"Stormtrooper", Appointment.SOLDIER, 100, 50);
    }
}
