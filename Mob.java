import java.util.UUID;

public class Mob implements callBack {

    private final UUID id;
    private final String name;
    private int health;
    private final int dmg;
    private final double dmginterval;
    private final int exp;
    private Timers balance = new Timers();

    public Mob(UUID id, String name, int health, int dmg, double dmginterval, int exp) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.dmg = dmg;
        this.dmginterval = dmginterval;
        this.exp = exp;
        this.Attack();
    }

    public void Reset() {
        System.out.println("Test from mob");
    }

    private void Attack() {
        //
        balance.Start(this, dmginterval);
    }

    

    public int calcDmg() { return dmg;}
    public double getDmgInterval() { return this.dmginterval; }
    public void takeDamage(int damage) { this.health -= damage; }

    public UUID getId() { return this.id; }
    public String getName() { return this.name; }
    public int getHealth() { return this.health; }
    public int getExp() { return this.exp; }


}
