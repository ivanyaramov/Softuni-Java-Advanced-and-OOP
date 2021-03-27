import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

import static org.junit.Assert.assertEquals;

public class HeroTests {
    public static final int TARGETXP=10;

    @Test
    public void attackGainExperienceIfTargetIsDead(){
        Target fakeTarget= new Target(){

            public void takeAttack(int attackPoints) {

            }

            public int getHealth() {
                return 0;
            }

            public int giveExperience() {
                return TARGETXP;
            }

            public boolean isDead() {
                return true;
            }
        };

        Weapon fakeWeapon = new Weapon(){

            public void attack(Target target) {

            }

            public int getAttackPoints() {
                return 10;
            }

            public int getDurabilityPoints() {
                return 0;
            }
        };
        Hero hero=new Hero("banov",fakeWeapon);
        hero.attack(fakeTarget);
       assertEquals(TARGETXP,hero.getExperience());

    }
}
