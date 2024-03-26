
/**
 * Represents a villain in the DragonBall game. Villains are characters that the player
 * can encounter and combat within the game. Each villain has a name, 
 * health points, and an item that they can drop when defeat.
 *
 * @author Juan Jimenez
 * @version 2024-03-11
 */
public class Villain
{
    private String name;
    private int health;
    private Item dropItem;

     /**
     * Constructs a Villain with a specified name, health, and item to drop upon defeat.
     *
     * @param name The name of the villain.
     * @param health The initial health points of the villain.
     * @param dropItem The item that will be dropped by the villain when defeated.
     */
    public Villain(String name, int health, Item dropItem) {
        this.name = name;
        this.health = health;
        this.dropItem = dropItem;
    }

    /**
     * Retrieves the name of the villain.
     *
     * @return A string representing the name of the villain.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the current health points of the villain.
     *
     * @return The current health points of the villain.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Retrieves the item that the villain will drop when defeated.
     *
     * @return The item to be dropped upon the villain's defeat.
     */
    public Item getDropItem() {
        return dropItem;
    }

    /**
     * Reduces the villain's health by a specified amount of damage. If health is less
     * than 0, is set to 0.
     *
     * @param damage The amount of damage to be inflicted on the villain.
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) 
        health = 0;
    }

    /**
     * Checks whether the villain is defeated, which is determined by their health 
     * being 0
     *
     * @return True if the villain's health is 0 or less, indicating they are defeated;
     * otherwise false.
     */
    public boolean isDefeated() {
        return health <= 0;
    }
}
