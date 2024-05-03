package entities.ships.rebels;

import assets.data.enums.Side;
import entities.Coordinates;
import entities.crewmembers.CrewMember;
import entities.crewmembers.rebels.Calamari;
import entities.crewmembers.rebels.Jedi;
import entities.crewmembers.rebels.Wookie;
import entities.ships.ManageShip;
import entities.ships.Ship;

import java.util.TreeMap;

public class StarCruiser extends Ship implements ManageShip
{
    public StarCruiser()
    {
        super(Side.REBEL, "Crucero Estelar", "Construido inicialmente como una masiva nave de placer por los Astilleros de Mon " +
                "Calamari, los Crucero Estelares MC80a han recibido una serie de actualizaciones " +
                "cruciales para permitirles operar contras naves de guerra Imperiales.", 8000, 9000, 9000, 6000, 16, 30, 4000, null, new Coordinates(), 15, 30);
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

        for(int i = 0; i < 2; i++)
        {
            crewMembers.put(new Coordinates(), new Jedi());
        }

        for(int i = 0; i < 2; i++)
        {
            crewMembers.put(new Coordinates(), new Calamari());
        }

        for(int i = 0; i < 16; i++)
        {
            crewMembers.put(new Coordinates(), new Wookie());
        }

        this.setCrewMembers(crewMembers);
    }
}