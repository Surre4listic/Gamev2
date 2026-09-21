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
    private Timers timerBalance = new Timers();

    // constructor when object is created, always require name
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

        Output.Debug(currentLevel + "-:-" + this.level);
        // Output message if you change level
        if (currentLevel > this.level) {
            Output.Send("You have increased to level " + currentLevel + "!");
        } else if (currentLevel < this.level) {
            Output.Send("You have decreased to level " + currentLevel + "!");
        }

        this.level = currentLevel;
    }

    public void Attack(String name) {
        
        for (Mob mob : Main.room.mobsInRoom) {
            timerBalance.Start(this, 2.0);
            mob.takeDamage(50);
            Output.Send("You attacked " + mob.getName() + (mob.getHealth() <= 0 ? " and it falls helplessly to the ground.":"."));
            break;
        }

    }

    // 
    public void TakeDamage(int damage) {
        this.health -= damage;
    
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean getBalance() {
        if (timerBalance.isCreated) { return true; } else { return false; }
    }

    public int getHealthMax() {
        return this.healthMax;
    }
    
    public boolean getProned() {
        return this.isProned;
    }

    public void Reset() {
        Output.Debug("You have recovered balance.");
    }

}
