package TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = Arrays.stream(scanner.nextLine().split(" ")).map(String::valueOf).toArray(String[]::new);
        int n = Integer.parseInt(scanner.nextLine());
        List<TrafficLight> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            TrafficLight trafficLight = new TrafficLight(arr[i]);
            list.add(trafficLight);

        }
        for (int i = 0; i < n; i++) {
            for (TrafficLight cur : list) {
                cur.move();
                System.out.print(cur + " ");
            }
            if(i!=n-1) {
                System.out.println();
            }
        }
    }
}
