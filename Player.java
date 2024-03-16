import java.util.ArrayList;
import java.util.List;
/**
 * The Player class represents a player in the adventure game. 
 * It stores information about the player, including their name 
 * and their current location within the game.
 */
public class Player 
{
    private String name;
    private Room currentRoom;
    private List<Item> inventory;
    
    public Player(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
    
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public String getName() {
        return name;
    }
    
    public void addItem(Item item) {
        inventory.add(item);
    }

    public boolean removeItem(Item item) {
        return inventory.remove(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public String getInventoryString() {
        if (inventory.isEmpty()) {
            return "You currently are carrying nothing.";
        }
        String returnString = "You are currently carrying the:";
        for (Item item : inventory) {
            returnString += " " + item.getName();
        }
        return returnString;
    }
}

