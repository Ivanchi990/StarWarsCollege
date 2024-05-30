package gui.console;

import assets.data.ApplicationValues;
import assets.data.enums.Side;
import data.DataStore;
import entities.Coordinates;
import entities.Game;
import entities.Player;
import entities.locations.*;
import entities.ships.Ship;
import entities.ships.empire.DeathStar;
import entities.ships.empire.StarDestroyer;
import entities.ships.empire.TIE;
import entities.ships.rebels.MilenniumFalcon;
import entities.ships.rebels.StarCruiser;
import entities.ships.rebels.XWing;
import exceptions.InvalidCoordenatesException;
import exceptions.InvalidOptionException;
import exceptions.NotEnoughEnergyException;
import exceptions.NotEnoughPointsException;

import java.util.*;

public class MainInterface
{
    private Scanner sc;
    private Game game;

    public MainInterface()
    {
        sc = new Scanner(System.in);
    }

    public void startGame()
    {
        System.out.println("¡Bienvenido a " + ApplicationValues.APPLICATION_NAME + "!");

        int option = 0;
        boolean validOption = false;

        while (!validOption)
        {
            try
            {
                showOptions();
                option = sc.nextInt();

                if (validOption(option, 4))
                {
                    validOption = true;
                }
                else
                {
                    System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
                }
            }
            catch (InputMismatchException e)
            {
                System.err.println("Por favor, introduce un número.");
                sc.next();
            }
            catch (InvalidOptionException e)
            {
                System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
            }
        }

        switch (option)
        {
            case 1:
                createNewGame();
                checkGameStatus();
                break;
            case 2:
                continueGame();
                checkGameStatus();
                break;
            case 3:
                showInstructions();
                break;
            case 4:
                exitGame();
                break;
        }
    }


    private void checkGameStatus()
    {
        if(game.getWinner() == null)
        {
            if(game.getRound() == 0)
            {
                System.out.println("¡Vamos a asignar las naves a los jugadores!");

                getShips(game.getPlayer1());
                getShips(game.getPlayer2());
            }

            playGame();
        }
        else
        {
            System.out.println("¡El ganador de la partida es el bando " + game.getWinner() + "! \n¡Felicidades!");

            startGame();
        }
    }


    private void playGame()
    {
        System.out.println("¡Comienza la batalla!");

        while(game.getWinner() == null)
        {
            game.showLastActions();

            if(game.getRound() % 2 == 0)
            {
                System.out.println("¡Turno del jugador 1!" + game.getPlayer1().getTeam());
                showActions(game.getPlayer1());
            }
            else
            {
                System.out.println("¡Turno del jugador 2!" + game.getPlayer2().getTeam());
                showActions(game.getPlayer2());
            }

            game.increaseRound();
            game.updateShips();
            game.checkRecharge();

            if(game.getPlayer1().getShips().isEmpty())
            {
                game.setWinner(game.getPlayer2().getTeam());
            }
            else if(game.getPlayer2().getShips().isEmpty())
            {
                game.setWinner(game.getPlayer1().getTeam());
            }
        }

        congratsWinner();
    }


    private void congratsWinner()
    {
        System.out.println("¡El ganador de la partida es el bando " + game.getWinner() + "! \n¡Felicidades!");

        startGame();
    }


    private void showActions(Player player)
    {
        int option = 0;
        boolean validOption = false;

        while (!validOption)
        {
            try
            {
                System.out.println("¿Qué acción te gustaría realizar? \n [1] Atacar \n [2] Mover nave \n [3] Ver naves \n [4] Comprar nave \n [5] Ver tablero");
                option = sc.nextInt();

                if (validOption(option, 5))
                {
                    validOption = true;
                }
                else
                {
                    System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
                }
            }
            catch (InputMismatchException e)
            {
                System.err.println("Por favor, introduce un número.");
                sc.next();
            }
            catch (InvalidOptionException e)
            {
                System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
            }
        }

        switch (option)
        {
            case 1:
                attack(player);
                break;
            case 2:
                moveShip(player);
                break;
            case 3:
                showShipsInfo(player);
                break;
            case 4:
                getShips(player);
                break;
            case 5:
                showShips(player);
                break;
        }
    }


    private void moveShip(Player player)
    {
        System.out.println("Jugador: " + player.getTeam() + "\n Turno de mover nave");

        Ship ship = showAvailableShips(player.getShips());
        int quantity = requestMovementQuantity(ship);


        try
        {
            game.playerMoveShip(player.getTeam(), ship, quantity);
        }
        catch (NotEnoughEnergyException e)
        {
            System.out.println("Vaya... parece que no tienes suficiente energía para realizar el ataque. Por favor, elige otra acción.");
            showActions(player);
        }
        catch (InvalidCoordenatesException e)
        {
            System.out.println("Vaya... parece que las coordenadas no son válidas. Por favor, elige otra acción.");
            showActions(player);
        }

        /*System.out.println("Jugador: " + player.getTeam() + "\n Turno de ataque");

        Ship ship = showAvailableShips(player.getShips());
        Coordinates coordinates = getCoordinates();

        try
        {
            game.playerAttack(player.getTeam(), coordinates, ship);
        }
        catch (NotEnoughEnergyException e)
        {
            System.out.println("Vaya... parece que no tienes suficiente energía para realizar el ataque. Por favor, elige otra acción.");
            showActions(player);
        }*/
    }

    private int requestMovementQuantity(Ship ship)
    {
        int quantity = 0;
        boolean validQuantity = false;

        while (!validQuantity)
        {
            try
            {
                System.out.println("¿Cuántas posiciones te gustaría realizar? \nMáximo: " + ship.getMaxMovement() + " posiciones.");
                quantity = sc.nextInt();

                if (validOption(quantity, ship.getMaxMovement()) && quantity > 0 && validOption(quantity, game.getLocation().getSize().getY()))
                {
                    validQuantity = true;
                }
                else
                {
                    System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
                }
            }
            catch (InputMismatchException e)
            {
                System.err.println("Por favor, introduce un número.");
                sc.next();
            }
            catch (InvalidOptionException e)
            {
                System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
            }
        }

        return quantity;
    }


    private void attack(Player player)
    {
        System.out.println("Jugador: " + player.getTeam() + "\n Turno de ataque");

        Ship ship = showAvailableShips(player.getShips());
        Coordinates coordinates = getCoordinates();

        try
        {
            game.playerAttack(player.getTeam(), coordinates, ship);
        }
        catch (NotEnoughEnergyException e)
        {
            System.out.println("Vaya... parece que no tienes suficiente energía para realizar el ataque. Por favor, elige otra acción.");
            showActions(player);
        }
    }


    private void showShipsInfo(Player player)
    {
        HashSet<Ship> uniqueShips = new HashSet<>(player.getShips().values());
        int cont = 1;

        for(Ship ship: uniqueShips)
        {
            System.out.println("[" + cont + "]" + ship.shootInfo());
            cont++;
        }

        showActions(player);
    }


    private Ship showAvailableShips(TreeMap<Coordinates, Ship> ships)
    {
        HashSet<Ship> uniqueShips = new HashSet<>(ships.values());
        boolean validOption = false;
        int option = 0;

        while (!validOption)
        {
            try
            {
                System.out.println("Naves disponibles: ");
                int cont = 1;
                for(Ship ship: uniqueShips)
                {
                    System.out.println("[" + cont + "] - " + ship.shootInfo() + "\n");
                    cont++;
                }

                option = sc.nextInt();

                if (validOption(option, uniqueShips.size()))
                {
                    validOption = true;
                }
                else
                {
                    System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
                }
            }
            catch (InputMismatchException e)
            {
                System.err.println("Por favor, introduce un número.");
                sc.next();
            }
            catch (InvalidOptionException e)
            {
                System.err.println("Vaya... parece que esa posición excede el límite. Por favor, introduce una posición válida.");
            }
        }

        return uniqueShips.toArray(new Ship[0])[option-1];
    }


    private Coordinates getCoordinates()
    {
        int x = 0;
        int y = 0;
        boolean validCoordinates = false;

        while (!validCoordinates)
        {
            try
            {
                System.out.println("Introduce las coordenadas del ataque: ");
                System.out.print("X: ");
                x = sc.nextInt();
                System.out.print("Y: ");
                y = sc.nextInt();

                if (validOption(x, game.getLocation().getSize().getX()) && validOption(y, game.getLocation().getSize().getY()))
                {
                    validCoordinates = true;
                }
                else
                {
                    System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
                }
            }
            catch (InputMismatchException e)
            {
                System.err.println("Por favor, introduce un número.");
                sc.next();
            }
            catch (InvalidOptionException e)
            {
                System.err.println("Vaya... parece que esa posición excede el límite. Por favor, introduce una posición válida.");
            }
        }

        return new Coordinates(x, y);
    }


    private void showShips(Player player)
    {
        int boardSizeX = game.getLocation().getSize().getX();
        int boardSizeY = game.getLocation().getSize().getY();
        char[][] board = new char[boardSizeX][boardSizeY];

        for (int i = 0; i < boardSizeX; i++)
        {
            for (int j = 0; j < boardSizeY; j++)
            {
                board[i][j] = '-';
            }
        }

        for (Map.Entry<Coordinates, Ship> entry :player.getShips().entrySet())
        {
            Coordinates coordinates = entry.getKey();
            board[coordinates.getX()][coordinates.getY()] = 'X';
        }

        System.out.print("  ");
        for (int i = 0; i < boardSizeY; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < boardSizeX; i++)
        {
            System.out.print(i + " ");
            for (int j = 0; j < boardSizeY; j++)
            {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }


    private void getShips(Player player)
    {
        int option = 0;
        boolean validOption = false;
        boolean enoughPoints = player.getPoints()>0;

        while(enoughPoints)
        {
            while (!validOption)
            {
                try
                {
                    if (player.getTeam().equals(Side.EMPIRE))
                    {
                        System.out.println("Jugador imperial [ Tienes "+ player.getPoints() + " pts disponibles] " +
                                "\n¿Qué nave te gustaría elegir? \n [1] Estrella de la Muerte 15000 pts \n [2] Destructor Imperial  2500 pts \n [3] Caza TIE 500 pts");
                    }
                    else
                    {
                        System.out.println("Jugador imperial [ Tienes "+ player.getPoints() + " pts disponibles] " +
                                "\n¿Qué nave te gustaría elegir? \n [1] Halcón Milenario 2000 pts \n [2] Crucero estelar  8000 pts \n [3] Ala-X 500 pts");
                    }

                    option = sc.nextInt();

                    if (validOption(option, 3))
                    {
                        validOption = true;
                        enoughPoints = enoughPoints(player, option);
                    }
                    else
                    {
                        System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
                    }
                }
                catch (InputMismatchException e)
                {
                    System.err.println("Por favor, introduce un número.");
                    sc.next();
                } catch (InvalidOptionException e)
                {
                    System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
                }
                catch(NotEnoughPointsException e)
                {
                    System.err.println("Vaya... parece que no tienes suficientes puntos para comprar esa nave. Por favor, elige otra.");
                    validOption = false;
                }
            }

            if (enoughPoints)
            {
                if (player.getTeam().equals(Side.EMPIRE))
                {
                    switch (option)
                    {
                        case 1:
                            placeShip(player, new DeathStar(new Coordinates()));
                            break;
                        case 2:
                            placeShip(player, new StarDestroyer(new Coordinates()));
                            break;
                        case 3:
                            placeShip(player, new TIE(new Coordinates()));
                            break;
                    }
                }
                else
                {
                    switch (option)
                    {
                        case 1:
                            placeShip(player, new MilenniumFalcon(new Coordinates()));
                            break;
                        case 2:
                            placeShip(player, new StarCruiser(new Coordinates()));
                            break;
                        case 3:
                            placeShip(player, new XWing(new Coordinates()));
                            break;
                    }
                }
            }

            validOption = false;
            enoughPoints = (player.getPoints() > 0);
        }

        System.out.println("¡Perfecto! Tus naves han sido asignadas. ¡Que comience la batalla!");
    }


    private boolean enoughPoints(Player player, int option) throws NotEnoughPointsException
    {
        boolean enoughPoints = true;
        int points = player.getPoints();

        switch (option)
        {
            case 1:
                if (player.getTeam().equals(Side.EMPIRE))
                {
                    if (points < new DeathStar(new Coordinates()).getPrice())
                    {
                        enoughPoints = false;
                    }
                }
                else
                {
                    if (points < new MilenniumFalcon(new Coordinates()).getPrice())
                    {
                        enoughPoints = false;
                    }
                }
                break;
            case 2:
                if (player.getTeam().equals(Side.EMPIRE))
                {
                    if (points < new StarDestroyer(new Coordinates()).getPrice())
                    {
                        enoughPoints = false;
                    }
                }
                else
                {
                    if (points < new StarCruiser(new Coordinates()).getPrice())
                    {
                        enoughPoints = false;
                    }
                }
                break;
            case 3:
                if (player.getTeam().equals(Side.EMPIRE))
                {
                    if (points < new TIE(new Coordinates()).getPrice())
                    {
                        enoughPoints = false;
                    }
                }
                else
                {
                    if (points < new XWing(new Coordinates()).getPrice())
                    {
                        enoughPoints = false;
                    }
                }
                break;
        }

        if (!enoughPoints)
        {
            throw new NotEnoughPointsException();
        }

        return enoughPoints;
    }

    private void placeShip(Player player, Ship ship)
    {
        Random random = new Random();
        player.updatePoints(-1*ship.getPrice());

        int xSize = game.getLocation().getSize().getX();
        int ySize = game.getLocation().getSize().getY();
        boolean validCoordinates = false;
        ArrayList<Coordinates> coordinates = null;

        while (!validCoordinates)
        {
            int x = random.nextInt(xSize);
            int y = random.nextInt(ySize);
            coordinates = new ArrayList<>();

            int shipSize = ship.getSize();
            Coordinates coord = null;

            if (shipSize > 1 && (y+shipSize) <= ySize)
            {
                for (int i = 0; i < shipSize; i++)
                {
                    coord = new Coordinates(x, y+i);
                    coordinates.add(coord);
                }

                validCoordinates = game.isCoordenatesAvailable(coord);
            }
            else if (shipSize == 1)
            {
                coord = new Coordinates(x, y);
                coordinates.add(coord);
                validCoordinates = game.isCoordenatesAvailable(coord);;
            }
        }

        ship.setCoordinatesStart(coordinates.get(0));

        for(Coordinates cor: coordinates)
        {
            player.addShip(cor, ship);
            game.addUsedCoordinates(cor, player.getTeam());
        }
    }


    private void createNewGame()
    {
        Location location = getLocation();
        System.out.println("¡Has elegido jugar en " + location.getName() + "!");

        Player player1 = new Player(getSide(), location.getInitialPoints());
        Player player2 = null;

        if(player1.getTeam().equals(Side.EMPIRE))
        {
            player2 = new Player(Side.REBEL, location.getInitialPoints());
        }
        else
        {
            player2 = new Player(Side.EMPIRE, location.getInitialPoints());
        }

        game = new Game(player1, player2, 0, location);

        System.out.println("Perfecto, la partida ha sido creada. ¡Que comience el juego!");
    }

    private Side getSide()
    {
        int option = 0;
        boolean validOption = false;

        while (!validOption)
        {
            try
            {
                System.out.println("Jugador 1, ¿Con qué bando de gustaría jugar?\n [1] Imperio \n [2] Rebeldes");
                option = sc.nextInt();

                if (validOption(option, 2))
                {
                    validOption = true;
                }
                else
                {
                    System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
                }
            }
            catch (InputMismatchException e)
            {
                System.err.println("Por favor, introduce un número.");
                sc.next();
            }
            catch (InvalidOptionException e)
            {
                System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
            }
        }

        Side side = null;

        switch (option)
        {
            case 1:
                side = Side.EMPIRE;
                break;
            case 2:
                side = Side.REBEL;
                break;
        }

        return side;
    }

    private Location getLocation()
    {
        int option = 0;
        boolean validOption = false;

        while (!validOption)
        {
            try
            {
                System.out.println("¿En que escenario te gustaría jugar?\n" + showLocations());
                option = sc.nextInt();

                if (validOption(option, 5))
                {
                    validOption = true;
                }
                else
                {
                    System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
                }
            }
            catch (InputMismatchException e)
            {
                System.err.println("Por favor, introduce un número.");
                sc.next();
            }
            catch (InvalidOptionException e)
            {
                System.err.println("Vaya... parece que has introducido una opción inválida. Por favor, introduce una opción válida.");
            }
        }

        Location location = null;

        switch (option)
        {
            case 1:
                location = new Agamar();
                break;
            case 2:
                location = new Alderaan();
                break;
            case 3:
                location = new Coruscant();
                break;
            case 4:
                location = new EndorMoon();
                break;
            case 5:
                location = new PlanetAtollon();
                break;
        }

        return location;
    }

    private String showLocations()
    {
        return "[1] Agamar -300x100- \n[2] Alderaan -400x400- \n[3] Coruscant -500x300- \n[4] Luna de Endor -200x200- \n[5] Planeta Atollon -100x100-";
    }


    private void continueGame()
    {
        DataStore dt = new DataStore();
        game = dt.loadData("gameData.bin");
    }



    private void showInstructions()
    {

    }



    private void exitGame()
    {
        System.out.println("¡Adios loquete!");
        sc.close();
    }


    private boolean validOption(int option, int limit) throws InvalidOptionException
    {
        if(option < 1 || option > limit)
        {
            throw new InvalidOptionException();
        }

        return true;
    }


    private void showOptions()
    {
        System.out.println("[1] Nueva partida");
        System.out.println("[2] Continar partida");
        System.out.println("[3] Instrucciones");
        System.out.println("[4] Salir");
    }
}