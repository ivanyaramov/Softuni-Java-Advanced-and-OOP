import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class uniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set=new LinkedHashSet<>();
        int a = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<a;i++){
            String name = scanner.nextLine();
            set.add(name);
        }
        for(String s:set){
            System.out.println(s);
        }
    }
}
