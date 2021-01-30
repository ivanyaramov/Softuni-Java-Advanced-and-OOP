import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class consumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Consumer<String> print = p-> Arrays.stream(p.split(" "))
                .forEach(System.out::println);
        print.accept(line);
    }
}
