import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;

public class DummyTests {
    private static final int  HEALTH=100;
Dummy dummy;
@Before
public void createDummy(){
    this.dummy=new Dummy(HEALTH,10);
}
    @Test
    public void testIfDummyLosesHealthWhenAttacked(){

dummy.takeAttack(10);
        assertEquals(HEALTH-10,dummy.getHealth());
    }
    @Test(expected = IllegalStateException.class)
    public void testIfDeadDummyThrowsExceptionWhenAttacked(){
this.dummy=new Dummy(0,10);
dummy.takeAttack(5);

    }
    @Test
    public void testIfDeadDummyCanGiveXP(){
        this.dummy=new Dummy(0,10);
        assertEquals(dummy.giveExperience(),dummy.giveExperience());
    }
    @Test(expected = IllegalStateException.class)
    public void testIfAliveDummyCantGiveXP(){
        this.dummy=new Dummy(10,10);
        assertEquals(dummy.giveExperience(),dummy.giveExperience());
    }
}
