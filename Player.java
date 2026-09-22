
public class Player implements Listener {

    private String name;
    // new players always start with these
    private int health = 1000;
    private int healthMax = 1000;
    private int level = 0;
    private int experience = 0;
    // 
    private boolean isProned = false;

    // create our own Timer from Timers object that are modified. Pass this class that has the listener, pass name for onTaskComplete listener
    private Timers timeBalance = new Timers("balance", this);
    private Timers timeSleep = new Timers("sleeping", this);

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
        for (int lvl = 0; lvl <= 100; lvl++) {
            Output.Debug("Our experience: " + this.experience + "/" + ((int)(100.0 * Math.pow(lvl, 1.5))) + ". Next: "+ ((int)(100.0 * Math.pow(lvl+1, 1.5))) +". Level: " + lvl + ". ");
            if ((int)(100.0 * Math.pow(lvl, 1.5)) <= this.experience) {
                currentLevel = lvl;
            } else {
                break;
            }
        }

        // Calculate health based on level
        this.healthMax = (int)Math.round(1000 + (this.level - 1) * 0.5);

        // Output message if you change level
        if (currentLevel > this.level) {
            Output.Send("You have increased to level " + currentLevel + "!");
        } else if (currentLevel < this.level) {
            Output.Send("You have decreased to level " + currentLevel + "!");
        }

        this.level = currentLevel;
    }

    //
    public void healthIncrease() {
        this.health = Math.min((int)(this.healthMax * 1.20), this.healthMax);
    }

    // 
    public void Attack(String name) {
        // check and save eventual target in the room
     
        Mob target = Main.room.inRoom(name);
        if (target != null) {

            timeBalance.Start(2500L);
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

    public void Sleep() {

        timeSleep.Start(3000L);
        System.out.println("Start timer.");
        Output.Send("You lay down and fall sleep.");
        this.isProned = true;

    }

    // 
    public void TakeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            Main.room.clearRoom();
            Output.Send("You have died.");
            Main.player.calculateStats();
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
        return timeBalance.getReady();
    }


    // method that overides interface in timers
    @Override
    public void onTaskComplete(TimersReturn result) {
        Output.Debug("Player (onTaskComplete): '" + result.getName() + "'");

        if ("balance".equals(result.getName())) {

            timeBalance.setReady(true);
            Output.Send("You have recovered your balance.");
            
        } else if ("sleeping".equals(result.getName())) {

            this.health = Math.min((int)(this.healthMax * 1.20), this.healthMax);
            if (getHealthMax() >= getHealth()) {
                Output.Send("You snore and continue sleeping.");
            } else {
                timeSleep.setReady(true);
                Output.Send("You are fully rested.");
            }



        }

    }


}
