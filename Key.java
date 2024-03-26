
/**
 * Represents a key in the adventure game, extending the functionality of an Item by 
 * adding the ability to unlock specific rooms.  Keys are specialized items that can 
 * unlock doors or pathways to new rooms, providing access to otherwise inaccessible 
 * areas.
 *
 * @author Juan Jimenez
 * @version 2024-3-22
 */
public class Key extends Item {
    private String unlocksRoom;

    /**
     * Constructs a Key with a specified name, description, weight, and the room it 
     * unlocks. Inherits the name, description, and weight properties from the Item class.
     *
     * @param name The name of the key.
     * @param description A description of the key.
     * @param weight The weight of the key, affecting the player's ability to carry it.
     * @param unlocksRoom The name of the room that this key can unlock.
     */
    public Key(String name, String description, int weight, String unlocksRoom) {
        super(name, description, weight);
        this.unlocksRoom = unlocksRoom;
    }

    /**
     * Retrieves the name of the room that this key unlocks.
     *
     * @return The name of the room this key can unlock.
     */
    public String getUnlocksRoom() {
        return unlocksRoom;
    }
}