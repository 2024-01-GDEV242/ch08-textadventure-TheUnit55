import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a location in the game world. Each room has a description, exits to other
 * rooms, items, and some a villain. Rooms can be locked and require a specific 
 * item key to unlock.
 *
 * @author Juan Jimenez
 * @version 2024-03-11
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private List<Item> items;
    private boolean isLocked;
    private String keyName;
    private int damage;
    private Villain villain;
    
        
    /**
    * Constructs a Room with a description and initial damage setting.
    * Initializes the room with no exits, no items, not locked, and without a villain.
    *
    * @param description The description of the room.
    * @param damage The initial damage setting for the room.
    */
    public Room(String description, int damage) 
    {
        this.description = description;
        this.items = new ArrayList<>();
        this.exits = new HashMap<>();
        this.isLocked = false;
        this.keyName = null;
        this.damage = damage;
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
     * Constructs and returns a long description of the room that includes exits, items,
     * and any present villain.
     *
     * @return A detailed description of the room, its exits, items, and villain
     */
    public String getLongDescription() {
        String description = "You are " + this.description + ".\n" + getExitString() + 
        getItemDescriptions();
        if (hasVillain()) {
            description += "\nnew foe appeared " + villain.getName() + 
            " who is ready to fight. Villain Health: " + villain.getHealth() + 
            "\nfighting options are fight[rock, paper, scissors]";
        }
        return description;
    }

    /**
     * Generates and returns a string listing all items in the room.
     *
     * @return A description of all items present in the room. Returns an empty string 
     * if no items are present.
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
    
    /**
     * Locks the room, requiring a specific key to unlock.
     *
     * @param keyName The name of the key required to unlock the room.
     */
    public void lock(String keyName) {
        isLocked = true;
        this.keyName = keyName;
    }

    /**
     * Attempts to unlock the room using a provided item as a key.
     *
     * @param key The item used as a key to attempt unlocking the room.
     * @return true if the room was successfully unlocked, false otherwise.
     */
    public boolean unlock(Item key) {
        if (key.getName().equals(this.keyName)) {
            isLocked = false;
            System.out.println("You now have access");
            return true;
        }
        System.out.println("Not the right key");
        return false;
    }

    /**
     * Checks if the room is currently locked.
     *
     * @return true if the room is locked, false otherwise.
     */
    public boolean isLocked() {
        return isLocked;
    }

    
    /**
     * Retrieves the name of the key required to unlock the room.
     *
     * @return The name of the key item needed to unlock the room.
     */
    public String getKeyName() {
        return keyName;
    }
    
    /**
     * Unlocks the room, allowing entry 
     */
    public void unlock() {
        this.isLocked = false;
    }

    /**
     * Returns the damage setting of the room.
     *
     * @return The damage value associated with the room.
     */
    public int getDamage() {
        return damage;
    }
    
    /**
     * Sets a villain in the room.
     *
     * @param villain The villain to be placed in the room.
     */
        public void setVillain(Villain villain) {
        this.villain = villain;
    }

    /**
     * Retrieves the villain present in the room, if any.
     *
     * @return The villain in the room or null if no villain is present.
     */
    public Villain getVillain() {
        return villain;
    }

    /**
     * Checks if there is an undefeated villain present in the room.
     *
     * @return true if an undefeated villain is present, false otherwise.
     */
    public boolean hasVillain() {
        return villain != null && !villain.isDefeated();
    }
}

