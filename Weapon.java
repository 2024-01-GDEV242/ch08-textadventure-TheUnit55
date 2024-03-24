

public class Weapon extends Item {
    private int damageIncrease;

    public Weapon(String name, String description, int weight, int damageIncrease) {
        super(name, description, weight);
        this.damageIncrease = damageIncrease;
    }

    public int getDamageIncrease() {
        return damageIncrease;
    }
}