import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
private List<Product> listOfProducts;
    @Override
    public int getCount() {

        return listOfProducts.size();
    }

    @Override
    public boolean contains(Product product) {
        return listOfProducts.contains(product);
    }

    public Instock() {
        this.listOfProducts = new ArrayList<>();
    }

    @Override
    public void add(Product product) {
        listOfProducts.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        Product productToChange=this.findByLabel(product);
        productToChange.setQuantity(productToChange.getQuantity()+quantity);
    }

    @Override
    public Product find(int index) {
        if(index>listOfProducts.size()-1 || index<0){
            throw new IndexOutOfBoundsException();
        }
        return listOfProducts.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        Product foundProduct=null;
        for(Product product:listOfProducts){
            if(product.getLabel().equals(label)){
                foundProduct=product;
            }
        }
        if(foundProduct==null){
            throw new IllegalArgumentException();
        }
        return foundProduct;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
     if(count<=0 || count>this.getCount()){
         return new ArrayList<>();
     }
     return listOfProducts.stream()
             .sorted(Comparator.comparing(Product::getLabel))
             .limit(count)
             .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> list=new ArrayList<>();
        list=listOfProducts.stream()
                .filter(p->p.getPrice()>lo)
                .filter(p->p.getPrice()<=hi)
                .sorted((a,b)->Double.compare(b.getPrice(),a.getPrice()))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return listOfProducts.stream()
                .filter(p->p.getPrice()==price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if(count>listOfProducts.size()||count<=0){
            throw new IllegalArgumentException();
        }
        return listOfProducts.stream()
                .sorted((a,b)-> Double.compare(b.getPrice(),a.getPrice()))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return listOfProducts.stream().filter(e -> e.getQuantity() == quantity).collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.listOfProducts.iterator();
    }
}
