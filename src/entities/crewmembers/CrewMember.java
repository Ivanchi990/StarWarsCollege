package entities.crewmembers;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.Coordinates;

public abstract class CrewMember
{
    private Side side;
    private String name;
    private Appointment appointment;
    private int resistance;
    private int reward;

    public CrewMember(Side side, String name, Appointment appointment, int resistance, int reward)
    {
        this.side = side;
        this.name = name;
        this.appointment = appointment;
        this.resistance = resistance;
        this.reward = reward;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
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

    public boolean recieveDamage(int damage)
    {
        this.resistance -= damage;

        return this.resistance <= 0;
    }
}
