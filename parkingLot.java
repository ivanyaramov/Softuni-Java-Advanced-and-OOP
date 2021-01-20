import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class parkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set=new LinkedHashSet<>();
        while(true){
            String a = scanner.nextLine();
            if(a.equals("END")){
                break;
            }
            String number=a.substring(a.indexOf(",")+2);
            if(a.charAt(0)=='I'){
                set.add(number);
            }
            else{
                set.remove(number);
            }
        }
        if(set.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        else{
            set.stream().forEach(p-> System.out.println(p));
        }
    }
}
