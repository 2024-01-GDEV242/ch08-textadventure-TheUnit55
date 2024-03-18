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
    private Player player;
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
        parser = new Parser();
        player = new Player("Z-Fighter",50);
        createRooms();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room home, grampsHome, hideout, oMansion, sCity, fPMountain, rMPath, pCastle,
        parCity, westCity, timeMachine, frzLandingShip, gingerTown, centralCity, cellGames,
        majinBuuHome, korinTower, lookout, redRHeadquater, giranVillage, fortuneBaba,
        babidiSpaceship, namVillage; //SouthCity, papaya island, training island, KameHouse,
        //kingKaiPnt
        
        Item senzuBean = new Item("SenzuBean", "a special bean that restores energy and increases strength", 1);
        
        // create the rooms
        home = new Room("In Goku's Home, where he lives with his wife ChiChi");
        
        //going east from home
        grampsHome = new Room("at Grandpas Gohans home where goku started his journey");
        grampsHome.addItem(new Item("DragonBall","4 star dragon ball", 2));
        grampsHome.addItem(new Item("PowerPole", "extending staff", 10));
        
        //going west from home
        hideout = new Room("at Yamcha's hideout in the desert with his buddy Puar");
        
        fPMountain = new Room("At FryPan Mountain where the Ox-King lived on fire mountain \nwhere goku meet ChiChi and Master Roshi showed his famous kamehame way");
        
        rMPath = new Room("Where the Rabbit gang who are a trio of rabbit worshipers who \nterrize people on passing through");
        
        pCastle = new Room("Arrived at Pilaf's castle where it used to be his main residence \nbut was turned into rubble when goku looked at the fullMoon and became \na great Ape");
        pCastle.addItem(senzuBean);
        
        parCity = new Room("At Parsley city where in an alternate timeline the androids \n attacked the humans");
        
        westCity = new Room("At West City where Bulma lives and where capsule Corp headquaters \n is located");
        
        timeMachine = new Room("Trunk's time machine where he crosses timelines");
        
        frzLandingShip = new Room("where freiza landed when he came to earth to wreck havoc");
        
        gingerTown = new Room("A suburb of West city where cell first absorbed the population");
        
        majinBuuHome = new Room("where majin buu lived with Hercule and their pet dog");
        
        korinTower = new Room("At the great tower where korin the hermit grows Senzu beans \n and lives");
        
        lookout = new Room("At the lookout where the gardian of earth watches over earth\n and where the hyperbolic time chamber is");
        
        redRHeadquater = new Room("The Red Ribbon headquaters where commander Red once orded \n his army");
        
        giranVillage = new Room("where Giran and the rest of the giras live in the village");
        
        fortuneBaba = new Room("where baba the witch lives in her palace with her five warriors");
        
        babidiSpaceship = new Room("created by babadi via magic which held majin buu");
        
        namVillage = new Room("where nam live's in a naturally barren region with very low annual rainfall, the environment\n is very harsh");
        
        centralCity = new Room("Largest city with location of King's castle, where \n where King Furry main residence is");
        
        cellGames = new Room("Where cell once gave the earth's greatest fighters 10 days \n to train and prepare to save their world");
        //going north from home
        oMansion = new Room("in Oolongs mansion where he practices his shapeShifting");
        
        sCity = new Room("At the great Satan City");
        
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
        pCastle.setExit("west", parCity);
        
        parCity.setExit("east", pCastle);
        parCity.setExit("north", westCity);
        
        westCity.setExit("south", parCity);
        westCity.setExit("east", timeMachine);
        westCity.setExit("north", frzLandingShip);
        westCity.setExit("northwest", gingerTown);
        
        timeMachine.setExit("west", westCity);
        timeMachine.setExit("east", centralCity);
        timeMachine.setExit("north", cellGames);
        
        centralCity.setExit("west", timeMachine);
        
        cellGames.setExit("south", timeMachine);
        cellGames.setExit("west", frzLandingShip);
        
        frzLandingShip.setExit("south", westCity);
        frzLandingShip.setExit("east", cellGames);
        
        gingerTown.setExit("southeast", westCity);
        gingerTown.setExit("west", majinBuuHome);
        
        majinBuuHome.setExit("east", gingerTown);
        majinBuuHome.setExit("southwest", korinTower);
        
        korinTower.setExit("northeast", majinBuuHome);
        korinTower.setExit("up", lookout);
        
        lookout.setExit("down", korinTower);
        
        oMansion.setExit("east",sCity );
        oMansion.setExit("south",home );
        
        sCity.setExit("west", oMansion);
    
        
        

        player.setCurrentRoom(home);  // start game at home
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
        System.out.println("Get ready " + player.getName() + " for your great"
         + " adventure finding the dragonBalls");
        System.out.print(player.getCurrentRoom().getLongDescription());
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
                eatItem(command);
                break;
                
            case BACK:
                back();
                break;
                
            case TAKE:
                takeItem(command);
                break;
                
            case DROP:
                dropItem(command);
                break;
                
            case ITEMS:
                player.listItems();
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

        Room currentRoom = player.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            roomHistory.push(currentRoom); 
            player.setCurrentRoom(nextRoom); 
            System.out.println(player.getCurrentRoom().getLongDescription());
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
        System.out.println(player.getCurrentRoom().getLongDescription());
        //System.out.println(player.getInventoryString());
    }
    
    /**
     * Simulates eating action within the game.
     * When this method is called, it prints a message. indicating that the 
     * player has eaten and is no longer hungry.
     * This method is used for game mechanics related to hunger or health.
     */
    private void eatItem(Command command) 
    {
        if (!command.hasSecondWord()) {
            System.out.println("Eat what?");
            return;
        }

        String itemToEat = command.getSecondWord();
        if (itemToEat.equalsIgnoreCase("SenzuBean")) {
            
            Item senzuBean = player.getItemByName(itemToEat);
            if (senzuBean != null) {
                player.increaseMaxWeight(10);
                player.removeItem(senzuBean);
                System.out.println("You've eaten the Senzu Bean. You've gained power and can carry more.");
            } else {
                System.out.println("There's no Senzu Bean to eat.");
            }
        } else {
            System.out.println("You can't eat that.");
        }
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
            player.setCurrentRoom(roomHistory.pop());
            System.out.println(player.getCurrentRoom().getLongDescription());
        } else {
            System.out.println("You are home, you cant go back");
        }
    }
    
    private void takeItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Take what?");
            return;
        }
        String itemName = command.getSecondWord();
        Item itemToTake = player.getCurrentRoom().getItem(itemName);

        if (itemToTake == null) {
            System.out.println("That's not here");
        } else {
            player.getCurrentRoom().removeItem(itemToTake);
            player.addItem(itemToTake);
            System.out.println("Taken.");
        }
    }
    
    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }
        String itemName = command.getSecondWord();
        Item itemToDrop = null;
        for (Item item : player.getInventory()) {
            if (item.getName().equals(itemName)) {
                itemToDrop = item;
                break;
            }
        }

        if (itemToDrop == null) {
            System.out.println("You currently dont have that");
        } else {
            player.removeItem(itemToDrop);
            player.getCurrentRoom().addItem(itemToDrop);
            System.out.println("Dropped.");
        }
    }
}