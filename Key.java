
/**
 * 
 *
 * @author (Juan Jimenez)
 * @version 2024-3-22
 */
public class Key extends Item {
    private String unlocksRoom;

    public Key(String name, String description, int weight, String unlocksRoom) {
        super(name, description, weight);
        this.unlocksRoom = unlocksRoom;
    }

    public String getUnlocksRoom() {
        return unlocksRoom;
    }
}