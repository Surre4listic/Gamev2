import java.util.UUID;

// implements callBack interface from Timers class
public class Mob implements callBack {

    private final UUID id;
    private final String name;
    private int health;
    private final int dmg;
    private final double balance;
    private final int exp;
    private Timers timerBalance = new Timers("balance");

    // constructor
    public Mob(UUID id, String name, int health, int dmg, double balance, int exp) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.dmg = dmg;
        this.balance = balance;
        this.exp = exp;
        this.Attack();
    }

    public void timerComplete() {
        // reset balance from balance
        this.timerBalance.isReady = true;
        // attack again
        this.Attack();
    }

    private void Attack() {
        if (this.timerBalance.isReady) {
            timerBalance.Start(this, balance);
            Main.player.TakeDamage(calcDmg());
            Output.Send(this.name + " attacks you.");
        }
    }

    // metod to remove mobs in the room
    public void Remove() {
        Output.Debug("Mob -> Remove -> " + getName() + ". " + getId() + ".");
        // remove any balance timer present
        timerBalance.Cancel();
        // remove reference to timer
        timerBalance = null;
        // remove this object from 
        Main.room.mobsList.removeIf(e -> e.getId().equals(this.id));
    }

    public void takeDamage(int damage) {
        // remove health from mob
        this.health -= damage;
        // if health is less then 0
        if (this.health <= 0) {
            Main.player.expChanged(this.getExp());
            timerBalance.Cancel();
        }
    }

    public int calcDmg() { return dmg;}
    public double getDmgInterval() { return this.balance; }

    public UUID getId() { return this.id; }
    public String getName() { return this.name; }
    public int getHealth() { return this.health; }
    public int getExp() { return this.exp; }

}
