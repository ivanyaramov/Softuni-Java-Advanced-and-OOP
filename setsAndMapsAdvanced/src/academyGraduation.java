import java.text.DecimalFormat;
import java.util.*;

public class academyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Double> map =new TreeMap<>();
        for(int i=0;i<n;i++) {
            String name = scanner.nextLine();
            String numbers = scanner.nextLine();
            String[] arrString = numbers.split(" ");
            double sum = 0;

            for (int k = 0; k < arrString.length; k++) {
                double cur = Double.parseDouble(arrString[k]);
                sum += cur;
            }
            double avg = sum / arrString.length;
            map.put(name, avg);
        }
            DecimalFormat df = new DecimalFormat("0.#################");
        for (Map.Entry<String, Double> str : map.entrySet()) {
            System.out.printf("%s is graduated with ",str.getKey());
            System.out.println(str.getValue());
        }






    }
}
