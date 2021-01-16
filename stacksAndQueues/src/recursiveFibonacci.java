import java.util.ArrayDeque;
import java.util.Scanner;

public class recursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
       long[] arr=new long[n+1];
        System.out.print(getFibonacci(n,arr));

    }
    public static long getFibonacci(int n,long[] arr){
        if(n==0||n==1){
          return 1;
        }
        if(arr[n]!=0){
            return arr[n];
        }
       else{
           arr[n]=getFibonacci(n-1,arr)+getFibonacci(n-2,arr);
           return arr[n];
        }

    }
}
