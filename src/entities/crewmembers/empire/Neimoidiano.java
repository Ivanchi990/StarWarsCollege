package entities.crewmembers.empire;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;

import java.io.Serializable;

public class Neimoidiano extends CrewMember implements Serializable
{
    public Neimoidiano(Coordinates coordinates)
    {
        super(Side.EMPIRE ,"Neimoidiano", Appointment.PILOT, 150, 100, coordinates);
    }
}
