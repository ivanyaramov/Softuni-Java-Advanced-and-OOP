import java.util.Scanner;

public class pistionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = Integer.parseInt(scanner.next());
        int c = Integer.parseInt(scanner.next());
        int[][]arr=new int[r][c];
        for(int i=0;i<r;i++){
            for(int k=0;k<c;k++){
                int cur=Integer.parseInt(scanner.next());
                arr[i][k]=cur;
            }
        }
        int a = Integer.parseInt(scanner.next());
        boolean bool=false;
        for(int i=0;i<r;i++){
            for(int k=0;k<c;k++){
                if(arr[i][k]==a){
                    bool=true;
                    System.out.print(i+" ");
                    System.out.println(k);
                }
            }
        }
        if(!bool){
            System.out.println("not found");
        }
    }
}
