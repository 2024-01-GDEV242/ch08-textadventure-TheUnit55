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
    private int maxHealth;
    private int currentHealth;
    
    public Player(String name, int maxWeight, int maxHealth) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
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
    
    public boolean hasKey(String keyName) {
        for (Item item : inventory) {
            if (item instanceof Key && item.getName().equalsIgnoreCase(keyName)) {
                return true;
            }
        }
        return false;
    }

    public Item getKey(String keyName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(keyName) && item instanceof Key) {
                return item;
            }
        }
        return null;
    }
    
    public void receiveDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth <= 0) {
            currentHealth = 0;
            System.out.println("You have been defeated. Game Over.");
            
        } else {
            System.out.println("You've taken " + damage + " damage. Current health: " +
            currentHealth + "/" + maxHealth);
        }
    }

    public void heal(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid heal amount.");
            return;
        }
        this.currentHealth += amount;
        if (this.currentHealth > this.maxHealth) {
            this.currentHealth = this.maxHealth;
        }
        System.out.println("You've been healed. Current health: " + this.currentHealth +
        "/" + this.maxHealth);
    }

    public int getCurrentHealth() {
        return currentHealth;
    }
    
    public boolean isAlive() {
        return currentHealth > 0;
    }
    
     public void increaseHealth(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid heal amount.");
            return;
        }
        this.currentHealth += amount;
        if (this.currentHealth >= this.maxHealth) {
            this.currentHealth = this.maxHealth;
        }
        System.out.println("Your health has increased by " + amount +
        ". Current health: " + this.currentHealth + "/" + this.maxHealth);
    }
    
    public void increaseMaxHealth(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid health increase amount.");
            return;
        }
        this.maxHealth += amount;
        this.currentHealth += amount;
        System.out.println("Your maximum health has increased by " + amount + 
        ". Max health: " + this.maxHealth);
    }
}

