import java.util.Scanner;

public class intersectionOfTwoMatrixes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        char[][]arr=new char[r][c];
        char[][]arr2=new char[r][c];
        for(int i=0;i<r;i++){
            for(int k=0;k<c;k++){
                arr[i][k]=scanner.next().charAt(0);
            }
        }
        for(int i=0;i<r;i++){
            for(int k=0;k<c;k++){
                arr2[i][k]=scanner.next().charAt(0);
            }
        }
        for(int i=0;i<r;i++){
            if(i!=0)
            System.out.println();
            for(int k=0;k<c;k++){
                if(arr[i][k]==arr2[i][k]){
                    System.out.print(arr[i][k]+" ");
                }
                else{
                    System.out.print("* ");
                }
            }
        }
    }
}
