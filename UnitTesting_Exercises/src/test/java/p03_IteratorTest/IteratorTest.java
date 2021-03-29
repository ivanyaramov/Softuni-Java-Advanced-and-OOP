package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;
import java.util.List;

public class IteratorTest {
    ListIterator listIterator;
@Before
public void createIterator() throws OperationNotSupportedException {
    this.listIterator=new ListIterator("a","b");
}
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void testMoveWhenThereAreNextElements() throws OperationNotSupportedException {
        Assert.assertTrue(listIterator.move());
    }
    @Test
    public void testMoveWhenThereAreNoNextElements() throws OperationNotSupportedException {
       listIterator.move();
       listIterator.move();
               Assert.assertFalse(listIterator.move());
    }

    @Test
    public void testPrint() throws OperationNotSupportedException {
Assert.assertEquals("a",this.listIterator.print());
this.listIterator.move();
Assert.assertEquals("b",this.listIterator.print());
    }
}
