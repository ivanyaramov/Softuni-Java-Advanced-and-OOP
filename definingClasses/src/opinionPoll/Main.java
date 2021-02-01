package opinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());

        List<Person> list=new ArrayList<>();
        Consumer<Person> prints=p-> System.out.printf("%s - %d%n",p.getName(),p.getAge());
        Predicate<Person> isOlderThan30= p->p.getAge()>30;
        for(int i=0;i<a;i++){
            String line = scanner.nextLine();
            String[] arrString = line.split(" ");
            String name=arrString[0];
            int age=Integer.parseInt(arrString[1]);
            Person person= new Person(name,age);
            list.add(person);
        }
        list.stream()
                .filter(isOlderThan30)
                .sorted((x,y)->x.getName().compareTo(y.getName()))
                .forEach(prints);


        }
    }

