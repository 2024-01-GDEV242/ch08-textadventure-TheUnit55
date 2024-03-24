
public class Villain
{
    private String name;
    private int health;
    private Item dropItem;

    public Villain(String name, int health, Item dropItem) {
        this.name = name;
        this.health = health;
        this.dropItem = dropItem;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Item getDropItem() {
        return dropItem;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) 
        health = 0;
    }

    public boolean isDefeated() {
        return health <= 0;
    }
}
