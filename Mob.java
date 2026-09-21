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
        // reset balance from balance
        this.balance.isCreated = false;
        // remove timer for balance
        // this.balance.timer.cancel();
        // attack again
        this.Attack();
    }

    private void Attack() {
        if (!this.balance.isCreated) {
            balance.Start(this, dmginterval);
            Main.player.TakeDamage(calcDmg());
            Output.Send(this.name + " attacks you.");
        }
    }

    // metod to remove mobs in the room
    public void Remove() {
        Output.Debug("Mob -> Remove -> " + getName() + ". " + getId() + ".");
        // remove any balance timer present
        balance.Cancel();
        // remove reference
        balance = null;
    }

    public void takeDamage(int damage) {
        // remove health from mob
        this.health -= damage;
        // if health is less then 0
        if (this.health <= 0) {
            Main.player.expChanged(this.getExp());
            balance.Cancel();
        }
    }

    public int calcDmg() { return dmg;}
    public double getDmgInterval() { return this.dmginterval; }

    public UUID getId() { return this.id; }
    public String getName() { return this.name; }
    public int getHealth() { return this.health; }
    public int getExp() { return this.exp; }

}
