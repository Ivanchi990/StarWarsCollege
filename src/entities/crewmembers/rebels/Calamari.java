package entities.crewmembers.rebels;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.crewmembers.CrewMember;

public class Calamari extends CrewMember
{
    public Calamari()
    {
        super(Side.REBEL, "Calamari", Appointment.PILOT, 150, 100);
    }
}
