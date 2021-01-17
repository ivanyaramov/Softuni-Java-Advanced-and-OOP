import java.util.Scanner;

public class maximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] arrString=a.split(", ");
        int row=Integer.parseInt(arrString[0]);
        int column=Integer.parseInt(arrString[1]);
        int[][]arr=new int[row][column];
        for(int i=0;i<row;i++){
            arr[i]=readArray(scanner.nextLine());
        }
        int max=Integer.MIN_VALUE;
        int tl=0;
        int tr=0;
        int bl=0;
        int br=0;
        for(int i=0;i<row-1;i++){

            for(int k=0;k<column-1;k++){
                int sum=arr[i][k]+arr[i+1][k]+arr[i][k+1]+arr[i+1][k+1];
              if(sum>max){
                  max=sum;
                  tl=arr[i][k];bl=arr[i+1][k];tr=arr[i][k+1];br=arr[i+1][k+1];
              }
            }
        }

        System.out.println(tl+" "+tr);
        System.out.println(bl+" "+br);
        System.out.println(max);
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
