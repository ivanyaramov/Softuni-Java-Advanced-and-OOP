package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
    public static class Comp2 implements Comparator<Field>{


        @Override
        public int compare(Field o1, Field o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    public static class Comp implements Comparator<Method>{

        @Override
        public int compare(Method o1, Method o2) {
            return o1.getName().compareTo(o2.getName());
        }

    }
    @Author(name="Ivan")
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> clazz=Reflection.class;

//        System.out.println("class "+clazz.getSimpleName());
//        System.out.println(clazz.getSuperclass());
//        Arrays.stream(clazz.getInterfaces())
//                .forEach(System.out::println);
//        Reflection ref = clazz.getDeclaredConstructor().newInstance();
//        System.out.println(ref);
        Field[] fieldsArr=clazz.getDeclaredFields();
        Set<Field> fields=new TreeSet<>(new Comp2());
        Arrays.stream(fieldsArr).forEach(fields::add);
        Set<Method> getters=new TreeSet<>(new Comp());
        Set<Method> setters=new TreeSet<>(new Comp());
        Method[] methods=clazz.getDeclaredMethods();
        for(Method method:methods){
if(method.getName().contains("get")){
    getters.add(method);
}
else if(method.getName().contains("set")){
    setters.add(method);
}
        }
for(Field field:fields){
           if(!Modifier.isPrivate(field.getModifiers())){
               System.out.println(field.getName() + " must be private!");
           }
       }
       for(Method method:getters){
           if(!Modifier.isPublic(method.getModifiers())){
               System.out.println(method.getName() + " have to be public!");
           }
       }
        for(Method method:setters){
            if(!Modifier.isPrivate(method.getModifiers())){
                System.out.println(method.getName() + " have to be private!");
            }        }
        System.out.println();
Tracker.printMethodsByAuthor(Tracker.class);
Tracker.printMethodsByAuthor(Main.class);

    }
}
