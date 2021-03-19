package reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {
    @Author(name="Peter")
    public static void printMethodsByAuthor(Class<?> cl){
        Map<String, List<String>> methodsByAuthor=new HashMap<>();
        Method[] methods=cl.getDeclaredMethods();
        for(Method method:methods){
            Author annotation = method.getAnnotation(Author.class);
            if(annotation!=null){
                methodsByAuthor.putIfAbsent(annotation.name(),new ArrayList<>());
                methodsByAuthor.get(annotation.name()).add(method.getName()+"()");
            }
        }
        for (Map.Entry<String, List<String>> str : methodsByAuthor.entrySet()) {
            System.out.printf("%s: %s%n",str.getKey(),str.getValue().get(0));
        }

    }

}
