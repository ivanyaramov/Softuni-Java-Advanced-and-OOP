import java.util.Scanner;

public class fillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] arrString=a.split(", ");
        int size=Integer.parseInt(arrString[0]);
        String letter=arrString[1];
        if(letter.equals("A")){
            A(size);
        }
        else{
            B(size);
        }
    }
    public static void A(int n){
int[][]arr=new int[n][n];
int row=0;
int col=0;
for(int i=1;i<=n*n;i++){
    arr[row++][col]=i;
    if(row==n){
        row=0;
        col++;
    }
}
for(int i=0;i<n;i++){
    for(int k=0;k<n;k++){
        System.out.print(arr[i][k]+" ");
    }
    System.out.println();
}
    }


    public static void B(int n){
        int[][]arr=new int[n][n];
        int row=0;
        int col=0;
        boolean bool=true;
        for(int i=1;i<=n*n;i++){
            arr[row][col]=i;
            if(bool){
                row++;
            }
            else{
                row--;
            }
            if(row==n){
                bool=false;
                col++;
                row--;
            }
            if(row==-1){
                bool=true;
                col++;
                row=0;
            }
        }
        for(int i=0;i<n;i++){
            for(int k=0;k<n;k++){
                System.out.print(arr[i][k]+" ");
            }
            System.out.println();
        }
    }
}
