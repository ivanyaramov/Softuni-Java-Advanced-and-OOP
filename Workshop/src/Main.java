import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartArray test= new SmartArray();
        for(int i=0;i<100;i++){
            test.add(i);
        }
        test.add(5,49646);
        System.out.println(test.contains(79));
        Consumer<Integer> consumer = p-> System.out.println(p);
        test.forEach(consumer);
        CustomStack stack = new CustomStack();
        stack.push(1);
        System.out.println(stack.peek());
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.forEach(consumer);

    }
}
