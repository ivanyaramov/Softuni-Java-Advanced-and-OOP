import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class basicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int s = Integer.parseInt(scanner.next());
        int x = Integer.parseInt(scanner.next());
        ArrayDeque<Integer> queue =new ArrayDeque<>();
        for(int i=0;i<n;i++){
            queue.offer(Integer.parseInt(scanner.next()));

        }
        for(int i=0;i<s;i++){
            queue.poll();
        }
        if(queue.contains(x)){
            System.out.println(true);
        }
        else{
            PriorityQueue<Integer> Pqueue=new PriorityQueue();
            queue.stream().forEach(p->Pqueue.offer(p));
            if(queue.isEmpty()){
                System.out.println(0);
            }
            else {
                System.out.println(Pqueue.poll());
            }
        }


    }
}
