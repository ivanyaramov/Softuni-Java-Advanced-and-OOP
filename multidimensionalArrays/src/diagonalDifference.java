import java.util.Scanner;

public class diagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int[][] arr=new int[a][a];
        for(int i=0;i<a;i++){
            arr[i]=readArray(scanner.nextLine());
        }
        int row=0;
        int col=0;
        int sumL=0;
        int sumR=0;
        while(row<a){
            sumL+=arr[row++][col++];
        }
        col=0;
        row=a-1;
        while(row>=0){
            sumR+=arr[row--][col++];
        }
        System.out.println(Math.abs(sumL-sumR));

    }
    public static int[] readArray(String s){

        String[] arrString= s.split(" ");
        int[] arr=new int[arrString.length];
        for(int i=0;i<arrString.length;i++){
            arr[i]=Integer.parseInt(arrString[i]);
        }
        return arr;
    }
}
