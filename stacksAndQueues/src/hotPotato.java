import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class hotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int index=0;
        int cur=0;
        List<String> list = Arrays.stream(a.split(" ")).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        while(list.size()>1) {
            index+=n-1;
            if(index>list.size()-1){
                if(index%list.size()==0){
                    index=0;
                }
                else{
                    index = index % list.size();
                }
            }


            System.out.println("Removed " + list.get(index));
            list.remove(list.remove(index));
            if(index>list.size()-1){
                index=0;
            }


        }



        System.out.println("Last is "+list.get(0));
    }
}
