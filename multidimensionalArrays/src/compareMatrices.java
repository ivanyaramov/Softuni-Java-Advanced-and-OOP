import java.util.Scanner;

public class compareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r1 = Integer.parseInt(scanner.next());
        int c1 = Integer.parseInt(scanner.next());
        int[][]arr=new int[r1][c1];
        for(int i=0;i<r1;i++){
            for(int k=0;k<c1;k++){
                arr[i][k]=Integer.parseInt(scanner.next());
            }
        }
        int r2 = Integer.parseInt(scanner.next());
        int c2 = Integer.parseInt(scanner.next());
        int[][]arr2=new int[r2][c2];
        for(int i=0;i<r2;i++){
            for(int k=0;k<c2;k++){
                arr2[i][k]=Integer.parseInt(scanner.next());
            }
        }

        if(r1!=r2 || c1!=c2){
            System.out.println("not equal");

        }
        else{
            boolean bool=true;
            for(int i=0;i<r1;i++){
                for(int k=0;k<c1;k++){
                    if(arr[i][k]!=arr2[i][k]){
                        System.out.println("not equal");
                        bool=false;
                    }
                }
            }
            if(bool){
                System.out.println("equal");
            }
        }

    }
}
