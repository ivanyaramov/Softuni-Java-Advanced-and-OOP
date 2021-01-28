import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class sumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Function<String, IntStream> streamFunc=
                p->Arrays.stream(p.split(", "))
                        .mapToInt(Integer::parseInt);
        Function<IntStream,Long> count=p->
                p.count();
        Function<IntStream,Integer> sum=p->
                p.sum();
        System.out.printf("Count = %d%n",count.apply(streamFunc.apply(line)));
        System.out.printf("Sum = %d%n",sum.apply(streamFunc.apply(line)));

    }
}
