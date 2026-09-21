public enum MobTemplate {
    // name, health, damage, exp
    GOBLIN("Goblin", 100, 10, 10),
    ORC("Orc", 100, 10, 20),
    OGRE("Ogre", 20, 20, 30);

    private final String name;
    private final int health;
    private final int damage;
    private final int exp;

    MobTemplate(String name, int maxHealth, int damage, int exp) {
        this.name = name;
        this.health = maxHealth;
        this.damage = damage;
        this.exp = exp;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getExp() { return exp; }

}
