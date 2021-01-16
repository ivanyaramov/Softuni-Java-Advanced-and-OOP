import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class maximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack=new ArrayDeque<>();

        for(int i=0;i<a;i++){
            String[]arr=scanner.nextLine().split(" ");
            if(arr[0].equals("1")){
                stack.push(Integer.parseInt(arr[1]));
            }
            if(arr[0].equals("2")){
                stack.pop();
            }
            if(arr[0].equals("3")){
                PriorityQueue<Integer> queue=new PriorityQueue<>((p1,p2)-> p2.compareTo(p1));
                stack.stream().forEach(p->queue.offer(p));
                System.out.println(queue.peek());
            }
        }
    }
}
