import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class matchingBrackets2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] arr = a.split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean bool = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '(') {
                bool = true;
            }
            if (a.charAt(i)=='(') {
                stack.push(i);

            }
            if(a.charAt(i)==')'){
                System.out.println(a.substring(stack.pop(),i+1));
            }
        }
    }
}
