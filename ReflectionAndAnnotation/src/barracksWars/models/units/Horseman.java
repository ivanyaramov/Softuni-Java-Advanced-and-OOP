package barracksWars.models.units;

public class Horseman extends AbstractUnit {
    private static final int HORSEMAN_HEALTH = 50;
    private static final int HORSEMAN_DAMAGE = 10;
    protected Horseman(int health, int attackDamage) {
        super(HORSEMAN_HEALTH,HORSEMAN_DAMAGE);
    }
}
