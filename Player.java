public class Player {

    private String name;
    private int health;
    private int healthMax;
    private int level;
    private int experience;
    private boolean isBalance = true;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        calculateStats();
        this.health = this.healthMax;
    }

    public void expChanged(int exp) {
        this.experience += exp;
        calculateStats();
    }

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

        Output.Debug(currentLevel + ":" + this.level);
        // Output message if you change level
        if (currentLevel > this.level) {
            Output.Send("You have increased to level " + currentLevel + "!");
        } else if (currentLevel < this.level) {
            Output.Send("You have decreased to level " + currentLevel + "!");
        }

        this.level = currentLevel;
    }

    public int getHealth() {
        return this.health;
    }

}
