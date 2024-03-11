/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author Juan Jimenez
 * @version 2024-03-11
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room home, grampsHome, hideout, oMansion, sCity, fPMountain, rMPath, pCastle;
      
        // create the rooms
        home = new Room("In Goku's Home, where he lives with his wife ChiChi");
        grampsHome = new Room("at Grandpas Gohans home where goku started his journey");
        hideout = new Room("at Yamcha's hideout in the desert with his buddy Puar");
        oMansion = new Room("in Oolongs mansion where he practices his shapeShifting");
        sCity = new Room("At the great Satan City");
        fPMountain = new Room("At FryPan Mountain where the Ox-King lived on fire mountain \nwhere goku meet ChiChi and Master Roshi showed his famous kamehame way");
        rMPath = new Room("Where the Rabbit gang who are a trio of rabbit worshipers who \nterrize people on passing through");
        pCastle = new Room("Arrived at Pilaf's castle where it used to be his main residence \nbut was turned into rubble when goku looked at the fullMoon and became \na great Ape");
        
        // initialise room exits
        home.setExit("north", oMansion);
        home.setExit("southeast", grampsHome);
        home.setExit("southwest", hideout);
        //home.setExits(oMansion, grampsHome, null, hideout);
        grampsHome.setExit("northwest",home );
        //grampsHome.setExits(null, null, null, home);
        hideout.setExit("northeast", home);
        hideout.setExit("west", fPMountain);
        //hideout.setExits(null, home, null, null);
        fPMountain.setExit("east" , hideout);
        fPMountain.setExit("northwest" , rMPath);
        
        rMPath.setExit("southeast", fPMountain);
        rMPath.setExit("northeast", pCastle);
        
        pCastle.setExit("southwest", rMPath);
        
        oMansion.setExit("east",sCity );
        oMansion.setExit("south",home );
        //oMansion.setExits(null, sCity, home, null);
        sCity.setExit("west", oMansion);
        //sCity.setExits(null, null, null, oMansion);

        currentRoom = home;  // start game at home
    }

     /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of dragonBall");
        System.out.println("Dragon ball is a new, incredible adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case LOOK:
                look();
                break;
                
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. be careful you are");
        System.out.println("near powerful foes");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    private void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }
}
