import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class flowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String liliesAsString = scanner.nextLine();
        String rosesAsString= scanner.nextLine();
        ArrayDeque<Integer> stackOfLillies=new ArrayDeque<>();
        ArrayDeque<Integer> queueOfRoses=new ArrayDeque<>();
        Arrays.stream(liliesAsString.split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(stackOfLillies::push);
        Arrays.stream(rosesAsString.split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(queueOfRoses::offer);
        int sum=0;
        int wreaths=0;
while(!stackOfLillies.isEmpty() && !queueOfRoses.isEmpty()){
    int roses=queueOfRoses.poll();
    int lillies=stackOfLillies.pop();
    int together=roses+lillies;

    if(together>15) {
        while (together > 15) {
            together -= 2;

        }
    }
    if(together<15){
        sum+=together;
    }
    if(together==15) {
        wreaths++;
    }
}

wreaths=wreaths+sum/15;
if(wreaths>=5){
    System.out.printf("You made it, you are going to the competition with %d wreaths!",wreaths);

}
else{
    System.out.printf("You didn't make it, you need %d wreaths more!",5-wreaths);
}
    }
}
