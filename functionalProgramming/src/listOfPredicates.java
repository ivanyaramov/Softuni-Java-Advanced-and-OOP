import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class listOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());

        String line = scanner.nextLine();
        List<Integer> list= Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        BiFunction<List<Integer>,Integer,Boolean> func=
                (x,y)->{
            boolean bool=true; for(int cur:x){
                if(y%cur!=0) {
                    bool = false;
                    break;
                }
                }
            return bool;
                };
        String total=IntStream.range(1,a+1)
                .filter(p->func.apply(list,p))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(total);

    }
}
