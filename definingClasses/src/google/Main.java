package google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> listOfPeople=new ArrayList<>();
        String line = scanner.nextLine();
        while(!line.equals("End")){
            String[] arr=line.split(" ");
            String personName=arr[0];
            String type=arr[1];
            int index0=containsPerson(personName,listOfPeople);
            if(index0<0){
                List<Parent> listParent=new ArrayList<>();
                List<Child> listChild=new ArrayList<>();
                List<Pokemon> listPokemon=new ArrayList<>();
                Person person=new Person(personName,null,null,listParent,listChild,listPokemon);
            listOfPeople.add(person);
            }
            switch (type){
                case "company":
                    String companyName=arr[2];
                    String department=arr[3];
                    double salary=Double.parseDouble(arr[4]);
                    Company company=new Company(companyName,department,salary);
                   int index=containsPerson(personName,listOfPeople);

                       listOfPeople.get(index).setCompany(company);

                    break;
                case "pokemon":
                    String pokemonName=arr[2];
                    String pokemonType=arr[3];
                    Pokemon pokemon=new Pokemon(pokemonName,pokemonType);
                    int index2=containsPerson(personName,listOfPeople);
                    listOfPeople.get(index2).getListOfPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName=arr[2];
                    String parentBirthday=arr[3];
                    Parent parent = new Parent(parentName,parentBirthday);
                    int index3=containsPerson(personName,listOfPeople);
                    listOfPeople.get(index3).getListOfParents().add(parent);
                    break;
                case "children":
                    String childName=arr[2];
                    String childBirthday=arr[3];
                    Child child = new Child(childName,childBirthday);
                    int index4=containsPerson(personName,listOfPeople);
                    listOfPeople.get(index4).getListOfChildren().add(child);
                    break;
                case "car":
                    String carModle=arr[2];
                    int carSpeed=Integer.parseInt(arr[3]);
                    Car car=new Car(carModle,carSpeed);
                    int index1=containsPerson(personName,listOfPeople);

                        listOfPeople.get(index1).setCar(car);

                    break;
            }

            line=scanner.nextLine();
        }

        String finalName = scanner.nextLine();
        int finalIndex=containsPerson(finalName,listOfPeople);
        Person finalPerson=listOfPeople.get(finalIndex);
        System.out.println(finalPerson.getName());
        System.out.println("Company:" );
        if(finalPerson.getCompany()!=null){
        System.out.printf("%s %s %.2f%n",finalPerson.getCompany().getName(),finalPerson.getCompany().getDepartment(),finalPerson.getCompany().getSalary());}
        System.out.println("Car:");
        if(finalPerson.getCar()!=null) {
            System.out.printf("%s %d%n", finalPerson.getCar().getModel(), finalPerson.getCar().getSpeed());
        }
        System.out.println("Pokemon:");
        List<Pokemon> listOfPokemon=finalPerson.getListOfPokemons();
        listOfPokemon.stream()
                .forEach(p-> System.out.printf("%s %s%n",p.getName(),p.getType()));
        List<Parent> listOfParent=finalPerson.getListOfParents();
        System.out.println("Parents:");
        listOfParent.stream()
                .forEach(p-> System.out.printf("%s %s%n",p.getName(),p.getBirthday()));
        List<Child> listOfChild=finalPerson.getListOfChildren();
        System.out.println("Children:");
        listOfChild.stream()
                .forEach(p-> System.out.printf("%s %s%n",p.getName(),p.getBirthday()));

    }
    public static int containsPerson(String name,List<Person> list){
     for(int i=0;i<list.size();i++){
         Person person=list.get(i);
         if(person.getName().equals(name)){
             return i;
         }
     }
        return -1;
    }
}
