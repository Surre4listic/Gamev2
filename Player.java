public class Player {

    private String name;
    private int health;
    private int healthMax;
    private int level;
    private int experience;
    private boolean isBalance = true;

    public Player(String name) {
        // Constructor code here
        this.name = name;
        this.level = 1;
        this.experience = 0;
        calculateStats();
        this.health = this.healthMax;


    }

    public void changeExperience(int exp) {
        this.experience += exp;
        calculateStats();
    }

    private void calculateStats() {
        // Calculate the player's level based on experience
        for (int i = 1; i <= Tables.levels.length; i++) {

        }
        // Calculate health based on level
        this.healthMax = 100 + (this.level - 1) * 10;

    }
}
