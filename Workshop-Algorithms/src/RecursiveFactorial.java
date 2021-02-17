import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println(factorial(a));
    }

    private static int factorial(int a) {
    if(a==1){
        return 1;
    }
    return a*factorial(a-1);
    }
}
