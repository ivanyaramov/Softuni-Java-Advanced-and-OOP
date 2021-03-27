import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;

public class AxeTests {
    Dummy dummy;
@Before
public void createDummy(){
    this.dummy=new Dummy(100,100);

}
    @Test(expected = IllegalStateException.class)
    public void testAttackingWithBrokenAxe(){
        int attack=10;
        int durability=0;
        Axe axe=new Axe(attack,durability);
        axe.attack(dummy);

}
@Test
   public void testIfAxeLosesDurabilityAfterATtack(){
    int attack=10;
    int durability=100;
    Axe axe=new Axe(attack,durability);
    axe.attack(dummy);
    assertEquals(durability-1,axe.getDurabilityPoints());
}

}
