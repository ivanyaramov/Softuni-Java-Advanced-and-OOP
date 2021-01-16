import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class basicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int s = Integer.parseInt(scanner.next());
        int x = Integer.parseInt(scanner.next());
        ArrayDeque<Integer> stack =new ArrayDeque<>();
        for(int i=0;i<n;i++){
            stack.push(Integer.parseInt(scanner.next()));

        }
        for(int i=0;i<s;i++){
            stack.pop();
        }
        if(stack.contains(x)){
            System.out.println(true);
        }
        else{
            PriorityQueue<Integer> queue=new PriorityQueue();
            stack.stream().forEach(p->queue.offer(p));
            if(queue.isEmpty()){
                System.out.println(0);
            }
            else {
                System.out.println(queue.poll());
            }
        }


    }
}
