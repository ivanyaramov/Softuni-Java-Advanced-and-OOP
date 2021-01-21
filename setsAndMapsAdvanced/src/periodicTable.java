import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class periodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set=new TreeSet<>();
        int a = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<a;i++){
            String line = scanner.nextLine();
            String[] arrString=line.split(" ");
            for(int k=0;k<arrString.length;k++){
                set.add(arrString[k]);
            }
        }
        for(String s:set){
            System.out.print(s+" ");
        }
    }
}
