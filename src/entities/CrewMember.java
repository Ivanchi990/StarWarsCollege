package entities;

import assets.data.enums.Appointment;
import assets.data.enums.Side;

public class CrewMember
{
    private String name;
    private Appointment appointment;
    private Coordinates position;
    private Side side;
    private int resistance;
    private int reward;
    private int quantity;
    private boolean isDead;

    public CrewMember(String name, Appointment appointment, Coordinates position, int resistance, int reward, Side side, int quantity, boolean isDead)
    {
        this.name = name;
        this.appointment = appointment;
        this.position = position;
        this.side = side;
        this.resistance = resistance;
        this.reward = reward;
        this.quantity = quantity;
        this.isDead = isDead;
    }

    public boolean getIsDead()
    {
        return isDead;
    }

    public void setIsDead(boolean isDead)
    {
        this.isDead = isDead;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Appointment getAppointment()
    {
        return appointment;
    }

    public Coordinates getPosition()
    {
        return position;
    }

    public int getResistance()
    {
        return resistance;
    }

    public int getReward()
    {
        return reward;
    }

    public void setAppointment(Appointment appointment)
    {
        this.appointment = appointment;
    }

    public void setPosition(Coordinates position)
    {
        this.position = position;
    }

    public void setResistance(int resistance)
    {
        this.resistance = resistance;
    }

    public void setReward(int reward)
    {
        this.reward = reward;
    }

    public Side getSide()
    {
        return side;
    }

    public void setSide(Side side)
    {
        this.side = side;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String toString()
    {
        return "Tripulation{" + "appointment=" + appointment + ", position=" + position + ", side=" + side + ", resistance=" + resistance + ", reward=" + reward + '}';
    }
}
