import java.util.ArrayList;
import java.util.List;
/**
 * Represents a player in the dragonball game. Stores information such as name, health,
 * inventory, and location. Players can carry items, fight villains, and move through
 * rooms in the game world of dragonballs.
 *
 * @author Juan Jimenez
 * @version 2024-03-11
 *
 **/
public class Player 
{
    private String name;
    private Room currentRoom;
    private List<Item> inventory;
    private int maxWeight;
    private int currentWeight;
    private int maxHealth;
    private int currentHealth;
    private int additionalDamage = 0;
    private int baseDamage = 10;
    
    /**
     * Constructs a Player with specified name, maximum carry weight, and maximum health.
     * Initializes player's inventory and sets current health to maximum.
     *
     * @param name The name of the player.
     * @param maxWeight The maximum weight the player can carry.
     * @param maxHealth The maximum health of the player.
     */
    public Player(String name, int maxWeight, int maxHealth) {
        this.name = name;
        this.inventory = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }
    
    /**
     * Sets the current room of the player to the specified room.
     *
     * @param currentRoom The new current room of the player.
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    
    /**
     * Returns the current room where the player is located.
     *
     @return The current room of the player.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    /**
     * Returns the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Attempts to add an item to the player's inventory. Checks if the addition
     * does not exceed the maximum weight the player can carry.
     *
     * @param item The item to be added.
     * @return true if the item was successfully added, false otherwise.
     */
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

    /**
     * Removes an item from the player's inventory.
     *
     * @param item The item to be removed.
     * @return true if the item was successfully removed, false otherwise.
     */
    public boolean removeItem(Item item) {
        if (inventory.remove(item)) {
            currentWeight -= item.getWeight();
            return true;
        }
        return false;
    }

    /**
     * Returns the list of items in the player's inventory.
     *
     * @return A list of items currently carried by the player.
     */
    public List<Item> getInventory() {
        return inventory;
    }
    
    /**
     * Lists all items in the player's inventory along with their weight.
     */
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

    /**
     * Retrieves an item by its name from the player's inventory.
     *
     * @param name The name of the item to retrieve.
     * @return The item with the specified name, or null if not found.
     */
    public Item getItemByName(String name) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Increases the maximum weight the player can carry.
     *
     * @param weight The amount by which to increase the max weight.
     */
    public void increaseMaxWeight(int weight) {
        this.maxWeight += weight;
        System.out.println("Your power has increased by " + weight + ".");
    }
    
    /**
     * Checks if the player has a specific key.
     *
     * @param keyName The name of the key to check for.
     * @return true if the player has the key, false otherwise.
     */
    public boolean hasKey(String keyName) {
        for (Item item : inventory) {
            if (item instanceof Key && item.getName().equalsIgnoreCase(keyName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves a key item by its name from the player's inventory.
     *
     * @param keyName The name of the key to retrieve.
     * @return The key item, or null if not found.
     */
    public Item getKey(String keyName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(keyName) && item instanceof Key) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Applies damage to the player, reducing their current health.
     *
     * @param damage The amount of damage to inflict.
     */
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

    /**
     * Heals the player by a specified amount, not exceeding their maximum health.
     *
     * @param amount The amount of health to restore.
     */
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

    /**
     * Returns the player's current health.
     *
     * @return The current health of the player.
     */
    public int getCurrentHealth() {
        return currentHealth;
    }
    
    /**
    * Checks if the player is alive, based on their current health.
     *
     * @return true if the player is alive, false otherwise.
     */
    public boolean isAlive() {
        return currentHealth > 0;
    }
    
    /**
     * Increases the player's current health by a specified amount, not exceeding 
     * maximum health.
     *
     * @param amount The amount by which to increase health.
     */
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
    
    /**
     * Increases the player's maximum health by a specified amount and heals the 
     * player by the same amount.
     *
     * @param amount The amount by which to increase maximum health.
     */
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

    /**
     * Equips a weapon, increasing the player's damage output by the weapon's damage 
     * increase value.
     *
     * @param weapon The weapon to equip.
     */
    public void equipWeapon(Weapon weapon) {
        additionalDamage += weapon.getDamageIncrease();
    }

    /**
     * Returns the player's additional damage value from equipped weapons.
     *
     * @return The additional damage value.
     */
    public int getAdditionalDamage() {
        return additionalDamage;
    }

    /**
     * Counts how many Dragon Balls the player has in their inventory.
     *
     * @return The number of Dragon Balls in the inventory.
     */
    public int countDragonBalls() {
        int count = 0;
        for (Item item : inventory) {
            if (item instanceof DragonBall) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calculates and returns the player's total damage output, combining base 
     * damage with additional damage from equipped weapons.
     */
    public int getCurrentDamage() {
        int totalDamage = baseDamage + additionalDamage;
        System.out.println("Your current damage: " + totalDamage);
        return totalDamage;
    }
}


