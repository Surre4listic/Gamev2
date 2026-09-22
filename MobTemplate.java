import java.util.UUID;;

public enum MobTemplate {
    // name,            health, damage, balance, exp
    GOBLIN("Goblin",    100,    10,     3.0,    10),
    ORC("Orc",          100,    10,     3.5,    20),
    OGRE("Ogre",        20,     20,     4.0,    30);

    private final String name;
    private final int health;
    private final int dmg;
    private final double balance;
    private final int exp;

    MobTemplate(String name, int maxHealth, int dmg, Double balance, int exp) {
        this.name = name;
        this.health = maxHealth;
        this.dmg = dmg;
        this.balance = balance;
        this.exp = exp;
    }

    // method to create new mob with random UUID
    public static Mob createMob(MobTemplate template) {
        return new Mob(UUID.randomUUID(),
            template.getName(),
            template.getHealth(),
            template.getDmg(),
            template.getDmgInterval(),
            template.getExp()
        );
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDmg() { return dmg; }
    public double getDmgInterval() { return balance; }
    public int getExp() { return exp; }

}