// implements callBack interface from Timers
public class Player implements callBack {

    private String name;
    // new players always start with these
    private int health = 1000;
    private int healthMax = 1000;
    private int level = 1;
    private int experience = 0;
    // 
    private boolean isProned = true;
    // different kind of balances and timers
    private Timers timerBalance = new Timers("balance");
    private Timers timerEquilbrium = new Timers("equilbrium");

    // constructor when player object is created
    public Player(String name) {
        this.name = name;
    }

    // change experience and call method to calculate changes
    public void expChanged(int exp) {
        this.experience += exp;
        calculateStats();
    }

    // Calculate stats such as health, mana, strength etc
    private void calculateStats() {

        int currentLevel = 0;
        // Calculate the player's level based on experience
        for (int i = 0; i <= Tables.levels.length - 1; i++) {
            Output.Debug(this.experience + " >= " + Tables.levels[i][1]);
            if (this.experience >= Tables.levels[i][1]) {
                currentLevel = i + 1;
                break;
            }
        }

        // Calculate health based on level
        this.healthMax = 1000 + (this.level - 1) * 5;

        // Output message if you change level
        if (currentLevel > this.level) {
            Output.Send("You have increased to level " + currentLevel + "!");
        } else if (currentLevel < this.level) {
            Output.Send("You have decreased to level " + currentLevel + "!");
        }

        this.level = currentLevel;
    }

    public void Attack(String name) {

        // check and save eventual target in the room
        Mob target = Main.room.inRoom(name);
        if (target != null) {

            timerBalance.Start(this, 2.5);
            target.takeDamage(50);
            Output.Send("You attacked " + target.getName() + (target.getHealth() <= 0 ? " and it falls helplessly to the ground.":"."));

            if (target.getHealth() <= 0) {
                // give experience
                Main.player.expChanged(target.getExp());
                // remove target
                target.Remove();
            }

        } else {
            Output.Debug("You cant find \""+ name + "\" here.");
        }
        


    }

    // 
    public void TakeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            // dead
            // lose exp
        }
    }

    public String getName() { return this.name; }
    public int getHealth() { return this.health; }
    public int getHealthMax() { return this.healthMax; }
    public boolean getProned() { return this.isProned; }

    // metod that checks for balance and outputs error if there is no balance
    public boolean checkBalance() {
        if (getBalance()) { return true; }
        Output.Send("This action requires balance to perform.");
        return false;
    }

    public boolean getBalance() {
        if (timerBalance.getReady()) { return true; } else { return false; }
    }

    // method that overides interface in timer
    public void timerComplete() {

        Output.Debug("Timer reset for: " + this.timerBalance.timerName + ".");

        if (this.timerBalance.timerName == "balance") {

            this.timerBalance.setReady(true);
            Output.Send("You have recovered balance.");

        } else if (this.timerBalance.timerName == "equilibrium") {

            this.timerBalance.setReady(true);
            Output.Send("You have recovered equilibrium.");
        }
    }

}
