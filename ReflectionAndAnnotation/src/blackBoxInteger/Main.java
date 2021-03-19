package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        Class<BlackBoxInt> clazz=BlackBoxInt.class;
        Constructor<BlackBoxInt> ctor=clazz.getDeclaredConstructor();
        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt=ctor.newInstance();
        Method[] methods=clazz.getDeclaredMethods();
        Field value=clazz.getDeclaredField("innerValue");
        value.setAccessible(true);
        Map<String,Method> map=new HashMap<>();
        for(Method method:methods){
            method.setAccessible(true);
            map.put(method.getName(),method);

        }
        while(true){
            String line = scanner.nextLine();
            if(line.equals("END")){
                break;
            }
            String[]arr=line.split("_");
            String met=arr[0];
            int amount=Integer.parseInt(arr[1]);
           printValue(met,amount,map,blackBoxInt,value);
        }

    }
    public static void printValue(String met,int amount,Map<String,Method> map,BlackBoxInt blackBoxInt,Field value) throws InvocationTargetException, IllegalAccessException {
        map.get(met).invoke(blackBoxInt,amount);
        System.out.println(value.getInt(blackBoxInt));

    }
}
