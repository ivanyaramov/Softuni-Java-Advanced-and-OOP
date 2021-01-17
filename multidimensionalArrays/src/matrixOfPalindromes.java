import java.util.Scanner;

public class matrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.next());
        int cols= Integer.parseInt(scanner.next());
        for(int i=0;i<rows;i++){
            char outter=(char)returnLetter(i);
            for(int k=0;k<cols;k++){
char inner=(char)returnLetter(i,k);
                System.out.printf("%c%c%c ",outter,inner,outter);
            }
            System.out.println();
        }
    }
    public static int returnLetter(int a,int b){
        int cur=a+b;
        return 97+cur;

    }
    public static int returnLetter(int a){
        return a+97;

    }
}
