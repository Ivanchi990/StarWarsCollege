package entities.crewmembers.rebels;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.crewmembers.CrewMember;
import entities.crewmembers.ManageCrewMember;

public class Calamari extends CrewMember implements ManageCrewMember
{
    public Calamari()
    {
        super(Side.REBEL, "Calamari", Appointment.PILOT, 150, 100);
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
