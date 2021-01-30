import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class knightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Consumer<String> printer=p-> Arrays.stream(p.split(" "))
                .forEach(f->System.out.println("Sir "+f));
        printer.accept(line);
    }
}
