import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class setOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set1=new LinkedHashSet<>();
        Set<Integer> set2=new LinkedHashSet<>();
        Set<Integer> total=new LinkedHashSet<>();
        String a = scanner.nextLine();
        String[] arrString=a.split(" ");
        int n=Integer.parseInt(arrString[0]);
        int m=Integer.parseInt(arrString[1]);
        for(int i=0;i<n;i++){
            set1.add(Integer.parseInt(scanner.nextLine()));
        }
        for(int i=0;i<m;i++){
            set2.add(Integer.parseInt(scanner.nextLine()));
        }
        for(int set1Cur:set1){
            for(int set2Cur:set2){
                if(set1Cur==set2Cur){
                    total.add(set1Cur);
                }
            }
        }
        for(int cur:total){
            System.out.print(cur+" ");
        }
    }
}
