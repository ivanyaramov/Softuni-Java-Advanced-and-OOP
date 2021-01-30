import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class customComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] even= Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .filter(p->p%2==0)
                .toArray();
        Arrays.sort(even);
        int[] odd= Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .filter(p->p%2!=0)
                .toArray();
        Arrays.sort(odd);
        String evenString= Arrays.stream(even)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        String oddString= Arrays.stream(odd)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(evenString +" "+oddString);
    }
}
