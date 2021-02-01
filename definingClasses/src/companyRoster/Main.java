package companyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        List<Employee> list = new ArrayList<>();
        List<Department> listDep=new ArrayList<>();
        for(int i=0;i<a;i++){
            String line = scanner.nextLine();
            String[]arrString=line.split(" ");
            switch(arrString.length){
                case 6:
                    has6(list,arrString,listDep);
                    break;
                case 5:
                    has5(list,arrString,listDep);
                    break;
                case 4:
                    has4(list,arrString,listDep);
                    break;
            }

        }
        double max=-1;
        String highestDepartment="";
        for(Department cur:listDep){
            double average=cur.sum/cur.count;
            if(average>max){
                max=average;
                highestDepartment=cur.name;

            }
        }
        BiFunction<String,String,Boolean> isEqual=(p1,p2)-> {
            if(p1.equals(p2)){
                return true;
            }
            return false;
        };
        String f=highestDepartment;
        System.out.println("Highest Average Salary: "+f);
        list.stream()
                .filter(p->isEqual.apply(p.getDepartment(),f))
                .sorted((p2,p1)->Double.compare(p1.getSalary(),p2.getSalary()))
                .forEach(p-> System.out.printf("%s %.2f %s %d%n",p.getName(),p.getSalary(),p.getEmail(),p.getAge()));

    }
    public static void has6(List<Employee> list,String[] arr,List<Department> listDep){
        String name=arr[0];
        double salary=Double.parseDouble(arr[1]);
        String position=arr[2];
        String department=arr[3];
        calculatesAverage(listDep,department,salary);
        String email=arr[4];
        int age =Integer.parseInt(arr[5]);
        Employee employee=new Employee(name,salary,position,department,email,age);
        list.add(employee);
    }

    public static void has5(List<Employee> list,String[] arr,List<Department> listDep){
        String name=arr[0];
        double salary=Double.parseDouble(arr[1]);
        String position=arr[2];
        String department=arr[3];
        calculatesAverage(listDep,department,salary);
        Employee employee;
        if(arr[4].contains("@")){
            String email=arr[4];
            employee=new Employee(name,salary,position,department,email);
        }
        else{
            int age=Integer.parseInt(arr[4]);
            employee=new Employee(name,salary,position,department,age);
        }

        list.add(employee);
    }
    public static void has4(List<Employee> list,String[] arr,List<Department> listDep){
        String name=arr[0];
        double salary=Double.parseDouble(arr[1]);
        String position=arr[2];
        String department=arr[3];
calculatesAverage(listDep,department,salary);
        Employee employee=new Employee(name,salary,position,department);
        list.add(employee);
    }
    public static void calculatesAverage(List<Department> listDep,String name, double salary)
    {
       boolean bool=false;
       int index=-1;
       for(int i=0;i<listDep.size();i++){
           Department cur=listDep.get(i);
           if(cur.name.equals(name)){
               bool=true;
               index=i;
               break;
           }
       }
       if(!bool){
           Department department=new Department(name,salary);
           listDep.add(department);
       }
       else{
           listDep.get(index).count++;
           listDep.get(index).sum=salary+ listDep.get(index).sum;
       }
    }

}
