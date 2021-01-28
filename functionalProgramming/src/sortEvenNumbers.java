import java.util.*;
import java.util.stream.Collectors;

public class sortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String filtered = Arrays.stream(line.split(", "))
                .mapToInt(Integer::parseInt)
               .filter(p->p%2==0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(filtered);

        int[] arr=Arrays.stream(filtered.split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(arr);
        System.out.println(Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));


    }
}
