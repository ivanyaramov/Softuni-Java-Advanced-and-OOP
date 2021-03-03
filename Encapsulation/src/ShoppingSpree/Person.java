package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.length()<1){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }


    private void setMoney(double money) {
        if(money<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            products.add(product);
            this.money -= product.getCost();
            System.out.printf("%s bought %s%n", getName(), product.getName());
        } else {
            System.out.printf("%s can't afford %s%n", getName(), product.getName());
        }
    }
        public List<Product> getList(){
            return Collections.unmodifiableList(this.products);
        }
    }

