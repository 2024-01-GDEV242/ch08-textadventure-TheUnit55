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
    private int maxWeight;
    private int currentWeight;
    
    public Player(String name, int maxWeight) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
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
    
    public boolean addItem(Item item) {
        if (currentWeight + item.getWeight() <= maxWeight) {
            inventory.add(item);
            currentWeight += item.getWeight();
            return true;
        } else {
            System.out.println("Max weight reached, keep training");
            return false;
        }
    }

    public boolean removeItem(Item item) {
        if (inventory.remove(item)) {
            currentWeight -= item.getWeight();
            return true;
        }
        return false;
    }

    public List<Item> getInventory() {
        return inventory;
    }
    
    public void listItems() {
        if (inventory.isEmpty()) {
            System.out.println("You are carrying nothing.");
            return;
        }
        System.out.println("Items carried:");
        for (Item item : inventory) {
            System.out.println(item.getName() + " (Weight: " + 
            item.getWeight() + ")");
        }
        System.out.println("Total weight: " + currentWeight + "/" + 
        maxWeight);
    }

    public Item getItemByName(String name) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
    
    public void increaseMaxWeight(int weight) {
        this.maxWeight += weight;
        System.out.println("Your power has increased by " + weight + ".");
    }
}

