import java.util.Scanner;

public class printDiagonalsofSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int[][] arr=new int[a][a];
       for(int i=0;i<a;i++){
           arr[i]=readArray(scanner.nextLine());
       }
       int[] diagleft=new int[a];
       int[] diagright=new int[a];
       for(int i=0;i<a;i++){
           for(int k=0;k<a;k++){
               if(i==k){
                   diagleft[i]=arr[i][k];
               }
               if(i==(a-1)-k){
                   diagright[k]=arr[i][k];
               }
           }
       }

       for(int i=0;i<a;i++){
           System.out.print(diagleft[i]+" ");
       }
        System.out.println();
       for(int i=0;i<a;i++){
           System.out.print(diagright[i]+" ");
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
