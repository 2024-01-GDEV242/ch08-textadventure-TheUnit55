
/**
 * Represents a Dragon Ball in the adventure game, a special item that extends the 
 * functionality of an Item. Dragon Balls are mystical objects with the power to summon 
 * the dragon Shenron when all seven are collected. This class inherits from the Item 
 * class and is used specifically to represent a Dragon Ball within the game.
 *
 * @author Juan Jimenez
 * @version 2024-03-11
 */
public class DragonBall extends Item {
    /**
     * Constructs a DragonBall with a specified name, description, and weight.
     * Inherits the name, description, and weight properties from the Item class.
     * Each DragonBall is a unique item within the game world.
     *
     * @param name The name of the Dragon Ball, indicating which number it is like "Four-Star Dragon Ball".
     * @param description A brief description of the Dragon Ball.
     * @param weight The weight of the Dragon Ball, affecting the player's ability to carry it.
     */
    public DragonBall(String name, String description, int weight) {
        super(name, description, weight);
    }
}
