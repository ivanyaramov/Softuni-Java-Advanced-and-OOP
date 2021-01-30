import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class reverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> isDivisable =p->p%a!=0;
        ArrayDeque<String> stack=new ArrayDeque<>();
         Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .filter(isDivisable::test)
                .mapToObj(String::valueOf)
                .forEach(stack::push);

      line= stack.stream()
               .collect(Collectors.joining(" "));
        System.out.println(line);

    }
}
