import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while(true){
            String resource = scanner.nextLine();
            if(resource.equals("stop")){
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());
            if(map.containsKey(resource)) {
                map.put(resource, quantity + map.get(resource));
            }
            else{
                map.put(resource,quantity);
            }
        }
        for (Map.Entry<String, Integer> str : map.entrySet()) {
            System.out.printf("%s -> %d%n",str.getKey(),str.getValue());
        }

    }
}
