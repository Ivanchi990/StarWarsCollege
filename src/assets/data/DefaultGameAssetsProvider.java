package assets.data;

import assets.data.enums.Appointment;
import assets.data.enums.Side;
import entities.*;

public class DefaultGameAssetsProvider
{
    public DefaultGameAssetsProvider()
    {

    }

    public Location[] getLocations()
    {
        return new Location[] {
            new Location("Planeta Atollon", "Atollon fue un remoto planeta del sector Lothal de los Territorios del\n" +
                    "Borde Exterior. Era conocido por la antigua gente del sector y estaba presente en sus obras de arte. Su único habitante conocido era el Bendu, un misterioso portador de la\n" +
                    "Fuerza. En el 3 ABY, los rebeldes de la Célula Fénix establecieron una base allí tras\n" +
                    "recibir información de inteligencia del droide astromecánico rebelde Chopper y AP-5, un\n" +
                    "droide de inventario anteriormente al servicio del Imperio Galáctico. Eventualmente, los\n" +
                    "rebeldes fueron obligados a abandonar el planeta después de que el Gran Almirante Thrawn\n" +
                    "localizara su base y lanzara un ataque que destruyó la Base de Chopper y mató a muchos\n" +
                    "de los rebeldes.\n", new Coordinates(100, 100)),
            new Location("Luna Boscosa de Endor", "Endor (también conocido como la Luna Boscosa de Endor o la\n" +
                    "Luna Santuario) era una pequeña luna boscosa que orbitaba el planeta del Borde Exterior\n" +
                    "de su mismo nombre y era el mundo naral de las especies inteligentes Ewoks y de Yuzzums.", new Coordinates(200, 200)),
            new Location("Agamar", "Agamar fue un planeta localizado en los Territorios del Borde Exterior de la\n" +
                    "galaxia. El Conde Dooku ordenó al General Kalani retirarse a Agamar tras su derrota en\n" +
                    "la Batalla de Onderon.", new Coordinates(300, 100)),
            new Location("Alderaan", "Alderaan, situado en los Mundos del Núcleo, fue un planeta terrestre cubierto\n" +
                    "de montañas. Durante las últimas décadas de la República Galáctica, estuvo gobernado por\n" +
                    "la Reina Breha Organa y representado en el Senado Galáctico por su marido, el Senador\n" +
                    "Bail Prestor Organa. Alderaan era célebre por su belleza natural, su tranquilidad, y su\n" +
                    "cultura y arte sofisticados.\n" +
                    "Tras el alzamiento del Imperio Galáctico de Sheev Palpatine, Alderaan jugó un papel clave\n" +
                    "en el establecimiento de la Alianza Rebelde, un movimiento que buscaba restaurar los valores\n" +
                    "de la Antigua República, y fue uno de sus primeros apoyos.\n" +
                    "Era el planeta de origen de la princesa Leia y Bail Organa, y fue destruido por la primera\n" +
                    "Estrella de la muerte como una demostración de poder.\n", new Coordinates(400, 400)),
            new Location("Coruscant", "También conocido como Centro Imperial durante el reinado del Imperio Galáctico, fue una ecumenópolis—un planeta cubierto de ciudad, colectivamente conocida como\n" +
                    "Ciudad Galáctica— en el sistema Coruscant de los Mundos del Núcleo. Aunque era asunto\n" +
                    "de debate entre los historiadores, en general se creía que Coruscant era el planeta natal\n" +
                    "original de la humanidad. Destacado por su cultura cosmopolita y sus enormes rascacielos,\n" +
                    "la población de Coruscant consistía en aproximadamente un billón de ciudadanos pertenecientes a un amplio abanico de especies humanoides y alienígenas. Además, la ubicación\n" +
                    "estratégica de Coruscant al final de varias grandes rutas hiperespaciales permitió que creciera en poder e influencia, haciendo que el planeta-ciudad superara a sus rivales iniciales\n" +
                    "y se convirtiera en un núcleo galáctico de cultura, educación, finanzas, artes, política y tecnología. Albergaba varios puntos de gran interés, incluido el Templo Jedi, la Plaza de\n" +
                    "los Monumentos y el Edificio del Senado Galáctico.\n" +
                    "Sirviendo como la capital de la galaxia desde los días antiguos de la República Galáctica,\n" +
                    "Coruscant estuvo en el centro de numerosos eventos históricos, como el conflicto entre la\n" +
                    "Orden Jedi y los Sith. Aunque el planeta cayó bajo la ocupación de los Sith durante un\n" +
                    "tiempo, las fuerzas de la República en última instancia liberaron Coruscant con la ayuda\n" +
                    "de los Caballeros Jedi. Su victoria fue decisiva hasta el punto de que los Sith quedaron casi\n" +
                    "extintos, reemplazándose una época de oscuridad y guerras por el gobierno democrático\n" +
                    "de la República Galáctica moderna. Manteniendo su estatus de capital galáctica, fue en\n" +
                    "Coruscant donde el Senado Galáctico gobernó la galaxia durante siglos, estableciendo una\n" +
                    "era de paz que duró casi un milenio bajo la protección de los guardianes de la paz Jedi.", new Coordinates(500, 300))
        };
    }

    public Ship[] getShips()
    {
        return new Ship[]{
            new Ship(Side.EMPIRE,"Estrella de la Muerte", "La Estrella de la Muerte (plataforma EM-1 ), también conocida como la Estrella de " +
                    "la Muerte I, es una estación de combate espacial móvil tamaño lunar construida por el Imperio Galáctico", 15000,
                    7500, 7500, 0,
                    30, 500, 10000, getCrewMembers(6, 4, 50, Side.EMPIRE), null,
                    0, 0, false),
            new Ship(Side.EMPIRE,"Destructor estelar", "Los destructores estelares son naves de guerra relativamente comunes, son la nave de " +
                    "guerra estándar del Imperio Galáctico. La longitud un destructor estelar es de unos 3.8 kilometros.",
                    2500, 1000,1000, 500,
                    8, 80, 1500, getCrewMembers(0, 1, 7, Side.EMPIRE),
                    null, 20, 100, false),
            new Ship(Side.EMPIRE,"TIE", "La serie de cazas TIE (Motores de Iones Gemelos) diseñados por Sistemas de Flotas " +
                    "Sienar, son el símbolo de la superioridad numérica y de la voluntad implacable del Imperio para imponer el orden en la Galaxia.",
                    500, 0, 100, 500,
                    1, 20, 250, getCrewMembers(0, 1, 1, Side.EMPIRE), null, 2, 25, false),
            new Ship(Side.REBEL,"Crucero Estelar MC80a", "Construido inicialmente como una masiva nave de placer por los Astilleros de Mon " +
                    "Calamari, los Crucero Estelares MC80a han recibido una serie de actualizaciones cruciales para permitirles operar contras naves de guerra Imperiales.",
                    8000, 9000, 9000, 6000,
                    16, 30, 4000, getCrewMembers(2, 2, 16, Side.REBEL), null,
                    15, 300, false),
            new Ship(Side.REBEL,"Halcón Milenario", "El Halcón Milenario es un Carguero ligero YT-1300f. Su apariencia envejecida oculta " +
                    "numerosas modificaciones avanzadas para aumentar la velocidad, las armas y el escudo de la nave, incluido un motor hiper-impulsor entre los más rápidos de toda la galaxia.",
                    2000, 1500, 2000, 2500,
                    4, 40, 1000, getCrewMembers(0, 1, 3, Side.REBEL), null,
                    99999, 500, false),
            new Ship(Side.REBEL,"Ala-X", "El caza estelar T-65 Ala-X de Incom es el caza estelar multiusos principal de la Alianza Rebelde. Conocido por su versatilidad y excepcional rendimiento en combate.",
                    500, 500, 500, 500,
                    1, 10, 250, getCrewMembers(0, 1, 1, Side.REBEL), null, 2, 25, false)
        };
    }

    private CrewMember[] getCrewMembers(int officials, int pilots, int soldier, Side side)
    {
        CrewMember[] crewMembers = new CrewMember[officials + pilots + soldier];
        int i = 0;

        if(side == Side.EMPIRE) {
            for (i = i; i < officials; i++) {
                crewMembers[i] = new CrewMember("Sith", Appointment.OFFICIAL, null, 200, 400, Side.EMPIRE, officials, false);
            }

            for (i = i; i < pilots; i++) {
                crewMembers[i] = new CrewMember("Neimoidiano", Appointment.PILOT, null, 150, 100, Side.EMPIRE, pilots, false);
            }

            for (i = i; i < soldier; i++) {
                crewMembers[i] = new CrewMember("Stormtrooper", Appointment.SOLDIER, null, 100, 50, Side.EMPIRE, soldier, false);
            }
        }
        else
        {
            for (i = i; i < officials; i++) {
                crewMembers[i] = new CrewMember("Jedi", Appointment.OFFICIAL, null, 200, 400, Side.EMPIRE, officials, false);
            }

            for (i = i; i < pilots; i++) {
                crewMembers[i] = new CrewMember("Calamari", Appointment.PILOT, null, 150, 100, Side.EMPIRE, pilots, false);
            }

            for (i = i; i < soldier; i++) {
                crewMembers[i] = new CrewMember("Wookie", Appointment.SOLDIER, null, 100, 50, Side.EMPIRE, soldier, false);
            }
        }

        return crewMembers;
    }

    public String getInstructions()
    {
        return "Instrucciones:\n" +
                "1. Selecciona una nave de la lista de naves disponibles.\n" +
                "2. Selecciona una ubicación de la lista de ubicaciones disponibles.\n" +
                "3. Haz clic en el botón 'Viajar' para viajar a la ubicación seleccionada.\n" +
                "4. Repite los pasos 1-3 hasta que hayas visitado todas las ubicaciones.\n" +
                "5. ¡Que la Fuerza te acompañe!";
    }
}
