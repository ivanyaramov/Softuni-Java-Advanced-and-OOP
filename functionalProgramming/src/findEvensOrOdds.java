import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class findEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start=Integer.parseInt(scanner.next());
        int end=Integer.parseInt(scanner.next());
        String type = scanner.next();
        Predicate<Integer> isEven=p->p%2==0;
        Predicate<Integer> isOdd=p->p%2!=0;
        if(type.equals("odd")){
            printer(isOdd,start,end);
        }
        else{
            printer(isEven,start,end);
        }



    }
    public static void printer(Predicate<Integer> func,int start,int end){
        System.out.print(IntStream.range(start,end+1)
                .filter(func::test)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
