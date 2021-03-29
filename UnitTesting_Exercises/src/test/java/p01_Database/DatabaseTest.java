package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    Database database;

    @Test
    public void testConstructor() throws OperationNotSupportedException {
        Integer[] integers = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15, 16};
        this.database = new Database(integers);
        Assert.assertEquals(integers.length, database.getElements().length);
        Assert.assertArrayEquals(integers, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCapacityMoreThan16() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCapacityLessThan1() throws OperationNotSupportedException {
        new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowsExceptionWhenNullElementIsPassed() throws OperationNotSupportedException {
        this.database = new Database(new Integer[1]);
        database.add(null);
    }

    @Test
    public void testAddValidELement() throws OperationNotSupportedException {
        this.database = new Database(1);
        Integer added = 5;
        database.add(added);
        Assert.assertEquals(added, database.getElements()[1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementWhichIsNull() throws OperationNotSupportedException {
        this.database = new Database(1);
        database.remove();
        database.remove();
    }
    @Test
    public void testRemoveElementWhichIsNotNull() throws OperationNotSupportedException {
        Integer[] elements = new Integer[]{1,2,3,4,5};
        this.database = new Database(elements);
        database.remove();
        Integer[] databaseElements=database.getElements();
        Assert.assertEquals(elements.length-1,databaseElements.length);
        Assert.assertEquals(elements[elements.length-2],databaseElements[databaseElements.length-1]);

    }

}
