
/**
 * Represents an item in the adventure game. An item is characterized by its 
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
     * @return The weight of the item
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return A string representation of the item, including its description 
     * and weight
     */
    public String toString() {
        return name + ": " + description + " (Weight: " + weight + ")";
    }
    
    public String getName() {
        return name;
    }
}