package entities;

import assets.data.enums.Side;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable
{
    private Date date;
    private Side user;
    private String message;

    public Message(Date date, Side user, String message)
    {
        this.date = date;
        this.user = user;
        this.message = message;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Side getUser()
    {
        return user;
    }

    public void setUser(Side user)
    {
        this.user = user;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return "\n Fecha: " + date + "\n Jugador: " + user + "\n Mensaje: " + message;
    }
}
