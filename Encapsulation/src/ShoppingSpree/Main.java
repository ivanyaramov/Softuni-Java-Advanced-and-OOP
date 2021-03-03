package ShoppingSpree;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String peopleAndMoney = scanner.nextLine();
        Map<String,Person> mapOfPeople=new LinkedHashMap<>();
        Map<String,Product> mapOfProducts=new LinkedHashMap<>();
        String productsAndCost=scanner.nextLine();
        Arrays.stream(peopleAndMoney.split(";"))
                .forEach(p->{
                    String[] arr=p.split("=");
                    mapOfPeople.put(arr[0],new Person(arr[0],Integer.parseInt(arr[1])));
                });
        Arrays.stream(productsAndCost.split(";"))
                .forEach(p->{
                    String[] arr=p.split("=");
                    mapOfProducts.put(arr[0],new Product(arr[0],Integer.parseInt(arr[1])));
                });
        while(true){
            String a = scanner.nextLine();
            if(a.equals("END")){
                break;
            }
            String[] arr=a.split(" ");
            String personName=arr[0];
            String productName=arr[1];
            mapOfPeople.get(personName).buyProduct(mapOfProducts.get(productName));

        }
        for (Map.Entry<String, Person> str : mapOfPeople.entrySet()) {
            Person person=str.getValue();
            if(person.getList().size()==0){
                System.out.printf("%s - Nothing bought%n",person.getName());
            }
            else {
                StringBuilder builder = new StringBuilder();
                person.getList().stream()
                        .forEach(p -> builder.append(String.format("%s, ", p.getName())));
                builder.replace(builder.length() - 2, builder.length(), "");
                System.out.printf("%s - %s%n", person.getName(), builder.toString());
            }



        }

    }
}
