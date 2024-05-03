package entities.ships.empire;

import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.empire.Neimoidiano;
import entities.crewmembers.empire.Stormtrooper;
import entities.ships.ManageShip;
import entities.ships.Ship;

import java.util.TreeMap;

public class StarDestroyer extends Ship implements ManageShip
{
    public StarDestroyer() {
        super(Side.EMPIRE, "Destructor Estelar", "Los destructores estelares son naves de guerra relativamente comunes, son la nave de " +
                "guerra estándar del Imperio Galáctico. La longitud un destructor estelar es de unos " +
                "3.8 kilometros", 2500, 1000, 1000, 500, 8, 80, 1500, null, new Coordinates(), 20, 100);
        setCrewMembers();
    }

    @Override
    public boolean moveShip() {
        return false;
    }

    @Override
    public boolean damageShip() {
        return false;
    }

    @Override
    public boolean shoot() {
        return false;
    }

    @Override
    public void setCrewMembers()
    {
        TreeMap<Coordinates, CrewMember> crewMembers = new TreeMap<>();

        crewMembers.put(new Coordinates(), new Neimoidiano());

        for(int i = 0; i < 7; i++)
        {
            crewMembers.put(new Coordinates(), new Stormtrooper());
        }

        this.setCrewMembers(crewMembers);
    }
}
