import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author Juan Jimenez
 * @version 2024-03-11
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;// stores exits of this room.
    private Item item;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Returns a detailed description of this room, including its exits and 
     * any item present. The description consists of the room's basic 
     * description, followed by a list of exits. If an item is present in the 
     * room, its description is included as well.
     * 
     * @return A String containing the long description of the room, including
     * exits and item description if an item is present.
     */
    public String getLongDescription() {
        String descriptionText = "You are " + description + ".\n" + getExitString();
    
        if (item != null) {
            descriptionText += "\nYou see " + item.toString();
        }
    
        return descriptionText;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * Sets the item contained in the room.
     * @param item The item to be placed in the room.
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return The item contained in the room.
     */
    public Item getItem() {
        return item;
    }

}

