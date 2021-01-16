import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class mathPotato {
    static boolean isPrime(int num){
        int br=0;
        for(int i=2;i<num;i++){
            if(num%i==0){
                br++;

            }
        }
        if(num==1){
            return false;
        }
        else if(br>=1){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int index=0;
        int cur=1;
        ArrayDeque<String> queue =new ArrayDeque<>();
        Arrays.stream(a.split(" ")).forEach(p->queue.offer(p));
       int cycle=1;
        int n = Integer.parseInt(scanner.nextLine());

       while(queue.size()>1){
           for(int i=1;i<n;i++){
               queue.offer(queue.poll());}
               if(isPrime(cycle)){
                   System.out.println("Prime "+queue.peek());
               }
               else{
                   System.out.println("Removed "+queue.poll());
               }
               cycle++;

       }
        System.out.println("Last is "+queue.poll());
    }
}
