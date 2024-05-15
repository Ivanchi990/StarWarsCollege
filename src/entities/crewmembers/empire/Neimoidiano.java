package entities.crewmembers.empire;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.crewmembers.CrewMember;

public class Neimoidiano extends CrewMember
{
    public Neimoidiano()
    {
        super(Side.EMPIRE ,"Neimoidiano", Appointment.PILOT, 150, 100);
    }
}
