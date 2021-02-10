import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Garden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] arr2=a.split(" ");
        int rows = Integer.parseInt(arr2[0]);
        int cols = Integer.parseInt(arr2[1]);
        int[][] arr=new int[rows][cols];
        List<Integer> rowholder=new ArrayList<>();
        List<Integer> colholder=new ArrayList<>();
        while(true){
            String line = scanner.nextLine();
            if(line.equals("Bloom Bloom Plow")){
                actions(arr,rowholder,colholder,rows,cols);
                break;

            }
            String[] arrString=line.split(" ");
            int row=Integer.parseInt(arrString[0]);
            int col=Integer.parseInt(arrString[1]);
            if(row<0||col<0||row>=rows||col>=cols){
                System.out.println("Invalid coordinates.");
            }
            else{
                rowholder.add(row);
                colholder.add(col);
            }
        }
        for(int i=0;i<rows;i++){
            for(int k=0;k<cols;k++){
                System.out.print(arr[i][k]+" ");
            }
            System.out.println();
        }

    }
    public static void actions(int[][] arr,List<Integer> rowholder,List<Integer> colholder,int rows,int cols){
        for(int i=0;i<rowholder.size();i++){
            int row=rowholder.get(i);
            for(int k=0;k<cols;k++){
                arr[row][k]+=1;
            }
        }
        for(int i=0;i<colholder.size();i++){
            int col=colholder.get(i);
            for(int k=0;k<rows;k++){
                arr[k][col]+=1;
            }
        }
        for(int i=0;i<rowholder.size();i++){
            int row=rowholder.get(i);
            int col=colholder.get(i);
            arr[row][col]--;
        }
    }
}
