package entities;

import java.util.Objects;

public class Coordinates implements Comparable<Coordinates>
{
    private int x;
    private int y;

    public Coordinates()
    {

    }

    public Coordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int compareTo(Coordinates other) {
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        } else {
            return Integer.compare(this.x, other.x);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public String toString()
    {
        return "[" + x + "," + y + "]";
    }
}
