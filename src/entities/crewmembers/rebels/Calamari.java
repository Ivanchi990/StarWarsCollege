package entities.crewmembers.rebels;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;

import java.io.Serializable;

public class Calamari extends CrewMember implements Serializable
{
    public Calamari(Coordinates coordinates)
    {
        super(Side.REBEL, "Calamari", Appointment.PILOT, 150, 100, coordinates);
    }
}
