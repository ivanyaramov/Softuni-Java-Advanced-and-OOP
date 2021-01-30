import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class predicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        Predicate<String> isShorter=p->p.length()<=a;
        Arrays.stream(line.split(" "))
                .filter(isShorter)
                .forEach(System.out::println);
    }
}
