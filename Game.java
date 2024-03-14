import java.util.Stack;
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
    private Stack<Room> roomHistory = new Stack<>();
    
    /**
     * main method so it can be run outside of Blue J 
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
    
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
        grampsHome.addItem(new Item("4 star Dragon ball", 2));
        grampsHome.addItem(new Item("Power Pole", 10));
        
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
        
        grampsHome.setExit("northwest",home );
        
        hideout.setExit("northeast", home);
        hideout.setExit("west", fPMountain);
        
        fPMountain.setExit("east" , hideout);
        fPMountain.setExit("northwest" , rMPath);
        
        rMPath.setExit("southeast", fPMountain);
        rMPath.setExit("northeast", pCastle);
        
        pCastle.setExit("southwest", rMPath);
        
        oMansion.setExit("east",sCity );
        oMansion.setExit("south",home );
        
        sCity.setExit("west", oMansion);
        

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
                
            case EAT:
                eat();
                break;
                
            case BACK:
                back();
                break;
            
                
        }
        return wantToQuit;
    }

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
            roomHistory.push(currentRoom);
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
    
    /**
     * Prints the long description of the current room.
     * This method is intended to be used to give the player a detailed
     * description of their current location within the game.
     * It retrieves the long description from the currentRoom object
     * and prints it.
     */
    private void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }
    
    /**
     * Simulates eating action within the game.
     * When this method is called, it prints a message. indicating that the 
     * player has eaten and is no longer hungry.
     * This method is used for game mechanics related to hunger or health.
     */
    private void eat()
    {
        System.out.println("You have eaten and are not hungry anymore");
    }
    
    /**
     * Takes the player back to the previous room.
     * This method allows the player to navigate back to the last room they 
     * were in, It relies on a stack called roomHistory that tracks the player's
     * movement history through the game. When invoked, it checks if the room 
     * history is not empty, indicating that the player has previously moved 
     * from another room. If so, it updates the currentRoom to the most recent
     * room stored in the history and removes that entry from the history.
     * The long description of the current room is then displayed. If the 
     * player is in the starting room a message is then displayed that they 
     * cannot go back further.
     */
    private void back() {
        if (!roomHistory.isEmpty()) {
            currentRoom = roomHistory.pop();
            System.out.println(currentRoom.getLongDescription());
        } else {
            System.out.println("You are home, you cant go back");
        }
    }
}