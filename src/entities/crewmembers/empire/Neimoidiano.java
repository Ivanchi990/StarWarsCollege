package entities.crewmembers.empire;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.ManageCrewMember;

public class Neimoidiano extends CrewMember implements ManageCrewMember
{
    public Neimoidiano()
    {
        super(Side.EMPIRE ,"Neimoidiano", Appointment.PILOT, 150, 100);
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
