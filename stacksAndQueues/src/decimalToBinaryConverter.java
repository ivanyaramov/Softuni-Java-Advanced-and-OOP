import java.util.ArrayDeque;
import java.util.Scanner;

public class decimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        if(a==0){
            System.out.println(0);
        }
        while(a!=0){
            stack.push(a%2);
            a/=2;
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
