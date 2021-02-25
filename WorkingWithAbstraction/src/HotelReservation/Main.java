package HotelReservation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
String[] arr= Arrays.stream(scanner.nextLine().split(" ")).map(String::valueOf).toArray(String[]::new);
PriceCalculator priceCalculator=new PriceCalculator(Double.parseDouble(arr[0]),Integer.parseInt(arr[1]),Season.valueOf(arr[2].toUpperCase()),DiscountType.valueOf(arr[3].toUpperCase()));
        System.out.println(priceCalculator.calculate());

    }
}
