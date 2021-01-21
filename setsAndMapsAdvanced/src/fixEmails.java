import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class fixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> map=new LinkedHashMap<>();
        while(true){
            String name= scanner.nextLine();
            if(name.equals("stop")){
                break;
            }
            String email = scanner.nextLine();
            int index=email.indexOf(".");
            String sub=email.substring(index+1);
            if(sub.equals("us")||sub.equals("uk")||sub.equals("com")){

            }
            else{
                map.put(name,email);
            }

        }
        for (Map.Entry<String, String> str : map.entrySet()) {
            System.out.printf("%s -> %s%n",str.getKey(),str.getValue());
        }

    }
}
