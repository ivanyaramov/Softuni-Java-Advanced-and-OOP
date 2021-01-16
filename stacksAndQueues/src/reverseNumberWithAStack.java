import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class reverseNumberWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        ArrayDeque<String> stack =new ArrayDeque<>();
        Arrays.stream(a.split(" ")).forEach(p->stack.push(p));
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
