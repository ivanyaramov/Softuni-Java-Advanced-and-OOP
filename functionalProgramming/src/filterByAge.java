import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class filterByAge {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        Map<String,Integer>map=new LinkedHashMap<>();
        for(int i=0;i<a;i++){
            String line = scanner.nextLine();
            String[]arrString=line.split(", ");
            map.put(arrString[0],Integer.parseInt(arrString[1]));
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format=scanner.nextLine();
        Predicate<Integer> younger=p->p<=age;
        Predicate<Integer> older=p->p>=age;
        Consumer<Map.Entry<String,Integer>> printer=null;
        switch (format){
            case "name age":
                printer=p-> System.out.printf("%s - %d%n",p.getKey(),p.getValue());
                break;
            case "name":
                printer=p-> System.out.printf("%s%n",p.getKey());
                break;
            case "age":
                printer=p-> System.out.printf("%d%n",p.getValue());
                break;

        }
        if(condition.equals("younger")){

            for (Map.Entry<String, Integer> str : map.entrySet()) {
                if(younger.test(str.getValue())){
                    printer.accept(str);

                }
            }

        }
        else{

            for (Map.Entry<String, Integer> str : map.entrySet()) {
                    if(older.test(str.getValue())){
                        printer.accept(str);

                    }
                }

        }
    }
}
