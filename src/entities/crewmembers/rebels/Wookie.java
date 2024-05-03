package entities.crewmembers.rebels;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.crewmembers.CrewMember;
import entities.crewmembers.ManageCrewMember;

public class Wookie extends CrewMember implements ManageCrewMember
{
    public Wookie()
    {
        super(Side.REBEL,"Wookie", Appointment.SOLDIER, 100, 50);
    }

    @Override
    public boolean getDamage()
    {
        return false;
    }

    @Override
    public boolean placeCrewMember()
    {
        return false;
    }
}
