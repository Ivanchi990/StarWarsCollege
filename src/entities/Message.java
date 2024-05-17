package entities;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable
{
    private Date date;
    private String user;
    private String message;

    public Message(Date date, String user, String message)
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

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
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
        return date + " " + user + ": " + message;
    }
}
