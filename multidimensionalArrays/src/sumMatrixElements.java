import java.util.Arrays;
import java.util.Scanner;

public class sumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
     String[]arrString=a.split(", ");
     int sum=0;
     int[][]arr=new int[Integer.parseInt(arrString[0])][Integer.parseInt(arrString[1])];
for(int i=0;i<Integer.parseInt(arrString[0]);i++){
    arr[i]=readArray(scanner.nextLine());
    for(int k=0;k<arr[i].length;k++){
        sum+=arr[i][k];
    }
}
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        System.out.println(sum);

    }

    public static int[] readArray(String s){

        String[] arrString= s.split(", ");
        int[] arr=new int[arrString.length];
        for(int i=0;i<arrString.length;i++){
            arr[i]=Integer.parseInt(arrString[i]);
        }
        return arr;
    }
}
