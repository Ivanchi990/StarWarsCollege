package entities.crewmembers.empire;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.crewmembers.CrewMember;
import entities.crewmembers.ManageCrewMember;

public class Stormtrooper extends CrewMember implements ManageCrewMember
{
    public Stormtrooper()
    {
        super(Side.EMPIRE,"Stormtrooper", Appointment.SOLDIER, 100, 50);
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
