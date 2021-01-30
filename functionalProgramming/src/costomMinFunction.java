import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class costomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
      int[] arr= Arrays.stream(line.split(" "))
              .mapToInt(Integer::parseInt)
              .toArray();
        Integer[] arr2= Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Function<Integer[],Integer> func=
                p-> Arrays.stream(p)
                .sorted((a,b)->Integer.compare(a,b))
                .findFirst().get();

        System.out.println(func.apply(arr2));
    }
}
