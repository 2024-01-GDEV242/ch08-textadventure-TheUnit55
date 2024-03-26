
/**
 * Represents an item in the Dragonball game. An item is characterized by its 
 * description and weight. Items can be placed in various rooms within the game,
 * and they can be interacted with by the player. The weight attribute of an 
 * item can be used to determine if an item can be picked up or carried by the
 * player.
 * 
 * Each item is created with a specific description that says what the item is,
 * along with its weight. The toString method provides the textual 
 * representation of the item, which includes both its description and weight,
 * making it useful for displaying item information to the player.
 *
 * @author Juan Jimenez
 * @version 2024-03-11
 */
public class Item {
    private String description;
    private int weight;
    private String name;

    /**
     * Constructor for objects of class Item
     * @param description The item's description
     * @param weight The item's weight
     */
    public Item(String name, String description, int weight) {
        this.description = description;
        this.weight = weight;
        this.name = name;
    }

    /**
     * @return The description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the weight of the item.
     * The weight is used in the game's inventory system to determine if the player 
     * can carry the item.
     *
     * @return The weight of the item.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Provides a string of the item, including its name, description, and weight.
     * This can be used to display information about the item to the player.
     *
     * @return A string that represents the item, combining its name, description, 
     * and weight.
     */
    public String toString() {
        return name + ": " + description + " (Weight: " + weight + ")";
    }
    
     /**
     * Retrieves the name of the item.
     * The name is used to identify the item within the game, in commands
     * issued by the player.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }
}