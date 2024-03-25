import java.util.Stack;
import java.util.Random;

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
    private Room lookout;
    
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
        player = new Player("Z-Fighter",50, 100);
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
        babidiSpaceship, namVillage, kameHouse, southCity, papayaIsland, trainingIsland, 
        pirateCave, blueCompanyBase, penguinVillage, KameHouse, kingKaiPnt, raditzLanding,
        eastCity, silverPlatoonBase, jingleVillage, muscleTower, drGeroLab, northCity;
        
       
        
        Item senzuBean = new Item("SenzuBean", "a special bean that restores energy and increases strength", 1);
        
        Key turtleShell = new Key("TurtleShell", "Master Roshi's companion", 1, "kameHouse");

        
        // create the rooms
        home = new Room("In Goku's Home, where he lives with his wife ChiChi", 10);
        
        //going east from home
        grampsHome = new Room("at Grandpas Gohans home where goku started his journey", 10);
        grampsHome.addItem(new DragonBall("DragonBall1","1 star DragonBall", 2));
        grampsHome.addItem(new DragonBall("DragonBall2","2 star DragonBall", 2));
        grampsHome.addItem(new DragonBall("DragonBall3","3 star DragonBall", 2));
        grampsHome.addItem(new DragonBall("DragonBall4","4 star DragonBall", 2));
        grampsHome.addItem(new DragonBall("DragonBall5","5 star DragonBall", 2));
        grampsHome.addItem(new DragonBall("DragonBall6","6 star DragonBall", 2));
        grampsHome.addItem(new DragonBall("DragonBall7","7 star DragonBall", 2));
        
        //grampsHome.addItem(new Item("DragonBall","4 star dragon ball", 2));
        Weapon powerPole = new Weapon("PowerPole" , "An extending staff", 10, 5);
        grampsHome.addItem(powerPole);
        
        //going west from home
        hideout = new Room("at Yamcha's hideout in the desert with his buddy Puar", 10);
        Item yamchaDropItem = new Item("WolfHide", "Clothes made from wolf hide", 1);
        Villain yamcha = new Villain("yamcha", 30, yamchaDropItem);
        hideout.setVillain(yamcha);
        
        fPMountain = new Room("At FryPan Mountain where the Ox-King lived on fire mountain \nwhere goku meet ChiChi and Master Roshi showed his famous kamehame way", 10);
        fPMountain.addItem(turtleShell);
        
        rMPath = new Room("Where the Rabbit gang who are a trio of rabbit worshipers who \nterrize people on passing through", 10);
        
        pCastle = new Room("Arrived at Pilaf's castle where it used to be his main residence \nbut was turned into rubble when goku looked at the fullMoon and became \na great Ape", 10);
        pCastle.addItem(senzuBean);
        
        parCity = new Room("At Parsley city where in an alternate timeline the androids \n attacked the humans", 10);
        
        westCity = new Room("At West City where Bulma lives and where capsule Corp headquaters \n is located", 10);
        
        timeMachine = new Room("Trunk's time machine where he crosses timelines", 10);
        
        frzLandingShip = new Room("where freiza landed when he came to earth to wreck havoc", 10);
        
        gingerTown = new Room("A suburb of West city where cell first absorbed the population", 10);
        
        majinBuuHome = new Room("where majin buu lived with Hercule and their pet dog", 10);
        
        korinTower = new Room("At the great tower where korin the hermit grows Senzu beans \n and lives", 10);
        
        lookout = new Room("At the lookout where the gardian of earth watches over earth\n and where the hyperbolic time chamber is", 10);
        this.lookout = lookout;
        
        redRHeadquater = new Room("The Red Ribbon headquaters where commander Red once orded \n his army", 10);
        
        giranVillage = new Room("where Giran and the rest of the giras live in the village", 10);
        
        fortuneBaba = new Room("where baba the witch lives in her palace with her five warriors", 10);
        
        babidiSpaceship = new Room("created by babadi via magic which held majin buu", 10);
        
        namVillage = new Room("where nam live's in a naturally barren region with very low annual rainfall, the environment\n is very harsh", 10);
        
        centralCity = new Room("Largest city with location of King's castle, where \n where King Furry main residence is", 10);
        
        cellGames = new Room("Where cell once gave the earth's greatest fighters 10 days \n to train and prepare to save their world", 10);
        //going north from home
        oMansion = new Room("in Oolongs mansion where he practices his shapeShifting", 10);
        
        sCity = new Room("At the great Satan City", 10);
        
        raditzLanding = new Room("",10);
        
        eastCity = new Room("",10); 
        
        silverPlatoonBase = new Room("",10);
        
        jingleVillage = new Room("",10);
        
        muscleTower = new Room("",10);
        
        drGeroLab = new Room("",10);
        
        northCity = new Room("",10);
        
        //going south from home
        kameHouse = new Room("At master Roshi's house where the z-fighters hang out", 10);
        kameHouse.lock("turtleShell");
        
        trainingIsland = new Room("",10);
        
        pirateCave = new Room("",10);
        
        blueCompanyBase = new Room("",10);
        
        penguinVillage = new Room("",10);
        
        kingKaiPnt = new Room("",10);
        
        papayaIsland = new Room("",10);
        
        southCity = new Room("",10);
        
        
        // initialise room exits
        home.setExit("north", oMansion);
        home.setExit("southeast", grampsHome);
        home.setExit("southwest", hideout);
        
        grampsHome.setExit("northwest",home );
        grampsHome.setExit("south", kameHouse);
        
        //going west
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
        centralCity.setExit("north", northCity);
        
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
        korinTower.setExit("south", redRHeadquater);
        
        lookout.setExit("down", korinTower);
        
        redRHeadquater.setExit("north", korinTower);
        redRHeadquater.setExit("southwest", giranVillage);
        redRHeadquater.setExit("southeast", babidiSpaceship);
        
        giranVillage.setExit("northeast", redRHeadquater);
        giranVillage.setExit("southeast", fortuneBaba);
        
        fortuneBaba.setExit("northwest", giranVillage);
        fortuneBaba.setExit("northeast", babidiSpaceship);
        fortuneBaba.setExit("southwest", namVillage);
        fortuneBaba.setExit("east", southCity);
        
        babidiSpaceship.setExit("northwest", redRHeadquater);
        babidiSpaceship.setExit("southwest", fortuneBaba);
        
        namVillage.setExit("northeast", fortuneBaba);
        
        //going North
        oMansion.setExit("east",sCity );
        oMansion.setExit("south",home );
        
        sCity.setExit("west", oMansion);
        sCity.setExit("north", raditzLanding);
        
        raditzLanding.setExit("south", sCity );
        raditzLanding.setExit("east", eastCity);
        
        eastCity.setExit("west", raditzLanding );
        eastCity.setExit("east", silverPlatoonBase);
        
        silverPlatoonBase.setExit("west", eastCity);
        silverPlatoonBase.setExit("northwest", jingleVillage );
        
        jingleVillage.setExit("southeast", silverPlatoonBase);
        jingleVillage.setExit("north", muscleTower );
        
        muscleTower.setExit("south", jingleVillage);
        muscleTower.setExit("west", drGeroLab);
        
        drGeroLab.setExit("east", muscleTower);
        drGeroLab.setExit("west", northCity);
        
        northCity.setExit("east", drGeroLab);
        northCity.setExit("south", centralCity);
    
        //going south
        kameHouse.setExit("north", grampsHome);
        kameHouse.setExit("southwest", trainingIsland);
        kameHouse.setExit("southeast", blueCompanyBase);
        
        trainingIsland.setExit("northeast", kameHouse);
        trainingIsland.setExit("south", pirateCave);
        trainingIsland.setExit("west", papayaIsland);
        trainingIsland.setExit("afterlife", kingKaiPnt);
        
        pirateCave.setExit("north", trainingIsland);
        
        blueCompanyBase.setExit("northwest", kameHouse);
        blueCompanyBase.setExit("east", penguinVillage);
        
        penguinVillage.setExit("west", blueCompanyBase);
        penguinVillage.setExit("afterlife", kingKaiPnt);
        
        kingKaiPnt.setExit("penguinVillage", penguinVillage);
        kingKaiPnt.setExit("trainingIsland", trainingIsland);
        
        papayaIsland.setExit("east", trainingIsland);
        papayaIsland.setExit("west", southCity);
        
        southCity.setExit("east", papayaIsland);
        southCity.setExit("west", fortuneBaba);
        
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
        System.out.println("Thank you for playing DragonBall text adventure. Good bye.");
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
                
            case FIGHT:
                fightVillain(command);
                break;
                
            case HEALTH:
                System.out.println("Current health: " + player.getCurrentHealth());
                break;
                
            case SUMMON:
                if (player.getCurrentRoom().equals(lookout) && 
                    player.countDragonBalls() == 7) {
                    System.out.println("You have collected all 7 dragon balls and summoned Shenron. You win!");
                    wantToQuit = true;
                } else {
                    System.out.println("Nothing happens, are at the lookout with all 7 Dragon Balls.");
                }
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
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        Room currentRoom = player.getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is nothing there");
        } else if (nextRoom.isLocked()) {
            if (player.hasKey(nextRoom.getKeyName())) {
            nextRoom.unlock();
            System.out.println("You have been granted access");
            player.setCurrentRoom(nextRoom);
            System.out.println(player.getCurrentRoom().getLongDescription());
        } else {
            System.out.println("You don't have the key.");
            }
        } else {
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
            return true;
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
                player.increaseMaxHealth(20);
                player.heal(20);
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
            System.out.println("That's not here.");
        } else {
            player.getCurrentRoom().removeItem(itemToTake);
            player.addItem(itemToTake);
            System.out.println(itemToTake.getName() + " taken.");
            if (itemToTake instanceof Weapon) {
                player.equipWeapon((Weapon)itemToTake);
                System.out.println("You equipped " + itemToTake.getName() + " as a weapon.");
            
            }
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
    
    private void fightVillain(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Fight what?");
            return;
        }

        String fightWith = command.getSecondWord().toLowerCase();
        Room currentRoom = player.getCurrentRoom();

        if (currentRoom.hasVillain()) {
            Villain villain = currentRoom.getVillain();
            Random rand = new Random();
            String[] choices = {"rock", "paper", "scissors"};
            String playerChoice = fightWith;
            String villainChoice = choices[rand.nextInt(choices.length)];

            System.out.println("You chose " + playerChoice + ". Villain chose " + 
            villainChoice + ".");
            if (playerChoice.equals(villainChoice)) {
                System.out.println("It's a draw.");
            } else if ((playerChoice.equals("rock") && villainChoice.equals("scissors")) ||
                   (playerChoice.equals("paper") && villainChoice.equals("rock")) ||
                   (playerChoice.equals("scissors") && villainChoice.equals("paper"))) {
                System.out.println("You win!");
                int damageDealt = 20 + player.getAdditionalDamage(); 
                villain.takeDamage(damageDealt);
                if (villain.isDefeated()) {
                    System.out.println(villain.getName() + " is defeated!");
                    if (villain.getDropItem() != null) {
                        currentRoom.removeItem(villain.getDropItem());
                        player.addItem(villain.getDropItem());
                        System.out.println("You obtained " + 
                        villain.getDropItem().getName() + ".");
                    }
                }
            }else {
                System.out.println("You lose.");
                player.receiveDamage(10);
            }
        } else {
            System.out.println("There is no villain to fight here.");
        }
    }   
    
    private void fight(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Fight who?");
            return;
        }

        Room currentRoom = player.getCurrentRoom();
        if (!currentRoom.hasVillain()) {
            System.out.println("There's no one here to fight.");
            return;
        }

        Villain villain = currentRoom.getVillain();
    }
}