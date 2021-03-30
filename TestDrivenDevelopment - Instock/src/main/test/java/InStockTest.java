import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class InStockTest {
    Instock instock;
    @Before
    public void createInstock(){
        this.instock=new Instock();
        Product product1=new Product("label1",1,1);
        Product product2=new Product("label2",2,2);


    }
    @Test
    public void testAddAndContainsMethod(){
        Product product=new Product("label",5.5,5);
        Instock instock=new Instock();
        instock.add(product);
        Assert.assertTrue(instock.contains(product));
        assertEquals(1,instock.getCount());
    }
    @Test
    public void testContainsShouldReturnFalseWhenProductIsNotPresent(){
        Product product=new Product("label",5.5,5);
        Instock instock=new Instock();
        Product notPresent=new Product("test",10,10);
        instock.add(product);
        Assert.assertFalse(instock.contains(notPresent));
        assertEquals(1,instock.getCount());
    }
    @Test
    public void testContainsShouldReturnFalseWhenInstockIsEmpty(){
        Instock instock=new Instock();
        Product notPresent=new Product("test",10,10);
        Assert.assertFalse(instock.contains(notPresent));
        assertEquals(0,instock.getCount());
    }
    @Test
    public void testFindFindsAProduct(){
        Product product1=new Product("label1",1,1);
        Instock instock=new Instock();
        instock.add(product1);
        Product product=instock.find(0);
        Assert.assertNotNull(product);
        assertEquals(0,product.compareTo(product1));

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithInvalidUpperIndex(){
        Product product1=new Product("label1",1,1);
        Product product=instock.find(3);
        assertEquals(0,product.compareTo(product1));

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithInvalidDownIndex(){
        Product product1=new Product("label1",1,1);
        Product product=instock.find(-1);
        assertEquals(0,product.compareTo(product1));

    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWhenListIsEmpty(){
        Product product1=new Product("label1",1,1);
        Instock instock=new Instock();
        Product product=instock.find(0);
        assertEquals(0,product.compareTo(product1));

    }
    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityWhenTheProductIsNotPresent(){
        Product product=new Product("test",10,10);
        instock.changeQuantity("test",5);
    }
    @Test
    public void testChangeQuantityWhenTheProductIsPresent(){
        int current=10;
        int toChange=5;
        Product product=new Product("test",10,current);
        instock.add(product);
        instock.changeQuantity("test",toChange);
        assertEquals(current+toChange,instock.findByLabel("test").getQuantity());

    }
    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelWhenTheProductIsNotPresent(){
        Product product=new Product("test",10,10);
        instock.findByLabel("test");
    }
    @Test
    public void testFindByLabelWhenTheProductIsPresent(){
        int current=10;
        int toChange=5;
        Product product=new Product("test",10,current);
        instock.add(product);
        Product found=instock.findByLabel("test");
        assertEquals(0,found.compareTo(product));

    }
    @Test
    public void testCollectionByAlphabeticOrder(){
        Product p1=new Product("a",10,10);
        Product p2=new Product("b",10,10);
        Product p3=new Product("c",10,10);
        Instock instock=new Instock();
        instock.add(p1);
        instock.add(p2);
        instock.add(p3);
        Iterable<Product> iterable=instock.findFirstByAlphabeticalOrder(3);
        List<Product> list=new ArrayList<>();
        iterable.forEach(list::add);
        assertEquals(3,list.size());
        assertEquals(0,p1.compareTo(list.get(0)));
        assertEquals(0,p2.compareTo(list.get(1)));
        assertEquals(0,p3.compareTo(list.get(2)));

    }
    @Test
    public void testAlphabeticalOrderReturnsEmptyCollectionWithUpperIndex(){
        Product p1=new Product("a",10,10);
        Product p2=new Product("b",10,10);
        Product p3=new Product("c",10,10);
        Instock instock=new Instock();
        instock.add(p1);
        instock.add(p2);
        instock.add(p3);
        Iterable<Product> iterable=instock.findFirstByAlphabeticalOrder(10);
        List<Product> list=new ArrayList<>();
        iterable.forEach(list::add);
        assertEquals(0,list.size());

    }
    @Test
    public void testAlphabeticalOrderReturnsEmptyCollectionWithIndexBelow(){
        Product p1=new Product("a",10,10);
        Product p2=new Product("b",10,10);
        Product p3=new Product("c",10,10);
        Instock instock=new Instock();
        instock.add(p1);
        instock.add(p2);
        instock.add(p3);
        Iterable<Product> iterable=instock.findFirstByAlphabeticalOrder(-1);
        List<Product> list=new ArrayList<>();
        iterable.forEach(list::add);
        assertEquals(0,list.size());

    }

    @Test
    public void testfindAllInPriceRangeReturnsEmptyCollection(){
        Product p1=new Product("a",10,10);
        Product p2=new Product("b",10,10);
        Product p3=new Product("c",10,10);
        Instock instock=new Instock();
        instock.add(p1);
        instock.add(p2);
        instock.add(p3);
        Iterable<Product> iterable=instock.findAllInRange(60,100);
        List<Product> list=new ArrayList<>();
        iterable.forEach(list::add);
        assertEquals(0,list.size());

    }

    @Test
    public void testfindAllInPriceRangeReturnsTrueCollection(){
        Product p1=new Product("a",5,10);
        Product p2=new Product("b",10,10);
        Product p3=new Product("c",15,10);
        Instock instock=new Instock();
        instock.add(p1);
        instock.add(p2);
        instock.add(p3);
        Iterable<Product> iterable=instock.findAllInRange(8,15);
        List<Product> list=new ArrayList<>();
        iterable.forEach(list::add);
        assertEquals(2,list.size());
        assertEquals(0,p3.compareTo(list.get(0)));
        assertEquals(0,p2.compareTo(list.get(1)));

    }
    @Test
    public void testfindAllByGivenPrice(){
        Product p1=new Product("a",10,10);
        Product p2=new Product("b",10,10);
        Product p3=new Product("c",10,10);
        Instock instock=new Instock();
        instock.add(p1);
        instock.add(p2);
        instock.add(p3);
        Iterable<Product> iterable=instock.findAllByPrice(10);
        List<Product> list=new ArrayList<>();
        iterable.forEach(list::add);
        assertEquals(3,list.size());
        Assert.assertTrue(list.stream().allMatch(p->p.getPrice()==10));

    }
    @Test
    public void testfindAllByGivenPriceReturnsEmptyCOllection(){
        Product p1=new Product("a",10,10);
        Product p2=new Product("b",10,10);
        Product p3=new Product("c",10,10);
        Instock instock=new Instock();
        instock.add(p1);
        instock.add(p2);
        instock.add(p3);
        Iterable<Product> iterable=instock.findAllByPrice(20);
        List<Product> list=new ArrayList<>();
        iterable.forEach(list::add);
        assertEquals(0,list.size());


    }
    @Test
    public void testfindMostExpensiveProducts(){
        Product p1=new Product("a",5,10);
        Product p2=new Product("b",10,10);
        Product p3=new Product("c",15,10);
        Instock instock=new Instock();
        instock.add(p1);
        instock.add(p2);
        instock.add(p3);
        Iterable<Product> iterable=instock.findFirstMostExpensiveProducts(3);
        List<Product> list=new ArrayList<>();
        iterable.forEach(list::add);
        assertEquals(3,list.size());
        assertEquals(0,p3.compareTo(list.get(0)));
        assertEquals(0,p2.compareTo(list.get(1)));
        assertEquals(0,p1.compareTo(list.get(2)));

    }
    @Test(expected = IllegalArgumentException.class)
    public void testfindMostExpensiveProductsThrowsException(){
        Product p1=new Product("a",5,10);
        Product p2=new Product("b",10,10);
        Product p3=new Product("c",15,10);
        Instock instock=new Instock();
        instock.add(p1);
        instock.add(p2);
        instock.add(p3);
        Iterable<Product> iterable=instock.findFirstMostExpensiveProducts(4);
        List<Product> list=new ArrayList<>();
        iterable.forEach(list::add);
        assertEquals(3,list.size());
        assertEquals(0,p1.compareTo(list.get(0)));
        assertEquals(0,p2.compareTo(list.get(1)));
        assertEquals(0,p3.compareTo(list.get(2)));

    }
    @Test
    public void testIteratorShouldReturnAllProductsInTheOrderOfAddition() {
        Product product1=new Product("label1",1,1);
        Product product2=new Product("label2",2,2);
        instock.add(product1);
        instock.add(product2);
        List<Product> expected =new ArrayList<>();
        expected.add(product1);
        expected.add(product2);
        Iterator<Product> iterator = instock.iterator();
        List<Product> actual = new ArrayList<>();
        while (iterator.hasNext()) {
            actual.add(iterator.next());
        }
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getLabel(), actual.get(i).getLabel());
        }
    }
    @Test
    public void testfindAllByGivenQuantityPriceReturnsEmptyCollection(){
        Product p1=new Product("a",10,10);
        Product p2=new Product("b",10,10);
        Product p3=new Product("c",10,10);
        Instock instock=new Instock();
        instock.add(p1);
        instock.add(p2);
        instock.add(p3);
        Iterable<Product> iterable=instock.findAllByQuantity(20);
        List<Product> list=new ArrayList<>();
        iterable.forEach(list::add);
        assertEquals(0,list.size());


    }
    @Test
    public void testfindAllByGivenQuantityPriceReturnsTrueCollection(){
        Product p1=new Product("a",10,10);
        Product p2=new Product("b",10,10);
        Product p3=new Product("c",10,10);
        Instock instock=new Instock();
        instock.add(p1);
        instock.add(p2);
        instock.add(p3);
        Iterable<Product> iterable=instock.findAllByQuantity(10);
        List<Product> list=new ArrayList<>();
        iterable.forEach(list::add);
        assertEquals(3,list.size());
        assertTrue(list.stream().allMatch(p -> p.getQuantity() == 10));

    }

}
