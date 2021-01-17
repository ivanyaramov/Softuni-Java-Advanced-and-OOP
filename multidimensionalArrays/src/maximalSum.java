import java.util.Scanner;

public class maximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] arrString=a.split(" ");
        int rows=Integer.parseInt(arrString[0]);
        int cols=Integer.parseInt(arrString[1]);
        int[][] arr= new int[rows][cols];
        int[][]arr3=new int[3][3];
        for(int i=0;i<rows;i++){
            arr[i]=readArray(scanner.nextLine());
        }
        int sum=Integer.MIN_VALUE;
        for(int i=0;i<rows-2;i++){
            for(int k=0;k<cols-2;k++){
                if(sum<sumArr(arr,i,k)){
                    sum=sumArr(arr,i,k);
                    outputArr(arr,arr3,i,k);
                }
            }
        }
        System.out.println("Sum = "+sum);
        for(int i=0;i<3;i++){
            for(int k=0;k<3;k++){
                System.out.print(arr3[i][k]+" ");
            }
            System.out.println();
        }

    }
    public static int sumArr(int[][] arr,int row,int col) {
        int sum=0;
        for(int i=row;i<row+3;i++){
            for(int k=col;k<col+3;k++){
                sum+=arr[i][k];


            }
        }
        return sum;
    }

    public static void outputArr(int[][]arr,int[][]arr3,int row,int col){
        int brc=0;
        int brr=0;
        for(int i=row;i<row+3;i++){
            for(int k=col;k<col+3;k++){
                arr3[brr][brc++]=arr[i][k];
            }
            brc=0;
            brr++;
        }
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
