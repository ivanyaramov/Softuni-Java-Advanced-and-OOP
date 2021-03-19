package barracksWars.models.units;

public class Gunner extends AbstractUnit {
    private static final int GUNNER_HEALTH = 20;
    private static final int GUNNER_DAMAGE = 20;
    protected Gunner(int health, int attackDamage) {
        super(GUNNER_HEALTH,GUNNER_DAMAGE);
    }
}
