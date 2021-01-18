import java.util.Scanner;

public class reverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] arrString=a.split(" ");
        int rows=Integer.parseInt(arrString[0]);
        int cols=Integer.parseInt(arrString[1]);
        int[][] arr = new int[rows][cols];
        for(int i=0;i<rows;i++){
            arr[i]=readArray(scanner.nextLine());
        }
        int rowsCur=rows-1;
        int rows2=rowsCur;
        int colsCur=cols-1;
        int cols2=colsCur;
        while(cols2>=0){
            while(rowsCur>=0&&colsCur<cols){
                System.out.print(arr[rowsCur--][colsCur++]+" ");

            }
            cols2--;
            colsCur=cols2;
            rowsCur=rows2;
            System.out.println();
        }
        rows2--;
        rowsCur=rows2;
        colsCur=0;
        while(rows2>=0){
            while(rowsCur>=0&&colsCur<cols){
                System.out.print(arr[rowsCur--][colsCur++]+" ");

            }
            rows2--;
            colsCur=0;
            rowsCur=rows2;
            System.out.println();
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
