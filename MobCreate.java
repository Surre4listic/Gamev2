import java.util.UUID;

public class MobCreate {
    
    public static Mob createMob(MobTemplate template) {
        return new Mob(UUID.randomUUID(),
            template.getName(),
            template.getHealth(),
            template.getDamage(),
            template.getExp()
        );
    }

}
