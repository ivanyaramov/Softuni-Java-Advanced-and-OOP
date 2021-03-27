import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.Target;
import rpg_lab.Weapon;

public class HeroTestsWithMockito {
    private static final int TARGET_XP=10;
    private static final String NAME="Banov";
    @Test
    public void attackGainsExperienceIfTargetIsDead(){
        Weapon weaponMock= Mockito.mock(Weapon.class);
        Target targetMock=Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);
        Hero hero=new Hero(NAME,weaponMock);
        hero.attack(targetMock);
        Assert.assertEquals(TARGET_XP,hero.getExperience());
    }
}
