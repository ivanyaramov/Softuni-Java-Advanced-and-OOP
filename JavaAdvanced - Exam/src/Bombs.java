import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        int datura=0;
        int cherry=0;
        int smoke=0;
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        while(!stack.isEmpty()&&!queue.isEmpty()){

            if(datura>=3 && cherry>=3 && smoke>=3){

            break;
            }
            int together=stack.pop()+queue.poll();
            if(together>=120){
                smoke++;
            }
            else if(together>=60){
                cherry++;
            }
            else{
                datura++;
            }
        }
        if(datura>=3 && cherry>=3 && smoke>=3){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }
        else{
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if(queue.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }
        else{
            System.out.print("Bomb Effects: ");
            System.out.println(queue.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        if(stack.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }
        else{
            System.out.print("Bomb Casings: ");
            System.out.println(stack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }

        System.out.printf("Cherry Bombs: %d%n",cherry);
        System.out.printf("Datura Bombs: %d%n",datura);
        System.out.printf("Smoke Decoy Bombs: %d%n",smoke);
    }
}
