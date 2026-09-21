import java.util.UUID;

public class Mob {

    private final UUID id;
    private final String name;
    private int health;
    private final int damage;
    private final int exp;

    public Mob(UUID id, String name, int health, int damage, int exp) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.exp = exp;
    }

    public int calcDmg() {
        return damage;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public UUID getId() { return this.id; }
    public String getName() { return this.name; }
    public int getHealth() { return this.health; }
    public int getExp() { return this.exp; }

}
