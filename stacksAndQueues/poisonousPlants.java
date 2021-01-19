import java.util.ArrayDeque;
import java.util.Scanner;

public class poisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = Integer.parseInt(scanner.next());
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        ArrayDeque<Integer> stackHelp=new ArrayDeque<>();
        for(int i=0;i<amount;i++){
            stack.push(Integer.parseInt(scanner.next()));
        }
        int br=0;
        boolean flag=false;
        while(true) {
            br++;
            flag=false;
            while (stack.size() > 1) {
                int cur = stack.peek();
                if (stack.pop() > stack.peek()) {
                flag=true;
                } else {
                    stackHelp.push(cur);
                }
            }
            if(!flag){
                System.out.println(br-1);
                        break;
            }
            while (!stackHelp.isEmpty()) {
                stack.push(stackHelp.pop());
            }
        }
    }
}
