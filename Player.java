
public class Player {

    private String name;
    // new players always start with these
    private int health = 1000;
    private int healthMax = 1000;
    private int level = 1;
    private int experience = 0;
    // 
    private boolean isProned = true;
    // different kind of balances and timers
    public Timers hasBalance = new Timers();

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
        this.healthMax = 100 + (this.level - 1) * 10;

        Output.Debug(currentLevel + "-:-" + this.level);
        // Output message if you change level
        if (currentLevel > this.level) {
            Output.Send("You have increased to level " + currentLevel + "!");
        } else if (currentLevel < this.level) {
            Output.Send("You have decreased to level " + currentLevel + "!");
        }

        this.level = currentLevel;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getHealthMax() {
        return this.healthMax;
    }
    
    public boolean getProned() {
        return this.isProned;
    }


}
