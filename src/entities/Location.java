package entities;

public class Location
{
    private String name;
    private String description;
    private Coordinates size;

    public Location(String name, String description, Coordinates size)
    {
        this.name = name;
        this.description = description;
        this.size = size;
    }

    private int getInitialPoints()
    {
        return size.getX() * (size.getY()/2);
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public Coordinates getSize()
    {
        return size;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setSize(Coordinates size)
    {
        this.size = size;
    }

    public String toString()
    {
        return name + " - " + description + " - " + size;
    }
}
