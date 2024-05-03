package entities.crewmembers.empire;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.crewmembers.CrewMember;
import entities.crewmembers.ManageCrewMember;

public class Sith extends CrewMember implements ManageCrewMember
{
    public Sith()
    {
        super(Side.EMPIRE,"Sith", Appointment.OFFICIAL, 200, 400);
    }

    @Override
    public boolean getDamage() {
        return false;
    }

    @Override
    public boolean placeCrewMember() {
        return false;
    }
}
