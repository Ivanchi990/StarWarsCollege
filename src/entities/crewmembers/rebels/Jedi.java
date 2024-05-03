package entities.crewmembers.rebels;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.crewmembers.CrewMember;
import entities.crewmembers.ManageCrewMember;

public class Jedi extends CrewMember implements ManageCrewMember
{
    public Jedi()
    {
        super(Side.REBEL, "Jedi", Appointment.OFFICIAL, 200, 400);
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
