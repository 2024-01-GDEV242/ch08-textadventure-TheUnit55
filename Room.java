import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

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
    private List<Item> items;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        this.items = new ArrayList<>();
        this.exits = new HashMap<>();
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
     */
    public String getShortDescription()
    {
        return description;
    }

     /**
     * Return a long description of the room, including exits and items present.
     * @return A description of the room, its exits, and any items it has.
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString() + 
        getItemDescriptions();
    }

    /**
     * Return a string listing the items in the room, if there is any.
     * @return A description of the items present in the room.
     */
    private String getItemDescriptions() {
        if (items.isEmpty()) {
            return "";
        }
        String returnString = "\nItems in the room:";
        for (Item item : items) {
              returnString += " " + item.toString();
        }
        return returnString;
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
     * Add an item to the room.
     * @param item The item to add to the room.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Remove an item from the room.
     * @param item The item to be removed.
     * @return true if the room had the specified item and it was removed, 
     * false otherwise.
     */
    public boolean removeItem(Item item) {
        return items.remove(item);
    }
    
     /**
     * Retrieves an item by its name from the room.
     * @param itemName The name of the item to retrieve.
     * @return The item with the specified name, or null if the item doesn't
     * exist in the room.
     */
    public Item getItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
        }
        }
        return null;
    }
}

