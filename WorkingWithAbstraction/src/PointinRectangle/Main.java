package PointinRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Rectangle rectangle=new Rectangle(new Point(arr[0],arr[1]),new Point(arr[2],arr[3]));
        int n= Integer.parseInt(scanner.nextLine());
        for(int i=0;i<n;i++){
            int[] arrPointCoordinates= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(rectangle.contains(new Point(arrPointCoordinates[0],arrPointCoordinates[1])));
        }
    }
}
