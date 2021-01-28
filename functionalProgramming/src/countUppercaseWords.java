import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class countUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Predicate<String> isUpper=p->Character.isUpperCase(p.charAt(0));
        List<String> list = Arrays.stream(line.split(" "))
                .filter(isUpper)
                .collect(Collectors.toList());
        System.out.println(list.size());
        for(String s: list){
            System.out.println(s);
        }
    }
}
