package google;

import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> listOfParents;
    private List<Child> listOfChildren;
    private List<Pokemon> listOfPokemons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name, Company company, Car car, List<Parent> listOfParents, List<Child> listOfChildren, List<Pokemon> listOfPokemons) {
        this.name = name;
        this.company = company;
        this.car = car;
        this.listOfParents = listOfParents;
        this.listOfChildren = listOfChildren;
        this.listOfPokemons = listOfPokemons;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parent> getListOfParents() {
        return listOfParents;
    }

    public void setListOfParents(List<Parent> listOfParents) {
        this.listOfParents = listOfParents;
    }

    public List<Child> getListOfChildren() {
        return listOfChildren;
    }

    public void setListOfChildren(List<Child> listOfChildren) {
        this.listOfChildren = listOfChildren;
    }

    public List<Pokemon> getListOfPokemons() {
        return listOfPokemons;
    }

    public void setListOfPokemons(List<Pokemon> listOfPokemons) {
        this.listOfPokemons = listOfPokemons;
    }
}
