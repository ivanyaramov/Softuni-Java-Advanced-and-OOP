import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Scheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();


        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(p->tasksStack.push(p));
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(p->threadsQueue.offer(p));

int end=Integer.parseInt(scanner.nextLine());
while(true){
    if(tasksStack.peek()==end){
        System.out.printf("Thread with value %d killed task %d%n",threadsQueue.peek(),end);
    print(threadsQueue);
    break;
    }
    if(threadsQueue.peek()>=tasksStack.peek()){
        threadsQueue.poll();
        tasksStack.pop();
    }
    else{
        threadsQueue.poll();
    }
}

    }
    public static void print(ArrayDeque<Integer> queue){
        System.out.println(queue.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
