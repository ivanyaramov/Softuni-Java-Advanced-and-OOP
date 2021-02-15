import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dancers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stackBoy=new ArrayDeque<>();
        ArrayDeque<Integer> queueGirl= new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(p->stackBoy.push(p));
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(p->queueGirl.offer(p));
int couples=0;
        while(true){
            if(stackBoy.isEmpty()||queueGirl.isEmpty()){
                break;
            }
            int girl=queueGirl.peek();
            int boy=stackBoy.peek();
            if(girl%7==0 || girl<=0){
                queueGirl.poll();
                continue;
            }
            if(boy%7==0 || boy<=0){
                stackBoy.pop();
                continue;
            }
            if(boy==girl){
                queueGirl.poll();
                stackBoy.pop();
                couples++;
            }
            else{
                queueGirl.poll();
                stackBoy.pop();
                stackBoy.push(boy-1);
            }

        }
        System.out.printf("Couples: %d%n",couples);
        if(stackBoy.isEmpty()){
            System.out.println("There are no boys left.");
        }
        else{
            System.out.print("Boys left: ");
            System.out.println(stackBoy.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if(queueGirl.isEmpty()){
            System.out.println("There are no girls left.");
        }
        else{
            System.out.print("Girls left: ");
            System.out.println(queueGirl.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
    }
}
