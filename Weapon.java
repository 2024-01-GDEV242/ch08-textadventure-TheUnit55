
/**
 * Represents a weapon in the Dragonball game, extending the functionality of an Item by
 * adding the ability to increase damage dealt by the player. Weapons can be equipped to 
 * enhance the player's attack.
 *
 * @author Juan Jimenez
 * @version 2024-03-11
 */
public class Weapon extends Item {
    private int damageIncrease;

    /**
     * Constructs a Weapon with a specified name, description, weight, and damage 
     * increase.Inherits the name, description, and weight properties from the Item class.
     *
     * @param name The name of the weapon.
     * @param description A description of the weapon.
     * @param weight The weight of the weapon, affecting the player's ability to carry.
     * @param damageIncrease The additional damage dealt by the player when a weapon 
     * is equipped.
     */
    public Weapon(String name, String description, int weight, int damageIncrease) {
        super(name, description, weight);
        this.damageIncrease = damageIncrease;
    }

    /**
     * Retrieves the amount of damage increase provided by this weapon.
     *
     * @return The additional damage dealt when this weapon is equipped.
     */
    public int getDamageIncrease() {
        return damageIncrease;
    }
}