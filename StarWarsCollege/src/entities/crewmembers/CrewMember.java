package entities.crewmembers;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.Coordinates;

public abstract class CrewMember
{
    private String name;
    private Appointment appointment;
    private Coordinates position;
    private Side side;
    private int resistance;
    private int reward;

    public CrewMember(String name, Appointment appointment, Coordinates position, Side side, int resistance, int reward) {
        this.name = name;
        this.appointment = appointment;
        this.position = position;
        this.side = side;
        this.resistance = resistance;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }
}
