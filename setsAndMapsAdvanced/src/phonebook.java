import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> map= new HashMap<>();
        while(true){
            String line = scanner.nextLine();
            if(line.equals("search")){
                break;
            }
            String[] arrString=line.split("-");
            String name=arrString[0];
            String number=arrString[1];
            map.put(name,number);

        }
        while(true){
            String line = scanner.nextLine();
            if(line.equals("stop")){
                break;
            }
            if(map.containsKey(line)){
                System.out.printf("%s -> %s%n",line,map.get(line));
            }
            else{
                System.out.printf("Contact %s does not exist.%n",line);
            }
        }
    }
}
