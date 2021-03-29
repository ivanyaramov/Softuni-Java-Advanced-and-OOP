package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTest {
    Database database;
    @Before
    public void createDatabse() throws OperationNotSupportedException {
        Person p1=new Person(1,"banov");
        Person p2=new Person(2,"kokov");
        this.database=new Database(p1,p2);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWith0People() throws OperationNotSupportedException {
        Person[] people=new Person[0];
        Database database=new Database(people);
    }
    @Test
    public void testConstructorWithSomePeople() throws OperationNotSupportedException {
        Person[] people=new Person[5];
        Database database=new Database(people);
        Assert.assertEquals(people.length,database.getElements().length);
    }
    @Test
    public void testAddPerson() throws OperationNotSupportedException {
        Person p=new Person(10,"Yaramov");
        database.add(p);
       Assert.assertEquals(p,database.getElements()[database.getElements().length-1]);

    }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullThrowsException() throws OperationNotSupportedException {

        database.add(null);

    }
   @Test
    public void testRemoveAPerson() throws OperationNotSupportedException {
        int size=database.getElements().length;
        database.remove();
        Assert.assertEquals(size-1,database.getElements().length);
   }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveAPersonWhen0ArePresent() throws OperationNotSupportedException {
        int size=database.getElements().length;
        database.remove();
        database.remove();
        database.remove();
    }

@Test(expected=OperationNotSupportedException.class)
    public void testFindByUsernameThrowsException() throws OperationNotSupportedException {
        database.add(new Person(10,"banov"));
        database.add(new Person(10,"banov"));
        database.findByUsername("banov");
}
    @Test(expected=OperationNotSupportedException.class)
    public void testFindByUsernameNullThrowsException() throws OperationNotSupportedException {
        database.add(new Person(10,"banov"));
        database.add(new Person(10,"banov"));
        database.findByUsername(null);
    }
    @Test
    public void testFindByUsernameReturnsPerson() throws OperationNotSupportedException {
String name="sosov";
        Person p1=new Person(10,name);
        database.add(p1);
        Person person=database.findByUsername(name);
        Assert.assertEquals(p1,person);
    }
    @Test(expected=OperationNotSupportedException.class)
    public void testFindByIDThrowsException() throws OperationNotSupportedException {
        database.add(new Person(10,"banov"));
        database.add(new Person(10,"banov"));
        database.findById(10);
    }
    @Test
    public void testFindByIDReturnsPerson() throws OperationNotSupportedException {
        String name="sosov";
        int id=10;
        Person p1=new Person(id,name);
        database.add(p1);
        Person person=database.findById(id);
        Assert.assertEquals(person,p1);

    }

}
